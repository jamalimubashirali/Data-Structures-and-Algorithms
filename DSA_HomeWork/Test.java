package DSA_HomeWork;


public class Test {
    static int size = 1;
    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
        public int small(Node start){
            int small = start.data;
            for(Node p = start.next ; p!=null;p = p.next){
                if(small > p.data)
                    small = p.data;
            }
            return small;
        }
        public int large(Node start){
            int large = start.data;
            for(Node p = start.next ; p!=null;p = p.next){
                if(large < p.data)
                    large = p.data;
            }
            return large;
        }
        public int mid(Node start){
            int mid = 0;
            if(Test.size%2!=0){
                for (int i = 1; i <= (Test.size/2) ; i++){
                    start = start.next;
                }
            }
            else if(Test.size%2==0){
                System.out.println("The list has two middle element");
            }
            mid = start.data;
            return mid;
        }
    }
    public static void main(String[] args) {
        int [] a = {25,9,11,16,1,15,95};
        Node start = new Node(a[0]);
        Node p = start;
        for(int i = 1; i < a.length; i++){
            p.next = new Node(a[i]);
            p = p.next;
            size++;
        }
        int small = a[0];
        int large = a[0];
        for(int i = 1; i < a.length; i++){
            if(a[i] > large)
                large = a[i];
            if(a[i] < small)
                small = a[i];
        }
        System.out.println("Linked List elements");
        System.out.println(start.small(start)+" "+start.large(start) + " "+start.mid(start));
        System.out.println("Array elements");
        System.out.println(small+" "+ large+" " + a[a.length/2]);
    }
}
