package it.unibs.ing.fp.mylib;
import java.util.Random; 

/**
 * Classe per la generazione di numeri casuali
 * @author Stefano Valloncini
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */

public class RandomNumbers 
{
	static Random random = new Random(); 
	
	/**
	 * Genera un numero random (intero) compreso tra due estremi 
	 * @param min - Il numero minimo estraibile [int]
	 * @param max - Il numero massimo estraibile [int]
	 * @return - il numero estratto viene ritornato [int]
	 */
	public static int getRandomInteger(int min, int max)
	{
		int range = max + 1 - min; 
		int random_number = random.nextInt(range); 
		
		return random_number; 
	}
	
	/**
	 * Genera un numero random (double) compreso tra due estremi 
	 * @param min - Il numero minimo estraibile [double]
	 * @param max - Il numero massimo estraibile [double]
	 * @return - il numero estratto viene ritornato [double]
	 */
	public static double getRandomDouble(double min, double max)
	{
		double range = max - min; 
		double random_number = random.nextDouble(); 
		
		double estratto = range * random_number; 
		
		return estratto + min; 
	}
}
