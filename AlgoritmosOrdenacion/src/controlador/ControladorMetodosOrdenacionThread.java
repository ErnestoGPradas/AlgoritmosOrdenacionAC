package controlador;

import java.util.Arrays;

import metodos.Metodos;

public class ControladorMetodosOrdenacionThread extends Thread{

	private Metodos metodos = new Metodos();
	private int array_a_ordenar[];
	private int opcion=0;
	
	
	public ControladorMetodosOrdenacionThread(int[] array_a_ordenar, int opcion) {
		super();
		this.array_a_ordenar = array_a_ordenar;
		this.opcion = opcion;
	}



	@Override
	public void run() {
		
		long time_init = 0;
		long time_final = 0;
		
        switch (opcion) {
			case 1:
				System.out.println("Estamos en el hilo del m�todo Selecci�n con el array desordenado: "+Arrays.toString(array_a_ordenar));
				time_init = System.nanoTime();
				metodos.seleccion2(array_a_ordenar);
				time_final = System.nanoTime();
				System.out.println("Tiempo de ejecuci�n m�todo Selecci�n: " + (time_final - time_init) + " ns");
				break;
			case 2:
				System.out.println("Estamos en el hilo del m�todo Burbuja con el array desordenado: "+Arrays.toString(array_a_ordenar));
				time_init = System.nanoTime();
				metodos.burbuja(array_a_ordenar);
				time_final = System.nanoTime();
				System.out.println("Tiempo de ejecuci�n m�todo Burbuja: " + (time_final - time_init) + " ns");
				break;
			case 3:
				System.out.println("Estamos en el hilo del m�todo Insercci�n con el array desordenado: "+Arrays.toString(array_a_ordenar));
				time_init = System.nanoTime();
				metodos.inserccion(array_a_ordenar);
				time_final = System.nanoTime();
				System.out.println("Tiempo de ejecuci�n m�todo Insercci�n: " + (time_final - time_init) + " ns");
				break;
			case 4:
				System.out.println("Estamos en el hilo del m�todo mergeSort con el array desordenado: "+Arrays.toString(array_a_ordenar));
				time_init = System.nanoTime();
				metodos.mergesort(array_a_ordenar, 0, array_a_ordenar.length-1);
				time_final = System.nanoTime();
				System.out.println("Tiempo de ejecuci�n m�todo mergeSort: " + (time_final - time_init) + " ns");
				break;
			case 5:
				System.out.println("Estamos en el hilo del m�todo quickSort con el array desordenado: "+Arrays.toString(array_a_ordenar));
				time_init = System.nanoTime();
				metodos.quicksort(array_a_ordenar, 0, array_a_ordenar.length-1);
				time_final = System.nanoTime();
				System.out.println("Tiempo de ejecuci�n m�todo quickSort: " + (time_final - time_init) + " ns");
				break;
			default:
				break;
		}
        
        
       
	}

	
}
