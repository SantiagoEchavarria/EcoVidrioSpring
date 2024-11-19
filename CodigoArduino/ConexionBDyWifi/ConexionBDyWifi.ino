#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <Adafruit_TCS34725.h>

const char* ssid = "INTELRED_GOMEZ2";  // Nombre de red WiFi
const char* password = "Hnbwpgl2";  // Contraseña WiFi
const char* serverUrlVerificar = "http://192.168.100.16:8080/api/verificarSolicitud";
const char* serverUrlPeso = "http://192.168.100.16:8080/api/peso";

// Crear una instancia del sensor con tiempos de integración y ganancia por defecto
Adafruit_TCS34725 tcs = Adafruit_TCS34725(TCS34725_INTEGRATIONTIME_600MS, TCS34725_GAIN_1X);

WiFiClient client;

void setup() {
  Serial.begin(115200);
  WiFi.begin(ssid, password);

  Serial.println("Conectando a WiFi...");
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.print(".");
  }
  Serial.println("\nConectado a WiFi");

  // Iniciar el sensor de color
  if (!tcs.begin()) {
    Serial.println("No se pudo iniciar el sensor TCS34725.");
  } else {
    Serial.println("Sensor TCS34725 inicializado.");
  }
}

void loop() {
   imprimirRGB();
  if (WiFi.status() == WL_CONNECTED) {
    HTTPClient http;
    http.begin(client, serverUrlVerificar);

    // Realiza la solicitud GET para verificar si se ha solicitado el peso
    int httpResponseCode = http.GET();

    if (httpResponseCode == 200) {
      String response = http.getString();
      if (response == "true") {
        Serial.println("Solicitud de peso recibida, se procederá a enviar el peso.");
        imprimirRGB(); // Imprime los valores RGB
        http.end();    // Finaliza la conexión actual antes de iniciar otra
        enviarPeso();  // Llama a la función para enviar el peso
      } else {
        Serial.println("No se solicitó la lectura del peso.");
      }
    } else {
      Serial.print("Error en la conexión al verificar solicitud: ");
      Serial.println(httpResponseCode);
    }

    http.end(); // Asegurar que la conexión HTTP finalice
  } else {
    Serial.println("WiFi no conectado, reconectando...");
    WiFi.begin(ssid, password);
    while (WiFi.status() != WL_CONNECTED) {
      delay(1000);
      Serial.print(".");
    }
    Serial.println("\nConectado a WiFi");
  }

  delay(5000); // Verificar cada 5 segundos
}

void enviarPeso() {
  if (WiFi.status() == WL_CONNECTED) {
    HTTPClient http;
    http.begin(client, serverUrlPeso);
    http.addHeader("Content-Type", "application/json");

    // Ejemplo de valor del peso
    float peso = 25.5;
    String jsonPayload = "{\"idsensor\": 2, \"peso\": " + String(peso) + ", \"alertas\": \"\"}";

    // Realiza la solicitud POST con el payload JSON
    int httpResponseCode = http.POST(jsonPayload);

    if (httpResponseCode > 0) {
      String response = http.getString();
      Serial.println("Respuesta del servidor al enviar peso: " + response);
    } else {
      Serial.print("Error en la conexión al enviar peso: ");
      Serial.println(httpResponseCode);
    }

    http.end(); // Asegurar que la conexión HTTP finalice
  }
}

void imprimirRGB() {
  uint16_t r, g, b, c; // Variables para los valores de rojo, verde, azul y claridad
  float redNorm, greenNorm, blueNorm;

  // Obtener los valores RGB si el sensor está operativo
  if (tcs.begin()) {
    tcs.getRawData(&r, &g, &b, &c);

    // Evitar división por cero
    if (c == 0) c = 1;

    // Normalizar los valores para tenerlos entre 0 y 255
    redNorm = (float)r / c * 255.0;
    greenNorm = (float)g / c * 255.0;
    blueNorm = (float)b / c * 255.0;

    // Imprimir valores normalizados de RGB
    Serial.print("Rojo: ");
    Serial.print((int)redNorm);
    Serial.print(" Verde: ");
    Serial.print((int)greenNorm);
    Serial.print(" Azul: ");
    Serial.println((int)blueNorm);
  } else {
    Serial.println("El sensor TCS34725 no está operativo.");
  }
}
