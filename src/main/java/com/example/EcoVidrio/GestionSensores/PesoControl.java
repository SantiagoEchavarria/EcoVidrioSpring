package com.example.EcoVidrio.GestionSensores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PesoControl {
     @Autowired
    private PesoServicio pesoServicio;

    // Endpoint para recibir el peso del sensor
    @PostMapping("/peso")
    public ResponseEntity<String> recibirPeso(@RequestBody PesoDTO pesoDTO) {
        System.out.println("Peticion post peso..");
        // Llama al servicio para guardar el peso en la base de datos
        pesoServicio.guardarPeso(pesoDTO);
        return ResponseEntity.ok("Peso recibido y almacenado.");
    }
}
