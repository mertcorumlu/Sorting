package sorting;


import java.util.Arrays;
import java.util.Random;

public class Main <T extends Comparable<T>>{

    public void selectionSort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int curr = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j].compareTo(array[curr]) < 0)
                    curr = j;
            swap(array, i, curr);
        }
    }

    public void insertionSort(T[] array) {

        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j].compareTo(array[j + 1]) > 0)
                    swap(array, j, j+1);
                else break;

            }
        }

    }

    public void mergeSort(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(T[] array, int l, int r) {

        if (l >= r) return; // exit condition;

        int mid = (l + r) >>> 1;


        mergeSort(array, l, mid);
        mergeSort(array, mid + 1, r);


        Object[] buffer = new Object[r - l + 1];

        for (int i = l, j = mid + 1, count = 0; i <= mid || j <= r; i++, j++, count++) {

            if (i <= mid && j <= r) {

                if (array[i].compareTo(array[j]) < 0) {
                    buffer[count] = array[i];
                    --j;
                } else {
                    buffer[count] = array[j];
                    --i;
                }

            } else if (i <= mid)
                buffer[count] = array[i];
            else if (j <= r)
                buffer[count] = array[j];
        }


        for (int i = 0; i < buffer.length ; i++)
            array[i + l] = (T) buffer[i];
    }


    public void quickSort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(T[] array, int l, int r) {

        if (l >= r) return; // Exit condition

        T pivot = array[new Random().nextInt(r - l + 1)];

        int low = l;
        int high = r;

        while (low < high) {
            while (array[low].compareTo(pivot) < 0) ++low;
            while (array[high].compareTo(pivot) > 0) --high;

            if (low < high)
                swap(array, low, high);
        }


        quickSort(array, l, low - 1);
        quickSort(array, low + 1, r);

    }


    private void swap(T[] array, int a, int b) {
        T tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }


    public static void main(String[] args) {
        Main<Integer> a = new Main<>();

        Integer[] b = {5,4,3,2,1};
        a.quickSort(b);

        System.out.println(Arrays.toString(b));
    }
}
