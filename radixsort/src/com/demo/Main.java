package com.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

public class Main {
    public static  String[] stringArr;
    public static void radixSort(int []arr)
    {
         stringArr = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(stringArr, '0');

        int maxlength = StringUtil.maxLengthValue;
        for(int i = maxlength; i > 0; i--)
        {
            Map<Character, ArrayList<String>> lList = new HashMap<Character, ArrayList<String>>();

            for(String element:stringArr)
            {
                char selectedChar = element.charAt(i-1);
               ArrayList selectedList = lList.get(selectedChar);
               if (selectedList == null)
               {
                   selectedList = new ArrayList<String>();
               }
               selectedList.add(element);
                lList.put(selectedChar,selectedList);


            }
            TreeMap<Character, ArrayList<String>> sorted = new TreeMap<>();

            // Copy all data from hashMap into TreeMap
            sorted.putAll(lList);
            ArrayList<String> newOrderedArrayList = new ArrayList<String>();
            for (Map.Entry<Character, ArrayList<String>> entry : sorted.entrySet())
            {
                for(String element: entry.getValue())
                {
                    newOrderedArrayList.add(element);
                }
            }
            stringArr = new String[arr.length];
            stringArr = newOrderedArrayList.toArray(stringArr);
        }
        int[] resultArray = StringUtil.toIntArray(stringArr);
        for(int i =0; i<arr.length; i++) {
            arr[i] = resultArray[i];
        }

    }
    public static void main(String[] args) {
	// write your code here
        int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        radixSort(arr);
        for (int i:arr) {
            System.out.println(i);
        }
    }
}
