package com.viviendas.Controller;

import java.beans.PropertyEditorSupport;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.viviendas.Models.Barrio;
import com.viviendas.Models.Propietario;
import com.viviendas.Models.Viviendas;
import com.viviendas.Service.BarrioService;
import com.viviendas.Service.PropietarioService;
import com.viviendas.Service.VivendaService;

@Controller
public class ViviendasController {
    @Autowired
    private VivendaService servicio;
    @Autowired
    private BarrioService servicioBarrio;
    @Autowired
    private PropietarioService servicioPropietario;

    @GetMapping({ "/viviendas", "/" })
    public String listarViviendas(Model modelo) {
        List<Viviendas> viviendas = servicio.listar();
        modelo.addAttribute("viviendas", viviendas);
        return "index"; // retorna al archivo index.html
    }
    @GetMapping("/viviendas/nuevo")
    public String FormularioRegistroVivienda(Model modelo) {
        Viviendas viviendas = new Viviendas();
         List<Propietario> propietarios = servicioPropietario.listar();
        List<Barrio> barrios = servicioBarrio.listar();
        modelo.addAttribute("propietarios", propietarios);
        modelo.addAttribute("barrios", barrios);
        modelo.addAttribute("vivienda", viviendas);
        return "crear"; // abre la pagina crear.html
    }
    
    @PostMapping("/viviendas")
    public String guardarVivienda(@ModelAttribute("vivienda") Viviendas vivienda) {
        servicio.guardarVivienda(vivienda);
        return "redirect:/viviendas"; // llama a la pagina ppal.
    }
    
    @GetMapping("/viviendas/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Integer id, Model modelo) {
        List<Propietario> propietarios = servicioPropietario.listar();
        List<Barrio> barrios = servicioBarrio.listar();
        modelo.addAttribute("vivienda", servicio.obtenerViviendaPorId(id));
        modelo.addAttribute("propietarios", propietarios);
        modelo.addAttribute("barrios", barrios);
        return "editar";
    }
    
    
    @PostMapping("/viviendas/{id}")
    public String actualizarVivienda(@PathVariable int id, @ModelAttribute("vivienda") Viviendas vivienda, Model modelo) {
        Viviendas viviendaExistente = servicio.obtenerViviendaPorId(id);
        Barrio barrio = servicioBarrio.obtenerPorId(vivienda.getBarrio().getId());
        Propietario propietario = servicioPropietario.obtenerPorId(vivienda.getPropietario().getId());
        // if (viviendaExistente == null) {
        //     // Manejar el caso en que la vivienda no se encuentre
        //     return "redirect:/viviendas";
        // }
        viviendaExistente.setId(id);
        viviendaExistente.setCalle(vivienda.getCalle());
        viviendaExistente.setNro(vivienda.getNro());
        viviendaExistente.setHabitantes(vivienda.getHabitantes());
        viviendaExistente.setTitular(vivienda.getTitular());
        viviendaExistente.setPropietario(propietario);
        viviendaExistente.setBarrio(barrio);
        servicio.actualizarVivienda(viviendaExistente);
        return "redirect:/viviendas";
    }
    
    
    
    @GetMapping("/viviendas/{id}")
    public String eliminarVivienda(@PathVariable int id) {
        servicio.eliminarVivienda(id);
        return "redirect:/viviendas";
    }
    
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Barrio.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                Barrio barrio = servicioBarrio.obtenerPorId(Integer.parseInt(text));
                setValue(barrio);
            }
        });

        binder.registerCustomEditor(Propietario.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                Propietario propietario = servicioPropietario.obtenerPorId(Integer.parseInt(text));
                setValue(propietario);
            }
        });
    }




}