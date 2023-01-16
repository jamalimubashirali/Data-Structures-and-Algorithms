import java.util.Arrays;

public class Main {
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int numbers[] = new int[nums1.length+nums1.length];
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
            if(numbers.length% 2 != 0){
                f = numbers[numbers.length/2];
            } else if (numbers.length%2 == 0) {
                f = (numbers[numbers.length/2]+numbers[numbers.length/2-1])/(float)2;
            }
            return f;
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            int a[] = {1,3};
            int b[] = {2};
            System.out.println(s.findMedianSortedArrays(a,b));
            System.out.println(a.length+b.length);
        }
    }
}

