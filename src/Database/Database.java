package ProofOfConcept.Database;

import java.sql.*;

public class Database {

    public static void main(String[] args) {
        String driver = "org.postgresql.Driver";

        String url = "jdbc:postgresql://localhost:5432/postgres";

        String user = "postgres";


        // Change the pw String to your password and run it one time only!
        String pw = "k4j4mnzswek";

        Connection connection = null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, user, pw);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "CREATE SCHEMA IF NOT EXISTS \"DATA\";";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "CREATE TABLE IF NOT EXISTS \"DATA\".book ("
                + "  title varchar(50) NOT NULL, "
                + "  author varchar(50) NOT NULL "+ ");";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String preparedSql = "INSERT INTO \"DATA\".book (title,author) "
                + "SELECT * FROM (SELECT ?, ?) AS tmp ";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(preparedSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        addBookToDatabase(preparedStatement,"Harry","Smokie");
    }


    private static void addBookToDatabase(PreparedStatement preparedStatement, String title, String author) {
        try {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
