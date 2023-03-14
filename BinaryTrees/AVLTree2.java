package BinaryTrees;

public class AVLTree2 {
    private int key,height;
    private Object value;
    private AVLTree2 left;
    private AVLTree2 right;
    public static final AVLTree2 NIL = new AVLTree2();
    private AVLTree2(){
        left = right = this;
        height = -1;
    }
    private AVLTree2(int key, AVLTree2 left, AVLTree2 right,Object value){
        this.key = key;
        this.value = value;
        this.right = right;
        this.left = left;
        this.height = 1+Math.max(left.height,right.height);
    }
    public AVLTree2(int key, Object value){
        this.key = key;
        this.value = value;
        this.left = this.right = NIL;
    }
    public int size(){
        if(this == NIL)
            return 0;
        return 1+ left.size()+ right.size();
    }
    public AVLTree2 grow(int key,Object value){
        if(this == NIL)
            return new AVLTree2(key,value);
        if(key == this.key)
            left.grow(key,value);
        if(key < this.key)
            left = left.grow(key,value);
        if(key > this.key)
            right = right.grow(key,value);
        // rebalance();
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
