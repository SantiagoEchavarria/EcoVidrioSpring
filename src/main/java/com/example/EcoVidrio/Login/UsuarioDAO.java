package com.example.EcoVidrio.Login;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email); 
    void deleteByEmail(String email);
    @Query("SELECT u FROM Usuario u WHERE u.tipoUsuario.id = :idTipoUsuario")
    List<Usuario> findByTipoUsuarioId(@Param("idTipoUsuario") int idTipoUsuario);

}
