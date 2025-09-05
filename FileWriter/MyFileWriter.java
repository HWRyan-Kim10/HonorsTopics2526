package FileWriter;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class MyFileWriter {
    public static void main(String[] args) {
        String data = "Hello, World!";
        String fileName1 = "example.txt";
        String fileName2 = "example2.txt";
        String fileName3 = "example3.txt";
        String fileName4 = "example4.txt";
        String fileName5 = "example5.txt";


        // 1. Using FileWriter
        try (FileWriter writer = new FileWriter(fileName1)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Using BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. Using FileOutputStream
        try (FileOutputStream outputStream = new FileOutputStream(fileName3)) {
            outputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4. Using BufferedOutputStream
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName4))) {
            bufferedOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5. Using Files (java.nio.file)
        try {
            Files.write(Paths.get(fileName5), data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        createHiddenPasswordFile("secrEtPassw0rd");
        createConfidentialFile("11/30/25");
    }

    public static void createHiddenPasswordFile(String password) {
        String fileName = ".verySecretFile.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(password);
            System.out.println("Hidden password file created successfully: " + fileName);
        } 
        catch (IOException e) {
            System.out.println("Error writing to hidden password file: " + e.getMessage());
        }
    }

    public static void createConfidentialFile(String info) {
        String folderName = ".confidentialFolder";
        String fileName = folderName + "/doNotShare.dat";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(info);
            System.out.println("Hidden file created successfully in confidential folder: " + fileName);
        } 
        catch (IOException e) {
            System.out.println("Error writing confidential file: " + e.getMessage());
        }
    }
}