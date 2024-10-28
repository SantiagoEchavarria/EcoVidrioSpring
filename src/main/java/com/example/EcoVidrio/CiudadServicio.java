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
	

	//inhabilitado
	@Override
	@Transactional
	public void inhabilitar(int id) {
		Ciudad ciudad = ciudadDAO.findById(id).orElse(null);
		if (ciudad != null) {
			ciudad.setEstado(Estado.INHABILITADO); // Cambia el estado a inhabilitado
			//System.out.println("Ya paso por inhabilitado");
			ciudadDAO.save(ciudad); // Guarda los cambios
		}
	}
	// Habilitar
    @Override
    @Transactional
    public void habilitarCiudad(int id) {
        Ciudad ciudad = ciudadDAO.findById(id).orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));
        ciudad.setEstado(Estado.HABILITADO); // Cambia el estado a habilitado
        ciudadDAO.save(ciudad); // Guarda los cambios
    }
}