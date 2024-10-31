package com.example.EcoVidrio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoDAO extends JpaRepository<Turno, Integer>{
    Optional<Turno> findByNombre(String nombre); 
    void deleteByNombre(String nombre);
    List<Turno> findByEstado(Estado estado);

} 