package fr.epita.biostat.services;

import fr.epita.biostat.datamodel.BioStatEntry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BioStatDataService {


    private static void save(BioStatEntry entry) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement insertStatement = connection.prepareStatement("""
                                INSERT INTO BIOSTATS(name, sex, age) VALUES (?, ?, ?)
                """);

            insertStatement.setString(1, entry.getName());
            insertStatement.setString(2, entry.getSex());
            insertStatement.setInt(3, entry.getAge());
            // insertStatement.setInt(4, entry.getHeight());
            // insertStatement.setInt(5, entry.getWeight());

            insertStatement.execute();
        }
    }


    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test");
    }
}


