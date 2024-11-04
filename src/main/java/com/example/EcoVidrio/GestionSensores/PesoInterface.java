package com.example.EcoVidrio.GestionSensores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesoInterface extends JpaRepository<Peso, Integer> {

    
} 
