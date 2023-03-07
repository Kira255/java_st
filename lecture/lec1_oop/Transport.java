/*
 реализовать следующий набор классов, при этом должна быть выделена их иерархия:
	2.1.Транспортное средство
	2.2.Автомобиль
	2.3.Мотоцикл
	2.4.Грузовик
	2.5.Велосипед
Во всех классах должны быть написаны: цвет, модель, количество колёс, вес и скорость а так же метод ехать.
В классе Program реализовать метод который будет работать с любым наследником класса ровно так же как и с родителем, то есть показать значение всех его публичных свойств и вызвать метод ехать.
*/
package lec1_oop;

public class Transport {
    enum State {
        On, Off
    }

    private State state;

    private String color;
    private String model;
    private Integer wheels;
    private Integer weight;
    private Integer speed;

    public Transport(String color, String model, Integer wheels, Integer weight, Integer speed) {
        this.color = color;
        this.model = model;
        this.wheels = wheels;
        this.weight = weight;
        this.speed = speed;
        this.state = State.Off;
    }

    @Override
    public String toString() {
        return String.format("Color: %s, Model: %s, Wheels: %d, Weight: %d, Speed: %d", this.color, this.model,
                this.wheels, this.weight, this.speed);
    }

    public String getColor() {
        return this.color;
    }

    public String getModel() {
        return this.model;
    }

    public Integer getWheels() {
        return this.wheels;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public Integer getSpeed() {
        return this.speed;
    }

    public void setValues(String color, String model, Integer wheels, Integer weight, Integer speed) {
        this.color = color;
        this.model = model;
        this.wheels = wheels;
        this.weight = weight;
        this.speed = speed;
    }

    public void move() {
        if (this.state == State.Off) {
            System.out.println("GO");
            this.state = State.On;
        }
    }

    public void stop() {
        if (this.state != State.Off) {
            System.out.println("STOP");
            this.state = State.Off;
        }
    }
}