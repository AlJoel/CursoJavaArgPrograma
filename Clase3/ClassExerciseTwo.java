package Clase3;

public class ClassExerciseTwo {
    private static final String ALPHABET = "abcdefghijklmnñopqrstuvwxyz ";

    public static String encrypt(String text, int offset) {
        String resultado = "";
        for (int i = 0; i < text.length(); i++) {
            char caracter = text.charAt(i);
            int posicion = ALPHABET.indexOf(caracter);
            if (posicion != -1) {
                int nuevaPosicion = (posicion + offset) % ALPHABET.length();
                resultado += ALPHABET.charAt(nuevaPosicion);
            } else {
                resultado += caracter;
            }
        }
        return resultado;
    }

    public static String decrypt(String encryptedText, int offset) {
        return encrypt(encryptedText, ALPHABET.length() - offset);
    }
}
