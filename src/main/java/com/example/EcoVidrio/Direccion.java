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
@Table(name = "direccion")
public class Direccion {
    @Id
    int id;
	String nombreDireccion;

    //Relacion muchos a uno	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Ciudad ciudad;

       ///Relacion 1 a muchos
    @OneToMany (mappedBy="direccion", fetch = FetchType.LAZY,
    		cascade = CascadeType.ALL) 
    List<Trituradora> trituradora;

        
    public Direccion() {
        trituradora= new ArrayList<>();
    }


    public List<Trituradora> getTrituradora() {
        return trituradora;
    }


    public void setTrituradora(List<Trituradora> trituradora) {
        this.trituradora = trituradora;
    }




	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}


    public Direccion( int id, String nombre) {
        this.id=id;
        this.nombreDireccion = nombre;
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

    public void setNombreDireccion(String direccion) {
        this.nombreDireccion = direccion;
    }
    @Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombreDireccion + "]";
	}
}
