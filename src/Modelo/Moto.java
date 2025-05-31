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

public class Moto extends Vehiculo{
    private boolean cilindrada;

    /**
     * @param placa
     * @param capacidadDeCarga
     * @param costoMantenimiento
     * @param consumoPorKM
     * @param viajes
     * @param capacidadCombustible
     */
    public Moto(String placa, float capacidadDeCarga, int costoMantenimiento, float consumoPorKM,
                List<Viaje> viajes, float capacidadCombustible, boolean cilindrada) {
        super(placa, capacidadDeCarga, costoMantenimiento, consumoPorKM, viajes, 20.0f);
        this.cilindrada = cilindrada;
    }

    @Override
    public float calcularConsumoCombustible(float distanciaRecorrida, float consumoPorKM, float capacidadCombustible) {
        return distanciaRecorrida / capacidadCombustible * consumoPorKM;
    }

    @Override
    public float calcularCostoOperativo(float precioCombustible, float consumoPorKM, float distanciaRecorrida, float costoMantenimiento) {
        float costoMoto = distanciaRecorrida * consumoPorKM * precioCombustible + costoMantenimiento;
        return costoMoto;
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
