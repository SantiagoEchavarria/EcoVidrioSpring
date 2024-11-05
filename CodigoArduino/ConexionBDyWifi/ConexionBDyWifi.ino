#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>

const char* ssid = "INTELRED_GOMEZ2";  // Nombre de red WiFi
const char* password = "Hnbwpgl2";  // Contraseña WiFi
const char* serverUrlVerificar = "http://192.168.100.16:8080/api/verificarSolicitud";
const char* serverUrlPeso = "http://192.168.100.16:8080/api/peso";

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
}

void loop() {
  if (WiFi.status() == WL_CONNECTED) {
    HTTPClient http;
    http.begin(client, serverUrlVerificar);

    // Realiza la solicitud GET para verificar si se ha solicitado el peso
    int httpResponseCode = http.GET();

    if (httpResponseCode == 200) {
      String response = http.getString();
      if (response == "true") {
        Serial.println("Solicitud de peso recibida, se procederá a enviar el peso.");
        http.end();
        enviarPeso();  // Llama a la función para enviar el peso
      } else {
        Serial.println("No se solicitó la lectura del peso.");
      }
    } else {
      Serial.print("Error en la conexión al verificar solicitud: ");
      Serial.println(httpResponseCode);
    }

    http.end();
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

    http.end();
  }
}
