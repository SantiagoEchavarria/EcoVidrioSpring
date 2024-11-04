package com.example.EcoVidrio.GestionSensores;
//Almacenar los datros de solicitudes https por aparte

public class PesoDTO {
    private int idsensor;
    private double peso;
    private String alertas;

    // Getters y Setters
    public int getIdsensor() {
        return idsensor;
    }

    public void setIdsensor(int idsensor) {
        this.idsensor = idsensor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getAlertas() {
        return alertas;
    }

    public void setAlertas(String alertas) {
        this.alertas = alertas;
    }
}
