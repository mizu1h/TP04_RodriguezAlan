package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListaDocentes;
import ar.edu.unju.fi.model.Docente;

@Controller
public class DocenteController {
	@Autowired
	Docente nuevoDocente = new Docente();
	
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		ModelAndView modelView = new ModelAndView("Docente/formularioDocente");
		modelView.addObject("nuevoDocente",nuevoDocente);
		
		return modelView;
	}
	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente(@ModelAttribute ("nuevoDocente") Docente Docente) {
		
		ListaDocentes.agregarDocente(Docente);
		ModelAndView modelView = new ModelAndView("Docente/listadoDocente");
		modelView.addObject("listadoDocentes",ListaDocentes.listarDocentes());
		
		return modelView;
	}
	@GetMapping("/borrarDocente/{legajo}")
	public ModelAndView borrarDocente(@PathVariable(name="legajo") String legajo){
		ListaDocentes.eliminarDocente(legajo);
		ModelAndView modelView = new ModelAndView("Docente/listadoDocente");
		modelView.addObject("listadoDocentes",ListaDocentes.listarDocentes());
		
		return modelView;
	}
	
	@GetMapping("/modificarDocente/{legajo}")
	public ModelAndView mostrarFormularioModificarDocente(@PathVariable(name="legajo") String legajo){
		nuevoDocente = ListaDocentes.buscarDocentePorCodigo(legajo);
		ModelAndView modelView = new ModelAndView("docente/modificadorDocente");
		modelView.addObject("Docente", nuevoDocente);

		return modelView;
	}
	
	@PostMapping("/guardarModificacionDocente")
	public ModelAndView guardarModificacionDocente(@ModelAttribute ("Docente") Docente Docente) {
		
		ListaDocentes.modificarDocente(Docente);
		ModelAndView modelView = new ModelAndView("docente/listadoDocente");
		modelView.addObject("listadoDocentes",ListaDocentes.listarDocentes());
		
		return modelView;
	}
}
