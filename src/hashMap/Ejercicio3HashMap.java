package hashMap;

import java.util.HashMap;
import java.util.Map.Entry;
/*
//Clave: 1  -> Valor: Casillas
//Clave: 3  -> Valor: Pique
//Clave: 5  -> Valor: Puyol
//Clave: 6  -> Valor: Iniesta
//Clave: 7  -> Valor: Villa
//Clave: 8  -> Valor: Xavi Hernandez
//Clave: 11 -> Valor: Capdevila
//Clave: 14 -> Valor: Xabi Alonso
//Clave: 15 -> Valor: Ramos
//Clave: 16 -> Valor: Busquets
//Clave: 18 -> Valor: Pedrito
 */
public class Ejercicio3HashMap {

	public static void main(String[] args) {
		HashMap<Integer, String> mapJugadores = new HashMap<Integer, String>();
		
		mapJugadores.put(1, "Casillas");
		mapJugadores.put(3, "Piqué");
		mapJugadores.put(5, "Puyol");
		mapJugadores.put(6, "Iniesta");
		mapJugadores.put(7, "Villa");
		mapJugadores.put(8, "Xavi Hernández");
		mapJugadores.put(11, "Capdevila");
		mapJugadores.put(14, "Xabi Alonso");
		mapJugadores.put(15, "Ramos");
		mapJugadores.put(16, "Busquets");
		mapJugadores.put(18, "Pedrito");
		
		// Devuelve el numero de elementos del Map
		System.out.println("Numero de jugadores: " + mapJugadores.size()); 
		//nombreMap.isEmpty(); // Devuelve true si no hay elementos en el Map y false si si los hay
		
		// Devuelve el valor de la clave que se le pasa como parámetro o 'null' si la clave no existe
		System.out.println("El jugador con el número 6 es " + mapJugadores.get(6));
		
		//nombreMap.clear(); // Borra todos los componentes del Map
		//nombreMap.remove(K clave); // Borra el par clave/valor de la clave que se le pasa como parámetro
		//nombreMap.containsKey(K clave); // Devuelve true si en el map hay una clave que coincide con K
		if (!mapJugadores.containsKey(4)) {
			System.out.println("No hay ningún con el número 4");
		}
		
		//nombreMap.containsValue(V valor); // Devuelve true si en el map hay un Valor que coincide con V
		if (mapJugadores.containsValue("Ramos")) {
			System.out.println("Ramos jugó en la final del mundial del 2010");
		}
		
		//nombreMap.values(); // Devuelve una "Collection" con los valores del Map
		
		System.out.println("Lista de jugadores de la final del mundial del 2010");
		for (Entry<Integer, String> entry : mapJugadores.entrySet()) {
			System.out.println("Con el número " + entry.getKey() + 
					" : " + entry.getValue());
		}


	}

}
