package BinaryTrees;

public class Main {
    public static void main(String[] args) {
        BinaryTree d = new BinaryTree("D",null,new BinaryTree("H"));
        BinaryTree b = new BinaryTree("B",d,new BinaryTree("E"));
        BinaryTree f = new BinaryTree("F",new BinaryTree("I"),null);
        BinaryTree g = new BinaryTree("G",new BinaryTree("J"),new BinaryTree("K"));
        BinaryTree c = new BinaryTree("C",f,g);
        BinaryTree a = new BinaryTree("A",b,c);
        System.out.println(a.inLine());
        System.out.println(a.postOrder());
        System.out.println(a.preOrder());
    }
}
