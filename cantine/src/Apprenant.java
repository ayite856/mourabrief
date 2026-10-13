public class Apprenant {
    private int idApprenant;
    private String nom;
    private String prenom;
    private String classe;

    public Apprenant(int idApprenant, String nom, String prenom, String classe) {
        this.idApprenant = idApprenant;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
    }

    public Apprenant(String nom, String prenom, String classe) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
    }

    public int getIdApprenant() { return idApprenant; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getClasse() { return classe; }

    @Override
    public String toString() {
        return String.format("[%d] %s %s (%s)", idApprenant, nom, prenom, classe);
    }
}