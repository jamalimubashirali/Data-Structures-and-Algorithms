package LinkedList_And_Types;

public class LinkedList {
   static class Node{
        int data;
        Node next;
        int size = 1;
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
        public Node insertInBetween(Node start,Node newNode){
            for(Node p = start.next; p.next!=null; p = p.next){
                if(p.data <= newNode.data && p.next.data >= newNode.data){
                    newNode.next = p.next;
                    p.next = newNode;
                    return start;
                }
            }
            System.out.println("Can't insert in between");
            return start;
        }
        public Node insertNode(Node start,Node newNode){
            if(start == null)
                return start;
            if(start.data > newNode.data){
                newNode.next =start;
                start = newNode;
                return start;
            }
            for (Node p = start ; p!= null; p = p.next){
                if(p.next == null){
                    p.next = newNode;
                    newNode.next = null;
                }
            }
            return start;
        }
        public Node reverse(Node start){
            int[] a = new int[size];
            Node p = start;
            for(int i = size-1; i>=0 ;i--){
                a[i] = p.data;
                p = p.next;
            }
            Node q = start;
            for(int i = 0; i < a.length; i++){
                q.data = a[i];
                q = q.next;
            }
            return start;
        }
        public Node deleteNode(Node start,Node deleteNode){
            if(start == null)
                return start;
            if(start.next == null){
                start = null;
                return start;
            }
            if(start.data == deleteNode.data){
                start = start.next;
            }
            Node p;
            for (p = start; p.next!= null; p = p.next){
                if(p.next.next== null && p.next.data == deleteNode.data){
                    p.next = null;
                    return start;
                }
               if(deleteNode.data == p.next.data){
                    p.next = p.next.next;
                }
            }
            return start;
        }
    }
    public static void main(String[] args) {
        Node start = new Node(1);
        Node p = start;
        for (int i = 2; i <= 10; i++) {
            p.next = new Node(i);
            p = p.next;
            start.size++;
        }
    }
}
