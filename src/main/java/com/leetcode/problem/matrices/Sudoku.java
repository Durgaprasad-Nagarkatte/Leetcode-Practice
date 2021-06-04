package com.leetcode.problem.matrices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sudoku {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rowCollection = new ArrayList<>();
        List<Set<Character>> columnCollection = new ArrayList<>();
        List<Set<Character>> matrixCollection = new ArrayList<>();

        int n = board.length;

        // Creating a row collection and column collection
        for(int i = 0; i < n; i++){
            rowCollection.add(new HashSet<>());
            columnCollection.add(new HashSet<>());
            matrixCollection.add(new HashSet<>());
        }

        // Iterate the matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != '.'){
                    if(rowCollection.get(i).contains(board[i][j])){
                        return false;
                    }else{
                        rowCollection.get(i).add(board[i][j]);
                    }

                    if(columnCollection.get(j).contains(board[i][j])){
                        return false;
                    }else{
                        columnCollection.get(j).add(board[i][j]);
                    }

                    // Iterating the grid
                    if(i < 3){
                       if(matrixCollection.get(j/3).contains(board[i][j])){
                           return false;
                       }else{
                           matrixCollection.get(j/3).add(board[i][j]);
                       }
                    }else if(i < 6){
                        if(matrixCollection.get(3 + j/3).contains(board[i][j])){
                            return false;
                        }else{
                            matrixCollection.get(3 + j/3).add(board[i][j]);
                        }
                    }else{
                        if(matrixCollection.get(6 + j/3).contains(board[i][j])){
                            return false;
                        }else {
                            matrixCollection.get(6 + j/3).add(board[i][j]);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Sudoku sudoku = new Sudoku();
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        char[][] b = {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};


        System.out.println(sudoku.isValidSudoku(board));
    }
}
