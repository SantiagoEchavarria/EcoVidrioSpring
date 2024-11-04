package com.example.EcoVidrio.GestionSensores;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PesoServicio {
     @Autowired
    private PesoInterface pesoRepository;
 public void guardarPeso(PesoDTO pesoDTO) {
        Peso peso = new Peso();
        peso.setIdsensor(pesoDTO.getIdsensor());
        peso.setPeso(pesoDTO.getPeso());
        peso.setFecha(LocalDate.now());
        peso.setHora(LocalTime.now());
        peso.setAlertas(pesoDTO.getAlertas());

        pesoRepository.save(peso);
    }
}
