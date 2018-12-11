package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
        /**
         * plik z folderu db(location.db) wrzuc do katalogu C:/sqlite/db/
         *
         */
        public static void connect() {
            Connection conn = null;
            try {
                String url = "jdbc:sqlite:C:/sqlite/db/location.db";
                conn = DriverManager.getConnection(url);
                System.out.println("Connection to SQLite has been established.");

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
    }
