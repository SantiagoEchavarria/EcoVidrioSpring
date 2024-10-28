package com.example.EcoVidrio;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "direccion")
public class Direccion {
    @Id
    private int id;
    private String nombreDireccion;

    // Nuevo atributo para estado
    @Enumerated(EnumType.STRING)
    private Estado estado; // Enum para estado habilitado o inhabilitado

    // Relación muchos a uno
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Ciudad ciudad;

    // Relación 1 a muchos
    @OneToMany(mappedBy = "direccion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Trituradora> trituradoras;

    public Direccion() {
        this.estado = Estado.HABILITADO; // Valor por defecto
        this.trituradoras = new ArrayList<>(); // Inicializar la lista de trituradoras
    }

    public Direccion(int id, String nombre) {
        this.id = id;
        this.nombreDireccion = nombre;
        this.estado = Estado.HABILITADO; // Valor por defecto
        this.trituradoras = new ArrayList<>(); // Inicializar la lista de trituradoras
    }

    public List<Trituradora> getTrituradoras() {
        return trituradoras;
    }

    public void setTrituradoras(List<Trituradora> trituradoras) {
        this.trituradoras = trituradoras;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDireccion() {
        return nombreDireccion;
    }

    public void setNombreDireccion(String nombre) {
        this.nombreDireccion = nombre;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Direccion [id=" + id + ", nombre=" + nombreDireccion + ", estado=" + estado + "]";
    }
}
