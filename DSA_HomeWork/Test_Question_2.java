package DSA_HomeWork;

public class Test_Question_2 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
        public Node copy(Node start){
            Node p = start;
            Node q = p;
            while(start!=null){
                q.next = start.next;
                start = start.next;
                q = q.next;
            }
            return p;
        }
        public Node concate(Node start,Node copy){
                Node p ;
                for (p=start; p.next!=null; p = p.next) {
                }
               p.next = copy;
            return start;
        }
    }
    public static void main(String[] args) {
        int a[] = {15,16,17};
        Node start = new Node(a[0]);
        Node p = start ;
        for(int i = 1; i < a.length ; i++){
            p.next = new Node(a[i]);
            p = p.next;
        }
        Node copy = start.copy(start);
        start = start.concate(start,copy);
        for (Node q = copy ; q!=null; q = q.next){
            System.out.print(q.data+"->");
        }
    }
}
