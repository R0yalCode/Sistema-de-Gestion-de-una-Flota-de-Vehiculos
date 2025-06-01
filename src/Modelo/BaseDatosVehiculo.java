package Modelo;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BaseDatosVehiculo {
    private static final String INFORMACION_VEHICULO = "vehiculo.dat";
    private static Map<String, Vehiculo> flota = new HashMap<>();

    public static void guardarVehiculo() throws IOException {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(INFORMACION_VEHICULO))) {
            salida.writeObject(flota);
        }
    }

    public static void cargarVehiculo() throws IOException, ClassNotFoundException {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(INFORMACION_VEHICULO))) {
            flota = (Map<String, Vehiculo>) entrada.readObject();
        } catch (FileNotFoundException e) {
            flota = new HashMap<>();
        }
    }

    public static void registrarVehiculo(Vehiculo vehiculo) throws IOException {
        if (flota.containsKey(vehiculo.getPlaca())) {
            throw new IllegalArgumentException("❌ Ya se encuentra registrado un vehículo con esa placa.");
        }
        flota.put(vehiculo.getPlaca(), vehiculo);
        guardarVehiculo();
    }

    public static Vehiculo buscarVehiculo(String placa) {
        return flota.get(placa);
    }

    public static Map<String, Vehiculo> getFlota() {
        return Collections.unmodifiableMap(flota);
    }
}
