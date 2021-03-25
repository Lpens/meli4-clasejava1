package demo;

import java.io.FileNotFoundException;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    Integer[] arr = new Integer[10000];
	    Timer t = new Timer();
	    for (int i = 0; i < 10000; i++)
        {
            arr[i] = 10000-i;
        }
	    Sorter s = (Sorter) MiFactory.getInstance("quick");

        String[] sArr = {"lala", "lulu", "lili", "lele","lolo"};
        Comparator <String> c2 = (a,b)->a.compareTo(b);
        t.start();
        s.sort(sArr,c2);
        t.pause();
        imprimirTiempo(t);
        for (String word : sArr)
        {
            System.out.println(word);
        }





        Comparator<Integer> c = (a,b)-> a.compareTo(b);
        t.start();
	    s.sort(arr,c);
	    t.pause();




	    for(Integer i: arr)
        {
            System.out.println(i);
        }

        imprimirTiempo(t);
    }

    public static void imprimirTiempo (Timer t)
    {
        System.out.println("_________________");
        System.out.println("el tiempo transcurrido fue: " + t.elapsedTime());
        System.out.println("-----------------");
    }
}
