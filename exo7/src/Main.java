import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Entrez le premier nombre:");
        int nombre1 =scanner.nextInt();
        System.out.println("Entrez le deuxieme nombre:");
        int nombre2 =scanner.nextInt();
        if (nombre1>nombre2){
            System.out.println("le plus grand nombre est:"+nombre2);
        }
        else {
            System.out.println("le plus grand nombre sont egaux.");
        }
        scanner.close();
    }
}