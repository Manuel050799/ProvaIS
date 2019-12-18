package entity;

import java.util.ArrayList;

public class Corso {
	private String nomeCorso;
	private String nomeDocente;
	private int CFU;
	private ArrayList<Appello> appelli;
	
	public Corso(String nomeCorso, String nomeDocente, int CFU) {
		this.nomeCorso = new String(nomeCorso);
		this.nomeDocente = new String(nomeDocente);
		this.CFU = CFU;
		this.appelli = new ArrayList<Appello>();
	}
	
	public String getNomeCorso() {
		return nomeCorso;
	}
	public String getNomeDocente() {
		return nomeDocente;
	}
	public int getCFU() {
		return CFU;
	}
	public ArrayList<Appello> getAppelli() {
		return appelli;
	}
	
	public boolean addAppello(Appello a) { //da aggiungere controlli sull'aggiunta di appello...
		return appelli.add(a);
	}
}
