package portAventura_atraccions;

public class ComprovarDiners <T,E>{
	private T obj1;
	private E obj2;
	
	public ComprovarDiners(T obj1, E obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	public void dinersComprovats() {
		try {
			comprovar();
		}catch(ExcepcioDiners e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void comprovar() throws ExcepcioDiners{
		if(((Visitant) obj1).getDiners() >= ((Entrada) obj2).getPreu()) {
			System.out.println("Pots comprar l'entrada !");
		}else {
			throw new ExcepcioDiners();
		}
	}	
}
