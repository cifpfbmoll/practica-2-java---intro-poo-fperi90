package com.poortoys.examples;

import java.util.ArrayList;
import java.util.Scanner;

public class Persona {
	public static Scanner lp = new Scanner(System.in);
	private String nombre;
	private String apellidos;
	private String nif;
	private String contraseña;

	// constructor vacio de persona
	public Persona() {
	}

	// constructor con parametros de persona
	public Persona(String nombre, String apellidos, String nif, String contraseña) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.contraseña = contraseña;
	}

	// DTO gettes y setters para persona
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", contraseña=" + contraseña
				+ "]";
	}

	// Constructor copia de persona.
	public Persona(Persona p1) {
		this.setNombre(p1.getNombre());
		this.setApellidos(p1.getApellidos());
		this.setNif(p1.getNif());
		this.setContraseña(p1.getNif());
	}

	public static void añadirPersona(ArrayList<Persona> listaPersonas) {
		Persona p0 = new Persona();
		System.out.println("Introduce el nombre del usuario:");
		p0.setNombre(lp.nextLine());
		System.out.println("Introduce los apellidos del usuario (separados por un espacio):");
		p0.setApellidos(lp.nextLine());
		System.out.println("Introduce el nif del usuario: ");
		p0.setNif(lp.nextLine());
		System.out.println("Introduce una contraseña para administrar el usuario:");
		p0.setContraseña(lp.nextLine());
		listaPersonas.add(p0);
	}

	public static void eliminarPersona(ArrayList<Persona> listaPersonas) {
		System.out.println("Introduce el NIF del usuario que quieres dar de baja: ");
		String findNIF = lp.nextLine();
		boolean nifEncontrado = false;
		int p = 0;
		while (nifEncontrado == false && p < listaPersonas.size()) {
			if (findNIF.equals(listaPersonas.get(p).getNif())) {
				System.out.println("Encontrado el registro: " + listaPersonas.get(p).toString());
				System.out.println("Registro con nif " + listaPersonas.get(p).getNif() + " eliminado.");
				listaPersonas.remove(p);
				nifEncontrado = true;
			}
			p++;
		}if(nifEncontrado==false) {
			System.out.println("No se ha encontrado ningún NIF coincidente.");
		}
	}

	// Método estático de persona que muestra todos los usuarios registrados en la
	// biblioteca.
	public static void mostrarPersonas(ArrayList<Persona> listaPersonas) {
		System.out.println("A continuación se muestran todos los usuarios registrados en la biblioteca: ");
		for (int i = 0; i < listaPersonas.size(); i++) {
			System.out.println(listaPersonas.get(i).toString());
		}
		System.out.println("Mostrados todos los usuarios. ");
	}
	
	//para inicializar personas
	public static void incializarPersonas(ArrayList<Persona> listaPersonas) {
		Persona p1 = new Persona("Franco", "Peri Bustos", "X3378273X", "tester");
		Persona p2 = new Persona("Albert", "Einstein", "4567893Q", "tester1");
		Persona p3 = new Persona("Thomas", "Edison", "1365478T", "tester2");
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		listaPersonas.add(p3);
	}
}
