package it.unibs.ing.fp.lab.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unibs.ing.fp.lab.TamaZoo.TamaGordo;
import it.unibs.ing.fp.lab.TamaZoo.Tamagotchi;

public class TamaGordoTest 
{
	@Test
	public void tamaGordoAncoraVivoAncheSeHaTroppoCiboTest() 
	{
		TamaGordo tamagordo1 = new TamaGordo("", 100); 
		assertFalse(tamagordo1.sonoMorto());
	}
	
	@Test
	public void tamaGordoMuoreConZeroCiboTest() 
	{
		TamaGordo tamagordo1 = new TamaGordo("", 0); 
		assertTrue(tamagordo1.sonoMorto());
	}
	
	@Test
	public void tamGordoAncoraVivoAncheSeAffettoZeroTest() 
	{
		TamaGordo tamagordo1 = new TamaGordo("", 100); 
		tamagordo1.setSoddisfazione_affettiva(0);
		assertFalse(tamagordo1.sonoMorto());
	}
	
	@Test
	public void tamaGordoHaCentoSazietaCon100BiscottiTest() 
	{
		TamaGordo tamagordo1 = new TamaGordo("", 100); 
		tamagordo1.riceviBiscotti(100);
		assertEquals(100, tamagordo1.getGrado_sazietà(), 0.0);
	}
	
	@Test
	public void dai5BiscottiATamagordo() 
	{
		TamaGordo tamagordo1 = new TamaGordo("", 50); 
		tamagordo1.riceviBiscotti(1);
		assertEquals(55, tamagordo1.getGrado_sazietà(), 0.0);
	}
	
	@Test
	public void tamaGordoNonMuoreNeancheConTroppiBiscotti()  
	{
		Tamagotchi tama = new TamaGordo("", 90);
		tama.riceviBiscotti(100);
		tama.riceviBiscotti(100);
		assertTrue(!tama.sonoTriste());
		assertTrue(!tama.sonoTriste());
	}
	
	@Test
	public void dai10BiscottiATamagordoTest() 
	{
		TamaGordo tamagordo1 = new TamaGordo("", 50); 
		tamagordo1.riceviBiscotti(2);
		assertEquals(60, tamagordo1.getGrado_sazietà(), 0.0);
	}
	
	@Test
	public void dai15BiscottiATamagordoTest() 
	{
		TamaGordo tamagordo1 = new TamaGordo("", 50); 
		tamagordo1.riceviBiscotti(3);
		assertEquals(65, tamagordo1.getGrado_sazietà(), 0.0);
	}
	
	@Test
	public void daiCarezzeAlTamaGordo() 
	{
		TamaGordo tamagordo1 = new TamaGordo("", 50); 
		tamagordo1.riceviCarezze(1);
		assertEquals(49, tamagordo1.getGrado_sazietà(), 0.0);
	}
}
