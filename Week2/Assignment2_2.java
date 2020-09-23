package edu.aed.week2;

import java.util.*;

public class Assignment2_2 {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and outprint its sum.
     *
     * Example 1:
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     * Example 2:
     * Input: nums = [1]
     * Output: 1
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum;

        for(int i=0;i<nums.length;i++)
        {
            sum=0;
            for(int j=i;j<nums.length;j++){
                sum=sum+nums[j];
                if(max<sum){
                    max=sum;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter length of array");
        int n=sc.nextInt();

        int nums[]=new int[n];

        System.out.println("Enter elements of array");

        for(int i=0;i<n;i++){

            nums[i]=sc.nextInt();

        }
        Assignment2_2  object=new Assignment2_2();
        System.out.println(+object.maxSubArray(nums));
}
}
