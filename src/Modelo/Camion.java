/**
 * @author
 * Steeven Pardo
 * Juan Calopino
 * Royel Jima
 * Daniel Savedra
 */

package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Camion extends Vehiculo {
    private int numeroDeEjes;

    public Camion(String placa, float capacidadDeCarga, int costoMantenimiento, float consumoPorKM,
                  List<Viaje> viajes, float capacidadCombustible, int numeroDeEjes) {
        super(placa, capacidadDeCarga, 50, consumoPorKM, new ArrayList<>(), 150);
        this.numeroDeEjes = numeroDeEjes;
    }


    @Override
    public float calcularConsumoCombustible(float distanciaRecorrida, float consumoPorKM, float capacidadCombustible) {
        return 0;
    }

    @Override
    public float calcularCostoOperativo(float precioCombustible, float consumoPorKM, float distanciaRecorrida, float costoMantenimiento) {
        float costoCamion = distanciaRecorrida * consumoPorKM * precioCombustible + costoMantenimiento;
        return costoCamion;
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
