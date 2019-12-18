package entity;

import java.util.ArrayList;

public class Appello {
	private String id;
	private String nomeCorso;
	private ArrayList<Data> date;
	private ArrayList<Studente> studentiPrenotati;
	
	public Appello(String id, String nomeCorso) {
		this.id = new String(id);
		this.date = new ArrayList<Data>();
		this.nomeCorso = new String(nomeCorso);
		this.studentiPrenotati = new ArrayList<Studente>();
	}
	
	public String getId() {
		return id;
	}
	public ArrayList<Data> getDate() {
		return date;
	}
	public String getNomeCorso() {
		return nomeCorso;
	}
	public ArrayList<Studente> getStudentiPrenotati(){
		return studentiPrenotati;
	}
	
	public boolean addData(Data d) { //da verificare alcuni controlli...
		return date.add(d); 
	}
	public boolean addStudente(Studente s) { //da verificare alcuni controlli 
		return studentiPrenotati.add(s);
	}
}
