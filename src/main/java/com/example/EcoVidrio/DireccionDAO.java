package com.example.EcoVidrio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionDAO extends JpaRepository<Direccion, Integer> {
    Optional<Direccion> findByNombreDireccion(String nombreDireccion); 
    void deleteByNombreDireccion(String nombreDireccion);
    
    // Agregar este método para buscar direcciones por estado
    List<Direccion> findByEstado(Estado estado);
}
