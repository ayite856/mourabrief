import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Entrez un nombre :");
        double nombre =scanner.nextDouble();
        double moitie=nombre/2;
        System.out.println("la moitie de"+"est:"+moitie);
        scanner.close();
    }
}