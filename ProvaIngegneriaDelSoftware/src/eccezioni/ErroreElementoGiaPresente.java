package eccezioni;

public class ErroreElementoGiaPresente extends Eccezione{
	private static final long serialVersionUID = 1L;
	String s;
	public ErroreElementoGiaPresente(String s) {
		this.s =new String(s);
	}


	@Override
	public void stampa() {
		System.out.println(s + " elemento già presente");
	}
}
