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

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes({"operador"})
public class OperadorControl {
    @Autowired
    private OperadorInterface operadorServicio;
    @Autowired
    private TurnoInterface turnoServicio;
    @Autowired
    private TrituradoraInterface trituradoraServicio;
    @Autowired
    private DireccionInterface direccionServicio;
    @Autowired
    private TurnoOperarioInterface turnoOperarioServicio;
 
    public OperadorControl() {
    }
 
    @GetMapping({"operadorInsertar"})
    public String operadorInsertar(Model model) {
        Operador operador = new Operador();
       model.addAttribute("operador", operador);
       model.addAttribute("mensaje", "nueva Operador");
       return "operadorInsertar";
    }

 

   
    @PostMapping({"/insertarOperador"})
    public String insertarOperador(@ModelAttribute(name = "operador") Operador operador, Model model, SessionStatus status) {
        if (operadorServicio.existeCedula(operador.getCedula())) {
        model.addAttribute("errorMessage", "La cédula ya existe. Por favor, ingrese una cédula única.");
        return "operadorInsertar"; // Devuelve a la vista de inserción con el mensaje de error.
    }
    
    this.operadorServicio.guardarOperador(operador);
    status.setComplete();
    return "redirect:/operadorListar";
}


    @GetMapping({"/operadorListar"})
    public String operadorListar(Model model, HttpSession session) {
       List<Operador> operador = this.operadorServicio.listadoOperadores();

       TurnoOperario turnoOperario = new TurnoOperario();
       session.setAttribute("turnoOperario", turnoOperario);
       model.addAttribute("turnoOperario", turnoOperario);
       //model.addAttribute("turnoOperario", turnoOperarioServicio.listadoTurnoOperarios());

       model.addAttribute("trituradora", trituradoraServicio.listadoTrituradoras()); 
       model.addAttribute("turnoOperario", new TurnoOperario()); 
       model.addAttribute("direccion", direccionServicio.listadoDirecciones());
       model.addAttribute("turno", turnoServicio.listadoTurnos());
       model.addAttribute("operador", operador);
       model.addAttribute("mensaje", "Listado de Operadores");
       return "operadorListar";
    }
    



    
    //Invento Aparte

    @PostMapping ("/insertar")
	public String insertar(@ModelAttribute (name="operador") Operador operador, Model model,SessionStatus status) {
		operadorServicio.guardarOperador(operador);
		status.setComplete();
		return "redirect:/operadorListar";
	}

    @GetMapping ("/consultarOperador/(cedula)")
	public String consultarOperador(@PathVariable (name="cedula") String cedula, Model model) {
		
		Operador operador = operadorServicio.consultar(cedula);
		model.addAttribute("operador", operador);
		model.addAttribute("mensaje","consultar");
		return "redirect:/operadorListar";
	}

    @GetMapping("/eliminarOperador/{cedula}")
	public String eliminarOperador (@PathVariable(name="cedula") String cedula, Model model) {
		//Turista turista = turistaServicio.consultar(id);
		operadorServicio.eliminar(cedula);
		return "redirect:/operadorListar";
	}

	@GetMapping("/modificarOperador/{cedula}")
	public String modificarOperador (@PathVariable(name="cedula")String cedula,Model model) {
		Operador operador = operadorServicio.consultar(cedula);
		model.addAttribute("operador", operador);
		model.addAttribute("mensaje","editar");
		return "operadorEditar";
	}
}
