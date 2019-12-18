package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.GestioneAppelloECorso;
import eccezioni.Eccezione;
import entity.Data;
import entity.Studente;
import entity.TipoProva;

public class RicercaStudPrenotatiTest {
	GestioneAppelloECorso gb;
	Data d;

	@Before
	public void setUp() throws Exception {
		gb = new GestioneAppelloECorso();
		d = new Data("SG-T4", TipoProva.ORALE);
		gb.creaCorso("Ingegneria Del Software", "Roberto Natella", 9);
		
	}

	@After
	public void tearDown() throws Exception {
		gb = null;
		d = null;
	}

	@Test
	public void test01PerAppelloNessunAppello() throws Eccezione {
		assertEquals(0, gb.studentiPrenotatiAppello("01"));
	}
	@Test
	public void test02PerAppelloUnAppelloNessunoStudente() throws Eccezione {
		gb.creaAppello("01", "Ingegneria Del Software", d);
		assertEquals(0, gb.studentiPrenotatiAppello("01"));
	}
	@Test
	public void test03PerAppelloUnAppelloUnoStudente() throws Eccezione {
		gb.creaAppello("01", "Ingegneria Del Software", d);
		Studente man = new Studente ("Manuel", "Maddaluno", "N46003832");
		gb.prenotazioneAppello("01", man);
		assertEquals(1, gb.studentiPrenotatiAppello("01"));
	}
	@Test
	public void test04PerAppelloUnAppelloPiùStudenti() throws Eccezione {
		gb.creaAppello("01", "Ingegneria Del Software", d);
		Studente man = new Studente ("Manuel", "Maddaluno", "N46003832");
		Studente dom = new Studente ("Domenico", "Iorio", "N46003456");
		Studente raff = new Studente ("Raffaella", "Perrot", "N44002343");
		gb.prenotazioneAppello("01", man);
		gb.prenotazioneAppello("01", dom);
		gb.prenotazioneAppello("01", raff);
		assertEquals(3, gb.studentiPrenotatiAppello("01"));
	}
	@Test
	public void test05PerAppelloPiuAppelliNessunoStudente() throws Eccezione {
		gb.creaAppello("01", "Ingegneria Del Software", d);
		gb.creaAppello("02", "Ingegneria Del Software", d);
		assertEquals(0, gb.studentiPrenotatiAppello("01"));
		assertEquals(0, gb.studentiPrenotatiAppello("02"));
	}
	@Test
	public void test06PerAppelloPiuAppelliUnoStudenteAUnSoloAppello() throws Eccezione {
		gb.creaAppello("01", "Ingegneria Del Software", d);
		gb.creaAppello("02", "Ingegneria Del Software", d);
		Studente man = new Studente ("Manuel", "Maddaluno", "N46003832");
		gb.prenotazioneAppello("01", man);
		assertEquals(1, gb.studentiPrenotatiAppello("01"));
		assertEquals(0, gb.studentiPrenotatiAppello("02"));
	}
	@Test
	public void test07PerAppelloPiuAppelliUnoStudentePerAppello() throws Eccezione {
		gb.creaAppello("01", "Ingegneria Del Software", d);
		gb.creaAppello("02", "Ingegneria Del Software", d);
		Studente man = new Studente ("Manuel", "Maddaluno", "N46003832");
		gb.prenotazioneAppello("01", man);
		gb.prenotazioneAppello("02", man);
		assertEquals(1, gb.studentiPrenotatiAppello("01"));
		assertEquals(1, gb.studentiPrenotatiAppello("02"));
	}
	@Test
	public void test08PerAppelloPiuAppelliPiuStudentiPerAppello() throws Eccezione {
		gb.creaAppello("01", "Ingegneria Del Software", d);
		gb.creaAppello("02", "Ingegneria Del Software", d);
		Studente man = new Studente ("Manuel", "Maddaluno", "N46003832");
		Studente dom = new Studente ("Domenico", "Iorio", "N46003456");
		Studente raff = new Studente ("Raffaella", "Perrot", "N44002343");
		gb.prenotazioneAppello("01", man);
		gb.prenotazioneAppello("02", man);
		gb.prenotazioneAppello("01", dom);
		gb.prenotazioneAppello("02", raff);
		assertEquals(2, gb.studentiPrenotatiAppello("01"));
		assertEquals(2, gb.studentiPrenotatiAppello("02"));
	}
	@Test
	public void test09PerAppelloPiuCorsiPiuAppelliPiuStudenti() throws Eccezione {
		gb.creaCorso("Analisi 1", "Umberto De Maio", 9);
		gb.creaAppello("01", "Ingegneria Del Software", d);
		gb.creaAppello("02", "Analisi 1", d);
		Studente man = new Studente ("Manuel", "Maddaluno", "N46003832");
		Studente dom = new Studente ("Domenico", "Iorio", "N46003456");
		Studente raff = new Studente ("Raffaella", "Perrot", "N44002343");
		gb.prenotazioneAppello("01", man);
		gb.prenotazioneAppello("02", man);
		gb.prenotazioneAppello("01", dom);
		gb.prenotazioneAppello("02", raff);
		assertEquals(2, gb.studentiPrenotatiAppello("01"));
		assertEquals(2, gb.studentiPrenotatiAppello("02"));
	}
	@Test
	public void test10PerAppelloNesunCorso() throws Eccezione{
		GestioneAppelloECorso gb1 = new GestioneAppelloECorso();
		assertEquals(0, gb1.studentiPrenotatiAppello("01"));
		gb1 = null;
	}
	@Test
	public void test11PerAppelloInputInesistente() throws Eccezione {
		assertEquals(0, gb.studentiPrenotatiAppello("primo appello"));
	}
	@Test
	public void test12PerAppelloInputMancante() throws Eccezione {
		assertEquals(0, gb.studentiPrenotatiAppello(null));
	}
	
	
	
	
	
	

}
