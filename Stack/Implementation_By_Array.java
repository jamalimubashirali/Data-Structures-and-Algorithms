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
    }
}
