package portAventura_atraccions;

public class ExpressPremium extends Entrada{

    private int primeraFila = 1;

    public ExpressPremium(int idEntrada, String categoriaEntrada, double preu, boolean estatCompra, int primeraFila) {
        super(idEntrada, categoriaEntrada, preu, estatCompra);
        this.primeraFila = primeraFila;
    }

    public int getPrimeraFila() {
        return primeraFila;
    }

    public void setPrimeraFila(int primeraFila) {
        this.primeraFila = primeraFila;
    }

    public String vegadesPrimeraFila(Visitant v) {
        if (v.getPrimeraFila() >= primeraFila) {
            return "Fer fora";
        } else {
            return "OK";

        }
    }
    
    @Override
    public ExpressPremium clone() throws CloneNotSupportedException {
        return new ExpressPremium(this.idEntrada, this.categoriaEntrada, this.preu, this.estatCompra, this.primeraFila);
    } 
    
}