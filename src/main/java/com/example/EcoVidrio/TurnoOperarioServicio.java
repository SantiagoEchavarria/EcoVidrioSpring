package com.example.EcoVidrio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TurnoOperarioServicio implements TurnoOperarioInterface {
    @Autowired
	private TurnoOperarioDAO turnoOperarioDAO;

	public TurnoOperarioServicio() {
	}

	@Transactional
	public void guardarTurnoOperario(TurnoOperario turnoOperario) {
	   this.turnoOperarioDAO.save(turnoOperario);
	}

	@Transactional
	public List<TurnoOperario> listadoTurnoOperarios() {
	   return this.turnoOperarioDAO.findAll();
	}

	@Override
	public TurnoOperario consultar(int nombreturnoOperario) {
	 return turnoOperarioDAO.findById(nombreturnoOperario).orElse(null);  
 }

 @Override
 @Transactional
 public void eliminar(int id) {
	 turnoOperarioDAO.deleteById(id);
 }



}
