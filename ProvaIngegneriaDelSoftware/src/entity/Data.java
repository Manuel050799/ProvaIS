package entity;

public class Data {
	private String aula;
	private TipoProva tipologia;
	
	public Data(String aula, TipoProva tipo) {
		this.aula = new String(aula);
		tipologia = tipo; //da verificare alcuni vincoli qui 
	}
	
	public String getAula() {
		return aula;
	}
	public TipoProva getTipologia() {
		return tipologia;
	}
}

