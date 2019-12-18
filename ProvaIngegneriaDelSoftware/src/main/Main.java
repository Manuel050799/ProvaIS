package main;
import control.*;
import eccezioni.Eccezione;
import entity.*;

public class Main {

	public static void main(String[] args) throws Eccezione {
		
		//Alcune prove per verificare il corretto funzionamento del programma
		
		GestioneAppelloECorso g = new GestioneAppelloECorso();
		
		Studente man = new Studente ("Manuel", "Maddaluno", "N46003832");
		Studente dom = new Studente ("Domenico", "Iorio", "N46003456");
		Studente raff = new Studente ("Raffaella", "Perrot", "N44002343");
		
		Data d = new Data("SG-T4", TipoProva.ORALE);
		Data d1 = new Data("SG-T4", TipoProva.ORALE);
		
		g.creaCorso("Ingegneria Del Software", "Roberto Natella", 9);
		g.creaCorso("Ingegneria Del Software", "Roberto Natella", 9);
		
		g.creaAppello("primo", "Ingegneria Del Software", d);
		g.creaAppello("primo", "Analisi 1", d);
		
		g.aggiungiDataAdAppello("primo", d1);
		
		g.prenotazioneAppello("primo", man);
		g.prenotazioneAppello("primo", man);
		g.prenotazioneAppello("primo", dom);
		g.prenotazioneAppello("primo", raff);
		
		int c = g.studentiPrenotatiAppello("primo");
		System.out.println(c);
		
		g.studentiPrenotatiAppello(null);
		
	}

}
