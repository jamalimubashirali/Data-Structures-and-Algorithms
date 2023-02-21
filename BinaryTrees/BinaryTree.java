package BinaryTrees;

public class BinaryTree {
    private Object root;
    private BinaryTree left,right;
    private int size;
    private int height;
    private int leftHeight;
    private int rightHeight;
    public BinaryTree(Object root){
        this.root = root;
    }
    public BinaryTree(Object root,BinaryTree left,BinaryTree right){
        this.root = root;
        this.right = right;
        this.left = left;
    }
    public String inLine(){
        StringBuffer buf = new StringBuffer();
        if(left!=null)
            buf.append(left.inLine());
        buf.append(root+",");
        if(right!=null)
            buf.append(right.inLine());
        return buf.toString();
    }
    public boolean isFull(){
        int total = (int) (Math.pow(2,this.height()+1) - 1);
        if(total == this.size())
            return true;
        return false;
    }
    public String preOrder(){
        StringBuffer buf = new StringBuffer();
        buf.append(root+",");
        if(left!=null)
            buf.append(left.inLine());
        if(right!=null)
            buf.append(right.inLine());
        return buf.toString();
    }
    public String postOrder(){
        StringBuffer buf = new StringBuffer();
        if(left!=null)
            buf.append(left.inLine());
        if(right!=null)
            buf.append(right.inLine());
        buf.append(root+",");
        return buf.toString();
    }
    public int height(){
        if(this.left == null || this.right == null)
            return 0;
        leftHeight = left.height();
        rightHeight = right.height();
        height = Math.max(leftHeight,rightHeight)+1;
        return height;
    }
    public String search(Object a){
            if(this.root == a)
                 return "Found";
            if(right!=null)
                return right.search(a);
            if(left!=null)
                return left.search(a);
            return "Not Found";
    }
    public boolean isLeaf(){
        if(this.right == null && this.left == null)
            return true;
        return false;
    }
    public int size(){
        size++;
        if(right!=null){
            size += right.size();
        }
        if(left!=null){
            size += left.size();
        }
        return size;
    }
}
