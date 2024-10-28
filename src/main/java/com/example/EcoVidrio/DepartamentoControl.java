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
@SessionAttributes({"departamento"})
public class DepartamentoControl {
    @Autowired
    private DepartamentoInterface departamentoServicio;

    public DepartamentoControl() {
    }

    @GetMapping({"departamentoInsertar"})
    public String departamentoInsertar(Model model) {
        Departamento departamento = new Departamento();
        model.addAttribute("departamento", departamento);
        model.addAttribute("mensaje", "nuevo departamento");
        return "departamentoInsertar";
    }

    @PostMapping({"/insertarDepartamento"})
    public String insertarDepartamento(@ModelAttribute(name = "departamento") Departamento departamento, 
                                       Model model, SessionStatus status) {
        this.departamentoServicio.guardarDepartamento(departamento);
        status.setComplete();
        return "redirect:departamentoListar";
    }

    @GetMapping({"/departamentoListar"})
    public String departamentoListar(Model model) {
        List<Departamento> departamento = this.departamentoServicio.listadoDepartamentos();
        model.addAttribute("departamento", departamento);
        model.addAttribute("mensaje", "Listado de departamentos");
        return "departamentoListar";
    }

    @GetMapping("/consultarDepartamento/{id}")
    public String consultarDepartamento(@PathVariable(name="id") int id, Model model) {
        Departamento departamento = departamentoServicio.consultar(id);
        model.addAttribute("departamento", departamento);
        model.addAttribute("mensaje", "consultar");
        return "redirect:/departamentoListar";
    }

    @GetMapping("/eliminarDepartamento/{id}")
    public String eliminarDepartamento(@PathVariable(name="id") int id) {
        departamentoServicio.eliminar(id);
        return "redirect:/departamentoListar";
    }

    @GetMapping("/modificarDepartamento/{id}")
    public String modificarDepartamento(@PathVariable(name="id") int id, Model model) {
        Departamento departamento = departamentoServicio.consultar(id);
        model.addAttribute("departamento", departamento);
        model.addAttribute("mensaje", "editar");
        return "departamentoEditar";
    }

    // Método para inhabilitar el departamento
    @GetMapping("/inhabilitarDepartamento/{id}")
    public String inhabilitarDepartamento(@PathVariable(name = "id") int id) {
        departamentoServicio.inhabilitar(id);  // Cambiar el estado del departamento a inhabilitado
        return "redirect:/departamentoListar";
    }

    // Método para habilitar el departamento
    @GetMapping("/habilitarDepartamento/{id}")
    public String habilitarDepartamento(@PathVariable(name = "id") int id) {
        departamentoServicio.habilitarDepartamento(id);
        return "redirect:/departamentoListar";
    }
}
