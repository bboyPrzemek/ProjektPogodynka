package sample;

import java.sql.*;

public class DatabaseConnection {
    private static String URL = "jdbc:sqlite:C:/sqlite/db/location.db";


    public static void updateDatabase(Location location) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
            conn.setAutoCommit(false);

            String sql = "UPDATE Location SET " +
                    "name='" + location.getName() + "'," +
                    " coords='" + location.getCoords() + "'";

            System.out.println("Update successful");

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static Location getLocationFromDatabase() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
            conn.setAutoCommit(false);

            String sql = "SELECT * from Location";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            conn.commit();

            String name= rs.getString("name");
            String coords=rs.getString("coords");
            Location location = new Location(coords,name);

            System.out.println(location.getCoords());
            System.out.println(location.getName());
            return location;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;

    }


}





