package com.example.EcoVidrio;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadDAO extends JpaRepository<Ciudad, Integer> {
	Optional<Ciudad> findByNombreCiudad(String nombreCiudad); 
    void deleteByNombreCiudad(String nombreCiudad);
    List<Ciudad> findByDepartamentoId(int departamentoId);

    
}
