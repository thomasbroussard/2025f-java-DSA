package fr.epita.biostat.tests;

import fr.epita.biostat.datamodel.BioStatEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TestFileInput {


    public static void main(String[] args) throws IOException {
        File file = new File("./java-exercises/biostat/biostat.csv");
        System.out.println(file.exists());


        Path path = Path.of("./java-exercises/biostat/biostat.csv");
        List<String> lines = Files.readAllLines(path);
        List<BioStatEntry> entries = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            System.out.println(line);
            String[] parts = line.split(",");
            entries.add(new BioStatEntry(
                    parts[0].trim(),
                    parts[1].trim(),
                    Integer.parseInt(parts[2].trim()),
                    Integer.parseInt(parts[3].trim()),
                    Integer.parseInt(parts[4].trim())
            ));
        }
        System.out.println("loaded " + entries.size() + " entries");

        //do the average age
        double totalAge = 0;
        for (BioStatEntry entry: entries){
            totalAge = totalAge + entry.getAge();
        }
        double averageAge = totalAge/entries.size();
        System.out.println(averageAge);

        //do the average age with stream approach
        OptionalDouble average = entries
                .parallelStream()
                .mapToInt(BioStatEntry::getAge)
                .average();

        if (average.isPresent()){
            System.out.println(average.getAsDouble());
        }


        Map<String,Integer> countByGender = new LinkedHashMap<>();


        for (BioStatEntry entry: entries){
            Integer currentCount = countByGender.get(entry.getSex());
            if (currentCount == null){
                currentCount = 0;
            }
            currentCount++;
            countByGender.put(entry.getSex(), currentCount);
        }
        System.out.println(countByGender);





    }
}
