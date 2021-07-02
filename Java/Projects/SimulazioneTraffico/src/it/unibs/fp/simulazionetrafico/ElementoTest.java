package it.unibs.fp.simulazionetrafico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ElementoTest
{
	@Test
	public void testPedone() throws Exception
	{
		final Pedone pedone = new Pedone();
		assertEquals("*", pedone.toString());
	}

	@Test
	public void testPosizionePedone() throws Exception
	{
		final Pedone pedone = new Pedone();
		assertEquals(new Coordinate(3, 3).toString(), pedone.getProssimaPosizione(2, 3).toString());
	}

	@Test
	public void testAuto() throws Exception
	{
		final Auto auto = new Auto();
		assertEquals(">", auto.toString());
	}

	@Test
	public void testPosizioneAuto() throws Exception
	{
		final Auto auto = new Auto();
		assertEquals(new Coordinate(2, 5).toString(), auto.getProssimaPosizione(2, 3).toString());
	}

	@Test
	public void testVuoto() throws Exception
	{
		final Vuoto vuoto = new Vuoto();
		assertEquals(" ", vuoto.toString());
	}

	@Test
	public void testPosizioneVuoto() throws Exception
	{
		final Vuoto vuoto = new Vuoto();
		assertEquals(new Coordinate(2, 3).toString(), vuoto.getProssimaPosizione(2, 3).toString());
	}

	@Test
	public void testPedonePrevaleSuAuto() throws Exception
	{
		final Pedone pedone = new Pedone();
		final Auto auto = new Auto();
		assertEquals(true, pedone.prevaleSu(auto));
	}

	@Test
	public void testAutoNonPrevaleSuPedone() throws Exception
	{
		final Pedone pedone = new Pedone();
		final Auto auto = new Auto();
		assertFalse(auto.prevaleSu(pedone));
	}

	@Test
	public void testPedoneeAutoPrevalgonoSuVuoto() throws Exception
	{
		final Pedone pedone = new Pedone();
		final Auto auto = new Auto();
		final Vuoto vuoto = new Vuoto();
		assertEquals(true, pedone.prevaleSu(vuoto));
		assertEquals(true, auto.prevaleSu(vuoto));
	}

	@Test
	public void testCollisioneAutoPedone() throws Exception
	{
		final Pedone pedone = new Pedone();
		final Auto auto = new Auto();
		assertEquals(true, pedone.collisioneCon(auto));
	}

	@Test
	public void testCollisionePedoneAuto() throws Exception
	{
		final Pedone pedone = new Pedone();
		final Auto auto = new Auto();
		assertTrue(auto.collisioneCon(pedone));
	}
}
