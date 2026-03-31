package fr.epita.biostat.tests.db;

import fr.epita.biostat.datamodel.BioStatEntry;
import fr.epita.biostat.services.BioStatDataService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTest {

    public static void main(String[] args) throws SQLException {

        BioStatDataService service = BioStatDataService.getInstance();
        BioStatEntry entry =  new BioStatEntry("thomas", "M", 39, 170, 73);
        service.save(entry);

        entry.setAge(40);
        BioStatEntry qbe = new BioStatEntry(null, null, null, null, null);

        System.out.println(service.search(qbe));
        service.update(entry);
        service.search(qbe);
        service.delete(entry);
        System.out.println(service.search(qbe));


    }

}
