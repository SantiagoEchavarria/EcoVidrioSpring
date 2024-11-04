#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>

const char* ssid = "INTELRED_GOMEZ2";  // Reemplaza con tu nombre de red WiFi
const char* password = "Hnbwpgl2";  // Reemplaza con tu contraseña WiFi
const char* serverUrl = "http://192.168.100.16:8080/api/peso";  // Ajusta la IP y puerto del servidor

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
    http.begin(client, serverUrl);
    
    // Establece el Content-Type a application/json
    http.addHeader("Content-Type", "application/json");

    // Ejemplo de valor del peso
    float peso = 25.5;
    String jsonPayload = "{\"idsensor\": 2, \"peso\": " + String(peso) + ", \"alertas\": \"\"}";

    // Realiza la solicitud POST con el payload JSON
    int httpResponseCode = http.POST(jsonPayload);

    if (httpResponseCode > 0) {
      String response = http.getString();
      Serial.println("Respuesta del servidor: " + response);
    } else {
      Serial.print("Error en la conexión: ");
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

  delay(60000);
}
