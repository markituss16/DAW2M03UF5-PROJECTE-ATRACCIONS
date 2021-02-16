package portAventura_atraccions;

public class Estandar extends Entrada{

    private int limitAtraccions = 5;

    public Estandar(int idEntrada, String categoriaEntrada, double preu, boolean estatCompra) {
        super(idEntrada, categoriaEntrada, preu, estatCompra);
    }

    public int getLimitAtraccions() {
        return limitAtraccions;
    }

    public void setLimitAtraccions(int limitAtraccions) {
        this.limitAtraccions = limitAtraccions;
    }

    public String controlAtraccionsEstandar(Visitant v) {
        if (v.getPujades() >= limitAtraccions) {
            return "Fora";
        } else {
            return "OK";
        }
    }

    @Override
    public Estandar clone() throws CloneNotSupportedException {
        return new Estandar(this.idEntrada, this.categoriaEntrada, this.preu, this.estatCompra);
    }
}
