import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String motdepasse = "java2026";
        String saisie;
        do {
            System.out.println(" Entrez le mot de passe : ");
            saisie = scanner.nextLine();
            if (!saisie.equals(motdepasse)) {
                System.out.println("incorrect.Reesayer");
            }
        } while (!saisie.equals(motdepasse)) ;
        System.out.println("mot de passe correct");
        scanner.close();
    }
}