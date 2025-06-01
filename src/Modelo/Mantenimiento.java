/**
 * @author
 * Steeven Pardo
 * Juan Calopino
 * Royel Jima
 * Daniel Savedra
 */

package Modelo;

import java.time.LocalDate;

public interface Mantenimiento {
    public LocalDate registrarFecha(LocalDate ingresarFecha);

    public LocalDate actualizarFecha(LocalDate fecha);

    public float calcularCosto(Vehiculo vehiculo);

    public LocalDate alertarFecha();
}
