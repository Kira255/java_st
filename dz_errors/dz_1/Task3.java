public class Task3 {
    public static void main(String[] args) {
        task3();
    }

    static void task3() {
        try {
            int[] arr1 = new CreateArray().generateArray();
            int[] arr2 = new CreateArray().generateArray();
            int[] result = new WorkArray().arraysDiv(arr1, arr2);
            for (int a1 : arr1)
                System.out.printf("%d\t", a1);
            System.out.println();
            for (int a2 : arr2)
                System.out.printf("%d\t", a2);
            System.out.println();
            System.out.println("Частное элементов:");
            for (int i : result)
                System.out.printf("%d\t", i);
        } catch (WorkArray.CustomArraySizeException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
            System.out.printf(
                    "Длина первого массива: %d\nДлина второго массива: %d\n",
                    e.getLength1(), e.getLength2());
        } catch (WorkArray.CustomDivideException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
            System.out.printf("Элемент с индексом %d равен нулю", e.getElement());
        }
    }
}
