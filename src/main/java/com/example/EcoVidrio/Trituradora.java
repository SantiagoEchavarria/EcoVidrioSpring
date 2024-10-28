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
@Table(name = "trituradora")
public class Trituradora {
    @Id
    int id;
    String nombre;
    String descripcion;

    // Nuevo atributo para estado
    @Enumerated(EnumType.STRING)
    private Estado estado; // Enum para estado habilitado o inhabilitado

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
        this.estado = Estado.HABILITADO; // Valor por defecto
        turnoOperario= new ArrayList<>();
    }


    public List<TurnoOperario> getTurnoOperario() {
	return turnoOperario;
    }

  
 

    public Trituradora(int id, String descripcion, String nombre) {
        this.id = id;
       
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.estado = Estado.HABILITADO; // Valor por defecto
        
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    // Método toString
    @Override
    public String toString() {
        return "Trituradora{" +
                "idTrituradora=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
