package controlador;

import java.util.Arrays;

import metodos.Metodos;
import util.Utils;

public class ControladorMetodosOrdenacion {
	private Utils utils = new Utils();
	private Metodos metodos = new Metodos();
	private int opcionMenuSeleccionada = 0;
	long time_init = 0;
	long time_final = 0;
	
	public long usarMetodoSeleccion(int[] array_a_ordenar) {
		long tiempo_final_Seleccion = 0;
		System.out.println("Estamos en el método Selección con el array desordenado: "+Arrays.toString(array_a_ordenar));
		
		time_init = System.nanoTime();
		metodos.seleccion(array_a_ordenar);
		time_final = System.nanoTime();
		tiempo_final_Seleccion = time_final - time_init;
		System.out.println("Tiempo de ejecución: " + (tiempo_final_Seleccion) + " ns");
		
		return tiempo_final_Seleccion;
	}
	
	public long usarMetodoSeleccion2(int[] array_a_ordenar) {
		long tiempo_final_Seleccion = 0;
		System.out.println("Estamos en el método Selección Optimizado con el array desordenado: "+Arrays.toString(array_a_ordenar));
		
		time_init = System.nanoTime();
		metodos.seleccion2(array_a_ordenar);
		time_final = System.nanoTime();
		tiempo_final_Seleccion = time_final - time_init;
		System.out.println("Tiempo de ejecución: " + (tiempo_final_Seleccion) + " ns");
		
		return tiempo_final_Seleccion;
	}
	
	public long usarMetodoBurbuja(int[] array_a_ordenar2) {
		long tiempo_final_Burbuja = 0;
		System.out.println("Estamos en el método Burbuja con el array desordenado: "+Arrays.toString(array_a_ordenar2));
		
		time_init = System.nanoTime();
		metodos.burbuja(array_a_ordenar2);
		time_final = System.nanoTime();
		tiempo_final_Burbuja = time_final - time_init;
		System.out.println("Tiempo de ejecución: " + (tiempo_final_Burbuja) + " ns");
		
		return tiempo_final_Burbuja;
	}
	
	public long usarMetodoInserccion(int[] array_a_ordenar3) {
		long tiempo_final_Inserccion = 0;
		System.out.println("Estamos en el método Insercción con el array desordenado: "+Arrays.toString(array_a_ordenar3));
		
		time_init = System.nanoTime();
		metodos.inserccion(array_a_ordenar3);
		time_final = System.nanoTime();
		tiempo_final_Inserccion = time_final - time_init;
		System.out.println("Tiempo de ejecución: " + (tiempo_final_Inserccion) + " ns");
		
		return tiempo_final_Inserccion;
	}
	
	public long usarMetodoMergeSort(int[] array_a_ordenar4) {
		long tiempo_final_MergeSort = 0;
		System.out.println("Estamos en el método MergeSort con el array desordenado: "+Arrays.toString(array_a_ordenar4));
		
		time_init = System.nanoTime();
		metodos.mergesort(array_a_ordenar4, 0, array_a_ordenar4.length-1);
		time_final = System.nanoTime();
		tiempo_final_MergeSort = time_final - time_init;
		System.out.println("Tiempo de ejecución: " + (tiempo_final_MergeSort) + " ns");
		
		return tiempo_final_MergeSort;
	}
	
	public long usarMetodoQuickSort(int[] array_a_ordenar5) {
		long tiempo_final_QuickSort = 0;
		System.out.println("Estamos en el método MergeSort con el array desordenado: "+Arrays.toString(array_a_ordenar5));
		
		time_init = System.nanoTime();
		metodos.quicksort(array_a_ordenar5, 0, array_a_ordenar5.length-1);
		time_final = System.nanoTime();
		tiempo_final_QuickSort = time_final - time_init;
		System.out.println("Tiempo de ejecución: " + (tiempo_final_QuickSort) + " ns");
		
		return tiempo_final_QuickSort;
	}
	
	public int opcionMostrarInfo() {
		 return opcionMenuSeleccionada = utils.opcionMostrarInfo();
	}
	
	public int llamarAlMenu() {
		 return opcionMenuSeleccionada = utils.menu();
	}
	

}
