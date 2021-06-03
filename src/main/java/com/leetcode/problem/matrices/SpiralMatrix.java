package com.leetcode.problem.matrices;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public void traverseMatrix(int[][] matrix, List<Integer> list, int i, int j, int n, int m){
        while (j < n && matrix[i][j] != -101){
            list.add(matrix[i][j]);
            matrix[i][j] = -101;
            j++;
        }
        i++;
        j--;

        while (i < m && matrix[i][j] != -101){
            list.add(matrix[i][j]);
            matrix[i][j] = -101;
            i++;
        }
        i--;
        j--;

        while (j >= 0 && matrix[i][j] != -101){
            list.add(matrix[i][j]);
            matrix[i][j] = -101;
            j--;
        }
        j++;
        i--;

        while (i > 0 && matrix[i][j] != -101){
            list.add(matrix[i][j]);
            matrix[i][j] = -101;
            i--;
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = 0;
        if(m == 0){
            return list;
        }


        if(m > 0){
            n = matrix[0].length;
        }
        int length = n;
        int breadth = m;

        int i = 0, j = 0;
        while((i < length)  && (j < breadth)){
            traverseMatrix(matrix, list, i, j, length, breadth);
            i++;
            j++;
            length--;
            breadth--;
        }

        return list;
    }


    public static void main(String[] args){
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> list = spiralMatrix.spiralOrder(arr);

        int[][] arr1 = {{1,2,3},{4,5,6}};
        list = spiralMatrix.spiralOrder(arr1);

        System.out.println(list);
    }
}
