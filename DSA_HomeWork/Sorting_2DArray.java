package DSA_HomeWork;

import java.util.Arrays;

public class Sorting_2DArray {
    public static void main(String[] args) {
        int target = 45;
        int [][] arr =  {{5,7,4}, {5,8,0}, {9,7,55}, {-98,9,67}, {45,78,90}, {56,89,0}, {44,32,-7}, {97,59,76}, {98,76,43}, {57,86,9}};
        int array[] = new int[30];
        int size = 0;
        for (int i = 0 ; i < arr.length;i++) {
            array[size] = arr[i][0];
            size++;
            array[size] = arr[i][1];
            size++;
            array[size] = arr[i][2];
            size++;
        }
        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
        int low , high;
        low = 0; high = array.length-1;
        while(low<=high){
            int mid = (low+high) - 1;
            if(array[mid] == target){
                System.out.println("Found at index : "+mid);
                break;
            }else if(array[mid] > target){
                high = mid -1;
            }else {
                low = mid + 1;
            }
        }
  }
}
