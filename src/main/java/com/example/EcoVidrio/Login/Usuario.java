package com.example.EcoVidrio.Login;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String contrasena;
    
    //Relacion muchos a uno	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private TipoUsuario tipoUsuario;
	

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	
	public Usuario(int id, String email, String contrasena, TipoUsuario tipoUsuario) {
		super();
		this.id = id;
		this.email = email;
		this.contrasena = contrasena;
		this.tipoUsuario = tipoUsuario;
	}

	public Usuario(String email, String contrasena, TipoUsuario tipoUsuario) {
		super();
		this.email = email;
		this.contrasena = contrasena;
		this.tipoUsuario = tipoUsuario;
	}

	public Usuario() {
		
	}
}
