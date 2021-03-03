package portAventura_atraccions;

public class ExcepcioDiners extends Exception{
	@Override
	public String getMessage() {
		return "No tens diners suficients.";
	}
}