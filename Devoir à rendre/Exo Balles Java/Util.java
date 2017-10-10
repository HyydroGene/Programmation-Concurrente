package TD1.Exercice3_1;

import java.util.*;

// Rassemblement de petites fonctions qui peuvent être utile dans divers programmes.

public class Util{
	public static String lectureClavier(){
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
	
		return line;
	}
	
	public static int rand(int d, int f){ 
		return((int)((Math.random() * (f-d+1))+d));
		//retourne une valeur aléatoire
	}
}