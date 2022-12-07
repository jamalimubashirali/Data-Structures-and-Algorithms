package BitMinupilation;

import java.util.Scanner;

public class UpdateBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pos = sc.nextInt();
        int bit_mask = 1<<pos;
        System.out.println("Enter Bit to be changed (0 or 1) : ");
        int update = sc.nextInt();
        if(update == 1){
            System.out.println(bit_mask | n);
        }else if(update == 0){
            System.out.println(~(bit_mask)&n);
        }
    }
}
