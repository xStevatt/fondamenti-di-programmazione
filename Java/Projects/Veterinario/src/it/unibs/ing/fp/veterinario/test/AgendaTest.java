package it.unibs.ing.fp.veterinario.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.unibs.ing.fp.veterinario.Agenda;

class AgendaTest 
{
	@Test
	public void testCreazioneAgenda()
	{
		Agenda agenda = new Agenda(); 
		agenda.inizializzaAgenda();
	}
}
