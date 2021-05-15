package util;

import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javafx.geometry.Orientation;

public class Utils {
	
	public int opcionMostrarInfo() {

        int selection;
        Scanner input1 = new Scanner(System.in);

        /***************************************************/
        System.out.println("");
        System.out.println("Seleccione como quiere probar los algoritmos de ordenación");
        System.out.println("-------------------------\n");
        System.out.println("1 - Métodos uno a uno");
        System.out.println("2 - Todos a la vez");
        System.out.println("3 - Todos a la vez en hilos");
        System.out.println("10 - Quit");

        selection = input1.nextInt();
        return selection;    
    }
		
    public int menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        /***************************************************/
        System.out.println("");
        System.out.println("Seleccione con que método quiere ordenar la lista");
        System.out.println("-------------------------\n");
        System.out.println("1 - Seleccion");
        System.out.println("2 - Burbuja");
        System.out.println("3 - Insercción");
        System.out.println("4 - Mezcla (merge_sort)");
        System.out.println("5 - Rápida (quick_sort)");
        System.out.println("10 - Quit");

        selection = input.nextInt();
        return selection;    
    }
	
	public int[] generarListaAleatoria() {	
		System.out.println("Generamos un Array de  números y tamaño al azar: ");
		int tamanio_array = (int)(Math.random()*10+5);
		int lista_numeros_aleatorios[] = new int[tamanio_array];	
		
		for(int i=0; i<tamanio_array; i++) {
			
			int numero_aleatorio = (int)(Math.random()*10+1);
			lista_numeros_aleatorios[i] = numero_aleatorio;
		}
		return lista_numeros_aleatorios;
	}
	

}
