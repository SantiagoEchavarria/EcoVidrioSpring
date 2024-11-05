package com.example.EcoVidrio.GestionSensores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/api")
public class PesoControl {
     @Autowired
    private PesoServicio pesoServicio;

     // Variable para saber si se solicitó el peso
     private boolean pesoSolicitado = false;

     // Endpoint para recibir el peso del sensor
     @PostMapping("/peso")
     public ResponseEntity<String> recibirPeso(@RequestBody PesoDTO pesoDTO) {
         // Llama al servicio para guardar el peso en la base de datos
         pesoServicio.guardarPeso(pesoDTO);
         // Reinicia la solicitud del peso
         pesoSolicitado = false;
         return ResponseEntity.ok("Peso recibido y almacenado.");
     }


//Codigo de gpt
// Endpoint para solicitar el peso desde la página web
    @PostMapping("/solicitarPeso")
    public ResponseEntity<String> solicitarPeso() {
        pesoSolicitado = true;
        return ResponseEntity.ok("Inicia lectura de peso.");
    }

    @GetMapping("/solicitarPeso")
    public ResponseEntity<String> solicita2rPeso() {
    // Aquí podrías agregar lógica adicional si es necesario
    return ResponseEntity.ok("Inicia lectura de peso.");
    }
    @GetMapping("/verificarSolicitud")
    public ResponseEntity<Boolean> verificarSolicitud() {
        return ResponseEntity.ok(pesoSolicitado);
    }

//

//para iniciar la pagina
   @GetMapping("/pesoGestion")
   public String iniciarPeso(Model model) {
       return "pesoGestion";
   }
   


   
    

}
