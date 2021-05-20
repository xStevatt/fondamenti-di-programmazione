package it.unibs.ing.fp.mytest;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unibs.ing.fp.cd.*;

public class ArchivioCDTest 
{
	@Test
	public void testAggiungiCdArchivio() 
	{
		ArchivioCd archivio = new ArchivioCd(); 
		archivio.aggiungiCd(new Cd("Nome CD 1", "Fabri Fibra"));
		archivio.aggiungiCd(new Cd("Nome CD 2", "Fabri Fibra"));
		archivio.aggiungiCd(new Cd("Nome CD 3", "Fabri Fibra"));
		archivio.aggiungiCd(new Cd("Nome CD 4", "Fabri Fibra"));
		
		assertEquals(4, archivio.getNumeroCd());
	}
	
	@Test
	public void testRimuoviCdArchivio()
	{
		ArchivioCd archivio = new ArchivioCd(); 
		archivio.aggiungiCd(new Cd("Nome CD 1", "Fabri Fibra"));
		archivio.aggiungiCd(new Cd("Nome CD 2", "Fabri Fibra"));
		archivio.aggiungiCd(new Cd("Nome CD 3", "Fabri Fibra"));
		archivio.aggiungiCd(new Cd("Nome CD 4", "Fabri Fibra"));
		
		archivio.eliminaCd("Nome CD 1");
		
		assertEquals(3, archivio.getNumeroCd());
	}
}
