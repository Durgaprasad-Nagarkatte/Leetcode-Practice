package com.leetcode.problem.string;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    Map<Character, String> map = new HashMap<>();

    private void initialiseMap(){
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        initialiseMap();
        LinkedList<String> wordList = new LinkedList<>();

        boolean flag = true;
        int index = 0;

        while(flag && index < digits.length()){
            if(digits.charAt(index) == '1'){
                index++;
            }else{
                String tempString = map.get(digits.charAt(index));
                for(int i = 0; i < tempString.length(); i++){
                    wordList.add("" + tempString.charAt(i));
                }
                flag = false;
                index++;
            }
        }

        if(wordList.isEmpty()){
            return wordList;
        }

        LinkedList<String> prevQueue = wordList;
        while(index < digits.length()){
            LinkedList<String> currQueue = new LinkedList<>();
            String value =  map.get(digits.charAt(index));
            while(!prevQueue.isEmpty()){
                String temp = prevQueue.poll();
                for(int i = 0; i < value.length(); i++){
                    currQueue.add(temp + value.charAt(i));
                }
            }
            prevQueue = currQueue;
            index++;
        }
        return prevQueue;
    }

    public static void main(String[] args){
        LetterCombinationsOfPhoneNumber letterCombinationsOfPhoneNumber = new LetterCombinationsOfPhoneNumber();
        letterCombinationsOfPhoneNumber.letterCombinations("123");
    }
}
