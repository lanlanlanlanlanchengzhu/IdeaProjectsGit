package leetcode.no17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Solution solution = new Solution();
        System.out.println("res: " + solution.letterCombinations("23"));;
    }

    public List<String> letterCombinations(String digits) {
        Set<String> res = new HashSet<String>();
        Set<String> resTemp = new HashSet<String>();
        char[] digitsArr = digits.toCharArray();
        char[] num2Char2 = new char[]{'a','b','c'};
        char[] num2Char3 = new char[]{'d','e','f'};
        char[] num2Char4 = new char[]{'g','h','i'};
        char[] num2Char5 = new char[]{'j','k','l'};
        char[] num2Char6 = new char[]{'m','n','o'};
        char[] num2Char7 = new char[]{'p','q','r','s'};
        char[] num2Char8 = new char[]{'t','u','v'};
        char[] num2Char9 = new char[]{'w','x','y','z'};

        Map<Character, char[]> num2CharMap = new HashMap();
        num2CharMap.put('2', num2Char2);
        num2CharMap.put('3', num2Char3);
        num2CharMap.put('4', num2Char4);
        num2CharMap.put('5', num2Char5);
        num2CharMap.put('6', num2Char6);
        num2CharMap.put('7', num2Char7);
        num2CharMap.put('8', num2Char8);
        num2CharMap.put('9', num2Char9);

        String origin = "";
        res.add(origin);

        for (int i = 0; i < digitsArr.length; i++) {
            for (int j = 0;j < num2CharMap.get(digitsArr[i]).length; j++) {
                for (String oneOrigin : res) {
                    String newStr = oneOrigin + num2CharMap.get(digitsArr[i])[j];
                    resTemp.add(newStr);
                }
            }
            res.clear();
            res.addAll(resTemp);
            resTemp.clear();
        }
        return new ArrayList(res);
    }

}
