import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int num = args.length == 1 ? Integer.parseInt(args[0]) : 10_000_000;
        Integer[] array = new Integer[num];
        Random rand;
        long start, stop;

        rand = new Random(1);
        for (int i = 0; i < array.length; ++i) {
            array[i] = rand.nextInt(num);
        }
        start = System.currentTimeMillis();
        Sorts.heapSort(array);
        stop = System.currentTimeMillis();
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] > array[i+1]) {
                System.out.println("heap fail");
                System.exit(0);
            }
        }
        System.out.println("heap pass: " + (stop - start));
    }
}



    /*
    // Commented out other sorts since we're only testing heapSort
    public static <T extends Comparable<? super T>> void bubbleSort(T[] array) { }
    public static <T extends Comparable<? super T>> void insertSort(T[] array) { }
    public static <T extends Comparable<? super T>> void mergeSort(T[] array) { }
    public static <T extends Comparable<? super T>> void quickSort(T[] array) { }
    public static <T extends Comparable<? super T>> void selectSort(T[] array) { }
    */

