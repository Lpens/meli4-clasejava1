package demo;

public class SortUtil {
    public static <T extends Precedable> void ordenar(T arr[]) {
        int n = arr.length;
        T temp = null;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1].precedeA(arr[j]) > 0) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
