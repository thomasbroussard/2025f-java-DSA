package fr.epita.biostat.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestFileInput {


    public static void main(String[] args) throws IOException {
        File file = new File("./java-exercises/biostat/biostat.csv");
        System.out.println(file.exists());


        Path path = Path.of("./java-exercises/biostat/biostat.csv");
        List<String> lines = Files.readAllLines(path);
        List<BioStatEntry> entries = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            System.out.println(line);
            String[] parts = line.split(",");
            entries.add(new BioStatEntry(parts[0], parts[1], parts[2]...));
        }


    }
}
