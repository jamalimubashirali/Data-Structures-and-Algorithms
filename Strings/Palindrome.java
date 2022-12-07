package Strings;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        String word;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word should be uppercase or lower :");
        word = sc.next();
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) != word.charAt(word.length()-1-i)){
                System.out.println("The entered word is not Palindrome");
                break;
            }
        }
        System.out.println("The Word is Palindrome");
    }
}
