package com.example.EcoVidrio;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "turno")
public class Turno {
    @Id
    private int idturno;
    private String nombre;
    private LocalTime hora_entrada;
    private LocalTime hora_salida;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    // Relación 1 a muchos
    @OneToMany(mappedBy = "turno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TurnoOperario> turnoOperarios;

    public Turno() {
        this.estado = Estado.HABILITADO;
        this.turnoOperarios = new ArrayList<>();
    }

    public Turno(int idturno, String nombre, LocalTime hora_entrada, LocalTime hora_salida) {
        this.idturno = idturno;
        this.nombre = nombre;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.estado = Estado.HABILITADO;
    }

    public int getIdturno() {
        return idturno;
    }

    public void setIdturno(int idturno) {
        this.idturno = idturno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHora_entrada() {
        return hora_entrada.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public void setHora_entrada(LocalTime hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_salida() {
        return hora_salida.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public void setHora_salida(LocalTime hora_salida) {
        this.hora_salida = hora_salida;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<TurnoOperario> getTurnoOperario() {
        return turnoOperarios;
    }

    public void setTurnoOperarios(List<TurnoOperario> turnoOperarios) {
        this.turnoOperarios = turnoOperarios;
    }
}
