package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;

public class ListaAlumnos {
public static List<Alumno> Alumnos = new ArrayList<Alumno>();
	
	public static List<Alumno> listarAlumnos(){
		return Alumnos;
	}
	
	public static Alumno buscarAlumnoPorCodigo(String codigo){
		for(Alumno a : Alumnos) {
			if(a.getLU().equals(codigo)){
				return a;
			}
		}
		return null;
	}
	
	public static void agregarAlumno(Alumno a) {
		Alumnos.add(a);
	}
	
	public static void modificarAlumno(Alumno AlumnoModificada) {
		for(int i = 0 ; i < Alumnos.size() ; i++) {
			Alumno alumno = Alumnos.get(i);
			if(alumno.getLU().equals(AlumnoModificada.getLU())) {
				Alumnos.set(i,AlumnoModificada);
				break;
			}
		}
	}
	
	public static void eliminarAlumno(String codigo) {
		Iterator<Alumno> iterator = Alumnos.iterator();
	    while (iterator.hasNext()) {
	        Alumno a = iterator.next();
	        if (a.getLU().equals(codigo)) {
	            iterator.remove();
	            break;
	        }
	    }
	}
}
