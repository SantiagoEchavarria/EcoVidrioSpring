package com.example.EcoVidrio.GestionSensores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/api/resultados")
public class ResultadoControl {
     @Autowired
    private ResultadoInterface resultadoRepository;

     @PostMapping
    public ResponseEntity<String> guardarResultado(@RequestBody Resultado resultado) {
        resultadoRepository.save(resultado);
        System.out.println("Resultado recibido y guardado: " + resultado);
        return ResponseEntity.ok("Resultado guardado correctamente.");
    }

     @ModelAttribute("resultado")
	public List<Resultado> datosDepartamentos(){
		return resultadoRepository.findAll();
	}


    @GetMapping({"/resultadoListar"})
    public String ciudadListar(Model model) {
       List<Resultado> resultado = this.resultadoRepository.findAll();
       model.addAttribute("resultado", resultado);
       model.addAttribute("mensaje", "Listado de resultados");
       return "resultadoListar";
    }
}
