package demo;

import java.util.Comparator;

public class BubleSorterImple <T>implements Sorter<T> {
    @Override
    public void sort(T[] arr, Comparator<T> c) {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 1; j < arr.length-i; j++) {
                if (c.compare(arr[j - 1], arr[j]) > 0) {
                    //swap elements
                    T temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
