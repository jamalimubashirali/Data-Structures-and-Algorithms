package DSA_HomeWork;

public class Test_Question_2 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
        public Node copy(Node start){
            Node copy = new Node(start.data);
            Node q = copy;
            for (Node p=start.next ; p!=null; p=p.next){
                q.next = new Node(p.data);
                q = q.next;

            }
            return copy;
        }
        public Node concate(Node start,Node copy){
//                    int i = 0;
//                    while(i<3) {
                        Node p;
                        for (p = start; p.next != null; p = p.next) {
                        }
                        p.next = copy;
                        //i++;
//                    }

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
        for (Node q = start ; q!=null; q = q.next){
            System.out.print(q.data+"->");
        }
    }
}
