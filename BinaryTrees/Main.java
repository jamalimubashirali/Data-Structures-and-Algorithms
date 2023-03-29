package BinaryTrees;

public class Main {
    public static void main(String[] args) {
        Tree d = new Tree("D",null,new Tree("H"));
        Tree b = new Tree("B",d,new Tree("E"));
        Tree f = new Tree("F",new Tree("I"),null);
        Tree g = new Tree("G",new Tree("J"),new Tree("K"));
        Tree c = new Tree("C",f,g);
        Tree a = new Tree("A",b,c);
    }
}
