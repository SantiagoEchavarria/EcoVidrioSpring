package com.example.EcoVidrio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"direccion"})
public class DireccionControl {
     @Autowired
   private DireccionInterface direccionServicio;

   @Autowired
	private CiudadInterface ciudadServicio;

   @Autowired
   private DepartamentoDAO departamentoRepository;

	
	@ModelAttribute("ciudad")
	public List<Ciudad> datosCiudad(){
		return ciudadServicio.listadoCiudades();
	}


   //
   @GetMapping("/direccionInsertar")
   public String mostrarFormulario(Model model) {
       // Cargar los departamentos para mostrarlos en el select
       List<Departamento> departamentos = departamentoRepository.findAll();
       model.addAttribute("departamentos", departamentos);
       
       // Crear un nuevo objeto Dirección para el formulario
       model.addAttribute("direccion", new Direccion());
       
       return "direccionInsertar";  // Nombre del archivo HTML Thymeleaf
   }


    @PostMapping("/guardarDireccion")
    public String guardarDireccion(@ModelAttribute Direccion direccion, @RequestParam int ciudadId) {
        Ciudad ciudad = ciudadServicio.consultar(ciudadId);
        direccion.setCiudad(ciudad);
        direccionServicio.guardarDireccion(direccion);
        return "redirect:/direccionListar";
    }

   //

   public DireccionControl() {
   }
/* el real
   @GetMapping({"direccionInsertar"})
   public String direccionInsertar(Model model) {
       Direccion direccion = new Direccion();
      model.addAttribute("direccion", direccion);
      model.addAttribute("mensaje", "nuevo cireccion");
      return "direccionInsertar";
   }*/



  
   @PostMapping({"/insertarDireccion"})
   public String insertarCireccion(@ModelAttribute(name = "direccion") Direccion direccion, 
   Model model, SessionStatus status) {
      this.direccionServicio.guardarDireccion(direccion);
      status.setComplete();
      return "redirect:direccionListar";
   }

   @GetMapping({"/direccionListar"})
   public String cireccionListar(Model model) {
      List<Direccion> direccion = this.direccionServicio.listadoDirecciones();
      model.addAttribute("direccion", direccion);
      model.addAttribute("mensaje", "Listado de direcciones");
      return "direccionListar";
   }


   
   //Invento Aparte

   @GetMapping ("/consultarDireccion/(nombreDireccion)")
  public String consultarDepartamento(@PathVariable (name="nombre") int id, Model model) {
     
      Direccion direccion = direccionServicio.consultar(id);
     model.addAttribute("cireccion", direccion);
     model.addAttribute("mensaje","direccion");
     return "redirect:/direccionListar";
  }

   @GetMapping("/eliminarDireccion/{nombreDireccion}")
  public String eliminarDepartamento (@PathVariable(name="nombreDireccion") int id, Model model) {
     
      direccionServicio.eliminar(id);
     return "redirect:/direccionListar";
  }

  @GetMapping("/modificarDireccion/{nombreDireccion}")
  public String modificarDepartamento (@PathVariable(name="nombreDireccion") int id,Model model) {
     Direccion direccion = direccionServicio.consultar(id);
     model.addAttribute("direccion", direccion);
     model.addAttribute("mensaje","editar");
     return "direccionEditar";
  }
}
