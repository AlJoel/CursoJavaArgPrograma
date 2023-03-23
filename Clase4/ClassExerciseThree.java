package Clase4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static Clase3.ClassExerciseTwo.*;

public class ClassExerciseThree {
    public static void processFile(String inputFilePath, String outputFilePath, int offset, boolean isEncrypt) {
        Path inputPath = Paths.get(inputFilePath);
        Path outputPath = Paths.get(outputFilePath);

        try {
            List<String> lines = Files.readAllLines(inputPath);

            for (String line : lines) {
                String result = isEncrypt ? encrypt(line, offset) : decrypt(line, offset);
                Files.writeString(outputPath, result + System.lineSeparator());
            }

            System.out.println("Operation completed successfully.");

        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
