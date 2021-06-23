package it.unibs.fp.morracinese;
import it.unibs.fp.mylib.*;

public class MorraCineseMain 
{
	public static void main(String[] args) 
	{
		String terminaProgramma = null;
		
		String [] rispostePossibili = {"SI", "NO"}; 
		
		do
		{
			new GestorePartita(); 
			
			terminaProgramma = InputDati.inputString("Vuoi giocare ancora? [SI/NO]", rispostePossibili); 
		}
		while(!terminaProgramma.equalsIgnoreCase("NO")); 
		
		System.out.println("\nGrazie per aver giocato a Sasso-carta-forbici-lucertola-Spock!");
	}
}
