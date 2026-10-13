import java.time.LocalDate;

public class Ticket {
    private int idTicket;
    private int idApprenant;
    private LocalDate dateCreation;
    private LocalDate dateExpiration;
    private float prix;
    private int repasParJour;
    private int repasServis;

    public Ticket(int idTicket, int idApprenant, LocalDate dateCreation, LocalDate dateExpiration, float prix, int repasParJour, int repasServis) {
        this.idTicket = idTicket;
        this.idApprenant = idApprenant;
        this.dateCreation = dateCreation;
        this.dateExpiration = dateExpiration;
        this.prix = prix;
        this.repasParJour = repasParJour;
        this.repasServis = repasServis;
    }

    public int getIdTicket() { return idTicket; }
    public int getIdApprenant() { return idApprenant; }
    public LocalDate getDateCreation() { return dateCreation; }
    public LocalDate getDateExpiration() { return dateExpiration; }
    public float getPrix() { return prix; }
    public int getRepasParJour() { return repasParJour; }
    public int getRepasServis() { return repasServis; }

    public boolean estValide() {
        return !LocalDate.now().isAfter(dateExpiration) && repasServis < repasParJour;
    }

    @Override
    public String toString() {
        return String.format("Ticket #%d | Apprenant ID: %d | Expiration: %s | Repas servis: %d/%d | Valide: %s",
                idTicket, idApprenant, dateExpiration, repasServis, repasParJour, estValide() ? "OUI" : "NON");
    }
}