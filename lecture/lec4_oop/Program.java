package lecture.lec4_oop;

public class Program {
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(JSONConvert.convert(cat));
        System.out.println(JSONConvert.convert(5));
        System.out.println(JSONConvert.convert("cat"));
        System.out.println(JSONConvert.convert(null));
    }

}
