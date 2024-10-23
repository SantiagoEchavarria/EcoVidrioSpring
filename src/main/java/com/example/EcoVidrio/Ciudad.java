package com.example.EcoVidrio;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudad")
public class Ciudad {
	@Id
    int id;
	String nombreCiudad;
	
    //Relacion muchos a uno	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Departamento departamento;

    
      ///Relacion 1 a muchos
    @OneToMany (mappedBy="ciudad", fetch = FetchType.LAZY,
    		cascade = CascadeType.ALL) 
    List<Direccion> direccion;

    
 public Ciudad() {
	 direccion= new ArrayList<>();
}


 public List<Direccion> getDireccion() {
	return direccion;
}


public void setDireccion(List<Direccion> direccion) {
	this.direccion = direccion;
}
	
	
    public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


    public Ciudad( int id, String nombre) {
        this.id=id;
        this.nombreCiudad = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String ciudad) {
        this.nombreCiudad = ciudad;
    }
    @Override
	public String toString() {
		return "Ciudad [id=" + id + ", nombre=" + nombreCiudad + "]";
	}
}
