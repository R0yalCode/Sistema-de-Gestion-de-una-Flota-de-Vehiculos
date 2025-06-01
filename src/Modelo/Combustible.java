/**
 * @author
 * Steeven Pardo
 * Juan Calopino
 * Royel Jima
 * Daniel Savedra
 */

package Modelo;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Combustible implements Serializable {
    private final TipoCombustible tipoCombustible;
    private static final Map<TipoCombustible, Float> PRECIOS;

    static {
        Map<TipoCombustible, Float> precios = new HashMap<>();
        precios.put(TipoCombustible.EXTRA, 2.466f);
        precios.put(TipoCombustible.ECOPAIS, 2.466f);
        precios.put(TipoCombustible.SUPER, 3.43f);
        precios.put(TipoCombustible.DIESEL, 1.797f);
        PRECIOS = Collections.unmodifiableMap(precios);
    }

    public Combustible(TipoCombustible tipoCombustible) {
        if (!PRECIOS.containsKey(tipoCombustible)) {
            throw new IllegalArgumentException("❌ Tipo de combustible inválido.");
        }
        this.tipoCombustible = tipoCombustible;
    }

    public float calcularPrecio() {
        return PRECIOS.get(tipoCombustible);
    }

    public static float obtenerPrecio(TipoCombustible tipoCombustible) {
        return PRECIOS.getOrDefault(tipoCombustible, 0f);
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    @Override
    public String toString() {
        return "Combustible{" +
                "tipoCombustible=" + tipoCombustible +
                ", precio=" + calcularPrecio() +
                '}';
    }
}
