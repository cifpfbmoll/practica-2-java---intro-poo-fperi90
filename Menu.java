package com.poortoys.examples;

import java.util.Scanner;

public class Menu {
	public static Scanner lectorMain = new Scanner(System.in);
	private static int opcion = 0;
	private static boolean salirPrincipal = false;
	private static boolean salirBiblioteca = false;
	private static boolean salirUsuarios = false;
	public static Biblioteca biblioteca = new Biblioteca();

	public static void main(String[] args) {
		iniciar();
		while (salirPrincipal == false) {
			System.out.println("Bienvenido a version Biblioteca 2.0");
			System.out.println("¿A que menú quieres acceder?");
			System.out.println("1 : Menu biblioteca ");
			System.out.println("2 : Menu usuarios");
			System.out.println("3 : Salir");
			opcion = Integer.parseInt(lectorMain.nextLine());
			switch (opcion) {
			case 1:
				mostrarMenuBiblioteca();
				break;
			case 2:
				mostrarMenuUsuarios();
				break;
			case 3:
				salirPrincipal = true;
				break;
			}
		}
	}

	public static void mostrarMenuBiblioteca() {
		// tengo que instanciar un objeto del tipo biblioteca dentro del metodo para
		// despues pasarlo por parametro a los metodos de libro y que vaya añadiendo
		// una vez creado el método biblioteca, llamo a inicializar Biblioteca de la1
		// clase libro, para que le vaya añadiendo unos libros para poder ir trabajando
		// con ellos.
		salirBiblioteca = false;
		while (salirBiblioteca == false) {
			System.out.println("		Menú biblioteca     ");
			System.out.println("	  ¿Que quieres hacer?");
			System.out.println("1 - Añadir libro ");
			System.out.println("2 - Eliminar libro ");
			System.out.println("3 - Buscar libro por ISBN");
			System.out.println("4 - Buscar libro por titulo");
			System.out.println("5 - Mostrar lista de libros actual");
			System.out.println("6 - Mostrar libros disponibles ");
			System.out.println("7 - Salir.");
			opcion = Integer.parseInt(lectorMain.nextLine());
			switch (opcion) {
			case 1:
				System.out.println("1 - Añadir libro ");
				Libro.añadirLibro(biblioteca.getListaLibros());
				break;
			case 2:
				System.out.println("2 - Eliminar libro ");
				Libro.eliminarLibro(biblioteca.getListaLibros());
				break;
			case 3:
				System.out.println("3 - Buscar libro por ISBN");
				Libro.buscarLibroIsbn(biblioteca.getListaLibros());
				break;
			case 4:
				System.out.println("4 - Buscar libro por titulo");
				Libro.buscarLibroTitulo(biblioteca.getListaLibros());
				break;
			case 5:
				System.out.println("5 - Mostrar lista de libros actual");
				biblioteca.mostrarLibros();
				break;
			case 6:
				System.out.println("6 - Mostrar libros disponibles ");
				biblioteca.mostrarLibrosDisponibles();
				break;
			case 7:
				salirBiblioteca = true;
				break;
			}
		}
	}

	// este metodo se utiliza para inicializar la biblioteca con libros y personas
	// por defecto para pdoer ir haciendo pruebas con ellos.
	public static void iniciar() {
		Libro.inicializarBiblioteca(biblioteca.getListaLibros());
		Persona.incializarPersonas(biblioteca.getUsuariosBiblioteca());
	}

	public static void mostrarMenuUsuarios() {
		salirUsuarios = false;
		while (salirUsuarios == false) {
			System.out.println("		Menú usuarios     ");
			System.out.println("	  ¿Que quieres hacer?");
			System.out.println("1 - Dar de alta usuario ");
			System.out.println("2 - Dar de baja usuario (por NIF) ");
			System.out.println("3 - Mostrar todos los usuarios.");
			System.out.println("4 - Salir.");
			opcion = Integer.parseInt(lectorMain.nextLine());
			switch (opcion) {
			case 1:
				Persona.añadirPersona(biblioteca.getUsuariosBiblioteca());
				break;
			case 2:
				Persona.eliminarPersona(biblioteca.getUsuariosBiblioteca());
				break;
			case 3:
				Persona.mostrarPersonas(biblioteca.getUsuariosBiblioteca());
				break;
			case 4:
				salirUsuarios = true;
				break;
			}
		}
	}
}
