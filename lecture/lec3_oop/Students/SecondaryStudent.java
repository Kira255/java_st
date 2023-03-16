package lec3_oop.Students;

import lec3_oop.Interfaces.Play;
import lec3_oop.Interfaces.Smoke;
import lec3_oop.Students.Base.Student;

public class SecondaryStudent extends Student implements Play, Smoke {

    private boolean isSmoke = false;

    public SecondaryStudent(String name, String lastName, int grade) {
        super(name, lastName, grade);
    }

    public SecondaryStudent() {
        super("Петр", "Петров", 7);
    }

    @Override
    public void study() {
        System.out.println("Я ненавижу учиться");
    }

    @Override
    public void smoking() {
        if (isSmoke)
            System.out.println("Я начинаю курить");
        else
            System.out.println("Я не курю");
    }

    @Override
    public void playing() {
        System.out.println("Я играю в танчики");
    }

    @Override
    public void startSmoking() {
        this.isSmoke = true;
        System.out.println("Я умею курить");
    }

    @Override
    public void stopSmoking() {
        this.isSmoke = false;
        System.out.println("Я бросил курить");
    }
}
