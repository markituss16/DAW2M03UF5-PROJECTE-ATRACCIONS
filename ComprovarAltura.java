package portAventura_atraccions;

public class ComprovarAltura <T,E> {
	private T obj1;
	private E obj2;
	
	public ComprovarAltura(T obj1, E obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	public void alturaComprovada() {
		try {
			comprovar();
		}catch(ExcepcioAltura e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void comprovar() throws ExcepcioAltura{
		if(((Visitant) obj1).getAltura() >= ((Atraccio) obj2).getAlturaMin()) {
			System.out.println("Pots pujar a l'atracció!");
		}else {
			throw new ExcepcioAltura();
		}
	}	
}
