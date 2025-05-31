/**
 * @author
 * Steeven Pardo
 * Juan Calopino
 * Royel Jima
 * Daniel Savedra
 */

package Modelo;

import java.time.LocalDate;
import java.util.List;

public class Camioneta extends Vehiculo{
    private boolean traccion4x4;

    /**
     * @param placa
     * @param capacidadDeCarga
     * @param costoMantenimiento
     * @param consumoPorKM
     * @param viajes
     * @param capacidadCombustible
     */

    public Camioneta(String placa, float capacidadDeCarga, int costoMantenimiento, float consumoPorKM,
                     List<Viaje> viajes, float capacidadCombustible, boolean tracion4x4) {
        super(placa, capacidadDeCarga, 100, consumoPorKM, viajes, 60);
        this.traccion4x4 = tracion4x4;
    }



    @Override
    public float calcularConsumoCombustible(float distanciaRecorrida, float consumoPorKM, float capacidadCombustible) {
        return 0;
    }

    @Override
    public float calcularCostoOperativo(float precioCombustible, float consumoPorKm, float distanciaRecorrida, float costoMantenimiento) {
        return 0;
    }

    @Override
    public LocalDate registrarFecha(LocalDate ingresarFecha) {
        return null;
    }

    @Override
    public LocalDate actualizarFecha(LocalDate fecha) {
        return null;
    }

    @Override
    public float calcularCosto(Vehiculo vehiculo) {
        return 0;
    }

    @Override
    public LocalDate alertarFecha() {
        return null;
    }
}
