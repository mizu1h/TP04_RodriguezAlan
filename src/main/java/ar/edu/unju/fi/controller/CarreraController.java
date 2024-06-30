package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListaCarrera;
import ar.edu.unju.fi.model.Carrera;

@Controller
public class CarreraController {
	@Autowired
	Carrera nuevaCarrera;
	
	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
		ModelAndView modelView = new ModelAndView("/Carrera/FormularioCarrera");
		modelView.addObject("nuevaCarrera",nuevaCarrera);
		
		return modelView;
	}
	@PostMapping("/guardarCarrera")
	public ModelAndView saveCarrera(@ModelAttribute ("nuevaCarrera") Carrera carrera) {
		
		ListaCarrera.agregarCarrera(carrera);
		ModelAndView modelView = new ModelAndView("/Carrera/ListadoCarrera");
		modelView.addObject("listadoCarreras",ListaCarrera.listarCarreras());
		
		return modelView;
	}
	@GetMapping("/borrarCarrera/{codigo}")
	public ModelAndView borrarCarrera(@PathVariable(name="codigo") String codigo){
		ListaCarrera.eliminarCarrera(codigo);
		ModelAndView modelView = new ModelAndView("/Carrera/ListadoCarrera");
		modelView.addObject("listadoCarreras",ListaCarrera.listarCarreras());
		
		return modelView;
	}
	
	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView mostrarFormularioModificarCarrera(@PathVariable("codigo") String codigo){
		nuevaCarrera = ListaCarrera.buscarCarreraPorCodigo(codigo);
		ModelAndView modelView = new ModelAndView("/Carrera/ModificarCarrera");
		modelView.addObject("carrera", nuevaCarrera);

		return modelView;
	}
	
	@PostMapping("/guardarModificacionCarrera")
	public ModelAndView guardarModificacionCarrera(@ModelAttribute ("carrera") Carrera carrera) {
		
		ListaCarrera.modificarCarrera(carrera);
		ModelAndView modelView = new ModelAndView("/Carrera/ListadoCarrera");
		modelView.addObject("listadoCarreras",ListaCarrera.listarCarreras());
		
		return modelView;
	}
	
	@GetMapping("/darDeBajaCarrera/{codigo}")
	public ModelAndView darDeBajaCarrera(@PathVariable(name="codigo") String codigo){
		ListaCarrera.darDeBajaCarrera(codigo);
		ModelAndView modelView = new ModelAndView("/Carrera/ListadoCarrera");
		modelView.addObject("listadoCarreras",ListaCarrera.listarCarreras());
		
		return modelView;
	}
	@GetMapping("/darDeAltaCarrera/{codigo}")
	public ModelAndView darDeAltaCarrera(@PathVariable(name="codigo") String codigo){
		ListaCarrera.darDeAltaCarrera(codigo);
		ModelAndView modelView = new ModelAndView("/Carrera/listadoCarrera");
		modelView.addObject("listadoCarreras",ListaCarrera.listarCarreras());
		
		return modelView;
	}
}
