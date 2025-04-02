package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
    static Connection connexion = null;
    static String url = "jdbc:mysql://localhost:3306/biblio";
    static String username = "root";
    static String password = "";

    public static Connection seConnecter() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connexion = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
        return connexion;
    }

    public static void seDeconnecter() {
        try {
            connexion.close();
        } catch (SQLException e) {
            //throw new RuntimeException(e);
        }
    }
}
