package com.example.EcoVidrio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "operador")
public class Operador {
    @Id
    //public int id;   
    public String cedula; 
    public String nombre1;
    public String nombre2;
    public String apellido1;
    public String apellido2;
    public String telefono;
    public String direccion;
    public String correoElectronico;
    
      ///Relacion 1 a muchos
    @OneToMany (mappedBy="operador", fetch = FetchType.LAZY,
    		cascade = CascadeType.ALL) 
    List<TurnoOperario> turnoOperarios;

    
 public Operador() {
	 turnoOperarios= new ArrayList<>();
}


 public List<TurnoOperario> getPurnoOperarios() {
	return turnoOperarios;
}


public void setTurnoOperarios(List<TurnoOperario> turnoOperarios) {
	this.turnoOperarios = turnoOperarios;
}



    public Operador(int id, String cedula, String nombre1, String nombre2, String apellido1, String apellido2, String telefono, String direccion, String correoElectronico) {
        //this.id = id;
        this.cedula = cedula;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
    }
/* 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico; }

}
