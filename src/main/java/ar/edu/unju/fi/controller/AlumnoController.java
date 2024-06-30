package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.collections.ListaAlumnos;
import ar.edu.unju.fi.model.Alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlumnoController {
	@Autowired
	Alumno nuevoAlumno = new Alumno();
	
	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		ModelAndView modelView = new ModelAndView("Alumno/FormularioAlumno");
		modelView.addObject("nuevoAlumno",nuevoAlumno);
		
		return modelView;
	}
	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno(@ModelAttribute ("nuevoAlumno") Alumno Alumno) {
		
		ListaAlumnos.agregarAlumno(Alumno);
		ModelAndView modelView = new ModelAndView("Alumno/ListadoAlumno");
		modelView.addObject("listadoAlumnos",ListaAlumnos.listarAlumnos());
		
		return modelView;
	}
	@GetMapping("/borrarAlumno/{LU}")
	public ModelAndView borrarAlumno(@PathVariable(name="LU") String LU){
		ListaAlumnos.eliminarAlumno(LU);
		ModelAndView modelView = new ModelAndView("Alumno/ListadoAlumno");
		modelView.addObject("listadoAlumnos",ListaAlumnos.listarAlumnos());
		
		return modelView;
	}
	
	@GetMapping("/modificarAlumno/{LU}")
	public ModelAndView mostrarFormularioModificarAlumno(@PathVariable(name="LU") String LU){
		nuevoAlumno = ListaAlumnos.buscarAlumnoPorCodigo(LU);
		ModelAndView modelView = new ModelAndView("Alumno/ModificadorAlumno");
		modelView.addObject("Alumno", nuevoAlumno);

		return modelView;
	}
	
	@PostMapping("/guardarModificacionAlumno")
	public ModelAndView guardarModificacionAlumno(@ModelAttribute ("Alumno") Alumno Alumno) {
		
		ListaAlumnos.modificarAlumno(Alumno);
		ModelAndView modelView = new ModelAndView("Alumno/listadoAlumno");
		modelView.addObject("listadoAlumnos",ListaAlumnos.listarAlumnos());
		
		return modelView;
	}
}
