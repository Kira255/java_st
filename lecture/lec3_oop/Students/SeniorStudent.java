package lec3_oop.Students;

import lec3_oop.Interfaces.Love;
import lec3_oop.Interfaces.Smoke;
import lec3_oop.Students.Base.Student;

public class SeniorStudent extends Student implements Smoke, Love {

    private boolean isSmoke = false;

    public SeniorStudent(String name, String lastName, int grade) {
        super(name, lastName, grade);
    }

    public SeniorStudent() {
        super("Михаил", "Зорин", 10);
    }

    @Override
    public void study() {
        System.out.println("Я должен учиться");
    }

    @Override
    public void smoking() {
        if (isSmoke)
            System.out.println("Я бросаю курить");
        else
            System.out.println("Я не курю");
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

    @Override
    public void loving() {
        System.out.println("Я ищу пару");
    }
}
