package dz_oop.dz2.Animals.Interfaces;

public interface Pet extends Sound {
    default void getWeasel() {
        System.out.println("- - -");
    }
}
