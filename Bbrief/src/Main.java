//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
  Scanner scanner=new Scanner(System.in);
  ArrayList<Animals> animals=new ArrayList<Animals>();
  int choice;

  animals.add(
//          le chemin ici sera different selon chaque orddinateur
          new Animals ("Loulou","Chien", "C:\\Users\\ADN\\IdeaProjects\\Bbrief\\src\\dog.wav")
  );

  animals.add(
//          le chemin ici sera different selon chaque ordinateur
          new Animals("Micha","Chat","C:\\Users\\ADN\\IdeaProjects\\Bbrief\\src\\cat.wav")
  );
    System.out.println("Welcome dans notre ZOO");
    System.out.println("==================================================");
    for (int i=0; i<animals.size(); i++) {
        System.out.println((i+1)+"-"+animals.get(i).getType());
    }
    System.out.println("===================================================");
    System.out.println("le cri de quel animal aimeriez-vous entendre?");

    try {
        choice=scanner.nextInt();
        if (choice<1 || choice> animals.size()) {
            System.out.println("Choix invalide");
        }else {
            animals.get(choice -1).scream();
        }
    }catch (Exception e) {
        System.out.println("Choix invalide");
    }
}
