package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Map.Entry;

/*
 * Creamos una clase PruebaMap con su correspondiente m�todo main. 
 * Dentro del main vamos a:
�	Generar de manera aleatoria 100 n�meros enteros que se encuentren 
entre el 1 el 100 (ambos inclusive)
�	Crear un objeto HashMap de nombre tablaAlea en el cual iremos 
insertando estos n�meros aleatorios junto con las veces que se van repitiendo.
�	Imprimir los n�meros que no han aparecido.
�	Imprimir los n�meros que han aparecido 5 veces.
�	Imprimir los n�meros que han aparecido 2 veces.
�	Imprimir de manera ordenada los elementos de la tabla junto con las veces que han aparecido.

 */
public class PruebaMap {

	public static void main(String[] args) {
		
		ArrayList<Integer> listaNumAleatorios = new ArrayList<Integer>();
		
		generarListaAleatoria(listaNumAleatorios);
		
		// la clave representar� el n�mero  
		// el valor el n�mero de veces que se repite
		HashMap<Integer, Integer> tablaMap = new HashMap<Integer, Integer>();
		
		generarTabla(listaNumAleatorios, tablaMap);
		
		imprimirTabla(tablaMap);
		
		imprimirNumNoEstan(tablaMap);
		
		int numVeces = 5;
		imprimirNumRep(tablaMap, numVeces);
		
		numVeces = 2;
		imprimirNumRep(tablaMap, numVeces);
		
		imprimirNumOrd(tablaMap);
	}

	public static void imprimirNumOrd(HashMap<Integer, Integer> tablaMap) {
		// imprimir los n�meros ordenados en funci�n de las veces que aparecen
		// primero encontramos cual es el mayor de las repeticiones
		int mayor = 0;
		for (Entry<Integer, Integer> entry : tablaMap.entrySet()) {
			if (mayor < entry.getValue()) {
				mayor = entry.getValue();
			}
		}
		
		for (int i = 1; i <= mayor; i++) {
			if (tablaMap.containsValue(i)) {
				imprimirNumRep(tablaMap, i);
			}
		}
	}

	public static void imprimirNumRep(HashMap<Integer, Integer> tablaMap, int numVeces) {
		System.out.println("Los siguientes n�meros aparecen " + numVeces + " veces");
		for (Entry<Integer, Integer> entry : tablaMap.entrySet()) {
			if (entry.getValue() == numVeces) {
				System.out.println(entry.getKey());
			}
		}
	}

	public static void imprimirNumNoEstan(HashMap<Integer, Integer> tablaMap) {
		System.out.println("Los siguientes n�meros no aparecen son:");
		for (int i = 1; i <= 100; i++) {
			if (!tablaMap.containsKey(i)) {
				System.out.println(i);
			}
		}
	}

	public static void generarTabla(ArrayList<Integer> listaNumAleatorios, HashMap<Integer, Integer> tablaMap) {
		/* recorremos el arrayList y para cada n�mero a�adimos una entrada en la tabla
		 * con dicho n�mero como clave y con valor inicial 1
		 * Cada vez que un n�mero se repita, modificaremos el valor de dicho n�mero 
		 * aumentando este valor en 1
		*/
		int valor = 0;
		for (Integer num : listaNumAleatorios) {
			if (tablaMap.containsKey(num)) {
				valor = tablaMap.get(num) + 1;
			} else {
				valor = 1;
			}
			tablaMap.put(num, valor);
		}
	}

	public static void imprimirTabla(HashMap<Integer, Integer> tablaMap) {
		System.out.println("Lista de n�mero junto con las repeticiones:");
		for (Entry<Integer, Integer> entry : tablaMap.entrySet()) {
			System.out.println("El n�mero " + entry.getKey() + 
					" se repite " + entry.getValue() + " veces");
		}
	}

	public static void generarListaAleatoria(ArrayList<Integer> listaNumAleatorios) {
		int n;
		for (int i = 0; i < 100; i++) {
			n = generarNumAleatorio(100, 1);
			listaNumAleatorios.add(n);
		}
	}

	public static int generarNumAleatorio(int max, int min) {
		Random rnd = new Random();
		int num = rnd.nextInt(max - min + 1) + min;
		
		return num;
	}

}
