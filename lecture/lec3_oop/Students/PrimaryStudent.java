package lec3_oop.Students;

import lec3_oop.Interfaces.AffterShcool;
import lec3_oop.Interfaces.Play;
import lec3_oop.Students.Base.Student;

public class PrimaryStudent extends Student implements AffterShcool, Play {

    public PrimaryStudent(String name, String lastName, int grade) {
        super(name, lastName, grade);
    }

    public PrimaryStudent() {
        super("Иван", "Иванов", 3);
    }

    @Override
    public void study() {
        System.out.println("Я люблю учиться");
    }

    @Override
    public void affterShcool() {
        System.out.println("Я хожу в продленку");
    }

    @Override
    public void playing() {
        System.out.println("Я играю в игрушки");
    }

}
