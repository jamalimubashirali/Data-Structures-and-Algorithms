package BitMinupilation;

import java.util.Scanner;

public class ClearBit {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int pos = sc.nextInt();
        int bit_mask = 1<<pos;
        int newNumber  = (~(bit_mask) & n);
        System.out.println("New number after clearing a bit from 1 to 0 is :"+newNumber);
    }
}
