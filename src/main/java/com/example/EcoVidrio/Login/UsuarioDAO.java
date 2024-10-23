package com.example.EcoVidrio.Login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email); 
    void deleteByEmail(String email);
}
