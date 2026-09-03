//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner scanner=new Scanner(System.in);
    final int MAX=150;
    int nombreLivres;
    do {
        System.out.println("combien de livres voulez-vous enregistrez(maximum 150):");
        nombreLivres=scanner.nextInt();
        scanner.nextLine();
        if (nombreLivres<1||nombreLivres>MAX){
            System.out.println("erreur !le nombre doit etre compris entre 1 et 150.");
        }
    }while (nombreLivres<1||nombreLivres>MAX);
    String[]titres=new String[MAX];
    String[]auteurs=new String[MAX];
    int[]annees=new int[MAX];
    String[]categories=new String[MAX];
    int[]exemplaires=new int[MAX];


    for (int i=0; i<nombreLivres;i++) {
        System.out.println("\n==================Livre" +(i+ 1)+
                "====================");
        System.out.println("titre  :");
        titres[i]=scanner.nextLine();
        System.out.println("auteur: ");
        auteurs[i]=scanner.nextLine();
        System.out.println("annee de publication :");
        annees[i]=scanner.nextInt();
        scanner.nextLine();
        System.out.println("categories: ");
        categories[i]=scanner.nextLine();

        System.out.println("nombre d'exemplaires: ");
        exemplaires[i]=scanner.nextInt();
        scanner.nextLine();
    }
    System.out.println("\n================listes des livres========================");
    System.out.printf("%-5s %-25s %-20s %-10s %-15s %-12s%n",
            "N","titre","auteur","annee","categorie","exemplaires");
    System.out.println("============================================================");
    for (int i=0;i<nombreLivres;i++){
        System.out.printf("%-5d %-25s %-20s %-10d %-15s %-12d%n",
                (i+ 1),
                titres[i],
                auteurs[i],
                annees[i],
                categories[i],
                exemplaires[i]);
    }
    int choix;
    do {
        System.out.println("=================================================================");
        System.out.println("       LA BIBLIOTHEQUE LE MONDE EST UN LIVRES                                                           ");
        System.out.println("\n======================MENUN PRINCIPAL===========================");
        System.out.println("1. Afficher les livres");
        System.out.println("2.rechercher un livre");
        System.out.println("3.emprunter un livre");
        System.out.println("4.retourner un livre");
        System.out.println("5.afficher les statistiques");
        System.out.println("6.quitter");
        System.out.println("votre choix: ");
        System.out.println("===================================================================");
        System.out.println("  la lecture,une bonne facon de s'enrichir sans voler personne    ");
        System.out.println("===================================================================");
        choix = scanner.nextInt();
        scanner.nextLine();


        switch (choix) {
            case 1:
//                System.out.println("afficher les livres");
                System.out.printf("%-5s %-25s %-20s %-10s %-15s %-12s%n",
                        "N", "titre", "auteur", "annee", "categorie", "exemplaires");
                for (int i = 0; i < nombreLivres; i++) {
                    System.out.printf("%-5d %-25s %-20s %-10d %-15s %-12d%n",
                            (i + 1),
                            titres[i],
                            auteurs[i],
                            annees[i],
                            categories[i],
                            exemplaires[i]);
                }
                break;


            case 2:
                System.out.println("entrez le titre du livre:");
                String recherche=scanner.nextLine();
                boolean trouve=false;
                for (int i=0; i<nombreLivres;i++){
                    if (titres[i].equalsIgnoreCase(recherche)){
                        System.out.println("\n======LIVRE TROUVER======");
                        System.out.println("titre  :"+titres[i]);

                        System.out.println("auteur: "+auteurs[i]);

                        System.out.println("annee de publication :"+annees[i]);

                        System.out.println("categories: "+categories[i]);

                        System.out.println("nombre d'exemplaires: "+exemplaires[i]);
                        trouve=true;
                        break;
                    }
                }
                if (!trouve){
                    System.out.println("error ce livre n'hesite pas ici!");
                }
                break;


            case 3:
                System.out.println("entrez votre nom:");
                String nomemprunteur=scanner.nextLine();
                System.out.println("entrez le titre du livre a emprunter:");
                String titrerecherche=scanner.nextLine();
                boolean trouveemprunt=false;
                for (int i=0; i<nombreLivres;i++){
                    if (titres[i].equalsIgnoreCase(titrerecherche)){
                        trouveemprunt=true;
                        if (exemplaires[i]>0){
                            exemplaires[i]--;
                            System.out.println("\nemprunt effectuer avec succes!");
                            System.out.println("nom de l'emprunteur:"+nomemprunteur);
                            System.out.println("titre:"+titres[i]);
                            System.out.println("emplaires restants:"+exemplaires[i]);
                        }else {
                            System.out.println("impossible d'emprunter ce livre,aucun exmplaire disponible");
                        }
                        break;
                    }
                }
                if (!trouveemprunt){
                    System.out.println("livre introuvable!");
                }
                break;


            case 4:
                System.out.println("entrez le titre du livre a retourner:");
                String titreretour=scanner.nextLine();
                boolean trouveretour=false;
                for (int i=0; i<nombreLivres;i++){
                    if
                    (titres[i].equalsIgnoreCase(titreretour)){
                        trouveretour=true;
                        exemplaires[i]--;

                            System.out.println("\nretour effectuer avec succes!");
                            System.out.println("titre:"+titres[i]);
                            System.out.println("nombre d'exemplaires disponibles:"+exemplaires[i]);
                            break;
                    }
                    if (!trouveretour){
                        System.out.println("livre retourner n est pas excat!");
                }
                    break;

                }


            case 5:
                int totalexemplaires=0;
                int livresdisponibles=0;
                int livresemprunter=0;
                for (int i =0;i<nombreLivres; i++){
                    totalexemplaires+=exemplaires[i];
                    if (exemplaires[i]>0){
                        livresdisponibles++;
                    }else {
                        livresemprunter++;
                    }
                }
                System.out.println("\n==========STATISTIQUES=================");
                System.out.println("nombre total de livres enregistrees:"+nombreLivres);
                System.out.println("nombre total d'exemplaires:"+totalexemplaires);
                System.out.println("nombre de livres actuellement disponibles"+livresdisponibles);
                System.out.println("nombre de livres complement empruntees:"+livresemprunter);
                break;


            case 6:
                System.out.println("Merci d'avoir utiliser le programme.");
                break;
            default:
                System.out.println("choix invalide!");
        }
    } while (choix!=6);
   scanner.close();
}