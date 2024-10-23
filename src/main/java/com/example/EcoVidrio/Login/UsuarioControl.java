package com.example.EcoVidrio.Login;

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
@SessionAttributes({"usuario"})
public class UsuarioControl {
      @Autowired
    private UsuarioInterface usuarioServicio;
    
    	@Autowired
	private TipoUsuarioInterface tipoUsuarioServicio;

   @Autowired
    private EmailServicio emailService;

   @ModelAttribute("tipoUsuario")
	public List<TipoUsuario> datosDipoUsuarios(){
		return tipoUsuarioServicio.listadoTipoUsuarios();
	}


   public UsuarioControl() {
   }

   @GetMapping({"usuarioInsertar"})
   public String usuarioInsertar(Model model) {
       Usuario usuario = new Usuario();
      model.addAttribute("usuario", usuario);
      model.addAttribute("mensaje", "");
      return "usuarioInsertar";
   }

   @GetMapping({"usuarioRecuperarContrasena"})
   public String recuperarUsuario(Model model) {
       Usuario usuario = new Usuario();
      model.addAttribute("usuario", usuario);
      model.addAttribute("mensaje", "");
      return "usuarioRecuperarContrasena";
   }



   @GetMapping({"usuarioIngresar"})
   public String usuarioIngresar(Model model) {
       Usuario usuario = new Usuario();
      model.addAttribute("usuario", usuario);
      model.addAttribute("mensaje", "");
      return "usuarioIngresar";
   }


  
   @PostMapping({"/insertarUsuario"})
   public String insertarUsuario(@ModelAttribute(name = "usuario") Usuario usuario, 
   Model model, SessionStatus status) {
      this.usuarioServicio.guardarUsuario(usuario);
      status.setComplete();
      return "redirect:usuarioInsertar";
   }


   @PostMapping({"/ingresarUsuario"})
public String ingresarUsuario(@ModelAttribute(name = "usuario") Usuario usuario, 
                              Model model, SessionStatus status) {
    Usuario usuarioExistente = usuarioServicio.consultar(usuario.getEmail());

    if (usuarioExistente != null) {
        if (usuarioExistente.getContrasena().equals(usuario.getContrasena())) {
            if (usuarioExistente.getTipoUsuario().getId()==usuario.getTipoUsuario().getId()) {
                System.out.println("Existe Usuario, contraseña y tipo de usuario correctos............................");
                status.setComplete();
                return "redirect:/operadorInsertar";
            } else {
                System.out.println("Existe Usuario pero el tipo de usuario es incorrecto............................");
                model.addAttribute("error", "Tipo de usuario incorrecto");
                return "redirect:/usuarioIngresar";
            }
        } else {
            System.out.println("Existe Usuario pero la contraseña es incorrecta............................");
            model.addAttribute("error", "Contraseña incorrecta");
            return "redirect:/usuarioIngresar";
        }
    }
    System.out.println("No existe Usuario............................");
    // Guardar el nuevo usuario si no existe
    //this.usuarioServicio.guardarUsuario(usuario);
    status.setComplete();
    return "redirect:/usuarioIngresar";
}

@PostMapping("/recuperarUsuario")
public String recuperarContrasena(@RequestParam("email") String email, Model model, SessionStatus status) {
    Usuario usuarioExistente = usuarioServicio.consultar(email);

    if (usuarioExistente != null) {
        String contrasena = usuarioExistente.getContrasena(); // Obtener la contraseña

        // Enviar correo con la contraseña
        String mensaje = "Su contraseña es: " + contrasena;
        emailService.enviarCorreo(email, "Recuperación de contraseña", mensaje);

        status.setComplete();
        model.addAttribute("mensaje", "Se ha enviado su contraseña al correo electrónico.");
        return "usuarioRecuperarContrasena"; // Retornar la vista sin redireccionar
    } else {
        model.addAttribute("error", "No se encontró un usuario con ese email.");
        return "usuarioRecuperarContrasena"; // Mantener la misma vista
    }
}


/* v2 funcional
@PostMapping("/recuperarUsuario")
public String recuperarContrasena(@RequestParam("email") String email, Model model, SessionStatus status) {
    Usuario usuarioExistente = usuarioServicio.consultar(email);

    if (usuarioExistente != null) {
        String contrasena = usuarioExistente.getContrasena(); // Obtener la contraseña

        // Enviar correo con la contraseña
        String mensaje = "Su contraseña es: " + contrasena;
        emailService.enviarCorreo(email, "Recuperación de contraseña", mensaje);

        status.setComplete();
        model.addAttribute("mensaje", "Se ha enviado su contraseña al correo electrónico.");
        return "redirect:/usuarioRecuperarContrasena";
    } else {
        model.addAttribute("error", "No se encontró un usuario con ese email.");
        return "usuarioRecuperarContrasena";
    }
}
*/

/* 
@PostMapping("/recuperarUsuario")
public String recuperarContrasena(@ModelAttribute("usuario") Usuario usuario, Model model, SessionStatus status) {
    Usuario usuarioExistente = usuarioServicio.consultar(usuario.getEmail());

    if (usuarioExistente != null) {
        String contrasena = usuarioExistente.getContrasena(); // Obtener la contraseña

        // Enviar correo con la contraseña
        String mensaje = "Su contraseña es: " + contrasena;
        emailService.enviarCorreo(usuario.getEmail(), "Recuperación de contraseña", mensaje);

        status.setComplete();
        model.addAttribute("mensaje", "Se ha enviado su contraseña al correo electrónico.");
        return "redirect:recuperarContrasena";
    } else {
        model.addAttribute("error", "No se encontró un usuario con ese email.");
        return "usuarioRecuperarContrasena";
    }
}*/




   @GetMapping({"/usuarioListar"})
   public String csuarioListar(Model model) {
      List<Usuario> usuario = this.usuarioServicio.listadoUsuarios();
      model.addAttribute("usuario", usuario);
      model.addAttribute("mensaje", "Listado de usuarios");
      return "usuarioListar";
   }


   
   //Invento Aparte

   @GetMapping ("/consultarCsuario/(email)")
  public String consultarDipoUsuario(@PathVariable (name="email") String email, Model model) {
     
      Usuario usuario = usuarioServicio.consultar(email);
     model.addAttribute("csuario", usuario);
     model.addAttribute("mensaje","usuario");
     return "redirect:/usuarioListar";
  }

   @GetMapping("/eliminarUsuario/{email}")
  public String eliminarTipoUsuario (@PathVariable(name="email") String email, Model model) {

      usuarioServicio.eliminar(email);
     return "redirect:/usuarioListar";
  }

  @GetMapping("/modificarUsuario/{email}")
  public String modificarDipoUsuario (@PathVariable(name="email") String email,Model model) {
     Usuario usuario = usuarioServicio.consultar(email);
     model.addAttribute("usuario", usuario);
     model.addAttribute("mensaje","editar");
     return "usuarioEditar";
  }
}
