package com.example.EcoVidrio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoDAO extends JpaRepository<Departamento, Integer> {
    Optional<Departamento> findByNombreDepartamento(String nombreDepartamento); 

    void deleteByNombreDepartamento(String nombreDepartamento);

    // Agregar este método para buscar departamentos por estado
    List<Departamento> findByEstado(Estado estado); 
}
