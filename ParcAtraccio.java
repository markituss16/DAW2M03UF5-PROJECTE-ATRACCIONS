package portAventura_atraccions;
import java.util.*;

public class ParcAtraccio {
	private ArrayList<Entrada> entrades = new ArrayList<Entrada>();
    private ArrayList<Visitant> visitants = new ArrayList<Visitant>();
    private ArrayList<Empleat> empleats = new ArrayList<Empleat>();
    private ArrayList<Atraccio> atraccions = new ArrayList<Atraccio>();
	private String nom = new String();
	private int horariObertura;
	private int numVisitants;
	private int nombreAtraccions;
	
	public ParcAtraccio(String nom) {
		this.nom = nom;
	}

	/*GETTERS I SETTERS*/

    public ArrayList<Entrada> getEntrades() {
        return entrades;
    }

    public void setEntrades(ArrayList<Entrada> entrades) {
        this.entrades = entrades;
    }

    public ArrayList<Visitant> getVisitants() {
        return visitants;
    }

    public void setVisitants(ArrayList<Visitant> visitants) {
        this.visitants = visitants;
    }

    public ArrayList<Empleat> getEmpleats() {
        return empleats;
    }

    public void setEmpleats(ArrayList<Empleat> empleats) {
        this.empleats = empleats;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Atraccio> getAtraccions() {
        return atraccions;
    }

    public void setAtraccions(ArrayList<Atraccio> atraccions) {
        this.atraccions = atraccions;
    }

    public int getHorariObertura() {
        return horariObertura;
    }

    public void setHorariObertura(int horariObertura) {
        this.horariObertura = horariObertura;
    }

    public int getNumVisitants() {
        assignaNumVisitants();
        return numVisitants;
    }

    public int getNombreAtraccions() {
        return nombreAtraccions;
    }

    public void setNombreAtraccions(int nombreAtraccions) {
        this.nombreAtraccions = nombreAtraccions;
    }

    @Override
    public String toString() {
        return "ParcAtraccio{" + "entrades=" + entrades + ", visitants=" + visitants + ", empleats=" + empleats + ", atraccions=" + atraccions + ", nom=" + nom + ", horariObertura=" + horariObertura + ", numVisitants=" + numVisitants + ", nombreAtraccions=" + nombreAtraccions + '}';
    }

	/*MÈTODES PROPIS*/
	
	public void afegirEntrada(Entrada e) {
		this.entrades.add(e);
	}
        
    public void afegirVisitant(Visitant v) {
		this.visitants.add(v);
	}
        
    public void afegirEmpleats(Empleat e) {
		this.empleats.add(e);
	}
        
    public void afegirAtraccio(Atraccio a) {
		this.atraccions.add(a);
	}
	
    /**
     * Mètode per a realitzar la compra de l'entrada
     * Elimina una entrada de la llista d'entrades cada cop que es compra una.
     * Si no es correspon amb cap entrada surt una excepció
     */
	public void comprarEntrada(int id) {
		try {
			for(Iterator<Entrada> c = this.entrades.iterator();c.hasNext();) {
				Entrada e = c.next();
				if (e.getIdEntrada() == id) {
					c.remove();
					System.out.println("L'entrada " + e.getIdEntrada() + " ha sigut comprada amb èxit!");
				};
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("No s'ha trobat l'entrada. Compra'n una!");
		}
	}
	
	//Mètode per assignar el número de visitants que hi ha.
    private void assignaNumVisitants(){
    	this.numVisitants = visitants.size();
    }
}
