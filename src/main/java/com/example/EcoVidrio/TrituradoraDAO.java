package com.example.EcoVidrio;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TrituradoraDAO extends JpaRepository<Trituradora, Integer>{
    List<Trituradora> findByEstado(Estado estado);
    Optional<Trituradora> findByNombre(String nombre);

} 