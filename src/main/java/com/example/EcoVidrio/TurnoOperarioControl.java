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
@SessionAttributes({"turnoOperario"})
public class TurnoOperarioControl {
    @Autowired
   private TurnoOperarioInterface turnoOperarioServicio;
   
   @Autowired
	private TurnoInterface turnoServicio;

   @Autowired
	private OperadorInterface operadorervicio;

   @Autowired
	private TrituradoraInterface trituradoraervicio;
   
	
	@ModelAttribute("trituradora")
	public List<Trituradora> datosTrituradora(){
		return trituradoraervicio.listadoTrituradoras();
	}


	
	@ModelAttribute("operador")
	public List<Operador> datosOperador(){
		return operadorervicio.listadoOperadores();
	}
	
	@ModelAttribute("turno")
	public List<Turno> datosTurno(){
		return turnoServicio.listadoTurnos();
	}
	

   public TurnoOperarioControl() {
   }

    @GetMapping({"turnoOperarioInsertar"})
   public String turnoOperario(Model model) {
      TurnoOperario turnoOperario = new TurnoOperario();
      List<Trituradora> trituradorasHabilitadas = trituradoraervicio.obtenerTrituradorasHabilitadas();
      model.addAttribute("turnoOperario", turnoOperario);
      model.addAttribute("trituradora", trituradorasHabilitadas);
      model.addAttribute("mensaje", "nuevo turnoOperario");
      return "turnoOperarioInsertar";
   }



  
   @PostMapping({"/insertarTurnoOperario"})
   public String insertarTurnoOperario(@ModelAttribute(name = "turnoOperario") TurnoOperario turnoOperario, 
   Model model, SessionStatus status) {
      this.turnoOperarioServicio.guardarTurnoOperario(turnoOperario);
      status.setComplete();
      return "redirect:/turnoOperarioListar";
   }

   @GetMapping({"/turnoOperarioListar"})
   public String turnoOperarioListar(Model model) {
      List<TurnoOperario> turnoOperario = this.turnoOperarioServicio.listadoTurnoOperarios();
      model.addAttribute("turnoOperario", turnoOperario);
      model.addAttribute("mensaje", "Listado de turnoOperarios");
      return "turnoOperarioListar";
   }


   
   //Invento Aparte

   @GetMapping ("/consultarTurnoOperario/(idOperario)")
  public String consultarDepartamento(@PathVariable (name="idOperario") int id, Model model) {
     
      TurnoOperario turnoOperario = turnoOperarioServicio.consultar(id);
     model.addAttribute("curnoOperario", turnoOperario);
     model.addAttribute("mensaje","turnoOperario");
     return "redirect:/turnoOperarioListar";
  }

   @GetMapping("/eliminarTurnoOperario/{idOperario}")
  public String eliminarDepartamento (@PathVariable(name="idOperario") int id, Model model) {
     
      turnoOperarioServicio.eliminar(id);
     return "redirect:/turnoOperarioListar";
  }

  @GetMapping("/modificarTurnoOperario/{idOperario}")
  public String modificarDepartamento (@PathVariable(name="idOperario") int id,Model model) {
     TurnoOperario turnoOperario = turnoOperarioServicio.consultar(id);
     model.addAttribute("turnoOperario", turnoOperario);
     model.addAttribute("mensaje","editar");
     return "turnoOperarioEditar";
  }



}
