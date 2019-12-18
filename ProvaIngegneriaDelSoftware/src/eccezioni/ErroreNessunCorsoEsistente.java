package eccezioni;

public class ErroreNessunCorsoEsistente extends Eccezione {
	private static final long serialVersionUID = 1L;

	@Override
	public void stampa() {
		System.out.println("Nessun corso esistente");
	}
}
