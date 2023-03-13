package dz_oop.dz2.Animals.Interfaces;

public interface Sound {

    default void getSound() {
        System.out.println("- - -");
    }
}
