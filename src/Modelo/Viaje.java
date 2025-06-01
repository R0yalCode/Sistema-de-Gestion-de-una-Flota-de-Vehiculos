/**
 * @author
 * Steeven Pardo
 * Juan Calopino
 * Royel Jima
 * Daniel Savedra
 */

package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Viaje implements Serializable {
    private final float distanciaRecorrida;
    private final LocalDate fecha;
    private static final List<Viaje> historialViajes = new ArrayList<>();

    public Viaje(float distanciaRecorrida, LocalDate fecha) {
        if (distanciaRecorrida <= 0) {
            throw new IllegalArgumentException("❌ La distancia no puede ser negativa.");
        }
        if (fecha == null) {
            throw new IllegalArgumentException("❌ La fecha no puede ser nula.");
        }
        this.distanciaRecorrida = distanciaRecorrida;
        this.fecha = fecha;
    }

    public static void registrarViaje(float distanciaRecorrida, LocalDate fecha) {
        historialViajes.add(new Viaje(distanciaRecorrida, fecha));
    }

    public static List<Viaje> getHistorialViajes() {
        return Collections.unmodifiableList(historialViajes);
    }

    public float getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Viaje{" +
                "distanciaRecorrida=" + distanciaRecorrida +
                ", fecha=" + fecha +
                '}';
    }
}
