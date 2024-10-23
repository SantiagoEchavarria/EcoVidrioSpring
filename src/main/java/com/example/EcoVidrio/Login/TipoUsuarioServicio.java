package com.example.EcoVidrio.Login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class TipoUsuarioServicio implements TipoUsuarioInterface{
    @Autowired
	private TipoUsuarioDAO tipoUsuarioDAO;

    public TipoUsuarioServicio(){

    }

    @Transactional
    public void guardarTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuarioDAO.save(tipoUsuario);
    }

    @Transactional
    public List<TipoUsuario> listadoTipoUsuarios() {
        return this.tipoUsuarioDAO.findAll();
    }

    @Override
    public TipoUsuario consultar(int id) {
        return tipoUsuarioDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
       tipoUsuarioDAO.deleteById(id);
    }
    
}
