package Graph;

public class Graph {
    int size;
    String[] vertices;
    boolean[][] a;
    public Graph(String[] args){
        size = args.length;
        vertices =  new String[size];
        System.arraycopy(args,0,vertices,0,size);
        a = new boolean[size][size];
    }
    public void add(String v, String w){
        int i = index(v),j = index(w);
        a[i][j] = a[j][i] = true;
    }
    private int index(String v){
        for(int  i = 0; i < size; i++){
            if(vertices[i].equals(v))
                return i;
        }
        return size;
    }
    public String toString(){
        if(size==0) return "{}";
        StringBuffer buff = new StringBuffer("{"+vertices[0]);
        for(int i = 0; i < size; i++){
            buff.append(vertex(i));
        }
        return buff+"}";
    }
    private String vertex(int i){
        StringBuffer buf = new StringBuffer(vertices[i]);
        for(int j = 0; j < size; j++){
            if(a[i][j])
                buf.append(vertices[j]);
        }
        return buf+":";
    }
}
