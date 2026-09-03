import java.util.Scanner;

      class LIVRE {
          String titre;
                  String auteur;
                   int anneePublication;
                  String categorie;
                  int exemplairesDisponibles;
      }

      void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          System.out.println(System.in);
          final int MAX = 10;
          String[] titre = {
                  "Java Debutant",
                  "le petit prince",
                  "l'Alchimiste",
                  "Candide",
                  "notre-dame de Paris",
                  "les Miserables",
                  "le Rouge et le Noir",
                  "une si longue lettre",
                  "le pere Goriot",
                  "bel-ami"};
          String[] auteur = {
                  "Pierre dupont",
                  "Antoine de saint-Euxpery",
                  "Paulo coelho",
                  "voltaire",
                  "Victor Hugo",
                  "Victor Hugo",
                  "Stendhal1",
                  "Mariama Ba",
                  "Honore de Balzac",
                  "Guy de Maupassent"
          };
          int[] annee = {
                  2024,
                  1943,
                  1988,
                  1759,
                  1831,
                  1831,
                  1862,
                  1979,
                  1547,
                  1885
          };
          String[] categorie = {
                  "Informatique",
                  "Roman",
                  "Philosophie",
                  "Roman",
                  "Roman",
                  "Roman",
                  "Roman",
                  "Roman",
                  "Roman",
                  "Roman"
          };
          int[] exemplaires = {
                  5,
                  2,
                  4,
                  6,
                  2,
                  1,
                  3,
                  7,
                  4,
                  8
          };
          int nombreLivre = 10;
          int choix;
          do {
              System.out.println("entrez le nombre de livres a enregistrer(maximun 10):");
             nombreLivre=scanner.nextInt();
             if (nombreLivre<1||nombreLivre>10){
                 System.out.println("erreur !vous devez saisir un nombre compris entre 1 et 10");
             }
          }while (nombreLivre<1||nombreLivre>10);
          scanner.nextLine();
          String[]titres=new String[10];
          String[]auteurs=new String[10];
          int[]annees=new int[10];
          String[] categories=new String[10];
          int[]exmplaires=new int[10];
          for (int i=0;i<nombreLivre;i++){
                         System.out.println("\nlivre"+(i+1));                          System.out.println("titre:");
                         titre[i]=scanner.nextLine();
                         System.out.println("Auteur:");
                         auteur[i]=scanner.nextLine();
                          System.out.println("Annee:");
                          annee[i]=scanner.nextInt();scanner.nextLine();
                        System.out.println("Categorie:");
                          categorie[i]=scanner.nextLine();
                         System.out.println("Nombre d'exmplaires:");
                          exemplaires[i]=scanner.nextInt();
                     }
                      nombreLivre=MAX;
                      System.out.println("les nombre de livres ont ete enregistrer.");


          do {
              System.out.println("\n=====Gestion de BIBLIOTHEQUE=====");
              System.out.println("1. Enregistrer les livres");
              System.out.println("2.Rechercher un livre");
              System.out.println("3.Emprunter un livre");
              System.out.println("4.Retourner un livre");
              System.out.println("5.Afficher les statistiques");
              System.out.println("6.Afficher tous les livres");
              System.out.println("7.Quitter");

              System.out.println("votre choix:");
              choix = scanner.nextInt();
              scanner.nextLine();
              switch (choix) {
                  case 1:
                      System.out.println("\n======================================");
                      System.out.println("   Listes des livres                    ");
                      System.out.println("==========================================");

//                     for (int i=0;i<MAX;i++){
//                         System.out.println("\nlivre"+(i+1));                          System.out.println("titre:");
//                         titre[i]=scanner.nextLine();
//                         System.out.println("Auteur:");
//                         auteur[i]=scanner.nextLine();
//                          System.out.println("Annee:");
//                          annee[i]=scanner.nextInt();scanner.nextLine();
//                        System.out.println("Categorie:");
//                          categorie[i]=scanner.nextLine();
//                         System.out.println("Nombre d'exmplaires:");
//                          exemplaires[i]=scanner.nextInt();
//                     }
//                      nombreLivre=MAX;
//                      System.out.println("les 10 livres ont ete enregistrer.");
//                      break;
                  case 2:
                      if (nombreLivre==0){
                          System.out.println("Aucun livre enregistrer.");
                          break;
                      }
                      System.out.println("titre a rechercher:");
                      String rechercher=scanner.nextLine();
                      boolean trouve=false;
                      for (int i=0;i<nombreLivre;i++){
                          if (titre[i].equalsIgnoreCase(rechercher)){
                              System.out.println("\nlivre trouve");
                              System.out.println("titre:"+titre[i]);
                              System.out.println("auteur:"+auteur[i]);
                              System.out.println("annee:"+annee[i]);
                              System.out.println("categorie:"+categorie[i]);
                              System.out.println("exemplaire:"+exemplaires[i]);
                              trouve=true;
                              break;
                                        }
                                  }
                      if (!trouve) System.out.println("livre introuvable.");
                      break;
                  case 3:
                      String[]emprunteur={

                      };
                      System.out.println("entrez votre nom:");
                      String nom=scanner.nextLine();
                      boolean autorise =true;
                      for (int i=0;i<emprunteur.length;i++){
                          if (emprunteur[i].equalsIgnoreCase(nom)){
                              autorise=true;
                              break;
                          }
                      }
                      if (autorise){
                          System.out.println("nom verifie.vous pouvez emprunter un livre:");
                          System.out.println("entrez le titre du livre:");
                          String ti=scanner.nextLine();
                      }else {
                          System.out.println("nom non reconnu.emprunt refuse");
                      }
                  case 4:
                      System.out.println("titre du livre a retourner:");
                      String ret=scanner.nextLine();
                      boolean retour=false;
                      for (int i=0;i<nombreLivre;i++){
                          if (titre[i].equalsIgnoreCase(ret)){
                              exemplaires[i]++;
                              retour=true;
                              break;
                          }
                      }
                      System.out.println("retour effectue avec succes.");
                      break;
                  case 5:
                      int total=0;
                      for (int i =0;i<nombreLivre;i++){
                          total +=exemplaires[i];
                      }
                      System.out.println("nombre de livres enregistres:"+nombreLivre);
                      System.out.println("nombre total d'exmplaires:"+total);
                      break;
                  case 6:
                      System.out.println("========================================================================================");
                      System.out.println("     LA BIBLIOTHEQUE :  Lire c'est voyager sans bouger                                                                                    ");
                      System.out.println("========================================================================================");
                      System.out.println("Livres               Auteurs                    Annees        Categories    Exemplaires");
                      System.out.println("========================================================================================");
                      System.out.println(" Java Debutant         Pierre Dupont             2024       informatique        5     ");
                      System.out.println(" le petit prince       Antoine de saint-Euxpery   1943       Roman              2              ");
                      System.out.println(" L'Alchimiste          Paulo Coelho                198        Roman             4    ");
                      System.out.println(" Candide                Voltaire                    1759      Philosophie        6   ");
                      System.out.println(" Notre-dame de paris     Victor Hugo                  1831      Roman            2   ");
                      System.out.println(" les Miserables          Victor  Hugo                  1831     Roman           1    ");
                      System.out.println("  Le rouge et le noir      Stendhal                     1862     Roman           3    ");
                      System.out.println("  une si longue lettre     Mariama Ba                   1979     Roman           7   ");
                      System.out.println(" le pere Goriot            Honore de Blazac               1547    Roman           4   ");
                      System.out.println(" Bel-Ami                  Guy de Maupassant                1885   Roman          8   ");
                      System.out.println("=======================================================================================");
                      System.out.println("            Chaque livre que tu lis devient une partie de toi.                                                        ");
                      System.out.println("========================================================================================");
//
                      break;
                  case 7:
                      System.out.println("Merci d'avoir utiliser le programme.");
                      break;
                  default:
                      System.out.println("choix invalide");
                  }
              }while (choix!=7);
          }
