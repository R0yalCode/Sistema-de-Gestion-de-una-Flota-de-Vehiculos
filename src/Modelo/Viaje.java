/**
 * @author
 * Steeven Pardo
 * Juan Calopino
 * Royel Jima
 * Daniel Savedra
 * Enlace al git: https://github.com/R0yalCode/Sistema-de-Gestion-de-una-Flota-de-Vehiculos.git
 */

package Modelo;

import java.io.Serializable;
import java.util.Date;

public class Viaje implements Serializable {
    private float distanciaRecorrida;
    private Date fecha;

    public Viaje(float distanciaRecorrida, float costoMantenimiento, Date fecha) {
        this.distanciaRecorrida = distanciaRecorrida;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Viaje{");
        sb.append("distanciaRecorrida=").append(distanciaRecorrida);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }
}
