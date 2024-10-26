package com.example.EcoVidrio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"trituradora"})
public class TrituradoraControl {
     @Autowired
    private TrituradoraInterface trituradoraServicio;

    @Autowired
    private DireccionInterface direccionServicio;


    @ModelAttribute("direccion")
	public List<Direccion> datosDireccion(){
		return direccionServicio.listadoDirecciones();
	}
    
 
    public TrituradoraControl() {
    }
 
    @GetMapping({"trituradoraInsertar"})
    public String trituradoraInsertar(Model model) {
        Trituradora trituradora = new Trituradora();
       model.addAttribute("trituradora", trituradora);
       model.addAttribute("mensaje", "nueva Trituradora");
       return "trituradoraInsertar";
    }

 

   
    @PostMapping({"/insertarTrituradora"})
    public String insertarTrituradora(@ModelAttribute(name = "trituradora") Trituradora trituradora, 
    Model model, SessionStatus status) {
       this.trituradoraServicio.guardarTrituradora(trituradora);
       status.setComplete();
       return "redirect:trituradoraInsertar";
    }
 
    @GetMapping({"/trituradoraListar"})
    public String orituradoraListar(Model model) {
       List<Trituradora> trituradora = this.trituradoraServicio.listadoTrituradoras();
       model.addAttribute("trituradora", trituradora);
       model.addAttribute("mensaje", "Listado de trituradoras");
       return "trituradoraListar";
    }


    
    //Invento Aparte
/* 
    @PostMapping ("/insertar")
	public String insertar(@ModelAttribute (name="trituradora") Trituradora trituradora, Model model,SessionStatus status) {
		trituradoraServicio.guardarTrituradora(trituradora);
		status.setComplete();
		return "redirect:/trituradoraListar";
	}*/

    @GetMapping ("/consultarTrituradora/(id)")
	public String consultarTrituradora(@PathVariable (name="id") int id, Model model) {
		
		Trituradora trituradora = trituradoraServicio.consultar(id);
		model.addAttribute("orituradora", trituradora);
		model.addAttribute("mensaje","consultar");
		return "redirect:/trituradoraListar";
	}

    @GetMapping("/eliminarTrituradora/{id}")
	public String eliminarTrituradora (@PathVariable(name="id") int id, Model model) {
		//Turista turista = turistaServicio.consultar(id);
		trituradoraServicio.eliminar(id);
		return "redirect:/trituradoraListar";
	}

	@GetMapping("/modificarTrituradora/{id}")
	public String modificarOrituradora (@PathVariable(name="id")int id,Model model) {
		Trituradora trituradora = trituradoraServicio.consultar(id);
		model.addAttribute("trituradora", trituradora);
		model.addAttribute("mensaje","editar");
		return "trituradoraEditar";
	}
}
