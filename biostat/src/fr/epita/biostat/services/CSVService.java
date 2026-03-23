package fr.epita.biostat.services;

import fr.epita.biostat.datamodel.BioStatEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVService {




    public static List<BioStatEntry> getBioStatEntries(String pathname) throws FileNotFoundException {
        File file = new File(pathname);
        System.out.println(file.exists());
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
        return entries;
    }
}
