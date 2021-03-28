package demo;

import java.util.Comparator;

public class HeapSorterImple <T> implements  Sorter <T>{
    T temp;
    @Override
    public void sort(T[] arr, Comparator<T> c)
    {
        int size = arr.length;
        int i;
        for (i = size / 2 - 1; i >= 0; i--)
            heapify(arr, size, i, c);
        for (i=size-1; i>=0; i--)
        {
            temp = arr[0];
            arr[0]= arr[i];
            arr[i] = temp;
            heapify(arr, i, 0, c);
        }
    }

    void heapify(T[] arr, int size, int i, Comparator<T> c)
    {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < size && c.compare(arr[left], arr[largest]) > 0 )
            largest = left;

        if (right < size && c.compare(arr[right], arr[largest]) > 0)
            largest = right;

        if (largest != i)
        {
            temp = arr[i];
            arr[i]= arr[largest];
            arr[largest] = temp;
            heapify(arr, size, largest, c);
        }
    }
}
