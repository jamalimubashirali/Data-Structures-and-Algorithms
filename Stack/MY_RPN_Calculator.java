package Stack;

public class MY_RPN_Calculator {
    static class Stack {
        int size;
        Object a[];

        public void push(Object data) {
            if (this.a == null) {
                a = new Object[size += 1];
                a[size - 1] = data;
            } else {
                Object[] b = new Object[size += 1];
                for (int i = 0; i < a.length; i++) {
                    b[i] = a[i];
                }
                b[size - 1] = data;
                a = b;
            }
        }

        public Object pop() {
            Object top;
            if (size == 1) {
                top = a[0];
                a = null;
                size -= 1;
                return top;
            }
            top = a[size - 1];
            Object[] b = new Object[size -= 1];
            for (int i = 0; i < b.length; i++) {
                b[i] = a[i];
            }
            a = b;
            return top;
        }

        public Object peak() {
            return a[size - 1];
        }

        public boolean isOperator(String s) {
            String[] operators = {"A", "S", "M", "D"};
            for (int i = 0; i < operators.length; i++) {
                if (operators[i].equals(s))
                    return true;
            }
            return false;
        }

        public double evaluate(double x, double y, String s) {
            double d = 0.0;
            if (s.equals("S"))
                d = x - y;
            else if (s.equals("A"))
                d = x + y;
            else if (s.equals("M"))
                d = x * y;
            else if (s.equals("D"))
                d = x / y;
            return d;
        }

        public void printStack() {
            for (int i = this.size - 1; i >= 0; i--) {
                System.out.println(this.a[i]);
            }
        }
    }

    public static void main(String[] args) {
        Stack c = new Stack();
        String[] rpn = {"7", "8", "A", "9", "S", "4", "2", "D","M"};
        for (int i = 0; i < rpn.length; i++){
            if(c.isOperator(rpn[i])){
                double x= Double.parseDouble(String.valueOf(c.pop()));
                double y= Double.parseDouble(String.valueOf(c.pop()));
                double r = c.evaluate(x,y,rpn[i]);
                c.push(r);
            }else {
                c.push(rpn[i]);
            }
        }
        System.out.println((double) c.peak());
    }
}
