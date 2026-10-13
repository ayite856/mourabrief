import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectiondb {

    private static final String URL = "jdbc:mysql://localhost:3306/rou_am";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Driver JDBC MySQL introuvable : " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static boolean testConnexion() {
        try (Connection conn = getConnection()) {
            if (conn != null && !conn.isClosed()) {
//                System.out.println("✅ Connexion réussie à la BDD 'rou_am' !");
                return true;
            }
        } catch (SQLException e) {
            System.err.println("❌ ÉCHEC : Impossible d'accéder à la base de données.");
            System.err.println("Détail : " + e.getMessage());
        }
        return false;
    }
}