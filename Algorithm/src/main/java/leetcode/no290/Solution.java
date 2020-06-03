package leetcode.no290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author x
 * @date 2020-05-11
 */
public class Solution {

    public boolean wordPattern(String pattern, String str) {
        String[] wordArr = str.split(" ");
        if (pattern.length() != wordArr.length) {return false;}
        Map<Character, String> mapping = new HashMap<>();
        Set<String> exists = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!mapping.containsKey(pattern.charAt(i))) {
                if (exists.contains(wordArr[i])) {
                    // 已经存在，保证映射唯一；防止 "abba" "AAAA"
                    return false;
                }
                mapping.put(pattern.charAt(i), wordArr[i]);
                exists.add(wordArr[i]);
            } else {
                if (!mapping.get(pattern.charAt(i)).equals(wordArr[i])) {
                    return false;
                }
            }
        }
        return true;
    }

}
