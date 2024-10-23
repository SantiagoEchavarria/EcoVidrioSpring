package com.example.EcoVidrio.Login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class UsuarioServicio implements UsuarioInterface {
    @Autowired
	private UsuarioDAO usuarioDAO;

	public UsuarioServicio() {
	}

	@Transactional
	public void guardarUsuario(Usuario usuario) {
	   this.usuarioDAO.save(usuario);
	}

	@Transactional
	public List<Usuario> listadoUsuarios() {
	   return this.usuarioDAO.findAll();
	}

	@Override
	public Usuario consultar(String email) {
	 return usuarioDAO.findByEmail(email).orElse(null); 
 }

 @Override
 @Transactional
 public void eliminar(String email) {
	 usuarioDAO.deleteByEmail(email);
 }

}
