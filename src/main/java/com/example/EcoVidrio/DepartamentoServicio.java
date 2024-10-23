package com.example.EcoVidrio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class DepartamentoServicio implements DepartamentoInterface {
	 @Autowired
	   private DepartamentoDAO departamentoDAO;

	   public DepartamentoServicio() {
	   }

	   @Transactional
	   public void guardarDepartamento(Departamento departamento) {
	      this.departamentoDAO.save(departamento);
	   }

	   @Transactional
	   public List<Departamento> listadoDepartamentos() {
	      return this.departamentoDAO.findAll();
	   }

	   @Override
	   public Departamento consultar(int nombreDepartamento) {
	    return departamentoDAO.findById(nombreDepartamento).orElse(null);  
	}

	@Override
	@Transactional
	public void eliminar(int id) {
	    departamentoDAO.deleteById(id);
	}

}
