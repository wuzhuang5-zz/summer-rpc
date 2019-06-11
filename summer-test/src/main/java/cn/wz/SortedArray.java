package cn.wz;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SortedArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 4, 6, 7};
        int[] arr2 = new int[]{3, 5, 6, 9};
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<arr1.length;i++) {
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++) {
            set.add(arr2[i]);
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
