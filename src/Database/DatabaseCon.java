package Database;

import java.sql.*;

public class DatabaseCon {

    private static Connection c = null;
    private static Statement stmt = null;


    private static void openConn() throws SQLException {
        c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "k4j4mnzswek");

    }
    public String getBook(String title) {

        try {
            openConn();
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM \"DATA\".book;");
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.executeQuery();


            while(rs.next()){
                String title1 = rs.getString("title");
                System.out.println("Book's title: " + title);
                String author = rs.getString("author");
                if(title.equals(title1))
                {
                    System.out.println("Book: " + title  +" "+ author);
                    return author;
                }

            }

            rs.close();
            preparedStatement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
