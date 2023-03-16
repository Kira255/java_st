package lec3_oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lec3_oop.Interfaces.AffterShcool;
import lec3_oop.Interfaces.Love;
import lec3_oop.Interfaces.Play;
import lec3_oop.Interfaces.Smoke;
import lec3_oop.Students.PrimaryStudent;
import lec3_oop.Students.SecondaryStudent;
import lec3_oop.Students.SeniorStudent;
import lec3_oop.Students.Base.Student;

public class Program {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new SeniorStudent());
        students.add(new SecondaryStudent());
        students.add(new PrimaryStudent());
        Collections.sort(students);
        for (Student student : students) {
            demo(student);
            System.out.println("-------------------");
        }
        students.get(0).compareTo(students.get(1));
    }

    public static void demo(Student obj) {
        System.out.println(obj);
        obj.study();
        if (obj instanceof Play) {
            ((Play) obj).playing();
        }
        if (obj instanceof Smoke) {
            ((Smoke) obj).startSmoking();
            ((Smoke) obj).smoking();
            ((Smoke) obj).stopSmoking();
        }
        if (obj instanceof Love) {
            ((Love) obj).loving();
        }
        if (obj instanceof AffterShcool) {
            ((AffterShcool) obj).affterShcool();
        }
    }
}
