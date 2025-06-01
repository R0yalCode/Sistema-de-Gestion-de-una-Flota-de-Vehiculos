/**
 * @author
 * Steeven Pardo
 * Juan Calopino
 * Royel Jima
 * Daniel Savedra
 */

package View;

import Modelo.BaseDatosVehiculo;
import Modelo.Vehiculo;
import Modelo.Moto;
import Modelo.Camioneta;
import Modelo.Camion;
import Exeption.ValidarPlacaException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class EjecutorVehiculo {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        cargarDatos();
        int opcion;

        do {
            mostrarMenu();
            opcion = obtenerOpcionValida();
            procesarOpcion(opcion);
        } while (opcion != 5);
    }

    private static void cargarDatos() {
        try {
            BaseDatosVehiculo.cargarVehiculo();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Error al cargar los datos.");
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Gestión de Flota ===");
        System.out.println("Autores: Steeven Pardo, Juan Calopino, Royel Jima, Daniel Savedra");
        System.out.println("1. Registrar vehículo");
        System.out.println("2. Registrar viaje");
        System.out.println("3. Actualizar mantenimiento");
        System.out.println("4. Listar vehículos");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int obtenerOpcionValida() {
        while (true) {
            try {
                int opcion = Integer.parseInt(scanner.nextLine().trim());
                if (opcion >= 1 && opcion <= 5) {
                    return opcion;
                }
                System.out.println("❌ La opcion ingresada es invalida. Ingrese un número entre 1 y 5.");
            } catch (Exception e) {
                System.out.println("❌ La opcion ingresada es invalida. Debe ingresar un número valido.");
            }
        }
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> registrarVehiculo();
            case 2 -> registrarViaje();
            case 3 -> actualizarMantenimiento();
            case 4 -> listarVehiculo();
            case 5 -> System.out.println("🫂 Saliendo del sistema...");
        }
    }

    private static void registrarVehiculo() {
        System.out.println("\nTipo de vehículo:");
        System.out.println("1: Moto\n2: Camioneta\n3: Camión");

        int tipo = obtenerOpcionValida();
        System.out.print("Placa (Ejemplo: AAA-1234): ");
        String placa = validarPlaca();
        System.out.print("Capacidad (kg): ");
        float capacidad = validarNumeroFlotante();
        System.out.print("Consumo (l/km): ");
        float consumo = validarNumeroFlotante();

        Vehiculo nuevoVehiculo = switch (tipo) {
            case 1 -> new Moto(placa, capacidad, 15, consumo, List.of(), 20, true);
            case 2 -> {
                System.out.print("¿Tiene tracción 4x4? (s/n): ");
                boolean traccion4x4 = validarTexto().equalsIgnoreCase("s");
                yield new Camioneta(placa, capacidad, 100, consumo, List.of(), 60, traccion4x4);
            }
            case 3 -> {
                System.out.print("Número de ejes: ");
                int ejes = obtenerOpcionValida();
                yield new Camion(placa, capacidad, 200, consumo, List.of(), 150, ejes);
            }
            default -> null;
        };

        if (nuevoVehiculo != null) {
            try {
                BaseDatosVehiculo.registrarVehiculo(nuevoVehiculo);
                System.out.println("✅ Vehículo registrado correctamente.");
            } catch (IOException e) {
                System.out.println("❌ Error al guardar el vehículo.");
            }
        }
    }

    private static void registrarViaje() {
        System.out.print("Ingrese la placa del vehículo: ");
        String placa = validarPlaca();

        Vehiculo vehiculo = BaseDatosVehiculo.buscarVehiculo(placa);
        if (vehiculo != null) {
            System.out.print("Ingrese la distancia del viaje (km): ");
            float distancia = validarNumeroFlotante();

            System.out.print("Ingrese el precio por litro de combustible ($): ");
            float precioCombustible = validarNumeroFlotante();

            vehiculo.registrarViaje(distancia);

            float costo = vehiculo.calcularCostoOperativo(precioCombustible, distancia);
            System.out.printf("✅ Viaje registrado.\n💸 El costo del viaje es: $%.2f\n", costo);
        } else {
            System.out.println("❌ Vehículo no encontrado.");
        }
    }

    private static void actualizarMantenimiento() {
        System.out.print("Ingrese la placa del vehículo: ");
        String placa = validarPlaca();

        Vehiculo vehiculo = BaseDatosVehiculo.buscarVehiculo(placa);
        if (vehiculo != null) {
            System.out.print("Ingrese la fecha del último mantenimiento (YYYY-MM-DD): ");
            String fechaInput = scanner.nextLine().trim();

            try {
                LocalDate fechaMantenimiento = LocalDate.parse(fechaInput);
                LocalDate fechaActual = LocalDate.now();

                if (fechaMantenimiento.plusDays(180).isBefore(fechaActual)) {
                    System.out.println("⚠️ ¡Alerta! Mantenimiento pendiente desde " + fechaMantenimiento);
                }

                // Actualiza la fecha de mantenimiento a hoy
                vehiculo.actualizarFecha(fechaActual);
                System.out.println("✅ Mantenimiento actualizado.");
            } catch (DateTimeParseException e) {
                System.out.println("❌ Fecha inválida. Formato correcto: YYYY-MM-DD.");
            }
        } else {
            System.out.println("❌ Vehículo no encontrado.");
        }
    }


    private static void listarVehiculo() {
        List<Vehiculo> flota = BaseDatosVehiculo.getFlota().values().stream().toList();
        if (flota.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
        } else {
            flota.forEach(System.out::println);
        }
    }

    private static float validarNumeroFlotante() {
        while (true) {
            try {
                float numero = Float.parseFloat(scanner.nextLine().trim());
                if (numero > 0) {
                    return numero;
                }
                System.out.println("❌ El número debe ser mayor a 0.");
            } catch (Exception e) {
                System.out.println("❌ Entrada inválida. Ingrese un número válido.");
            }
        }
    }

    private static String validarTexto() {
        while (true) {
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("❌ El texto no puede estar vacío.");
        }
    }

    private static String validarPlaca() {
        while (true) {
            String placa = scanner.nextLine().trim();
            try {
                ValidarPlacaException.validarPlaca(placa);
                return placa;
            } catch (ValidarPlacaException e) {
                System.out.println(e.getMessage());
                System.out.print("Ingrese una placa válida (Ejemplo: AAA-1234): ");
            }
        }
    }
}
