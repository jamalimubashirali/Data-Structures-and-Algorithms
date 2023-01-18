package Stack;

class ArrayStack implements Stack{
    Object[] a;
    int size;
    ArrayStack(int s){
        a = new Object[s];
        size = 0;
    }
    public void push(Object b){
        a[size++] = b;
    }
    public Object pop(){
        Object temp = a[size-1];
        a[size-1]=null;
        size--;
        return temp;
    }
    public void peek(){
        System.out.println(a[size-1]);
    }
    public int size(){
        return size;
    }
}
interface Stack{
    void push(Object a);
    Object pop();
    void peek();
}

class RPN{
    Stack stack;
    public RPN(String[] args){
        stack = new ArrayStack(args.length);
        for (int i=0;i<args.length;i++){
            String input = args[i];
            if (isAnOperator(input)==true){
                double x= Double.parseDouble(String.valueOf(stack.pop()));
                double y= Double.parseDouble(String.valueOf(stack.pop()));
                double z=calculate(x,y,input);
                stack.push(z);
            }
            else stack.push(input);
        }
    }
    public boolean isAnOperator(String op){
        return (op.length()==1 && (("ASMD".indexOf(op)>=0)||("asmd".indexOf(op)>=0))   );
    }

    private double calculate(double x,double y,String op){
        double z=0;
        if (op.equals("A") || op.equals("a"))  z=x+y;
        if (op.equals("S")||op.equals("s"))  z=x-y;
        if (op.equals("M")||op.equals("m"))  z=x*y;
        if (op.equals("D")||op.equals("d"))  z=x/y;
        System.out.println(x+" "+y+""+"="+z);
        return z;
    }

}
public class RPN_Calculator
{
    public static void main(String[] args) {
        System.out.println("Hello World");
        String[] data={"4","3","a","3","8","4","A","d","S"};
        RPN obj=new RPN(data);
    }
}
