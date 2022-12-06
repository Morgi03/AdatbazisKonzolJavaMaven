package hu.petrik.adatbaziskonzolos;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            DogDB dogDB = new DogDB();
            List<Dog> dogs = dogDB.getDogs();
            for (Dog dog : dogs) {
                System.out.println(dog);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
