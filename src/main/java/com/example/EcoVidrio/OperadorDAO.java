package com.example.EcoVidrio;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OperadorDAO extends JpaRepository<Operador, String>{
    Optional<Operador> findByCedula(String cedula); 
    void deleteByCedula(String cedula);
   
    List<Direccion> findByEstado(Estado estado);
}
