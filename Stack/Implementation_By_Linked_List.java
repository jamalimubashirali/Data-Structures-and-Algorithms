package Stack;

public class Implementation_By_Linked_List {
    private static class Node {
        int data;
        Node next;
        Node (int data){
            this.data = data;
        }
    }
    static class Stack{
        private  Node head;
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
        Implementation_By_Array.Stack change_to_arrayStack(){
            Implementation_By_Array.Stack arrayStack = new Implementation_By_Array.Stack();
            for(Node h = this.head ; h!=null; h = h.next){
                arrayStack.push(h.data);
            }
            arrayStack.reverse();
            return arrayStack;
        }
        public int peek(){
            int top = head.data;
            return top;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        for(int i = 0; i < 5; i++){
            s.push(i);
        }
        Implementation_By_Array.Stack array = s.change_to_arrayStack();
        array.printStack();
    }
}
