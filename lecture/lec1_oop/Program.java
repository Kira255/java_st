package lec1_oop;

public class Program {
    public static void main(String[] args) {

        Transport auto = new Auto();
        Transport moto = new Moto();
        Transport truck = new Truck();
        Transport bike = new Bike();

        demo(auto);
        demo(moto);
        demo(truck);
        demo(bike);
    }

    public static void demo(Transport o) {
        System.out.println(o);
        o.move();
        o.stop();
        System.out.println("- - - - - - - - - - - - - - -");
    }

}
