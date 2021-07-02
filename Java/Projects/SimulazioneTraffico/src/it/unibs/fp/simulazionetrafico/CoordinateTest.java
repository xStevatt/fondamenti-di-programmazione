package it.unibs.fp.simulazionetrafico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordinateTest
{
	final int riga = 2;
	final int colonna = 3;

	@Test
	public void testCoordinate() throws Exception
	{
		final Coordinate coordinate = new Coordinate(riga, colonna);
		assertEquals(riga, coordinate.getRiga());
		assertEquals(colonna, coordinate.getColonna());
	}

	@Test
	public void testToString() throws Exception
	{
		assertEquals("RIGA:" + (riga + 1) + ";COLONNA:" + (colonna + 1), new Coordinate(riga, colonna).toString());
	}

	@Test
	public void testStaDentro()
	{
		Coordinate coordinate = new Coordinate(3, 3);
		assertTrue(coordinate.staDentro(4, 4));
	}

	@Test
	public void testNonStaDentro()
	{
		Coordinate coordinate = new Coordinate(3, 3);
		assertFalse(coordinate.staDentro(3, 4));
	}

	@Test
	public void testNonStaDentro2()
	{
		Coordinate coordinate = new Coordinate(3, 3);
		assertFalse(coordinate.staDentro(4, 3));
	}

}
