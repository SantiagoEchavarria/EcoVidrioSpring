package com.example.EcoVidrio.Login;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descripcion;

  ///Relacion 1 a muchos
    @OneToMany (mappedBy="tipoUsuario", fetch = FetchType.LAZY,
    		cascade = CascadeType.ALL) 
    List<Usuario> usuario;

    
    public TipoUsuario() {
        usuario= new ArrayList<>();
    }


    public List<Usuario> getUsuario() {
        return usuario;
    }


    public void setPsuarios(List<Usuario> usuario) {
        this.usuario = usuario;
    }
    


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoUsuario(Long id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public TipoUsuario(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
}
