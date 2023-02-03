package Queue;

public class Implementing_Queue {
    static class Node {
        Object data;
        Node pre;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
            this.pre = null;
        }
    }
        static class MyQueue implements Queue{
            private Node head = new Node(null);
            private Node current = null;
            private int size = 1;
            @Override
            public void add(Object data) {
                Node newNode = new Node(data);
                 if (this.size()==1) {
                    current = newNode;
                    head.next = current;
                    current.next = head;
                    current.pre = head;
                    head.pre = current;
                    size++;
                } else{
                    newNode.next = head;
                    current.next = newNode;
                    newNode.pre = current;
                    current = newNode;
                    size++;
                }
            }
            public void print(){
                for(Node p = head.next; p!=head; p = p.next){
                    System.out.println(p.data);
                }
            }
            @Override
            public Object remove() {
                Object remove = head.next.data;
                head = head.next;
                return remove;
            }

            @Override
            public Object first() {
                return head.next.data;
            }

            @Override
            public int size() {
                return this.size;
            }
        }
}
