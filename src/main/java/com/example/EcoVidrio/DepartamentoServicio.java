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
    public Departamento consultar(int id) {
        return departamentoDAO.findById(id).orElse(null);  
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        departamentoDAO.deleteById(id);
    }

    // Método para inhabilitar departamento
    @Override
    @Transactional
    public void inhabilitar(int id) {
        Departamento departamento = departamentoDAO.findById(id).orElse(null);
        if (departamento != null) {
            departamento.setEstado(Estado.INHABILITADO); // Cambiar estado a inhabilitado
            departamentoDAO.save(departamento); // Guardar cambios
        }
    }

    // Método para habilitar departamento
    @Override
    @Transactional
    public void habilitarDepartamento(int id) {
        Departamento departamento = departamentoDAO.findById(id).orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
        departamento.setEstado(Estado.HABILITADO); // Cambiar estado a habilitado
        departamentoDAO.save(departamento); // Guardar cambios
    }

    @Override
    public List<Departamento> obtenerDepartamentosHabilitados() {
        return departamentoDAO.findByEstado(Estado.HABILITADO);
    }
}
