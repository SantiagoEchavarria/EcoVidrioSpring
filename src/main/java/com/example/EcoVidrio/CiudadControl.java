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
@SessionAttributes({"ciudad"})
public class CiudadControl {
   @Autowired
   private CiudadInterface ciudadServicio;
   
	@Autowired
	private DepartamentoInterface departamentoServicio;

   @ModelAttribute("departamento")
	public List<Departamento> datosDepartamentos(){
		return departamentoServicio.listadoDepartamentos();
	}


   public CiudadControl() {
   }

   @GetMapping({"ciudadInsertar"})
   public String ciudadInsertar(Model model) {
      Ciudad ciudad = new Ciudad();
      model.addAttribute("departamento", departamentoServicio.obtenerDepartamentosHabilitados());
      model.addAttribute("ciudad", ciudad);
      model.addAttribute("mensaje", "nuevo ciudad");
      return "ciudadInsertar";
   }



  
   @PostMapping({"/insertarCiudad"})
   public String insertarCiudad(@ModelAttribute(name = "ciudad") Ciudad ciudad, 
   Model model, SessionStatus status) {
      this.ciudadServicio.guardarCiudad(ciudad);
      status.setComplete();
      return "redirect:ciudadListar";
   }

   @GetMapping({"/ciudadListar"})
   public String ciudadListar(Model model) {
      List<Ciudad> ciudad = this.ciudadServicio.listadoCiudades();
      model.addAttribute("ciudad", ciudad);
      model.addAttribute("mensaje", "Listado de ciudades");
      return "ciudadListar";
   }


   
   //Invento Aparte

   @GetMapping ("/consultarCiudad/(id)")
  public String consultarDepartamento(@PathVariable (name="id") int id, Model model) {
     
      Ciudad ciudad = ciudadServicio.consultar(id);
     model.addAttribute("ciudad", ciudad);
     model.addAttribute("mensaje","ciudad");
     return "redirect:/ciudadListar";
  }
   /* 
   @GetMapping("/eliminarCiudad/{id}")
  public String eliminarDepartamento (@PathVariable(name="id") int id, Model model) {

      ciudadServicio.eliminar(id);
     return "redirect:/ciudadListar";
  }
   */

   // Método para inhabilitar la ciudad
   @GetMapping("/inhabilitarCiudad/{id}")
   public String inhabilitarCiudad(@PathVariable(name = "id") int id, Model model) {
   
      ciudadServicio.inhabilitar(id);  // Cambiar el estado de la ciudad a inhabilitado
      return "redirect:/ciudadListar";
   }
   //metodo para habilitar la ciudad
   @GetMapping("/habilitarCiudad/{id}")
   public String habilitarCiudad(@PathVariable("id") int id) {

      ciudadServicio.habilitarCiudad(id);
      return "redirect:/ciudadListar"; // Redirige a la lista de ciudades después de habilitar  
}




  @GetMapping("/modificarCiudad/{id}")
  public String modificarDepartamento (@PathVariable(name="id") int id,Model model) {
     Ciudad ciudad = ciudadServicio.consultar(id);
     model.addAttribute("ciudad", ciudad);
     model.addAttribute("mensaje","editar");
     return "ciudadEditar";
  }
}
