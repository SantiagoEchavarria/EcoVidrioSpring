package com.example.EcoVidrio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class CiudadServicio implements CiudadInterface {
	@Autowired
	private CiudadDAO ciudadDAO;

	public CiudadServicio() {
	}

	@Transactional
	public void guardarCiudad(Ciudad ciudad) {
	   this.ciudadDAO.save(ciudad);
	}

	@Transactional
	public List<Ciudad> listadoCiudades() {
	   return this.ciudadDAO.findAll();
	}

	@Override
	public Ciudad consultar(int id) {
	 return ciudadDAO.findById(id).orElse(null);  
 }

 @Override
 @Transactional
 public void eliminar(int id) {
	 ciudadDAO.deleteById(id);
 }

}
