package com.leetcode.problem.string;

import sun.security.krb5.internal.crypto.HmacSha1Aes128CksumType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {

    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, max_length = Integer.MIN_VALUE;
        Map<Character, Integer> charMap = new HashMap<>();

        if(s.length() == 0 || s.length() == 1){
            return s.length();
        }

        for(int i = 0; i < s.length(); i++){
            if(!charMap.containsKey(s.charAt(i))){
                charMap.put(s.charAt(i), i);
                end = i;
            }else {
                start = charMap.get(s.charAt(i)) + 1;
                end = charMap.get(s.charAt(i)) + 1;
                charMap.put(s.charAt(i), i);
            }
            max_length = Math.max(max_length, end-start+1);
        }

        return max_length;
    }

    public static void main(String[] args){
        LongestSubstringWithoutRepeatingCharacters3 longestSubstring = new LongestSubstringWithoutRepeatingCharacters3();
        System.out.println(longestSubstring.lengthOfLongestSubstring("abcdefg"));
    }
}
