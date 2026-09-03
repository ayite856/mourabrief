import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Entrez votre age");
        int age=scanner.nextInt();
        if (age<13) {
            System.out.println("vous etes enfant");
        } else if (age>=13&& age<18) {
            System.out.println("vous etes un ado");
        }else {
            System.out.println("vous etes grand");
        }
        scanner.close();
    }
}







