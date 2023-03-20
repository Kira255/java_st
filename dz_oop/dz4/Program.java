package dz_oop.dz4;

public class Program {
    public static void main(String[] args) {
        Simple<Integer> str = new SimpleArray<Integer>();
        str.add(1);
        str.add(2);
        str.add(3);
        str.add(4);
        str.add(5);
        str.display();
        System.out.println();
        str.delete(1);
        str.display();
        System.out.println();
        str.deletePos(3);
        str.display();
        System.out.println();
        System.out.println(str.inArray(3));
        System.out.println();
        System.out.println(str.get(0));
        System.out.println();
        str.update(0, 10);
        System.out.println();
        str.display();
        System.out.println();
        System.out.println(str.size());
        System.out.println(str.sum());
        System.out.println(str.mul());
    }
}
