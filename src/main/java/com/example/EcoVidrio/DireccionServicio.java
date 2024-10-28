package com.example.EcoVidrio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class DireccionServicio implements DireccionInterface {
    @Autowired
	private DireccionDAO direccionDAO;

	public DireccionServicio() {
	}

	@Transactional
	public void guardarDireccion(Direccion direccion) {
	   this.direccionDAO.save(direccion);
	}

	@Transactional
	public List<Direccion> listadoDirecciones() {
	   return this.direccionDAO.findAll();
	}

	@Override
	public Direccion consultar(int nombredireccion) {
	 return direccionDAO.findById(nombredireccion).orElse(null);  
 }

 @Override
 @Transactional
 public void eliminar(int id) {
	 direccionDAO.deleteById(id);
 }
 @Override
 public void inhabilitarDireccion(int id) {
	 Direccion direccion = consultar(id);
	 if (direccion != null) {
		 direccion.setEstado(Estado.INHABILITADO);  // Cambia el estado a inhabilitado
		 guardarDireccion(direccion);
	 }
 }

 @Override
 public void habilitarDireccion(int id) {
	 Direccion direccion = consultar(id);
	 if (direccion != null) {
		 direccion.setEstado(Estado.HABILITADO);  // Cambia el estado a habilitado
		 guardarDireccion(direccion);
	 }
 }

}
