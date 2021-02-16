package portAventura_atraccions;

public enum ESalariEmpleat {
    SUPERIOR(1500,2000),
    MEDIO(900,1400),
    INFERIOR(300,800);

    private double salariMax;
    private double salariMin;

    public double getSalariMax() {
        return salariMax;
    }

    public void setSalariMax(double salariMax) {
        this.salariMax = salariMax;
    }

    public double getSalariMin() {
        return this.salariMin;
    }

    public void setSalariMin(double salariMin) {
        this.salariMin = salariMin;
    }

    private ESalariEmpleat(double salariMin, double salariMax) {
        this.salariMin = salariMin;
        this.salariMax = salariMax;
    }
}
