package lec3_oop.Students.Base;

public abstract class Student implements Comparable<Student> {
    private String name;
    private String lastName;
    private int grade;

    public Student(String name, String lastName, int grade) {
        this.name = name;
        this.lastName = lastName;
        this.grade = grade;
    }

    public abstract void study();

    @Override
    public String toString() {
        return String.format("%s\nИмя: %s\nФамилия: %s\nКласс: %d", this.getClass().getSimpleName(), this.name,
                this.lastName, this.grade);
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Student o) {
        return this.grade - o.grade;
    }
}
