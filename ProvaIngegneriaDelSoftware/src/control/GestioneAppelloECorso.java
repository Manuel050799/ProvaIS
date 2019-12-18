package control;

import java.util.ArrayList;
import entity.*;
import eccezioni.*;
public class GestioneAppelloECorso {
	private ArrayList<Corso> corsi;
	
	public GestioneAppelloECorso() {
		this.corsi = new ArrayList<Corso>();
	}
	
	public ArrayList<Corso> getCorsi(){
		return corsi;
	}
	
	//funzione di creazione di un corso
	public boolean creaCorso(String nomeCorso, String nomeDocente, int CFU) throws Eccezione { 
		try {
			for(Corso c1 : corsi) {
				if(c1.getNomeCorso().equals(nomeCorso) && c1.getNomeDocente().contentEquals(nomeDocente)) {
					throw new ErroreElementoGiaPresente(nomeCorso);
				}
			}
		} catch (Eccezione e) {
			e.stampa();
			return false;
		}
		Corso c = new Corso(nomeCorso, nomeDocente, CFU);
		return corsi.add(c);
	}
	
	//funzione di creazione di un appello
	public boolean creaAppello(String id, String nomeCorso, Data d) throws Eccezione { 
		boolean flag = false;
		try {
			boolean flag1 = false;
			for(Corso c : corsi) {
				if(c.getNomeCorso().equals(nomeCorso)) {
					flag1 = true;
				}
				for (Appello a1 : c.getAppelli()) {
					if((a1.getId().equals(id)) && c.getNomeCorso().equals(nomeCorso)) {
						throw new ErroreElementoGiaPresente(id);
					}
				}
				if(c.getNomeCorso().equals(nomeCorso)) {
					Appello a = new Appello(id, nomeCorso);
					a.addData(d);
					flag = c.addAppello(a);
				}
			}
			if(!flag1) {
				throw new ErroreElementoInesistente(nomeCorso);
			}
			
		} catch (Eccezione e) {
			e.stampa();
			return false;
		}
		return flag;
	}
	
	//funzione di prenotazione ad un appello da parte di uno studente
	public boolean prenotazioneAppello(String idAppello, Studente s) { 
		boolean flag = false;
				try {
					boolean flag1 = false;
					for(Corso c : corsi) {
						for(Appello a : c.getAppelli()) {
							if(a.getId().equals(idAppello)) {
								flag1 = true;
							}
							for(Studente s1 : a.getStudentiPrenotati()) {
								if((s1.getMatricola().equals(s.getMatricola())) && a.getId().equals(idAppello)) {
									throw new ErroreElementoGiaPresente(s.getNome()+" "+s.getCognome()+" "+s.getMatricola());
								}
							}
							if(a.getId().equals(idAppello)) {
								flag = a.addStudente(s);
							}
						}
					}
					if(!flag1) {
						throw new ErroreElementoInesistente(idAppello);
					}
				}catch (Eccezione e) {
					e.stampa();
					return false;
				}
		return flag;
	}
	
	//funzione visualizza lista degli studenti prenotati a un determinato appello
	public int studentiPrenotatiAppello(String idAppello){
		int stud = 0;
		boolean flag1 = false;
		boolean flag2 = false;
		try {	
				if(idAppello == null) {
					throw new ErroreElementoInesistente();
				}
				for(Corso c : corsi) {
					flag2 = true;
					for(Appello a : c.getAppelli()) {
						if(a.getId().equals(idAppello)) {
							flag1 = true;
							System.out.println("Studenti prenotati per appello "+a.getId()+":");
							for(Studente s : a.getStudentiPrenotati()) {
								System.out.println(s.getNome()+" "+s.getCognome()+" "+s.getMatricola());
								stud++;
							}
						}
					}
				}
				if(!flag2) {
					throw new ErroreNessunCorsoEsistente();
				}
				if(!flag1) {
					throw new ErroreElementoInesistente(idAppello);
				}
				if(stud == 0) {
					throw new ErroreElementoInesistente();
				}
			}catch (Eccezione e) {
			e.stampa();
			return 0;
			}
		return stud;
	}
	
	//funzione di aggiunta di una data ad un appello
	public boolean aggiungiDataAdAppello(String idAppello, Data d){ 
		boolean flag = false;
		try {
		boolean flag1 = false;
		for(Corso c1 : corsi) {
			for(Appello a1 : c1.getAppelli()) {
				if(a1.getId().equals(idAppello)) {
					flag1 = true;
				}
				for(Data d1 : a1.getDate()) {
					if(d1.getAula().equals(d.getAula()) && d1.getTipologia().equals(d.getTipologia()) && a1.getId().equals(idAppello)) {
						throw new ErroreElementoGiaPresente(d1.getAula());
					}
				}
				if(a1.getId().equals(idAppello)) {
					flag = a1.addData(d);
				}
			}
		}
		if(!flag1) {
			throw new ErroreElementoInesistente(idAppello);
		}
		}catch(Eccezione e) {
			e.stampa();
			return false;
		}
		return flag;
	}
}
	
	