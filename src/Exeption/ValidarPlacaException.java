package Exeption;

public class ValidarPlacaException extends RuntimeException {
    public ValidarPlacaException(String message) {
        super(message);
    }

    public static void validarPlaca(String placa) {
        if (!placa.matches("^[A-Z]{3}-\\d{3,4}$")) {
            throw new ValidarPlacaException("❌ La placa ingresada es inválida, Ejemplo (AAA-1234).");
        }
    }


}
