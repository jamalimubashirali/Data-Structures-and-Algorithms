package BinaryTrees;

public class BinarySearchTree {
    private int key,height;
    private Object value;
    private BinarySearchTree left,right;
    public static final BinarySearchTree NIL = new BinarySearchTree();
    private BinarySearchTree(){
        left = right = this;
        height = -1;
    }
    private BinarySearchTree(int key, BinarySearchTree left, BinarySearchTree right,Object value){
        this.key = key;
        this.value = value;
        this.right = right;
        this.left = left;
        this.height = 1+Math.max(left.height,right.height);
    }
    public BinarySearchTree(int key,Object value){
        this.key = key;
        this.value = value;
        this.left = this.right = NIL;
    }
    public int size(){
        if(this == NIL)
            return 0;
        return 1+ left.size()+ right.size();
    }
    public BinarySearchTree grow(int key,Object value){
        if(this == NIL)
            return new BinarySearchTree(key,value);
        if(key == this.key)
            return this;
        if(key < this.key)
            left = left.grow(key,value);
        if(key > this.key)
            right = right.grow(key,value);
        height = 1+Math.max(left.height, right.height);
        return this;
    }
    public void leftMostValue(){
        if(this.left == NIL){
            System.out.println(key + " " + value);
            return;
        }
        this.left.leftMostValue();
    }
    public void rightMostValue(){
        if(this.right == NIL){
            System.out.println(key + " " + value);
            return;
        }
        this.right.rightMostValue();
    }
    public boolean add(int key,Object value){
        int oldSize = size();
        grow(key,value);
        return size() > oldSize;
    }
    public String toString(){
        if(this == NIL)
            return "";
        return this.left+" "+this.key+" "+this.value+" "+this.right;
    }
}
