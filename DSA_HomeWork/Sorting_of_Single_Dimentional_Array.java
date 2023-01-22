package DSA_HomeWork;

public class Sorting_of_Single_Dimentional_Array {
    static int[] bubble(int[] a){
        for(int i = 0; i < a.length; i++){
            int temp;
            for(int j = i+1; j < a.length-1; j++){
                if(a[i] > a[j]){
                    temp = a[j];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
    static int[] selection(int[] a){
        for(int i = 0; i < a.length; i++){
            int smallest = i;
            for(int j = i+1; j < a.length; j++){
                if(a[smallest] > a[j]){
                    smallest = j;
                }
            }
            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
        }
        return a;
    }
    static int[] insertion(int[] a){
        for(int i = 1; i < a.length; i++){
            int current = a[i];
            int j = i-1;
            while (j>=0 && current < a[j]){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = current;
        }
        return a;
    }
    public static void main(String[] args) {
        int[] a = {2,6,4,8,9,0,6,7};
        a = insertion(a);
        for (int i: a){
            System.out.println(i);
        }
    }
}
