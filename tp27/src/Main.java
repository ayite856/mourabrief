import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("entrez le mot de passe");
        String abc = "234";
        String motdepasse;
        motdepasse=scanner.nextLine();
        while (!motdepasse.equals(abc)) {
            System.out.println("incroyable");
            motdepasse = scanner.nextLine();
        }
        if (motdepasse.equals(abc)){
            System.out.println("bravo");
        }
        scanner.close();
    }
}