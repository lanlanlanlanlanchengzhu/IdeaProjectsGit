package leetcode.no60;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author x
 * @date 2020-05-31
 */
public class Solution60 {

    public static String getPermutation(int n, int k) {
        int[] fac = new int[n];
        fac[0] = 1;
        List<Integer> bucket = new ArrayList<Integer>();
        for(int i = 1; i < n; i++) {
            fac[i] = i * fac[i - 1];
        }
        for(int i = 0; i < n; i++) {
            bucket.add(i + 1);
        }

        k--;
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >=0; i--) {
            int idx = k / fac[i];
            sb.append(bucket.get(idx));
            k -= idx * fac[i];
            bucket.remove(idx);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Solution60.getPermutation(3, 3));
    }

}
