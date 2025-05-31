/**
 * @author
 * Steeven Pardo
 * Juan Calopino
 * Royel Jima
 * Daniel Savedra
 */

package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Vehiculo implements Serializable, Mantenimiento{
    private String placa;
    private float capacidadDeCarga;
    private int costoMantenimiento;
    private float consumoPorKM;
    private float capacidadCombustible;

    private List<Viaje> viajes; // Realacion UML

    /**
     *
     * @param placa
     * @param capacidadDeCarga
     * @param costoMantenimiento
     * @param consumoPorKM
     * @param viajes
     * @param capacidadCombustible
     */
    public Vehiculo(String placa, float capacidadDeCarga, int costoMantenimiento, float consumoPorKM,
                    List<Viaje> viajes, float capacidadCombustible) {
        this.placa = placa;
        this.capacidadDeCarga = capacidadDeCarga;
        this.costoMantenimiento = costoMantenimiento;
        this.consumoPorKM = consumoPorKM;
        this.capacidadCombustible = capacidadCombustible;
        this.viajes = new ArrayList<>(viajes);
    }

    public float getConsumoPorKM() {
        return consumoPorKM;
    }

    public abstract float calcularConsumoCombustible(float distanciaRecorrida, float consumoPorKM, float capacidadCombustible);

    public abstract float calcularCostoOperativo(float precioCombustible, float consumoPorKM,
                                                 float distanciaRecorrida, float costoMantenimiento);


    // Getters and Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public float getCapacidadDeCarga() {
        return capacidadDeCarga;
    }

    public void setCapacidadDeCarga(float capacidadDeCarga) {
        this.capacidadDeCarga = capacidadDeCarga;
    }

    public int getCostoMantenimiento() {
        return costoMantenimiento;
    }

    public void setCostoMantenimiento(int costoMantenimiento) {
        this.costoMantenimiento = costoMantenimiento;
    }

    public void setConsumoPorKM(float consumoPorKM) {
        this.consumoPorKM = consumoPorKM;
    }

    public float getCapacidadCombustible() {
        return capacidadCombustible;
    }

    public void setCapacidadCombustible(float capacidadCombustible) {
        this.capacidadCombustible = capacidadCombustible;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }

}
