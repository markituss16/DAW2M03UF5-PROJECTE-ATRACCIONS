package portAventura_atraccions;

import java.util.*;

public abstract class Entrada implements Cloneable {

    protected int idEntrada;
    protected String categoriaEntrada = new String();
    protected double preu;
    protected boolean estatCompra;

    public Entrada(int idEntrada, String categoriaEntrada, double preu, boolean estatCompra) {
        this.idEntrada = idEntrada;
        this.categoriaEntrada = categoriaEntrada;
        this.preu = preu;
        this.estatCompra = estatCompra;
    }

    public Entrada() {
    }

    public long getIdEntrada() {
        return idEntrada;
    }

    public String getCategoriaEntrada() {
        return categoriaEntrada;
    }

    public double getPreu() {
        return preu;
    }

    public boolean getEstatCompra() {
        boolean estat;
        if (this.estatCompra == true) {
            estat = true;
        } else {
            estat = false;
        }
        return estat;
    }

    @Override
    public String toString() {
        return "Ticket comprat: " + getEstatCompra() + "\nEl número de ticket és " + getIdEntrada()
                + ", la categoria és " + getCategoriaEntrada() + ". Costa " + getPreu() + "€";
    }
    
    @Override
    public abstract Entrada clone() throws CloneNotSupportedException;

}
