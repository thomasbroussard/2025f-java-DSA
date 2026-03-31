package fr.epita.biostat.services;

import fr.epita.biostat.datamodel.BioStatEntry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BioStatDataService {


    private static BioStatDataService instance;

    public static BioStatDataService getInstance() throws SQLException {
        if (instance == null){
            instance = new BioStatDataService();
        }
        return instance;
    }

    private BioStatDataService() throws SQLException {
        try (Connection connection = getConnection()) {

            PreparedStatement createTableStatement = connection.prepareStatement("""
                CREATE TABLE BIOSTATS (
                    name varchar(255), 
                    sex char, 
                    age int
                )                                                            
                """);
            createTableStatement.execute();
        }

    }


    public void save(BioStatEntry entry) throws SQLException {
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


    public List<BioStatEntry> search(BioStatEntry qbe) throws SQLException {
        List<BioStatEntry> entries = new ArrayList<>();
        try(Connection connection = getConnection()) {
           /* String selectQuery = """
                    SELECT name,age,sex FROM BIOSTATS
                    where 
                        (? IS NULL OR name = ?) 
                        and
                        (? IS NULL OR age = ?)
                        and
                        (? IS NULL OR sex = ?)
                    """;*/
            String selectQuery = """
                    SELECT name,age,sex FROM BIOSTATS 
                    where 
                        (? IS NULL OR name = ?) 
                        and
                  
                     
                        (? IS NULL OR sex = ?)
                    """;
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, qbe.getName());
            selectStatement.setString(2, qbe.getName());
            //selectStatement.setObject(3, qbe.getAge());
            //selectStatement.setObject(4, qbe.getAge());
            selectStatement.setString(3, qbe.getSex());
            selectStatement.setString(4, qbe.getSex());

            ResultSet resultSet = selectStatement.executeQuery();

            while(resultSet.next()){
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String sex = resultSet.getString("sex");
                BioStatEntry entry = new BioStatEntry(name, sex, age, null, null);
                entries.add(entry);
            }
        }
        return entries;
    }

    public void update(BioStatEntry entry) throws SQLException {
        try(Connection connection = getConnection()) {
            PreparedStatement updateStatement = connection.prepareStatement("""
                                UPDATE BIOSTATS SET age = ? where name = ?
                """);

            updateStatement.setString(2, entry.getName());
            updateStatement.setInt(1, entry.getAge());
            updateStatement.execute();
        }
    }


    public void delete(BioStatEntry entry) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement deleteStatement = connection.prepareStatement("""
                                    DELETE FROM BIOSTATS where name='thomas'
                    """);

            deleteStatement.execute();
        }


    }




    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    }
}


