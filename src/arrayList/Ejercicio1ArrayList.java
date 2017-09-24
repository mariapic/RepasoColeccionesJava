package arrayList;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Rellenar un ArrayList de números por teclado. 
 * Obtener el mayor valor de un ArrayList y especificar en qué posición 
 * se encuentra.
 */
public class Ejercicio1ArrayList {

	public static void main(String[] args) {
		ArrayList<Double> listaNumeros = new ArrayList<Double>();
		// invocamos al método rellenarLista pasándole como parámetro la lista vacía 
		// que acabamos de definir
		rellenarLista(listaNumeros);
		
		// imprimimos la lista por consola
		imprimirLista(listaNumeros); 
		
		// obtener el mayor valor y su posicion
		obtenerMayor(listaNumeros);
		
	}

	public static void obtenerMayor(ArrayList<Double> listaNumeros) {
		double mayor = 0;
		int pos = -1;
		for (int i = 0; i < listaNumeros.size(); i++) {
			if (mayor < listaNumeros.get(i)) {
				mayor = listaNumeros.get(i);
				pos = i;
			}
		}
		System.out.println("El mayor valor es " + mayor + " y se encuentra en la posición " + pos);
	}

	private static void imprimirLista(ArrayList<Double> listaNumeros) {
		System.out.println("Lista de números:");
		for (Double numero : listaNumeros) {
			System.out.println(numero);
		}
	}

	// metodo que se encarga de recibir una lista como parámetro y rellenarla 
	// método static por ser invocado desde otro método static
	// private porque solo lo vamos a usar desde esta clase
	private static void rellenarLista(ArrayList<Double> listaNumeros) {
		Scanner sc = new Scanner(System.in);
		// representa la cantidad de números
		int cant = 0;
		// representa cada uno de los número que se van añadir a la lista
		double num = 0; 
		
		// variables de control
		boolean cantOK = false;
		boolean numOk = false;
		
		// mientras la cantidad introducida no sea OK seguimos solicitandola
		while (!cantOK) {
			System.out.println("Introduce la cantidad de números: ");
			try {
				cant = Integer.parseInt(sc.nextLine());
				// comprobamos que sea positivo
				if (cant <= 0) {
					System.out.println("Debes introducir un valor entero positivo");
				} else {
					// si se parsea la cantidad y  es positivo y mayor que cero
					// entonces es OK
					cantOK = true;
				}
			} catch (NumberFormatException nfe) {
				// al parsear la cantida a entero salta la excepcion porque 
				// no es un valor entero
				System.out.println("Debes introducir un valor entero positivo");
			}
		}
		
		// para la cantidad introducida solicitamos cant números
		for (int i = 0; i < cant; i++) {
			// para cada número debemos partir de que numOk es falso
			numOk = false;
			while (!numOk) {
				System.out.println("Introduce el número " + (i+1) + ": ");
				try {
					num = Double.parseDouble(sc.nextLine());
					numOk = true; 
					// añadimos el número a la lista
					listaNumeros.add(num);
				} catch (NumberFormatException nfe) {
					System.out.println("Debes introducir un valor numérico");
				}
			}
		}
		
		sc.close();
		
	}

}
