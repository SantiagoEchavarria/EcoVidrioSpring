#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <Adafruit_TCS34725.h>

// Credenciales WiFi
const char* ssid = "INTELRED_GOMEZ2";  
const char* password = "Hnbwpgl2";

// Dirección del servidor Spring Boot
const char* server_url = "http://192.168.100.16:8080/api/resultados"; // Cambia la URL según tu configuración

// Configuración del sensor
Adafruit_TCS34725 tcs = Adafruit_TCS34725(TCS34725_INTEGRATIONTIME_600MS, TCS34725_GAIN_1X);

// Configuración del hardware
const int botonColorPin = D3;  // Pin GPIO0 (D3) conectado al botón para medir el color
const int botonPesoPin = D4;   // Pin GPIO2 (D4) conectado al botón para medir el peso
bool botonColorPresionado = false;
bool botonPesoPresionado = false;

// Variables globales para almacenar color y peso
String colorGuardado = "";  // Para guardar el color medido
int peso = 0;               // Peso actual: 148 gramos o 0 gramos
unsigned long ultimaPulsacion = 0; // Para manejar doble pulsación

void setup() {
  Serial.begin(115200);

  // Conexión WiFi
  Serial.println("Conectando a WiFi...");
  WiFi.begin(ssid, password);
  int attempts = 0;
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.print(".");
    attempts++;
    if (attempts >= 1000) { // Intentar 1000 veces antes de reiniciar
      Serial.println("\nNo se pudo conectar a WiFi. Reiniciando...");
      ESP.restart();
    }
  }
  Serial.println("\nConectado a WiFi");

  // Inicialización del sensor
  if (!tcs.begin()) {
    Serial.println("No se pudo iniciar el sensor TCS34725.");
  } else {
    Serial.println("Sensor TCS34725 inicializado.");
  }

  // Configuración de los botones
  pinMode(botonColorPin, INPUT);
  pinMode(botonPesoPin, INPUT);
}

void loop() {
  // Leer el estado del botón D3 (color)
  if (digitalRead(botonColorPin) == HIGH) {
    if (!botonColorPresionado) {  // Detectar solo la primera pulsación
      botonColorPresionado = true;
      guardarColorLocalmente();  // Medir y guardar el color localmente
    }
  } else {
    botonColorPresionado = false; // Reiniciar el estado del botón
  }

  // Leer el estado del botón D4 (peso)
  if (digitalRead(botonPesoPin) == HIGH) {
    if (!botonPesoPresionado) { // Detectar solo la primera pulsación
      botonPesoPresionado = true;
      manejarPesoYEnviarResultado();
    }
  } else {
    botonPesoPresionado = false; // Reiniciar el estado del botón
  }
}

void guardarColorLocalmente() {
  uint16_t r, g, b, c;
  tcs.getRawData(&r, &g, &b, &c);

  if (c == 0) c = 1; // Evitar división por cero

  // Calcular los valores normalizados
  int redNorm = constrain((r * 255) / c, 0, 255);
  int greenNorm = constrain((g * 255) / c, 0, 255);
  int blueNorm = constrain((b * 255) / c, 0, 255);

  // Construir el campo color
  colorGuardado = "Rojo:" + String(redNorm) + ",Verde:" + String(greenNorm) + ",Azul:" + String(blueNorm);

  // Mostrar el color guardado en el monitor serie
  Serial.print("Color medido y guardado localmente: ");
  Serial.println(colorGuardado);
}

void manejarPesoYEnviarResultado() {
  unsigned long tiempoActual = millis();

  // Si la pulsación ocurre dentro de los 500 ms de la anterior, es una doble pulsación
  if (tiempoActual - ultimaPulsacion <= 500) {
    peso = 0;  // Doble pulsación: Peso = 0 gramos
    Serial.println("Peso actualizado a 0 gramos (doble pulsación).");
  } else {
    peso = 148;  // Una sola pulsación: Peso = 148 gramos
    Serial.println("Peso actualizado a 148 gramos.");
  }

  ultimaPulsacion = tiempoActual; // Actualizar el tiempo de la última pulsación

  // Enviar el resultado con el peso actualizado y el color guardado
  enviarResultadoPorHTTP();
}

void enviarResultadoPorHTTP() {
  // Verificar conexión WiFi
  if (WiFi.status() != WL_CONNECTED) {
    Serial.println("WiFi desconectado. Intentando reconectar...");
    WiFi.begin(ssid, password);
    int attempts = 0;
    while (WiFi.status() != WL_CONNECTED && attempts < 20) {
      delay(1000);
      Serial.print(".");
      attempts++;
    }
    if (WiFi.status() != WL_CONNECTED) {
      Serial.println("No se pudo reconectar a WiFi.");
      return;
    }
    Serial.println("Reconexión a WiFi exitosa.");
  }

  // Crear el cliente WiFi
  WiFiClient wifiClient;

  // Configurar la solicitud HTTP POST
  HTTPClient http;
  http.begin(wifiClient, server_url); // Utiliza el cliente WiFi y la URL
  http.addHeader("Content-Type", "application/json");

  // Obtener la fecha en formato correcto (YYYY-MM-DD)
  String fecha = String(2024) + "-" + String(11) + "-" + String(21); // Sustituir por valores dinámicos si se dispone de un RTC.

  // Crear el cuerpo de la solicitud JSON
  String jsonPayload = "{";
  jsonPayload += "\"idsensor\": 2,"; // Ajusta según tu lógica
  jsonPayload += "\"fecha\": \"" + fecha + "\",";
  jsonPayload += "\"hora\": \"" + String(__TIME__) + "\",";
  jsonPayload += "\"peso\": " + String(peso) + ",";
  jsonPayload += "\"color\": \"" + colorGuardado + "\",";
  jsonPayload += "\"estado\": \"HABILITADO\"";
  jsonPayload += "}";

  // Enviar la solicitud
  int httpResponseCode = http.POST(jsonPayload);

  // Manejar la respuesta
  if (httpResponseCode > 0) {
    Serial.print("Respuesta HTTP: ");
    Serial.println(httpResponseCode);
    Serial.println(http.getString()); // Imprime la respuesta del servidor
  } else {
    Serial.print("Error en la solicitud HTTP: ");
    Serial.println(httpResponseCode);
  }

  http.end(); // Finalizar la conexión HTTP
}
