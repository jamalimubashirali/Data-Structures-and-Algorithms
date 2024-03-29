package BinaryTrees;

public class AVLTree {
    private int key,height;
    private Object value;
    private AVLTree left,right;
    public static final AVLTree NIL = new AVLTree();
    private AVLTree(){
        left = right = this;
        height = -1;
    }
    private AVLTree(int key, AVLTree left, AVLTree right,Object value){
        this.key = key;
        this.value = value;
        this.right = right;
        this.left = left;
        this.height = 1+Math.max(left.height,right.height);
    }
    public AVLTree(int key,Object value){
        this.key = key;
        this.value = value;
        this.left = this.right = NIL;
    }
    public int size(){
        if(this == NIL)
            return 0;
        return 1+ left.size()+ right.size();
    }
    public AVLTree grow(int key,Object value){
        if(this == NIL)
            return new AVLTree(key,value);
        if(key == this.key)
            return this;
        if(key < this.key)
            left = left.grow(key,value);
        if(key > this.key)
            right = right.grow(key,value);
        rebalance();
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
    private void rotateRight(){
        this.right = new AVLTree(this.key,this.value);
        this.key = this.left.right.key;
        this.value = this.left.right.value;
        this.left.right = NIL;
    }
    private void rotateLeft(){
            this.left = new AVLTree(this.key,this.value);
            this.key = this.right.left.key;
            this.value = this.right.left.value;
            this.right.left = NIL;
    }
    private void rebalance(){
        if(this.right.height > this.left.height+1){
            if(this.right.left.height > right.right.height)
                this.right.rotateRight();
            this.rotateLeft();
        } else if (this.left.height > this.right.height+1) {
            if(this.left.right.height > this.left.left.height)
                this.left.rotateLeft();
            this.rotateRight();
        }
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
