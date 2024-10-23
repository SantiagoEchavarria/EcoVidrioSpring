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
@Table(name = "trituradora")
public class Trituradora {
    @Id
    int idTrituradora;
    String nombre;
    String descripcion;


    //Relacion muchos a uno	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Direccion direccion;
	

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}



    //1 a muchos
    @OneToMany(mappedBy="trituradora", fetch = FetchType.LAZY,
    		cascade = CascadeType.ALL)
    List<TurnoOperario> turnoOperario;
    
     public Trituradora() {
        turnoOperario= new ArrayList<>();
    }


    public List<TurnoOperario> getTurnoOperario() {
	return turnoOperario;
    }

  
 

    public Trituradora(int idTrituradora, String descripcion, String nombre) {
        this.idTrituradora = idTrituradora;
       
        this.descripcion = descripcion;
        this.nombre = nombre;
       
    }

    
    public int getIdTrituradora() {
        return idTrituradora;
    }

    public void setIdTrituradora(int idTrituradora) {
        this.idTrituradora = idTrituradora;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

   

    // Método toString
    @Override
    public String toString() {
        return "Trituradora{" +
                "idTrituradora=" + idTrituradora +
                ", descripcion='" + descripcion + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
