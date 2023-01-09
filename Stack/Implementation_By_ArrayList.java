package Stack;

import java.util.ArrayList;

public class Implementation_By_ArrayList {
     static class Stack{
         ArrayList <Integer> l = new ArrayList<>();
         public void push(int data){
             l.add(data);
         }
         public void pop(){
             if(l.size() == 0){
                 System.out.println("The list is empty");
             }else{
                 l.remove(l.size()-1);
             }
         }
         public int peak(){
             int top = -1;
             if(l.size() == 0)
                 System.out.println("The list is empty");
             else {
               top = l.get(l.size()-1);
             }
             return top;
         }
     }

    public static void main(String[] args) {
        Stack s = new Stack();
        for (int i = 0; i < 5; i++){
            s.push(i);
        }
        while (s.l.size()!=0){
            System.out.println(s.peak());
            s.pop();
        }

    }
}
