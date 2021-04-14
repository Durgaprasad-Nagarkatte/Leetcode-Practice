package com.leetcode.problem.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    TODO : Not so good solution
 */

public class GroupAnagrams {
    private Map<String, List<String>> wordMap = new HashMap<>();

    public String getKey(String str){
        int[] charArray = new int[26];
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            charArray[str.charAt(i)-'a']++;
        }

        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] > 0){
                builder.append((char) (i + 'a'));
                builder.append(charArray[i]);
            }
        }

        return builder.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();

        for(int i = 0; i < strs.length; i++){
            String str = getKey(strs[i].trim());
            if(str.length() != 0){
                if(wordMap.containsKey(str)){
                    wordMap.get(str).add(strs[i]);
                }else{
                    List<String> tempList = new ArrayList<>();
                    tempList.add(strs[i]);
                    wordMap.put(str, tempList);
                }
            }

            if(str.length() == 0){
                if(wordMap.containsKey("#")){
                    wordMap.get("#").add(strs[i]);
                }else{
                    List<String> tempList = new ArrayList<>();
                    tempList.add(strs[i]);
                    wordMap.put("#", tempList);
                }
            }
        }

        for(String key : wordMap.keySet()){
            list.add(wordMap.get(key));
        }

        return list;
    }

    public static void main(String[] args){
        GroupAnagrams anagrams = new GroupAnagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat"," "};
        anagrams.groupAnagrams(strs);
    }
}
