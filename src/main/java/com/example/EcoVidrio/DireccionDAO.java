package com.example.EcoVidrio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionDAO extends JpaRepository<Direccion, Integer> {
    Optional<Direccion> findByNombreDireccion(String nombreDireccion); 
    void deleteByNombreDireccion(String nombreDireccion);
    
}
