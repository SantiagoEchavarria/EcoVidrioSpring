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
@SessionAttributes({"turno"})
public class TurnoControl {
     @Autowired
    private TurnoInterface turnoServicio;
 
    public TurnoControl() {
    }
 
    @GetMapping({"turnoInsertar"})
    public String turnoInsertar(Model model) {
        Turno turno = new Turno();
       model.addAttribute("turno", turno);
       model.addAttribute("mensaje", "nuevo Turno");
       return "turnoInsertar";
    }

 

   
    @PostMapping({"/insertarTurno"})
    public String insertarTurno(@ModelAttribute(name = "turno") Turno turno, 
    Model model, SessionStatus status) {
       this.turnoServicio.guardarTurno(turno);
       status.setComplete();
       return "redirect:turnoListar";
    }
 
    @GetMapping({"/turnoListar"})
    public String turnoListar(Model model) {
       List<Turno> turno = this.turnoServicio.listadoTurnos();
       model.addAttribute("turno", turno);
       model.addAttribute("mensaje", "Listado de Turnos");
       return "turnoListar";
    }


    
     //Invento Aparte
/* 
     @PostMapping ("/insertar")
     public String insertar(@ModelAttribute (name="turno") Turno turno, Model model,SessionStatus status) {
         turnoServicio.guardarTurno(turno);
         status.setComplete();
         return "redirect:/turnoListar";
     }*/
 
     @GetMapping ("/consultar/(idturno)")
     public String consultar(@PathVariable (name="idturno") int idturno, Model model) {
         
         Turno turno = turnoServicio.consultar(idturno);
         model.addAttribute("turno", turno);
         model.addAttribute("mensaje","turno");
         return "redirect:/turnoListar";
     }
 
     @GetMapping("/eliminar/{idturno}")
     public String eliminar (@PathVariable(name="idturno") int idturno, Model model) {
         //Turista turista = turistaServicio.consultar(id);
         turnoServicio.eliminar(idturno);
         return "redirect:/turnoListar";
     }
 
     @GetMapping("/modificar/{idturno}")
     public String modificar (@PathVariable(name="idturno")int idturno,Model model) {
         Turno turno = turnoServicio.consultar(idturno);
         model.addAttribute("turno", turno);
         model.addAttribute("mensaje","editar");
         return "turnoEditar";
     }
     // Método para inhabilitar el turno
    @GetMapping("/inhabilitarTurno/{id}")
    public String inhabilitarTurno(@PathVariable(name = "id") int id) {
        turnoServicio.inhabilitarTurno(id);  // Cambiar el estado del turno a inhabilitado
        return "redirect:/turnoListar";
    }

    // Método para habilitar el turno
    @GetMapping("/habilitarTurno/{id}")
    public String habilitarTurno(@PathVariable(name = "id") int id) {
        turnoServicio.habilitarTurno(id);  // Cambiar el estado del turno a habilitado
        return "redirect:/turnoListar";
    }

    
}
