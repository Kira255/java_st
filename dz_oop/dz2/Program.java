package dz_oop.dz2;

import dz_oop.dz2.Animals.Classes.Animals;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Animals[] animals = {};
        boolean contr = true;
        while (contr) {
            System.out.println(
                    "Welcome to the zoo to add new animals to the zoo enter: 1 to remove animals from the zoo enter: 2 to print information about a specific animal (by entering its number) enter: 3 to print information about all animals in the zoo at the moment enter: 4 to make an animal make a sound (by entering the number of the animal) enter: 5 to make all the animals that are currently in the zoo make a sound) enter: 6.");
            int control = scan.nextInt();
            switch (control) {
                case 1:
                    System.out.println(
                            "To add a cat enter: 1 to add a dog enter: 2 to add a tiger enter: 3 to add a wolf enter: 4 to add aitsa enter: 5 to add a chicken enter: 6.");
                    int index = scan.nextInt();
                    switch (index) {
                        case 1:
                            animals = Zoo.addCat(animals);
                            break;
                        case 2:
                            animals = Zoo.addDog(animals);
                            break;
                        case 3:
                            animals = Zoo.addTiger(animals);
                            break;
                        case 4:
                            animals = Zoo.addWolf(animals);
                            break;
                        case 5:
                            animals = Zoo.addStork(animals);
                            break;
                        case 6:
                            animals = Zoo.addChiken(animals);
                            break;
                        default:
                            break;
                    }
                    continue;
                case 2:
                    System.out.println("Введите индекс: ");
                    int index1 = scan.nextInt();
                    animals = Zoo.removeIndex(animals, index1);
                    continue;
                case 3:
                    System.out.println("Введите индекс: ");
                    int index2 = scan.nextInt();
                    animals = Zoo.getIndex(animals, index2);
                    continue;
                case 4:
                    System.out.println("Введите индекс: ");
                    int index3 = scan.nextInt();
                    animals = Zoo.getIndexSound(animals, index3);
                    continue;
                case 5:
                    animals = Zoo.printAll(animals);
                    continue;
                case 6:
                    animals = Zoo.getAllSound(animals);
                    continue;
                default:
                    contr = false;
            }
        }
    }
}
