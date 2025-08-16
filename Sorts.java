//Ameer Hassan
// CS 114 Section 021 
// Proffesor Johnathan Kapleau 

public class Sorts {

    //Implentation of heapSort 
    public static <T extends Comparable<? super T>> void heapSort(T[] array) {
        int size = array.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, size, i);
        }
        for (int i = size - 1; i > 0; i--) {
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    //private method of heapsort 
    private static <T extends Comparable<? super T>> void heapify(T[] array, int size, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
    
        if (left < size && array[left].compareTo(array[largest]) > 0) {
            largest = left;
        }
        if (right < size && array[right].compareTo(array[largest]) > 0) {
            largest = right;
        }
        if (largest != index) {
            T temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;
    
            heapify(array, size, largest);
        }
    }
    

    //Given Methods 
    public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
        T temp;
        boolean sorted;
        for (int i = array.length - 1; i > 0; --i) {
            sorted = true;
            for (int j = 0; j < i; ++j) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    sorted = false;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (sorted) break;
        }
    }

    public static <T extends Comparable<? super T>> void insertSort(T[] array) {
        for (int i = 1; i < array.length; ++i) {
            T temp = array[i];
            int j;
            for (j = i; j > 0 && temp.compareTo(array[j - 1]) < 0; --j) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }

    public static <T extends Comparable<? super T>> void selectSort(T[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] array) {
        if (array.length <= 1) return;
        T[] temp = array.clone();
        mergeSortHelper(array, temp, 0, array.length - 1);
    }

    private static <T extends Comparable<? super T>> void mergeSortHelper(T[] array, T[] temp, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSortHelper(array, temp, left, mid);
        mergeSortHelper(array, temp, mid + 1, right);
        merge(array, temp, left, mid, right);
    }

    private static <T extends Comparable<? super T>> void merge(T[] array, T[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (temp[i].compareTo(temp[j]) <= 0) {
                array[k++] = temp[i++];
            } else {
                array[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            array[k++] = temp[i++];
        }
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private static <T extends Comparable<? super T>> void quickSortHelper(T[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSortHelper(array, low, pi - 1);
            quickSortHelper(array, pi + 1, high);
        }
    }

    private static <T extends Comparable<? super T>> int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}