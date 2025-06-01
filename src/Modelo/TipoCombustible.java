/**
 * @author
 * Steeven Pardo
 * Juan Calopino
 * Royel Jima
 * Daniel Savedra
 */

package Modelo;

import java.io.Serializable;

public enum TipoCombustible implements Serializable{

    DIESEL(1.797f),
    EXTRA(2.466f),
    ECOPAIS(2.466f),
    SUPER(3.43f);

    private final float precioPorGalon;

    TipoCombustible(float precioPorGalon) {
        this.precioPorGalon = precioPorGalon;
    }
}
