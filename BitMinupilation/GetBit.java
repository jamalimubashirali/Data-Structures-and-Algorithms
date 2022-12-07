package BitMinupilation;

import java.util.Scanner;

public class GetBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int pos = sc.nextInt();
            int bit_mask = 1 << pos;

            if ((bit_mask & n) == 0) {
                System.out.println("The bit was Zero");
            } else {
                System.out.println("The bit was One ");
            }

    }
}
