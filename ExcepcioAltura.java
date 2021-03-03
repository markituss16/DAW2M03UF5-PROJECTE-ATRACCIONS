package portAventura_atraccions;

public class ExcepcioAltura extends Exception{
	@Override
	public String getMessage() {
		return "No tens l'altura necessària.";
	}
}
