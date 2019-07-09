package leetcode.no13;

public class Solution {

    public int romanToInt(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I' :
                    res += 1;
                    break;
                case 'V' :
                    res += 5;
                    break;
                case 'X' :
                    res += 10;
                    break;
                case 'L' :
                    res += 50;
                    break;
                case 'C' :
                    res += 100;
                    break;
                case 'D' :
                    res += 500;
                    break;
                case 'M' :
                    res += 1000;
                    break;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            switch ("" + s.charAt(i) + s.charAt(i + 1)) {
                case "IV" :
                case "IX" :
                    res -= 2;
                    break;
                case "XL" :
                case "XC" :
                    res -= 20;
                    break;
                case "CD" :
                case "CM" :
                    res -= 200;
                    break;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("IXIX"));;
    }

}
