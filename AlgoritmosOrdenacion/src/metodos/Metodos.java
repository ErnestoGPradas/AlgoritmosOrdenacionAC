package metodos;

import java.util.Arrays;

public class Metodos {

	
	
	public void seleccion(int A[]) {	
        int i, j, menor, pos, tmp;
        for (i = 0; i < A.length-1; i++) {      // tomamos como menor el primero
            menor = A[i];                       // de los elementos que quedan por ordenar                    
            pos = i;                            // y guardamos su posición
            for (j = i + 1; j < A.length; j++) { // buscamos en el resto
                if (A[j] < menor) {           // del array algún elemento
                    menor = A[j];             // menor que el actual
                    pos = j;
                }
            }
            if (pos != i) {                      // si hay alguno menor se intercambia                         
                tmp = A[i];
                A[i] = A[pos];
                A[pos] = tmp;
            }   
        }
        
        System.out.println("Esta es mi lista ordenada: " + Arrays.toString(A));    
    }
	
	public void seleccion2(int A[]) {
	    for (int i = 0; i < A.length - 1; i++) {
	        for (int j = i + 1; j < A.length; j++) {
	            if (A[i] > A[j]) {
	                //mover el actual a la derecha y el de la derecha al actual
	                int temporal = A[i];
	                A[i] = A[j];
	                A[j] = temporal;
	            }
	        }
	    }
	    System.out.println("Mi array ordenado: " + Arrays.toString(A));
	}
	
	public void burbuja(int[] A) {
        int i, j, aux;
        for (i = 0; i < A.length; i++) {
            for (j = 0; j < A.length - i - 1; j++) {
                if (A[j + 1] < A[j]) {
                    aux = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = aux;
                }
            }
            
        }
        System.out.println("Mi array ordenado: " + Arrays.toString(A));
    }
	
	public void inserccion(int[] A) {  
        int n = A.length;  
        for (int j = 1; j < n; j++) {  
            int key = A[j];  
            int i = j-1;  
            while ( (i > -1) && ( A [i] > key ) ) {  
                A [i+1] = A [i];  
                i--;  
            }  
            A[i+1] = key;  
        }  
        
        System.out.println("Mi array ordenado: " + Arrays.toString(A));
    }  
	
	public void mergesort(int A[],int izq, int der){
	    if (izq < der){
	            int m=(izq+der)/2;
	            mergesort(A,izq, m);
	            mergesort(A,m+1, der);                                                                                
	            merge(A,izq, m, der);                                                                                 
	    }
	    
	    System.out.println("Mi array ordenado: " + Arrays.toString(A));
	}
	
	public static void merge(int A[],int izq, int m, int der){
		   int i, j, k;
		   int [] B = new int[A.length]; //array auxiliar
		   for (i=izq; i<=der; i++)      //copia ambas mitades en el array auxiliar                                       
		        B[i]=A[i];

		   i=izq; j=m+1; k=izq;
		     
		   while (i<=m && j<=der) //copia el siguiente elemento más grande                                      
		          if (B[i]<=B[j])
		              A[k++]=B[i++];
		          else
		              A[k++]=B[j++];
		        
		   while (i<=m)         //copia los elementos que quedan de la
		         A[k++]=B[i++]; //primera mitad (si los hay)
		}
	
	
	
	
	public void quicksort(int A[], int izq, int der) {

		  int pivote=A[izq]; // tomamos primer elemento como pivote
		  int i=izq;         // i realiza la búsqueda de izquierda a derecha
		  int j=der;         // j realiza la búsqueda de derecha a izquierda
		  int aux;
		 
		  while(i < j){                          // mientras no se crucen las búsquedas                                   
		     while(A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
		     while(A[j] > pivote) j--;           // busca elemento menor que pivote
		     if (i < j) {                        // si no se han cruzado                      
		         aux= A[i];                      // los intercambia
		         A[i]=A[j];
		         A[j]=aux;
		     }
		   }
		   
		   A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos                                    
		   A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha
		   
		   if(izq < j-1)
		      quicksort(A,izq,j-1);          // ordenamos subarray izquierdo
		   if(j+1 < der)
		      quicksort(A,j+1,der);          // ordenamos subarray derecho
		   System.out.println("Mi array ordenado: " + Arrays.toString(A));
		}
	
	
}
