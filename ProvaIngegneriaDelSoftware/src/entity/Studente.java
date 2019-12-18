package entity;

public class Studente {
	private String nome;
	private String cognome;
	private String matricola;
	
	public Studente (String nome, String cognome, String matricola) {
		this.nome = new String(nome);
		this.cognome = new String(cognome);
		this.matricola = new String(matricola);
	}
	
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getMatricola() {
		return matricola;
	}
}
