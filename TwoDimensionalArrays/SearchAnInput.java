package TwoDimensionalArrays;

import java.util.Scanner;

public class SearchAnInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows,cols;
        System.out.println("Enter number of rows :");
        rows = sc.nextInt();
        System.out.println("Enter number of columns :");
        cols = sc.nextInt();
        int[][] array = new int[rows][cols];
        for(int i = 0; i<rows; i++){
            for (int j = 0; j<cols ; j++){
                System.out.println("Enter number at index :"+i+j);
                array[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter number to search");
        int target = sc.nextInt();
        for(int i = 0; i<rows; i++){
            for (int j = 0; j<cols ; j++){
                if(target == array[i][j]){
                    System.out.println(i+" "+j);
                    break;
                }
            }
        }
    }
}
