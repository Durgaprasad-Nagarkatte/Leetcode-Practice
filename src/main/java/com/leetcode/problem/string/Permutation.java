package com.leetcode.problem.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
TODO : Create a temp list when the level is zero;
 */

public class Permutation {
    List<List<Integer>> permutationList = new ArrayList<>();

    public void buildPermuation(int[] nums, boolean[] visited, List<Integer> tempList, int level){
        if(level > nums.length){
            return;
        }

        if(level == nums.length){
            List<Integer> copyList = new ArrayList<>();
            copyList.addAll(tempList);
            permutationList.add(copyList);
        }

        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                tempList.set(level, nums[i]);
                visited[i] = true;
                buildPermuation(nums, visited, tempList, level+1);
                visited[i] = false;
            }else{
                continue;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Integer[] tempArr = new Integer[nums.length];
        buildPermuation(nums, visited, Arrays.asList(tempArr), 0);
        return permutationList;
    }


    public static void main(String[] args){
        Permutation permutation = new Permutation();
        int[] nums = {1, 2, 3};
        permutation.permute(nums);
    }
}
