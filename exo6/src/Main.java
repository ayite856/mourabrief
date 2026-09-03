import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Entrez le premier nombre :");
        double nombre1= scanner.nextDouble();
        System.out.println("Entrez la deuxieme nombre:");
        double nombre2= scanner.nextDouble();
        System.out.println("Entrez la troisieme nombre:");
        double nombre3= scanner.nextDouble();
        double moyenne=(nombre1+nombre2+nombre3)/3;
        System.out.println("la moyenne est :"+moyenne);
        scanner.close();
    }
}