package com.example.EcoVidrio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UbicacionController {

    @Autowired
    private CiudadDAO ciudadRepository;

    @GetMapping("/ciudades/{departamentoId}")
    public List<Ciudad> getCiudadesByDepartamento(@PathVariable int departamentoId) {
        return ciudadRepository.findByDepartamentoId(departamentoId);
    }
}
