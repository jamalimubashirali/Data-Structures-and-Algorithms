package Leet_Code_Problem_Solutions;
import java.util.*;
// Problem Statement
//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//        The overall run time complexity should be O(log (m+n)).
public class Problem_1 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int l = nums1.length+nums2.length;
            int numbers[] = new int[l];
            int n = 0;
            for(int i = 0; i < 2 ; i++){
                if(i == 0){
                    for(int j = 0; j < nums1.length; j++){
                        numbers[n] = nums1[j];
                        n++;
                    }
                }
                if(i == 1){
                    for(int j = 0; j < nums2.length; j++){
                        numbers[n] = nums2[j];
                        n++;
                    }
                }
            }
            float  f = 0;
            Arrays.sort(numbers);
            if(numbers.length%2 == 0){
                f = (numbers[numbers.length/2]+numbers[numbers.length/2-1])/(float)2;

            } else if (numbers.length%2 != 0) {
                f = numbers[numbers.length/2];

            }
            return f;
        }
    }
}
