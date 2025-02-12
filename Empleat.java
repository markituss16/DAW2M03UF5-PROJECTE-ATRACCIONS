package portAventura_atraccions;

import java.util.LinkedHashSet;

public class Empleat extends Persona implements IEmpleat{
	private int idEmpleat;
	private ESalariEmpleat salari;
	private LinkedHashSet<Atraccio> vigilancia;
	
	public Empleat(String nom, String cognom, String DNI, int telefon, int idEmpleat, ESalariEmpleat salari) {
		super(nom, cognom, DNI, telefon);
		this.idEmpleat = idEmpleat;
		this.salari = salari;
		this.vigilancia = new LinkedHashSet<Atraccio>();
	}

	public int getIdEmpleat() {
		return idEmpleat;
	}

	public void setIdEmpleat(int idEmpleat) {
		this.idEmpleat = idEmpleat;
	}

	public ESalariEmpleat getSalari() {
		return salari;
	}

	public void setSalari(ESalariEmpleat salari) {
		this.salari = salari;
	}

	public LinkedHashSet<Atraccio> getVigilancia() {
        return this.vigilancia;
    }

    public void afegeixVigilancia(Atraccio a) {
        this.vigilancia.add(a);
    }

	@Override
	public String toString() {
		return "L'empleat/a " + nom + " " + cognom + " t� DNI " + DNI + " i tel�fon " + telefon +
				". El seu identificador �s " + idEmpleat + ", i t� un salari de tipus " + salari;
	}

    /**
     * Metodes de la interficie creada.
     */
	
	@Override
	public String comprovarSeguretat(Atraccio a){
        return a.getSeguretatAtraccio().toString();
    }

	@Override
	public String comprovarAltura(Visitant v, Atraccio a){
        if(v.getAltura()>=a.getAlturaMin()){
            return "OK";
        }
        return "OUT";
    }

	@Override
	public String comprovaEntrada(Visitant v){
        if(v.getEntrada()!=null){
            return "OK";
        }
        return "Fer fora";
    }
}
     