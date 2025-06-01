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

public class Camion extends Vehiculo {
    private int numeroDeEjes;

    public Camion(String placa, float capacidadDeCarga, int costoMantenimiento, float consumoPorKM,
                  List<Viaje> viajes, float capacidadCombustible, int numeroDeEjes) {
        super(placa, capacidadDeCarga, costoMantenimiento, consumoPorKM, viajes, capacidadCombustible);
        this.numeroDeEjes = numeroDeEjes;
    }

    @Override
    public LocalDate registrarFecha(LocalDate ingresarFecha) {
        return super.registrarFecha(ingresarFecha);
    }

    @Override
    public LocalDate actualizarFecha(LocalDate fecha) {
        return super.actualizarFecha(fecha);
    }

    @Override
    public float calcularCosto(Vehiculo vehiculo) {
        return super.calcularCosto(vehiculo);
    }

    @Override
    public LocalDate alertarFecha() {
        return super.alertarFecha();
    }

    @Override
    public String toString() {
        return "\n🚚 Camión\n" +
                "📌 Placa: " + getPlaca() + "\n" +
                "🔹 Capacidad de carga: " + getCapacidadDeCarga() + " kg\n" +
                "🔹 Costo de mantenimiento: $" + getCostoMantenimiento() + "\n" +
                "🔹 Consumo de combustible: " + getConsumoPorKM() + " l/km\n" +
                "🔹 Capacidad del tanque: " + getCapacidadCombustible() + " L\n" +
                "🔹 Número de ejes: " + numeroDeEjes + "\n" +
                "📌 Viajes: " + (getViajes().isEmpty() ? "No tiene viajes registrados" : getViajes());
    }

}
