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
    public boolean search(int key){
        if(this.key == key)
            return true;
        if(this.key < key && this.right!= NIL)
            return right.search(key);
        if(this.key > key && this.left != NIL)
            return left.search(key);
        else
            return false;
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
    public String inLIne(){
        StringBuffer buf = new StringBuffer();
        if(this.left != NIL)
            buf.append(left.inLIne());
        buf.append(this.key+" "+this.value+" ");
        if(this.right != NIL)
            buf.append(right.inLIne());
        return buf+"";
    }
    public String preOrder(){
        StringBuffer buf = new StringBuffer();
        buf.append(this.key+" "+this.value+" ");
        if(this.left != NIL)
            buf.append(left.preOrder());
        if(this.right != NIL)
            buf.append(right.preOrder());
        return buf+"";
    }
    public String toString(){
        if(this == NIL)
            return "";
        return this.left+" "+this.key+" "+this.value+" "+this.right;
    }
    public static void main(String[] args) {
        int[] a = {67,45,78,56,89,34,57,89};
        BinarySearchTree b = new BinarySearchTree(a[0],0);
        for(int i = 1; i < a.length; i++){
            b.add(a[i],i);
        }
        System.out.println(b.search(2));
    }
}
