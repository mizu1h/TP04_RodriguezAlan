package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ar.edu.unju.fi.model.Carrera;

public class ListaCarrera {
public static List<Carrera> carreras = new ArrayList<Carrera>();
	
	public static List<Carrera> listarCarreras(){
		return carreras;
	}
	public static Carrera buscarCarreraPorCodigo(String codigo) {
		for(Carrera c : carreras) {
			if(c.getCodigo().equals(codigo)){
				return c;
			}
		}
		return null;
	}
	
	public static void agregarCarrera(Carrera c) {
		c.setEstado(true);
		carreras.add(c);
	}
	
	public static void modificarCarrera(Carrera carreraModificada) {
	    for (int i = 0; i < carreras.size(); i++) {
	        Carrera carrera = carreras.get(i);
	        if (carrera.getCodigo().equals(carreraModificada.getCodigo())) {
	            carreras.set(i, carreraModificada);
	            break;
	        }
	    }
	}
	
	public static void eliminarCarrera(String codigo) {
	    Iterator<Carrera> iterator = carreras.iterator();
	    while (iterator.hasNext()) {
	        Carrera c = iterator.next();
	        if (c.getCodigo().equals(codigo)) {
	            iterator.remove();
	            break;
	        }
	    }
	}
	
	public static void darDeBajaCarrera(String codigo) {
		for(Carrera c : carreras) {
			if(codigo.equals(c.getCodigo())){
				c.setEstado(false);
				break;
			}
		}
	}
	public static void darDeAltaCarrera(String codigo) {
		for(Carrera c : carreras) {
			if(codigo.equals(c.getCodigo())){
				c.setEstado(true);
				break;
			}
		}
	}
}
