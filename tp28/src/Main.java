import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random random= new Random();
        int codeSecret =random.nextInt();
        int proposition;
        System.out.println("deviner le nbre(entre 1et 10):");
        proposition= scanner.nextInt();
        if (proposition==codeSecret) {
            System.out.println("bravo");
        } else {
            System.out.println("dommage:"+codeSecret);
        }
        scanner.close();
    }
}