package com.example.EcoVidrio;

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
@Table(name = "departamento")
public class Departamento {
	@Id
    int id;
	String nombreDepartamento;

      
      ///Relacion 1 a muchos
        @OneToMany (mappedBy="departamento", fetch = FetchType.LAZY,
    		cascade = CascadeType.ALL) 
         List<Ciudad> ciudades;
    /* 
	 public Departamento() {
	 ciudades= new ArrayList<>();
    }*/
    // Nuevo atributo para estado
    @Enumerated(EnumType.STRING)
    private Estado estado;  // Enum para estado habilitado o inhabilitado

    public Departamento(){
        this.estado = Estado.HABILITADO; // Valor por defecto
    }
    public List<Ciudad> getCiudades() {
	return ciudades;
    }


    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }



    public Departamento( int id, String nombre) {
        this.id=id;
        this.nombreDepartamento = nombre;
        this.estado = Estado.HABILITADO; // Valor por defecto
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombre) {
        this.nombreDepartamento = nombre;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
	public String toString() {
		return "Cepartamento [id=" + id + ", nombre=" + "]";
	}
}
