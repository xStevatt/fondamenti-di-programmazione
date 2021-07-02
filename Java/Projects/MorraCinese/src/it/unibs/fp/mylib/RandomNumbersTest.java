package it.unibs.fp.mylib;

import org.junit.jupiter.api.Test;

class RandomNumbersTest
{

	@Test
	void testGeneraNumeroCasualeInteroPositivo()
	{
		for (int i = 0; i < 15; i++)
			System.out.print(RandomNumbers.getRandomInteger(0, 5) + ", ");
		System.out.println("\n");
	}

	@Test
	void testGeneraNumeroCasualeInteroNegativo()
	{
		for (int i = 0; i < 15; i++)
			System.out.print(RandomNumbers.getRandomInteger(-5, 5) + ", ");
		System.out.println("\n");
	}

	@Test
	void testGeneraNumeroCasualeDoublePositivo()
	{
		for (int i = 0; i < 15; i++)
			System.out.print(RandomNumbers.getRandomDouble(0.0, 5.0) + ", ");
		System.out.println("\n");
	}

	@Test
	void testGeneraNumeroCasualeDoubleNegativo()
	{
		for (int i = 0; i < 15; i++)
			System.out.print(RandomNumbers.getRandomDouble(-5.0, 5.0) + ", ");
		System.out.println("\n");
	}
}
