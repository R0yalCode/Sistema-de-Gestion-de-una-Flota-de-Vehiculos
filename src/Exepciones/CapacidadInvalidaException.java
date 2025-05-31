package Exepciones;

import static View.Main.scanner;

public class CapacidadInvalidaException extends RuntimeException {
    public CapacidadInvalidaException(String message) {
        super(message);
    }

    public static float validarCapacidad() {
        if (!scanner.hasNextFloat()) {
            throw new CapacidadInvalidaException("❌ Entrada inválida. Ingrese un número válido para la capacidad de carga en kg.");
        }
        return scanner.nextFloat();
    }

}
