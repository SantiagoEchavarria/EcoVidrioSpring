package com.example.EcoVidrio.GestionSensores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resultados")
public class ResultadoControl {
     @Autowired
    private ResultadoInterface resultadoRepository;

     @PostMapping
    public ResponseEntity<String> guardarResultado(@RequestBody Resultado resultado) {
        // Lógica para guardar el resultado en la base de datos
        resultadoRepository.save(resultado);
        System.out.println("Resultado recibido y guardado: " + resultado);
        return ResponseEntity.ok("Resultado guardado correctamente.");
    }
}
