package eccezioni;

public class ErroreElementoInesistente extends Eccezione {
	private static final long serialVersionUID = 1L;
	String s;
	public ErroreElementoInesistente(String s) {
		this.s =new String(s);
	}
	public ErroreElementoInesistente() {
		this.s = new String();
	}
	@Override
	public void stampa() {
		System.out.println(s + " elemento non esistente");
	}
	
}
