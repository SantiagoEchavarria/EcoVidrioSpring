package com.example.EcoVidrio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TrituradoraDAO extends JpaRepository<Trituradora, Integer>{

    
} 