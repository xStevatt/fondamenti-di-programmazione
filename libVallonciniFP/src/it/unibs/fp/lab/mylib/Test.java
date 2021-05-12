package it.unibs.fp.lab.mylib;

public class Test {

	public static void main(String[] args) {
		String[] scelte = {"SCELTA 1", "SCELTA 2", "SCELTA 3"}; 
		
		GenerateMenu menu = new GenerateMenu("CAZZO", scelte); 
		menu.mostraMenu();
	}

}
