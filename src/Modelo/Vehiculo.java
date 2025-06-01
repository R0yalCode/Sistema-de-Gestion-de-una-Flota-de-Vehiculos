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
import java.util.List;

public abstract class Vehiculo implements Serializable, Mantenimiento {
    private final String placa;
    private final float capacidadDeCarga;
    private final int costoMantenimiento;
    private final float consumoPorKM;
    private final float capacidadCombustible;
    private LocalDate ultimaFechaMantenimiento;
    private final List<Viaje> viajes;

    public Vehiculo(String placa, float capacidadDeCarga, int costoMantenimiento, float consumoPorKM,
                    List<Viaje> viajes, float capacidadCombustible) {
        this.placa = placa;
        this.capacidadDeCarga = capacidadDeCarga;
        this.costoMantenimiento = costoMantenimiento;
        this.consumoPorKM = consumoPorKM;
        this.capacidadCombustible = capacidadCombustible;
        this.viajes = (viajes != null) ? new ArrayList<>(viajes) : new ArrayList<>();
        this.ultimaFechaMantenimiento = LocalDate.now(); // Se inicializa con la fecha actual
    }

    @Override
    public LocalDate registrarFecha(LocalDate ingresarFecha) {
        validarFecha(ingresarFecha);
        ultimaFechaMantenimiento = ingresarFecha;
        return ultimaFechaMantenimiento;
    }

    @Override
    public LocalDate actualizarFecha(LocalDate fecha) {
        validarFecha(fecha);
        ultimaFechaMantenimiento = fecha;
        return ultimaFechaMantenimiento;
    }

    @Override
    public float calcularCosto(Vehiculo vehiculo) {
        return mantenimientoVencido() ? 50 : 0;
    }

    @Override
    public LocalDate alertarFecha() {
        return mantenimientoVencido() ? ultimaFechaMantenimiento : null;
    }

    private void validarFecha(LocalDate fecha) {
        if (fecha == null || fecha.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("❌ Fecha inválida.");
        }
    }

    //public float calcularConsumoCombustible(float distanciaRecorrida) {
    //    validarDistancia(distanciaRecorrida);
    //    return (distanciaRecorrida / capacidadCombustible) * consumoPorKM;
    //}

    public float calcularCostoOperativo(float precioCombustible, float distanciaRecorrida) {
        validarDistancia(distanciaRecorrida);
        return (precioCombustible * consumoPorKM * distanciaRecorrida) + costoMantenimiento;
    }

    public void registrarViaje(float distanciaRecorrida) {
        validarDistancia(distanciaRecorrida);
        viajes.add(new Viaje(distanciaRecorrida, LocalDate.now()));
    }

    private void validarDistancia(float distancia) {
        if (distancia <= 0) {
            throw new IllegalArgumentException("❌ La distancia no puede ser negativa.");
        }
    }

    private boolean mantenimientoVencido() {
        return ultimaFechaMantenimiento.isBefore(LocalDate.now().minusMonths(6));
    }

    public String getPlaca() {
        return placa;
    }

    public float getCapacidadDeCarga() {
        return capacidadDeCarga;
    }

    public int getCostoMantenimiento() {
        return costoMantenimiento;
    }

    public float getConsumoPorKM() {
        return consumoPorKM;
    }

    public float getCapacidadCombustible() {
        return capacidadCombustible;
    }

    public List<Viaje> getViajes() {
        return new ArrayList<>(viajes);
    }

    @Override
    public String toString() {
        return "\n🚗 Vehículo\n" +
                "📌 Placa: " + placa + "\n" +
                "🔹 Capacidad de carga: " + capacidadDeCarga + " kg\n" +
                "🔹 Costo de mantenimiento: $" + costoMantenimiento + "\n" +
                "🔹 Consumo de combustible: " + consumoPorKM + " l/km\n" +
                "🔹 Capacidad del tanque: " + capacidadCombustible + " L\n" +
                "🔹 Último mantenimiento: " + ultimaFechaMantenimiento + "\n" +
                "📌 Viajes: " + (viajes.isEmpty() ? "No tiene viajes registrados" : viajes);
    }
}


