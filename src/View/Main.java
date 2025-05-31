/**
 * @author
 * Steeven Pardo
 * Juan Calopino
 * Royel Jima
 * Daniel Savedra
 */

package View;

import Modelo.Vehiculo;
import Modelo.Camion;
import Modelo.Camioneta;
import Modelo.Moto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Exepciones.Personalizada;

public class Main {
    private static List<Vehiculo> flota = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        do {
            mostrarMenu();

            // Validación de entrada
            while (!scanner.hasNextInt()) {
                System.out.println("❌ Entrada inválida. Por favor, ingrese un número del 1 al 5.");
                scanner.next(); // Limpiar entrada incorrecta
                mostrarMenu(); // Volver a mostrar opciones
            }

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            procesarOpcion(opcion);
        } while (opcion != 5);

        System.out.println("Saliendo del sistema...");
    }

    private static void mostrarMenu() {
        System.out.println("\n----BIENVENIDO----");
        System.out.println("\n=== Gestión de Flota de Reparto ===");
        System.out.println("=============================");
        System.out.println("1. Registrar vehículo");
        System.out.println("2. Registrar viaje");
        System.out.println("3. Actualizar mantenimiento");
        System.out.println("4. Listar vehículos");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> registrarVehiculo();
            case 2 -> registrarViaje();
            case 3 -> actualizarMantenimiento();
            case 4 -> listarVehiculos();
            case 5 -> System.out.println("Gracias por usar el sistema.");
            default -> System.out.println("Opción inválida, intente nuevamente.");
        }
    }

    private static void registrarVehiculo() {
        System.out.println("\nSeleccione el tipo de vehículo:");
        System.out.println("1: Moto\n2: Camioneta\n3: Camión");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        try {
            Personalizada.validarPlaca(placa);
        } catch (Personalizada e) {
            System.out.println(e.getMessage());
            System.out.print("Ingrese una placa válida: ");
            placa = scanner.nextLine();
        }

        System.out.print("Capacidad (kg): ");
        float capacidadDeCarga = scanner.nextFloat();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Consumo por km (litros/km): ");
        float consumoPorKM = scanner.nextFloat();
        scanner.nextLine(); // Limpiar buffer

        int costoMantenimiento = switch (tipo) {
            case 1 -> 15;  // Moto
            case 2 -> 100; // Camioneta
            case 3 -> 200; // Camión
            default -> 0;  // Valor de seguridad para casos inválidos
        };

        Vehiculo nuevoVehiculo = switch (tipo) {
            case 1 -> new Moto(placa, capacidadDeCarga, costoMantenimiento, consumoPorKM, new ArrayList<>(), 20, true);
            case 2 -> {
                System.out.print("¿Tiene tracción 4x4? (s/n): ");
                boolean traccion4x4 = scanner.nextLine().equalsIgnoreCase("s");
                yield new Camioneta(placa, capacidadDeCarga, costoMantenimiento, consumoPorKM, new ArrayList<>(), 60, traccion4x4);
            }
            case 3 -> {
                System.out.print("Número de ejes: ");
                int numeroDeEjes = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                yield new Camion(placa, capacidadDeCarga, costoMantenimiento, consumoPorKM, new ArrayList<>(), 150, numeroDeEjes);
            }
            default -> null;
        };

        if (nuevoVehiculo != null) {
            flota.add(nuevoVehiculo);
            System.out.println("Vehículo " + nuevoVehiculo.getPlaca() + " registrado con éxito.");
        } else {
            System.out.println("Tipo de vehículo inválido.");
        }
    }

    private static void registrarViaje() {
        System.out.println("\nFunción de registrar viaje aún en desarrollo...");
    }

    private static void actualizarMantenimiento() {
        System.out.println("\nFunción de actualizar mantenimiento aún en desarrollo...");
    }

    private static void listarVehiculos() {
        System.out.println("\n=== Lista de Vehículos Registrados ===");
        if (flota.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
        } else {
            flota.forEach(System.out::println);
        }
    }
}
