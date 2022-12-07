package DSA_HomeWork;

import java.util.Scanner;

// Task:
// Merge three one-dimensional of 45 into one two-dimensional array of size 45 by 3.
public class Two_Dimensional_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 4;
        String[] roll_No = new String[size];
        int[] oop_Marks = new int[size];
        int[] pp_marks = new int[size];
        String[][] record = new String[size][3];

        for(int i = 0; i < size; i++){
            System.out.println("Please enter student Roll No :");
            roll_No[i] = sc.next();
            System.out.println("Please enter marks in OOP :");
            oop_Marks[i] = sc.nextInt();
            System.out.println("Please enter marks in PP :");
            pp_marks[i] = sc.nextInt();
        }

        for(int i = 0; i< size; i++){
            record [i][0] = roll_No[i];
            record [i][1] = Integer.toString(oop_Marks[i]);
            record [i][2] = Integer.toString(pp_marks[i]);
        }
        System.out.println("Roll_No\t  OOP_Marks\tPP_Marks");
        for (int i = 0; i < size; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(record[i][j]+"       ");
            }
            System.out.println();
        }
    }
}
