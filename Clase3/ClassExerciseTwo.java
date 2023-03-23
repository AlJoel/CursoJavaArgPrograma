package Clase3;

public class ClassExerciseTwo {
    private static final String ALPHABET = "abcdefghijklmnñopqrstuvwxyz ";

    public static String encrypt(String text, int offset) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            int posicion = ALPHABET.indexOf(character);
            if (posicion != -1) {
                int newPosition = (posicion + offset) % ALPHABET.length();
                result += ALPHABET.charAt(newPosition);
            } else {
                result += character;
            }
        }
        return result;
    }

    public static String decrypt(String encryptedText, int offset) {
        return encrypt(encryptedText, ALPHABET.length() - offset);
    }
}
