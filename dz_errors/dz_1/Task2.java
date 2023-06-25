public class Task2 {
    public static void main(String[] args) {
        task2();
    }

    static void task2() {
        try {
            int[] arr1 = new CreateArray().generateArray();
            int[] arr2 = new CreateArray().generateArray();
            int[] result = new WorkArray().difference(arr1, arr2);
            for (int a1 : arr1)
                System.out.printf("%d\t", a1);
            System.out.println();
            for (int a2 : arr2)
                System.out.printf("%d\t", a2);
            System.out.println();
            System.out.println("Разница:");
            for (int i : result)
                System.out.printf("%d\t", i);
        } catch (WorkArray.CustomArraySizeException e) {
            System.out.println(e.getMessage());
            System.out.printf(
                    "Длина первого массива: %d\nДлина второго массива: %d\n",
                    e.getLength1(), e.getLength2());
        }
    }
}
