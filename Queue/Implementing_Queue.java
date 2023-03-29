package Queue;

public class Implementing_Queue implements Queue{
    public static class Node {
        public Object data;
        public Node pre;
        public Node next;

        Node(Object data) {
            this.data = data;
            this.next = this;
            this.pre = this;
        }
    }
            public Node head = new Node(null);
            private int size = 0;
            @Override
            public void add(Object data) {
                Node newNode = new Node(data);
                if(head.next == head){
                    head.next = newNode;
                    newNode.pre = head;
                    head.pre = newNode;
                    newNode.next = head;
                }
                else {
                    newNode.pre = head.pre;
                    head.pre.next = newNode;
                    head.pre = newNode;
                    newNode.next = head;
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
                head.next = head.next.next;
                head.next.pre = head;
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
