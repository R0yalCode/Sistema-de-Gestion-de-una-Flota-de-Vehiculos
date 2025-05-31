/**
 * @author
 * Steeven Pardo
 * Juan Calopino
 * Royel Jima
 * Daniel Savedra
 */

package Modelo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Combustible implements Serializable{
    private float precio;

    private TipoCombustible tipoCombustible; // Relacion UML

    private static final Map<TipoCombustible, Float> precios = new HashMap<>();
    static{
        precios.put(TipoCombustible.EXTRA, 2.466f);
        precios.put(TipoCombustible.ECOPAIS, 2.466f);
        precios.put(TipoCombustible.DIESEL, 1.797f);
    }

    public Combustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
        this.precio = precios.get(tipoCombustible);
    }

    public float calcularPrecio(float precio, TipoCombustible tipoCombustible) {
        return 0;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public float getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Combustible: \n");
        sb.append("precio: ").append(precio);
        sb.append(", tipoCombustible: \n").append(tipoCombustible);
        return sb.toString();
    }
}
