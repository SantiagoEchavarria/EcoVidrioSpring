package com.example.EcoVidrio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TrituradoraServicio implements TrituradoraInterface {
     @Autowired
   private TrituradoraDAO trituradoraDAO;

   public TrituradoraServicio() {
   }

   @Transactional
   public void guardarTrituradora(Trituradora trituradora) {
      this.trituradoraDAO.save(trituradora);
   }

   @Transactional
   public List<Trituradora> listadoTrituradoras() {
      return this.trituradoraDAO.findAll();
   }

   @Override
   public Trituradora consultar(int id) {
    return trituradoraDAO.findById(id).orElse(null);  // Usa findByCedula en lugar de findById
}

    @Override
@Transactional
public void eliminar(int id) {
    trituradoraDAO.deleteById(id);  // Usa deleteByCedula en lugar de deleteById
}
@Override
 public void inhabilitarTrituradora(int id) {
	 Trituradora trituradora = consultar(id);
	 if (trituradora != null) {
        trituradora.setEstado(Estado.INHABILITADO);  // Cambia el estado a inhabilitado
		 guardarTrituradora(trituradora);
	 }
 }

 @Override
 public void habilitarTrituradora(int id) {
	 Trituradora trituradora = consultar(id);
	 if (trituradora != null) {
        trituradora.setEstado(Estado.HABILITADO);  // Cambia el estado a habilitado
		 guardarTrituradora(trituradora);
	 }
 }
  

}
