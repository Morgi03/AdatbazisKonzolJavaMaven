package hu.petrik.adatbaziskonzolos;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
   static DogDB dogDB;
    public static void main(String[] args) {
        try {
            dogDB = new DogDB();
           readDogsFromConsole();
            listDogs();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void listDogs() throws SQLException {
        List<Dog> dogs = dogDB.getDogs();
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
        System.out.println();
    }

    private static void readDogsFromConsole() {
        System.out.print("Adja meg, hogy hány kutyát szeretne felvenni: ");
        Scanner sc = new Scanner(System.in);
        try {
            int count = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < count; i++) {
                System.out.print("Adja meg a kutya nevét: ");
                String name = sc.nextLine();
                System.out.print("Adja meg a kutya életkorát: ");
                int age = Integer.parseInt(sc.nextLine());
                System.out.print("Adja meg a kutya fajtáját: ");
                String breed = sc.nextLine();
                Dog dog = new Dog(name, age, breed);
                dogDB.createDog(dog);
            }
        } catch (NumberFormatException e) {
            System.out.println("Nem számot adott meg a felvétel megszakad!");
        } catch (SQLException e) {
            System.out.println("Hiba történt a kutya felvétele során: ");
            e.printStackTrace(System.out);
        }
    }
}
