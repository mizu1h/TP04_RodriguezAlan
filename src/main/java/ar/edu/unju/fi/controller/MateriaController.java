package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.collections.ListaMateria;
@Controller
public class MateriaController {
	@Autowired
	Materia nuevaMateria;
	
	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		ModelAndView modelView = new ModelAndView("Materia/formularioMateria");
		modelView.addObject("nuevaMateria",nuevaMateria);
		
		return modelView;
	}
	@PostMapping("/mostrarMateria")
	public ModelAndView viewMateria() {
		ModelAndView modelView = new ModelAndView("materia/listadoMateria");
		modelView.addObject("listadoMaterias",ListaMateria.listarMaterias());
		
		return modelView;
	}
	@PostMapping("/guardarMateria")
	public ModelAndView saveMateria(@ModelAttribute ("nuevaMateria") Materia Materia) {
		
		ListaMateria.agregarMateria(Materia);
		ModelAndView modelView = new ModelAndView("materia/listadoMateria");
		modelView.addObject("listadoMaterias",ListaMateria.listarMaterias());
		
		return modelView;
	}
	@GetMapping("/borrarMateria/{codigo}")
	public ModelAndView borrarMateria(@PathVariable(name="codigo") String codigo){
		ListaMateria.eliminarMateria(codigo);
		ModelAndView modelView = new ModelAndView("materia/listadoMateria");
		modelView.addObject("listadoMaterias",ListaMateria.listarMaterias());
		
		return modelView;
	}
	
	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView mostrarFormularioModificarMateria(@PathVariable("codigo") String codigo){
		nuevaMateria = ListaMateria.buscarMateriaPorCodigo(codigo);
		ModelAndView modelView = new ModelAndView("materia/modificadorMateria");
		modelView.addObject("Materia", nuevaMateria);

		return modelView;
	}
	
	@PostMapping("/guardarModificacionMateria")
	public ModelAndView guardarModificacionMateria(@ModelAttribute ("Materia") Materia Materia) {
		
		ListaMateria.modificarMateria(Materia);
		ModelAndView modelView = new ModelAndView("materia/listadoMateria");
		modelView.addObject("listadoMaterias",ListaMateria.listarMaterias());
		
		return modelView;
	}
}
