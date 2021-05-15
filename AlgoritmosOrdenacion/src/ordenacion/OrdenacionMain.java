package ordenacion;

import java.util.Arrays;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import controlador.ControladorMetodosOrdenacion;
import controlador.ControladorMetodosOrdenacionThread;
import util.Utils;


public class OrdenacionMain extends JFrame {
	
	static long tiempo_final_Seleccion = 0;
	static long tiempo_final_Burbuja = 0;
	static long tiempo_final_Inserccion = 0;
	static long tiempo_final_MergeSort = 0;
	static long tiempo_final_QuickSort = 0;
	static long tiempo_final_Seleccion2 = 0;
	
	public OrdenacionMain( String applicationTitle , String chartTitle ) {
	      super( applicationTitle );        
	      JFreeChart barChart = ChartFactory.createBarChart(
	         chartTitle,           
	         "Métodos",            
	         "Tiempo (ns)",            
	         createDataset(tiempo_final_Seleccion, tiempo_final_Seleccion2, tiempo_final_Burbuja, tiempo_final_Inserccion, tiempo_final_MergeSort, tiempo_final_QuickSort),          
	         PlotOrientation.VERTICAL,           
	         true, true, false);
	         
	      ChartPanel chartPanel = new ChartPanel( barChart );        
	      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
	      setContentPane( chartPanel ); 
	   }
	
	public static void main(String[] args) {
		Utils util = new Utils();
		ControladorMetodosOrdenacion controladorMetodosOrdenacion = new ControladorMetodosOrdenacion();
		int opcionMenuSeleccionada = 0;
		int formaMenu = 0;
		int lista_original[] = new int[] {};
		int lista_original1[] = new int[] {};
		int lista_original2[] = new int[] {};
		int lista_original3[] = new int[] {};
		int lista_original4[] = new int[] {};
		int lista_original5[] = new int[] {};
		int lista_original6[] = new int[] {};
			
		
		//Generamos la lista aleatoria
		lista_original = util.generarListaAleatoria();
		lista_original1 = Arrays.copyOf(lista_original, lista_original.length); //hacemos esto para que cree arrays nuevos y no apunte a la dirección de memoria original
		lista_original2 = Arrays.copyOf(lista_original, lista_original.length); // por que entonces no podremos hacer la ordenación con todos los algoritmos a la vez
		lista_original3 = Arrays.copyOf(lista_original, lista_original.length);
		lista_original4 = Arrays.copyOf(lista_original, lista_original.length);
		lista_original5 = Arrays.copyOf(lista_original, lista_original.length);
		lista_original6 = Arrays.copyOf(lista_original, lista_original.length);
		
		//Mostramos la lista generada de forma aleatoria 
		System.out.println(Arrays.toString(lista_original));
		System.out.println("*******************************************************");
	
		formaMenu = controladorMetodosOrdenacion.opcionMostrarInfo();
		if (formaMenu==1) {
			
			while(opcionMenuSeleccionada != 10 ) {
				//Generamos el Menú
				opcionMenuSeleccionada = controladorMetodosOrdenacion.llamarAlMenu();
				
				switch (opcionMenuSeleccionada) {
					case 1:
						controladorMetodosOrdenacion.usarMetodoSeleccion2(lista_original1);
						break;
					case 2:
						controladorMetodosOrdenacion.usarMetodoBurbuja(lista_original2);
						break;
					case 3:
						controladorMetodosOrdenacion.usarMetodoInserccion(lista_original3);
						break;
					case 4:
						controladorMetodosOrdenacion.usarMetodoMergeSort(lista_original4);
						break;
					case 5:
						controladorMetodosOrdenacion.usarMetodoQuickSort(lista_original5);
						break;
					default:
						break;
				}
			}
			
		}else if (formaMenu==2) {
			//Los hacemos todos a la vez con gráfica
			System.out.println("Ahora miramos si los tiempos con Hilos son los mismos o cambian");
			tiempo_final_Seleccion = controladorMetodosOrdenacion.usarMetodoSeleccion(lista_original1);
			tiempo_final_Seleccion2 = controladorMetodosOrdenacion.usarMetodoSeleccion2(lista_original6);
			tiempo_final_Burbuja = controladorMetodosOrdenacion.usarMetodoBurbuja(lista_original2);
			tiempo_final_Inserccion = controladorMetodosOrdenacion.usarMetodoInserccion(lista_original3);
			tiempo_final_MergeSort = controladorMetodosOrdenacion.usarMetodoMergeSort(lista_original4);
			tiempo_final_QuickSort = controladorMetodosOrdenacion.usarMetodoQuickSort(lista_original5);
			opcionMenuSeleccionada=10;
			
			OrdenacionMain chart = new OrdenacionMain("Estadísticas Algoritmos", 
			         "¿Cual es el más rápido?");
			      chart.pack( );        
			      RefineryUtilities.centerFrameOnScreen( chart );        
			      chart.setVisible( true );
			
		} else if (formaMenu==3) {
			//Lo hacemos mediante hilos
			System.out.println("Ahora miramos si los tiempos con Hilos son los mismos o cambian");
			ControladorMetodosOrdenacionThread controladorMetodosOrdenacionThread1 = new ControladorMetodosOrdenacionThread(lista_original1, 1);
			ControladorMetodosOrdenacionThread controladorMetodosOrdenacionThread2 = new ControladorMetodosOrdenacionThread(lista_original2, 2);
			ControladorMetodosOrdenacionThread controladorMetodosOrdenacionThread3 = new ControladorMetodosOrdenacionThread(lista_original3, 3);
			ControladorMetodosOrdenacionThread controladorMetodosOrdenacionThread4 = new ControladorMetodosOrdenacionThread(lista_original4, 4);
			ControladorMetodosOrdenacionThread controladorMetodosOrdenacionThread5 = new ControladorMetodosOrdenacionThread(lista_original5, 5);
			controladorMetodosOrdenacionThread1.start();
			controladorMetodosOrdenacionThread2.start();
			controladorMetodosOrdenacionThread3.start();
			controladorMetodosOrdenacionThread4.start();
			controladorMetodosOrdenacionThread5.start();
			
		} else {
			System.out.println("Saliendo del Programa...");
		}

		
		
	}
	
	private CategoryDataset createDataset(long tiempo_final_Seleccion, long tiempo_final_Seleccion2, long tiempo_final_Burbuja, long tiempo_final_Inserccion, long tiempo_final_MergeSort, long tiempo_final_QuickSort ) {
	      final String seleccion = "SELECCIÓN";    
	      final String seleccion2 = "SELECCIÓN OPTIMIZADO"; 
	      final String burbuja = "BURBUJA";        
	      final String inserccion = "INSERCCIÓN"; 
	      final String mergesort = "MERGESORT";
	      final String quicksort = "QUICKSORT";
	      
     
	      final DefaultCategoryDataset dataset = 
	      new DefaultCategoryDataset( );  

	      dataset.addValue( tiempo_final_Seleccion , seleccion , seleccion );   
	      dataset.addValue( tiempo_final_Seleccion2 , seleccion2 , seleccion2 ); 
	      dataset.addValue( tiempo_final_Burbuja , burbuja , burbuja );        
	      dataset.addValue( tiempo_final_Inserccion , inserccion , inserccion );   
	      dataset.addValue( tiempo_final_MergeSort , mergesort , mergesort ); 
	      dataset.addValue( tiempo_final_QuickSort , quicksort , quicksort ); 
            

	      return dataset; 
	   }
	

}
