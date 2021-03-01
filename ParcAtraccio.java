package portAventura_atraccions;
import java.util.*;
import java.io.*;

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
	
	public void afegirEntrada(Entrada e) throws IOException{
		this.entrades.add(e);
		EscriureEntrades(entrades);
	}
	
	public void EscriureEntrades(ArrayList<Entrada> entrades) throws IOException{
		File Fentrades = new File("entrades.txt");
		
		if(Fentrades.exists()) {
			FileWriter writer = new FileWriter(Fentrades);
			PrintWriter pw = new PrintWriter(writer);
			
			for(Entrada e : entrades) {
				pw.println(e.toString());
			}
			writer.close();
		}else {
			Fentrades.createNewFile();
		}
		
	}
        
    public void afegirVisitant(Visitant v) throws IOException{
		this.visitants.add(v);
		EscriureVisitants(visitants);
	}
    
    public void EscriureVisitants(ArrayList<Visitant> visitant) throws IOException{
		File Fvisitant = new File("visitant.txt");
		
		if(Fvisitant.exists()) {
			FileWriter writer = new FileWriter(Fvisitant);
			PrintWriter pw = new PrintWriter(writer);
			
			for(Visitant e : visitant) {
				pw.println(e.toString());
			}
			writer.close();
		}else {
			Fvisitant.createNewFile();
		}
		
	}
        
    public void afegirEmpleats(Empleat e) throws IOException {
		this.empleats.add(e);
		EscriureEmpleats(empleats);
	}
    
    public void EscriureEmpleats(ArrayList<Empleat> empleat) throws IOException{
		File Fempleat = new File("empleat.txt");
		
		if(Fempleat.exists()) {
			FileWriter writer = new FileWriter(Fempleat);
			PrintWriter pw = new PrintWriter(writer);
			
			for(Empleat e : empleat) {
				pw.println(e.toString());
			}
			writer.close();
		}else {
			Fempleat.createNewFile();
		}
		
	}
        
    public void afegirAtraccio(Atraccio a) throws IOException{
		this.atraccions.add(a);
		EscriureAtraccio(atraccions);
	}
    
    public void EscriureAtraccio(ArrayList<Atraccio> atraccio) throws IOException{
		File Fatraccio = new File("atraccions.txt");
		
		if(Fatraccio.exists()) {
			FileWriter writer = new FileWriter(Fatraccio);
			PrintWriter pw = new PrintWriter(writer);
			
			for(Atraccio e : atraccio) {
				pw.println(e.toString());
			}
			writer.close();
		}else {
			Fatraccio.createNewFile();
		}
		
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
