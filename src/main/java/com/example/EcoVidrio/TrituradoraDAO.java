package com.example.EcoVidrio;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TrituradoraDAO extends JpaRepository<Trituradora, Integer>{
// Agregar este método para buscar direcciones por estado
    List<Direccion> findByEstado(Estado estado);

    
} 