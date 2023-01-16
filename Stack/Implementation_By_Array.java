package Stack;

public class Implementation_By_Array {
    static class Stack{
        int size;
        Object[] a ;
        public void push(int data){
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
        public int peek(){
            return (int)a[size-1];
        }
    }
}
