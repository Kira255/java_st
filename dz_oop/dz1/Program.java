package dz_oop.dz1;

public class Program {
    public static void main(String[] args) {

        Food eggs = new Eggs();
        Food breads = new Bread();
        Drinkables lemonades = new Lemonade();
        Drinkables milks = new Milk();
        Hygiene masks = new Masks();
        Hygiene toiletPaper = new toiletPaper();
        childenProd pacifier = new Pacifier();
        childenProd dipers = new Diapers();

        demo(eggs);
        demo(breads);
        demo(lemonades);
        demo(milks);
        demo(masks);
        demo(toiletPaper);
        demo(pacifier);
        demo(dipers);
    }

    public static void demo(Products o) {
        System.out.println(o);
    }
}
