package it.unibs.ing.fp.mytest;

import static org.junit.Assert.*;
import org.junit.Test;

import it.unibs.ing.fp.cd.Brano;

public class BranoTest 
{
	@Test
	public void testCreaBrano()
	{
		new Brano("Canzone 1", 10, 10); 
		new Brano("Canzone 2", 10, 10); 
		new Brano("Canzone 3", 10, 10); 
		new Brano("Canzone 4", 10, 10); 
	}
}
