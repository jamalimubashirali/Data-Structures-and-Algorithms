package LinkedList_And_Types;

public class LinkedList {
   static class Node{
        int data;
        Node next;
        Node (int data){
            this.data = data;
            this.next = null;
        }
        public void printList(Node start){
            for (Node p = start ; p != null; p = p.next){
                System.out.print(p.data+" -> ");
            }
            System.out.print("Null");
        }
    }
    public static void main(String[] args) {
       Node start = new Node(1);
       Node p = start;
       for(int i = 2; i <= 10; i++){
           p.next = new Node(i);
           p = p.next;
        }
       start.printList(start);
    }
}
