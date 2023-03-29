package HashMap;

public class HashTable {
    private static class Node{
        Object key;
        Object value;
        public Node(Object key,Object value){
            this.key = key;
            this.value = value;
        }
    }
    private Node[] nodes;
    public HashTable(int numberOfPairs){
        nodes = new Node[numberOfPairs];
    }
    private int size;
    public int hash(Object key){
        return (key.hashCode() & 0x7FFFFFFF) % nodes.length;
    }
    public Object get(Object key) {
        int h = hash(key);
        for (int i = 0; i < nodes.length; i++) {
            int j = (h + i) % nodes.length;
//            if(nodes[j] == null)
//                break;
            if (nodes[j] != null && nodes[j].key.equals(key)) {
                return nodes[j].value;
            }
        }
        return null;
    }
    public void put(Object key,Object value){
        if(size == nodes.length){
            System.arraycopy(nodes, 0 , nodes,size,size+5);
            nodes[hash(key)] = new Node(key, value);
            size++;
        }
        nodes[hash(key)] = new Node(key, value);
        size++;
    }
    public void putBylinearProbing(Object key,Object value){
        int h = hash(key);
        for(int i = 0; i < nodes.length; i++){
            int j = (h+i) % nodes.length;
            Node tempNode = nodes[j];
            if(tempNode == null){
                nodes[j] = new Node(key, value);
                size++;
                return;
            }
        }
        return;
    }
    public Object remove(Object key){
        int h = hash(key);
        for(int i = 0; i < nodes.length; i++){
            int j = (h+i) % nodes.length;
            if(nodes[j] != null && nodes[j].key.equals(key)){
                Object temp = nodes[j].value;
                nodes[j] = null;
                size--;
                return temp.toString();
            }
        }
        return null;
    }
    public String toString(){
        StringBuffer buf = new StringBuffer();
        for(int i = 0; i < nodes.length; i++){
            if(nodes[i] == null)
                continue;
            buf.append(nodes[i].key+" "+nodes[i].value+" ");
        }
        return buf+"";
    }
    public int getSize(){
        return size;
    }
    public void reHash() {
        Node[] oldNodes = nodes;
        size = 0;
        nodes = new Node[2 * oldNodes.length + 1];
        for (int i = 0; i < oldNodes.length; i++) {
            if (oldNodes != null) {
                int h = hash(oldNodes[i].key);
                for (int j = 0; j < nodes.length; j++) {
                    int k = (h + i) % nodes.length;
                    if (nodes[k] == null) {
                        nodes[k] = oldNodes[i];
                        size++;
                        return;
                    }
                }
            }
        }
    }
}