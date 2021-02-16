package portAventura_atraccions;

public class Visitant extends Persona {

    private int numVisitant;
    private Entrada entrada;
    private double diners;
    private int pujades = 0;
    private int primeraFila = 0;
    private double altura;

    public Visitant(String nom, String cognom, String DNI, int telefon, double altura, int numVisitant, Entrada entrada, double diners, int pujades, int primeraFila) {
        super(nom, cognom, DNI, telefon);
        this.numVisitant = numVisitant;
        this.entrada = entrada;
        this.diners = diners;
        this.pujades = pujades;
        this.primeraFila = primeraFila;
        this.altura = altura;
    }

    public int getNumVisitant() {
        return numVisitant;
    }

    public void setNumVisitant(int numVisitant) {
        this.numVisitant = numVisitant;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public double getDiners() {
        return diners;
    }

    public void setDiners(double diners) {
        this.diners = diners;
    }

    public int getPujades() {
        return pujades;
    }

    public void setPujades(int pujades) {
        this.pujades = pujades;
    }

    public int getPrimeraFila() {
        return primeraFila;
    }

    public void setPrimeraFila(int primeraFila) {
        this.primeraFila = primeraFila;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
    	return "El número de visitant és " + numVisitant + " amb l'entrada " + entrada + ", té " + diners + ", porta " + pujades + "pujades, ha pujat a primera fila " + primeraFila + "vegades i medeix " + altura + ".";
    }

    /**
     * Metode per a pujar a l'atraccio.
     * Si  l'altura es correcte, entra i suma els cops que s'ha pujat.
     */
    public String pujarAtraccio(Atraccio a, Empleat e) {
        if (e.comprovarAltura(this, a).equals("OK")) {
            this.pujades = this.pujades + 1;
            return "Pujooo weeeee!!";
        }
        return "No puc pujar =(";
    }
    
    //El mateix que a dalt pero per a pujar a primera fila.
    public String pujarPrimeraFilaAtraccio(Atraccio a, Empleat e) {
        if (e.comprovarAltura(this, a).equals("OK") && this.entrada instanceof ExpressPremium) {
            this.primeraFila = this.primeraFila + 1;
            return "Pujooo weeeee!";
        }
        return "No compleixo els requisits per a pujar :(";
    }

    //Metode per a pagar una entrada.
    public void pagarEntrada(double preu) {
        diners -= preu;
    }

}
