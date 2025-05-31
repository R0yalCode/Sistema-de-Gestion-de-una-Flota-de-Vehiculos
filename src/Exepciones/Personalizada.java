package Exepciones;

public class Personalizada extends RuntimeException {
    public Personalizada(String message) {
        super(message);
    }

    public static void validarPlaca(String placa) {
        if (!placa.matches("^[A-Z]{3}-\\d{3,4}$")) {
            throw new Personalizada("❌ La placa ingresada es inválida, Ejemplo (AAA-1234).");
        }
    }


}
