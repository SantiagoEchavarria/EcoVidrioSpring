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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;




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
    public String insertarUsuario(@ModelAttribute(name = "usuario") Usuario usuario, Model model, RedirectAttributes redirectAttributes) {
        // Verificar si el usuario ya existe
        if (usuarioServicio.consultar(usuario.getEmail()) != null) {
            redirectAttributes.addFlashAttribute("error", "El correo electrónico ya está registrado.");
            return "redirect:usuarioInsertar"; // Redirigir al formulario de inserción
        }
        
        // Si no existe, guardar el usuario
        usuarioServicio.guardarUsuario(usuario);
        // Establecer un mensaje de éxito
        redirectAttributes.addFlashAttribute("success", "Usuario creado con éxito.");
        return "redirect:/usuarioInsertar"; // Redirigir después de insertar
    }



   @PostMapping("/ingresarUsuario")
   public String ingresarUsuario(@ModelAttribute(name = "usuario") Usuario usuario, Model model, HttpSession session) {
       Usuario usuarioExistente = usuarioServicio.consultar(usuario.getEmail());
       if (usuarioExistente != null) {
           if (usuarioExistente.getContrasena().equals(usuario.getContrasena())) {
            session.setAttribute("tipoUsuarioId", usuarioExistente.getTipoUsuario().getId());
            session.setAttribute("usuarioEmail", usuarioExistente.getEmail());
                if (usuarioExistente.getTipoUsuario().getId() == usuario.getTipoUsuario().getId()) {
                    if(usuario.getTipoUsuario().getId()==2){
                        System.out.println("Entro como admin");
                        System.out.println(usuarioExistente.getEmail());
                        return "redirect:/operadorListar"; 
                    }else{
                        System.out.println("Entro como operador u otro");
                        System.out.println(usuarioExistente.getEmail());
                        return "redirect:/operadorListar"; 
                    }
                  
               } else {
                   model.addAttribute("error", "Tipo de usuario incorrecto.");
               }
           } else {
               model.addAttribute("error", "Contraseña incorrecta.");
           }
       } else {
           model.addAttribute("error", "No existe el usuario.");
       }
       return "usuarioIngresar"; 
   }
   

   @PostMapping("/recuperarUsuario")
   public String recuperarContrasena(@RequestParam("email") String email, Model model, SessionStatus status) {
       // Verificar si el usuario existe
       Usuario usuarioExistente = usuarioServicio.consultar(email);
   
       if (usuarioExistente != null) {
           // Si existe, enviar la contraseña
           String contrasena = usuarioExistente.getContrasena();
           String mensaje = "Su contraseña es: " + contrasena;
           
           // Enviar correo con la contraseña
           emailService.enviarCorreo(email, "Recuperación de contraseña", mensaje);
   
           // Establecer mensaje de éxito
           model.addAttribute("mensaje", "Se ha enviado su contraseña al correo electrónico.");
           status.setComplete(); // Finaliza la sesión
       } else {
           // Si no existe, mostrar mensaje de error
           model.addAttribute("error", "No se encontró un usuario con ese email.");
       }
   
       return "usuarioRecuperarContrasena"; // Retornar la vista sin redireccionar
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
   @GetMapping("/consultarUsuario/{email}")
   public String consultarUsuario(@PathVariable(name = "email") String email, Model model) {
       Usuario usuario = usuarioServicio.consultar(email);
       model.addAttribute("usuario", usuario); // Asegúrate de que el nombre sea coherente
       model.addAttribute("mensaje", "Usuario encontrado");
       return "redirect:/usuarioListar";
  }

  @GetMapping("/eliminarUsuario/{email}")
  public String eliminarUsuario(@PathVariable(name = "email") String email, Model model) {
      usuarioServicio.eliminar(email);
      model.addAttribute("mensaje", "Usuario eliminado con éxito.");
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
