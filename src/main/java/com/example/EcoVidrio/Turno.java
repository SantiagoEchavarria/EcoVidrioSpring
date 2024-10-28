package com.example.EcoVidrio;
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
    int idturno;
    String nombre;
    String hora_entrada;
    String hora_salida;
    
    // Nuevo atributo para estado
    @Enumerated(EnumType.STRING)
    private Estado estado; // Enum para estado habilitado o inhabilitado

      ///Relacion 1 a muchos
    @OneToMany (mappedBy="turno", fetch = FetchType.LAZY,
    		cascade = CascadeType.ALL) 
    List<TurnoOperario> turnoOperarios;

    
    public Turno() {
        this.estado = Estado.HABILITADO; // Valor por defecto
        turnoOperarios= new ArrayList<>();
    }


    public List<TurnoOperario> getTurnoOperario() {
        return turnoOperarios;
    }


    public void setTurnoOperarios(List<TurnoOperario> turnoOperarios) {
        this.turnoOperarios = turnoOperarios;
    }

    
    public Turno(int idturno, String nombre, String hora_entrada, String hora_salida) {
        
        this.nombre = nombre;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.estado = Estado.HABILITADO; // Valor por defecto
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
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
