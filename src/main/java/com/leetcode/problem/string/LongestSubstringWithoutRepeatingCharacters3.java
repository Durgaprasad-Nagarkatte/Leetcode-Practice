package com.leetcode.problem.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, max_len = Integer.MIN_VALUE;

        if(s.length() == 0){
            return 0;
        }

        // Iterating the string
        for(int i = 0; i < s.length(); i++){
            // Check whether the start index is lesser than the currently occurring repeating character
            if(map.containsKey(s.charAt(i))){
                if(start <= map.get(s.charAt(i))){
                    start = map.get(s.charAt(i)) + 1;
                }
            }
            end++;
            max_len = Math.max(max_len, end-start);
            map.put(s.charAt(i), i);
        }
        return max_len;
    }

    public static void main(String[] args){
        LongestSubstringWithoutRepeatingCharacters3 longestSubstring = new LongestSubstringWithoutRepeatingCharacters3();
        System.out.println(longestSubstring.lengthOfLongestSubstring("pwwkew"));
    }
}
