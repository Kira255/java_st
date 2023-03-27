package lecture.lec4_oop;

public class Cat {

    private String name;
    private Integer age;
    private String color;
    private Integer weight;
    private Integer height;

    public Cat(
            String name, Integer age,
            String color, Integer weight,
            Integer height) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;
        this.height = height;
    }

    public Cat() {
        this("Barsik", 5, "Brown", 7, 20);
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getHeight() {
        return height;
    }
}