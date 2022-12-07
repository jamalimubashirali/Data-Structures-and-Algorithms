package BitMinupilation;

import java.util.Scanner;

public class SetBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pos = sc.nextInt();
        int bit_mask = 1 << pos;
        int newN = bit_mask | n;
        System.out.println("New number after setting bit(from 0 to 1) is : "+newN);

    }
}
