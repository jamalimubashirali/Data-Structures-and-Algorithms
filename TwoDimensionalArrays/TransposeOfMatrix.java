package TwoDimensionalArrays;

import java.util.Scanner;

public class TransposeOfMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows,cols;
        System.out.println("Enter number of rows :");
        rows = sc.nextInt();
        System.out.println("Enter number of columns :");
        cols = sc.nextInt();
        int[][] array = new int[rows][cols];
        for(int i = 0; i<rows; i++){
            System.out.println("Enter numbers in row :"+i);
            for (int j = 0; j<cols ; j++){
                array[i][j] = sc.nextInt();
            }
        }
        for (int i = 0 ; i < cols ; i++){
            for (int j = 0 ; j < rows ; j++){
                System.out.print(array[j][i]+"  ");
            }
            System.out.println();
        }
    }
}
