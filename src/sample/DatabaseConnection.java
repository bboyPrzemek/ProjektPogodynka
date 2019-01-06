package sample;

import javafx.scene.Cursor;

import java.sql.*;

public class DatabaseConnection {

    private static String dbName="DbLocation";
    private static String tableName="Location";




    public static void stworzTabele(Connection polaczenie) {
        // Obiekt odpowiadający za wykonanie instrukcji
        Statement stat = null;
        try {
            stat = polaczenie.createStatement();
            // polecenie SQL tworzące tablicę
            String tabelaSQL = "CREATE TABLE " + tableName
                    + " (ID INT PRIMARY KEY     NOT NULL,"

                    + " NAME        CHAR(50)     NOT NULL)";

            // wywołanie polecenia
            stat.executeUpdate(tabelaSQL);
            // zamykanie wywołania i połączenia
            stat.close();
            polaczenie.close();
        } catch (SQLException e) {
            System.out.println("Nie mogę stworzyć tabeli" + e.getMessage());
        }
    }

    public static Connection polacz() {
        Connection polaczenie = null;
        try {
            // Wskazanie jaki rodzaj bazy danych będzie wykorzystany, tu sqlite
            Class.forName("org.sqlite.JDBC");
            // Połączenie, wskazujemy rodzaj bazy i jej nazwę
            polaczenie = DriverManager.getConnection("jdbc:sqlite:"+dbName+".db");
            System.out.println("Połączyłem się z bazą "+dbName);
        } catch (Exception e) {
            System.err.println("Błąd w połączeniu z bazą: \n" + e.getMessage());
            return null;
        }
        return polaczenie;
    }

    public static void dodajDane(Location location) {
        Connection polaczenie = null;
        Statement stat = null;
        try {
            Class.forName("org.sqlite.JDBC");
            polaczenie = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");

            stat = polaczenie.createStatement();
            String dodajSQL = "INSERT INTO " + tableName + " (ID, NAME) "
                    + "VALUES ("
                    + location.getID() + ","

                    + "'" + location.getName() + "');";
            stat.executeUpdate(dodajSQL);
            stat.close();
            polaczenie.close();
            // Komunikat i wydrukowanie końcowej formy polecenia SQL
            System.out.println("Polecenie: \n" + dodajSQL + "\n wykonane.");
        } catch (Exception e) {
            System.out.println("Nie mogę dodać danych " + e.getMessage());
        }
    }


    public static void updateDatabase(Location location) {
        Connection conn = null;
        try {
            conn = polacz();
            System.out.println("Connection to SQLite has been established.");
            conn.setAutoCommit(false);

            String sql = "UPDATE Location SET " +
                    "name='" + location.getName() + "'" ;


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
            conn = polacz();
            System.out.println("Connection to SQLite has been established.");
            conn.setAutoCommit(false);

            String sql = "SELECT * from Location";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            conn.commit();

            String name= rs.getString("name");

            Location location = new Location(name);

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

    public static boolean isEmpty() {
        Connection con = null;
        try {

            con = polacz();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from Location");
            if (rs.next() == false) {
                System.out.println("ResultSet in empty in Java");
                return false;
            } else {
                do {
                    String data = rs.getString("ID");
                    System.out.println(data);
                } while (rs.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}









