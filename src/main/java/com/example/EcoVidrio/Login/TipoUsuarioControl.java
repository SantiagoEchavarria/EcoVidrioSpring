package com.example.EcoVidrio.Login;

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
@SessionAttributes({"tipousuario"})
public class TipoUsuarioControl {
        @Autowired
    private TipoUsuarioInterface tipoUsuarioSerivicio;
 
    public TipoUsuarioControl() {
    }
 
    @GetMapping({"tipoUsuarioInsertar"})
    public String tipoUsuarioInsertar(Model model) {
        TipoUsuario tipoUsuario = new TipoUsuario();
       model.addAttribute("tipoUsuario", tipoUsuario);
       model.addAttribute("mensaje", "nuevo TipoUsuario");
       return "tipoUsuarioInsertar";
    }

 

   
    @PostMapping({"/insertarTipoUsuario"})
    public String insertarTipoUsuario(@ModelAttribute(name = "tipoUsuario") TipoUsuario tipoUsuario, 
    Model model, SessionStatus status) {
       this.tipoUsuarioSerivicio.guardarTipoUsuario(tipoUsuario);
       status.setComplete();
       return "redirect:tipoUsuarioListar";
    }
 
    @GetMapping({"/tipoUsuarioListar"})
    public String tipoUsuarioListar(Model model) {
       List<TipoUsuario> tipoUsuario = this.tipoUsuarioSerivicio.listadoTipoUsuarios();
       model.addAttribute("tipoUsuario", tipoUsuario);
       model.addAttribute("mensaje", "Listado de TipoUsuarios");
       return "tipoUsuarioListar";
    }


    
     //Invento Aparte
/* 
     @PostMapping ("/insertar")
     public String insertar(@ModelAttribute (name="tipoUsuario") TipoUsuario tipoUsuario, Model model,SessionStatus status) {
         tipoUsuario.guardarTipoUsuario(tipoUsuario);
         status.setComplete();
         return "redirect:/tipoUsuarioListar";
     }*/
 
     @GetMapping ("/consultar/(idtipoUsuario)")
     public String consultar(@PathVariable (name="idtipoUsuario") int idtipoUsuario, Model model) {
         
         TipoUsuario tipoUsuario = tipoUsuarioSerivicio.consultar(idtipoUsuario);
         model.addAttribute("tipoUsuario", tipoUsuario);
         model.addAttribute("mensaje","tipoUsuario");
         return "redirect:/tipoUsuarioListar";
     }
 
     @GetMapping("/eliminartipoUsuario/{id}")
     public String eliminar (@PathVariable(name="id") int idtipoUsuario, Model model) {
         //Turista turista = turistaServicio.consultar(id);
         tipoUsuarioSerivicio.eliminar(idtipoUsuario);
         return "redirect:/tipoUsuarioListar";
     }
 
     @GetMapping("/modificartipoUsuario/{id}")
     public String modificar (@PathVariable(name="id")int idtipoUsuario,Model model) {
         TipoUsuario tipoUsuario = tipoUsuarioSerivicio.consultar(idtipoUsuario);
         model.addAttribute("tipoUsuario", tipoUsuario);
         model.addAttribute("mensaje","editar");
         return "tipoUsuarioEditar";
     }
}

