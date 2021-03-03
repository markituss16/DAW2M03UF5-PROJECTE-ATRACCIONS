package sample;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Entrada {
    private final SimpleIntegerProperty idEntrada = new SimpleIntegerProperty();
    private final SimpleStringProperty categoriaEntrada = new SimpleStringProperty();
    private final SimpleDoubleProperty preu = new SimpleDoubleProperty();
    private final SimpleBooleanProperty estatCompra = new SimpleBooleanProperty();


    public Entrada(int id, String cat, double p, boolean ec) {
        idEntrada.set(id);
        categoriaEntrada.set(cat);
        preu.set(p);
        estatCompra.set(ec);
    }

    public int getIdEntrada() {
        return idEntrada.get();
    }

    public SimpleIntegerProperty idEntradaProperty() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada.set(idEntrada);
    }

    public String getCategoriaEntrada() {
        return categoriaEntrada.get();
    }

    public SimpleStringProperty categoriaEntradaProperty() {
        return categoriaEntrada;
    }

    public void setCategoriaEntrada(String categoriaEntrada) {
        this.categoriaEntrada.set(categoriaEntrada);
    }

    public double getPreu() {
        return preu.get();
    }

    public SimpleDoubleProperty preuProperty() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu.set(preu);
    }

    public boolean isEstatCompra() {
        return estatCompra.get();
    }

    public SimpleBooleanProperty estatCompraProperty() {
        return estatCompra;
    }

    public void setEstatCompra(boolean estatCompra) {
        this.estatCompra.set(estatCompra);
    }
}
