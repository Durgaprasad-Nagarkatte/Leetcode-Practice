package com.leetcode.problem.string;

public class SearchInRotatedSortedArray {
    public int findPivot(int[] nums, int low, int high){
        if(low > high){
            return -1;
        }

        int mid = (low + high)/2;

        if(mid >= 0 && mid <= nums.length-1){
            if(mid > 0 && nums[mid] < nums[mid-1]){
                return mid;
            }

            if(mid < nums.length-1 && nums[mid] > nums[mid+1]){
                return mid+1;
            }
        }

        int result = findPivot(nums, low, mid-1);
        if(result >= 0){
            return result;
        }

        result = findPivot(nums, mid+1, high);
        if(result >= 0){
            return result;
        }

        return -1;
    }

    public int binarySearch(int[] nums, int low, int high, int target){
        if(low > high){
            return -1;
        }

        int mid = (low + high)/2;
        int result;

        if(nums[mid] == target){
            return mid;
        }

        if (nums[mid] < target){
            result = binarySearch(nums, mid+1, high, target);
            if(result > 0){
                return result;
            }
        }else{
            result = binarySearch(nums, low, mid-1, target);
            if(result > 0){
                return result;
            }
        }
        return result;
    }

    public int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length-1);
        int result;

        if(pivot == -1){
            return binarySearch(nums, 0, nums.length-1, target);
        }else{
            result = binarySearch(nums, 0, pivot-1, target);
            if(result >= 0){
                return result;
            }
            result = binarySearch(nums, pivot, nums.length-1, target);
        }
        return result;
    }


    public static void main(String[] args){
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        int[] nums = {3};
        System.out.println(search.search(nums, 3));
    }
}
