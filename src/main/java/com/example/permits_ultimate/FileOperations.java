package com.example.permits_ultimate;

import java.io.*;

public class FileOperations {
    public static void write(File destination, String src) {
        try (FileWriter writer = new FileWriter(destination)) {
            if (!destination.exists()) {
                destination.createNewFile();
            }
            writer.write(src);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(File src) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(src)) {
            int i;
            while ((i = reader.read()) != -1) {
                char letter = (char) i;
                stringBuilder.append(letter);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
