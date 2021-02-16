package portAventura_atraccions;

public interface IEmpleat {
	String comprovarSeguretat(Atraccio a);
	String comprovarAltura(Visitant v, Atraccio a);
	String comprovaEntrada(Visitant v);
}
