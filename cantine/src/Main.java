import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (!connectiondb.testConnexion()) {
            System.err.println("Arrêt de l'application : BDD inaccessible.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            System.out.println("\n========== GESTION CANTINE ROU_AM ==========");
            System.out.println("1. Ajouter un apprenant");
            System.out.println("2. Lister les apprenants");
            System.out.println("3. Acheter un ticket");
            System.out.println("4. Servir un repas (Mise à jour du ticket)");
            System.out.println("5. Afficher les tickets avec infos apprenants");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            switch (choix) {
                case 1 -> ajouterApprenant(scanner);
                case 2 -> listerApprenants();
                case 3 -> acheterTicket(scanner);
                case 4 -> servirRepas(scanner);
                case 5 -> listerTicketsComplets();
                case 0 -> {
                    continuer = false;
                    System.out.println("Au revoir !");
                }
                default -> System.out.println("Choix invalide.");
            }
        }
        scanner.close();
    }

    private static void ajouterApprenant(Scanner scanner) {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Classe : ");
        String classe = scanner.nextLine();

        String sql = "INSERT INTO apprenant (nom, prenom, classe) VALUES (?, ?, ?)";
        try (Connection conn = connectiondb.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, classe);
            stmt.executeUpdate();
            System.out.println("✅ Apprenant ajouté avec succès !");
        } catch (SQLException e) {
            System.err.println("❌ Erreur d'ajout : " + e.getMessage());
        }
    }

    private static void listerApprenants() {
        String sql = "SELECT * FROM apprenant";
        try (Connection conn = connectiondb.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- LISTE DES APPRENANTS ---");
            while (rs.next()) {
                Apprenant a = new Apprenant(
                        rs.getInt("idApprenant"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("classe")
                );
                System.out.println(a);
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur de lecture : " + e.getMessage());
        }
    }

    private static void acheterTicket(Scanner scanner) {
        System.out.print("ID Apprenant : ");
        int idApprenant = scanner.nextInt();
        System.out.print("Prix du ticket : ");
        float prix = scanner.nextFloat();
        System.out.print("Nombre de repas par jour : ");
        int repasParJour = scanner.nextInt();
        System.out.print("Durée de validité (en jours) : ");
        int joursValides = scanner.nextInt();

        LocalDate creation = LocalDate.now();
        LocalDate expiration = creation.plusDays(joursValides);

        String sql = "INSERT INTO ticket (idApprenant, dateCreation, dateExpiration, prix, repasParJour, repasServis) VALUES (?, ?, ?, ?, ?, 0)";
        try (Connection conn = connectiondb.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idApprenant);
            stmt.setDate(2, Date.valueOf(creation));
            stmt.setDate(3, Date.valueOf(expiration));
            stmt.setFloat(4, prix);
            stmt.setInt(5, repasParJour);
            stmt.executeUpdate();
            System.out.println("✅ Ticket acheté avec succès !");
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de l'achat : " + e.getMessage());
        }
    }

    private static void servirRepas(Scanner scanner) {
        System.out.print("ID Ticket : ");
        int idTicket = scanner.nextInt();

        String sql = "UPDATE ticket SET repasServis = repasServis + 1 WHERE idTicket = ? AND dateExpiration >= CURDATE() AND repasServis < repasParJour";
        try (Connection conn = connectiondb.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTicket);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Repas servi avec succès !");
            } else {
                System.out.println("⚠️ Impossible de servir le repas (Ticket expiré, introuvable ou quota atteint).");
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors du service : " + e.getMessage());
        }
    }

    private static void listerTicketsComplets() {
        String sql = "SELECT a.nom, a.prenom, a.classe, t.idTicket, t.prix, t.dateExpiration, t.repasParJour, t.repasServis " +
                "FROM apprenant a JOIN ticket t ON a.idApprenant = t.idApprenant";
        try (Connection conn = connectiondb.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- LISTE DES TICKETS ACTIFS ---");
            while (rs.next()) {
                System.out.printf("Ticket #%d | %s %s (%s) | Expire: %s | Repas: %d/%d | Prix: %.2f FCFA%n",
                        rs.getInt("idTicket"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("classe"),
                        rs.getDate("dateExpiration"),
                        rs.getInt("repasServis"),
                        rs.getInt("repasParJour"),
                        rs.getFloat("prix")
                );
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur de lecture : " + e.getMessage());
        }
    }
}