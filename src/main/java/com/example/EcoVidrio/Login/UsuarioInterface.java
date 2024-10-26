package com.example.EcoVidrio.Login;

import java.util.List;


public interface UsuarioInterface {
    
 void guardarUsuario(Usuario usuario);
    List<Usuario> listadoUsuarios();
    public Usuario consultar(String email);
	public void eliminar(String email); 
} 
