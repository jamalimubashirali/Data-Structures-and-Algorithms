package Stack;

public class Implementation_By_Array {
    static class Stack{
        private int size;
        private Object[] a ;
        public boolean isEmpty(Stack s){
            if(this.a == null)
                return true;
            return false;
        }
        public void printStack(){
            for(int i = this.size-1 ; i >= 0 ; i--){
                System.out.println(this.a[i]);
            }
        }
        public void push(Object data){
            if(this.a == null){
                a = new Object[1];
                a[0] = data;
            }
            Object b[] = new Object[size+=1];
            for(int i = 0; i < a.length;i++){
                b[i] = a[i];
            }
            b[size-1] = data;
            a = b;
        }
        public int pop(){
            int pop;
            if(a.length == 1){
                pop = (int)a[0];
                a = null;
                size--;
                return pop;
            }
            pop = (int) a[size-1];
            Object b[] = new Object[size-=1];
            for(int i = 0; i < size;i++){
                b[i] = a[i];
            }
            a = b;
            return pop;
        }
        public int peak(){
            return (int)a[size-1];
        }
        public String toString(){
            String s = "";
            for (int i = 0 ; i < size; i++){
                s += String.valueOf(a[i])+" ";
            }
            return s;
        }
        public void reverse(){
            for(int i = 0; i < this.a.length/2; i++){
                Object temp = a[i];
                a[i] = a[this.a.length-1-i];
                a[this.a.length-1-i] = temp;
            }
        }
        public boolean isEquals(Stack s){
            if(s.size != this.size){
                return false;
            }
            for (int i = 0 ; i < size ; i++){
                if(String.valueOf(this.a[i]) != String.valueOf(s.a[i]))
                    return false;
            }
            return true;
        }
        public int popFromBottom(){
            int pop;
            if(a.length == 1){
                pop = (int)a[0];
                a = null;
                size--;
                return pop;
            }
            pop = (int) a[0];
            Object b[] = new Object[size-=1];
            for(int i = 0; i < size; i++){
                b[i] = a[i+1];
            }
            a = b;
            return pop;
        }
        Implementation_By_Linked_List.Stack change_to_LinkedStack(){
            Implementation_By_Linked_List.Stack linkedStack = new Implementation_By_Linked_List.Stack();
            for(int i = 0; i < this.size; i++){
                linkedStack.push((Integer) this.a[i]);
            }
            return linkedStack;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(2);
        s.push(3);
        s.push(10);
        Implementation_By_Linked_List.Stack ls = s.change_to_LinkedStack();
        System.out.println(ls.peek());

    }
}
