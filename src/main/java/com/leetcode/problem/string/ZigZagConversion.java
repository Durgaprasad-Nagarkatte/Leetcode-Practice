package com.leetcode.problem.string;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion{
    public String convert(String s, int numRows) {
        int min_rows = Math.min(s.length(), numRows);
        boolean isMovingUp = true;

        List<StringBuilder> stringList = new ArrayList<>();
        for(int i = 0; i < min_rows; i++){
            stringList.add(new StringBuilder());
        }

        for(int i = 0; i < s.length();){
            if(isMovingUp){
                for(int j = 0; j < min_rows; j++){
                    if((i+j) < s.length()){
                        stringList.get(j).append(s.charAt(i+j));
                    }
                }
                i += min_rows;
                isMovingUp = false;
            }else {
                for(int j = 1; j < min_rows-1; j++){
                    if((i+j-1) < s.length()){
                        stringList.get(min_rows-j-1).append(s.charAt(i+j-1));
                    }
                }
                if(min_rows-2 > 0){
                    i += min_rows-2;
                }
                isMovingUp = true;

            }
        }

        StringBuilder zigZagBuilder = new StringBuilder();
        for(int i = 0; i < min_rows; i++){
            zigZagBuilder.append(stringList.get(i));
        }
        return zigZagBuilder.toString();
    }

    public static void main(String[] args){
        ZigZagConversion conversion = new ZigZagConversion();
        String zigZagString = conversion.convert("AB", 1);
        System.out.println(zigZagString);
    }
}
