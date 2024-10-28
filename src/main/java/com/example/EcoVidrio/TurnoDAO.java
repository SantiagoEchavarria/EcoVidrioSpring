package com.example.EcoVidrio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoDAO extends JpaRepository<Turno, Integer>{
    Optional<Turno> findByNombre(String nombre); 
    void deleteByNombre(String nombre);
    // Agregar este método para buscar direcciones por estado
    List<Direccion> findByEstado(Estado estado);

} 