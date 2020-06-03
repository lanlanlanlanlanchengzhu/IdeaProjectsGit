package leetcode.no56;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author x
 * @date 2020-05-31
 */
public class Solution56 {
    public static void main(String[] args) {
        int[][] origin = new int[10][10];
        Arrays.sort(origin, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                int[] arr1 = (int[]) o1;
                int[] arr2 = (int[]) o2;
                if (arr1[0] == arr2[0]) {
                    return arr1[1] - arr2[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
    }
}
