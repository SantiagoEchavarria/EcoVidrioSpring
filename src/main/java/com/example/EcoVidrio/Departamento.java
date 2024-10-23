package com.example.EcoVidrio;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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

    public Departamento(){}
    public List<Ciudad> getCiudades() {
	return ciudades;
    }


    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }



    public Departamento( int id, String nombre) {
        this.id=id;
        this.nombreDepartamento = nombre;
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

    @Override
	public String toString() {
		return "Cepartamento [id=" + id + ", nombre=" + "]";
	}
}
