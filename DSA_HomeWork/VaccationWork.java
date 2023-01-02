package DSA_HomeWork;
class Node{
    String word;
    Node next;
    public Node(String s){
        this.word = s;
    }
}
public class VaccationWork {
    public static void main(String[] args) {
        String [] sentance ={"I","love","my","university","I","have" ,"been" ,"studying", "in","this","university", "for", "the", "last", "twelve", "months", "and", "these", "twelve", "months", "of", "my", "life", "at", "the", "university", "have","provided", "me", "applied", "form", "to","enlite", "myself", "and", "prepared", "me", "for","future","challenges" ,"I" ,"keep", "loving", "my", "university", "for", "the","rest", "of", "my", "life"};
        Node start = new Node(sentance[0]);
        Node p = start;
        for (int i = 1;i < sentance.length;i++){
            p.next = new Node(sentance[i]);
            p = p.next;
        }
        for(Node q = start ; q!=null; q = q.next ){
            System.out.print(q.word+" ");
        }
    }
}
