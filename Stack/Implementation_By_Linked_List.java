package Stack;

public class Implementation_By_Linked_List {
    static class Node {
        int data;
        Node next;
        Node (int data){
            this.data = data;
        }
    }
    static class Stack{
        public  Node head;
        public Node push(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = newNode;
                return head;
            }
                newNode.next = head;
                head = newNode;
            return head;
        }
        public Node pop(){
            if (head == null){
                return head;
            }
            head = head.next;
            return head;
        }
        public int peek(){
            int top = head.data;
            return top;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.head = new Node(0);
        for(int i = 1; i < 5; i++){
            s.head = s.push(i);
        }
        while (s.head != null){
            System.out.println(s.peek());
            s.head = s.pop();
        }
    }
}
