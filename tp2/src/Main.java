import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       Scanner scanner=new Scanner(System.in);
       System.out.println("Entrez le nombre=");
       int nombre=
                scanner.nextInt();
      if (nombre % 2==0){
           System.out.println("le nombre est pair");
                }else {
          System.out.println("le nombre est impair");
      }
           scanner.close();
    }
}

//
