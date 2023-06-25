import java.util.Random;

public class CreateArray {
    public int[] generateArray() {
        Random random = new Random();
        int[] arr = new int[random.nextInt(2) + 4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
        return arr;
    }
}
