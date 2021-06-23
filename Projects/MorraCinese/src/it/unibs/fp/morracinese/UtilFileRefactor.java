package it.unibs.fp.morracinese;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UtilFileRefactor 
{
	@Test
	void testFile() 
	{
		UtilFile.scriviSulFile("Stefano", 10, 10);
		UtilFile.scriviSulFile("Marco", 11, 11);
		UtilFile.scriviSulFile("Marcello", 12, 12);
	}
}
