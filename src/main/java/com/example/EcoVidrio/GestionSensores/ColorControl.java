package com.example.EcoVidrio.GestionSensores;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/colors")
public class ColorControl {
    
    @PostMapping
    public ResponseEntity<String> receiveColor(@RequestBody ColorData colorData) {
        System.out.println("Datos recibidos: " + colorData);
        // Aquí puedes guardar los datos en la base de datos o procesarlos
        return ResponseEntity.ok("Datos recibidos exitosamente.");
    }
}
