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
    public Object get(Object key){
        return nodes[hash(key)].value;
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
    public Object remove(Object key){
        int h = hash(key);
        Object temp = nodes[h];
        nodes[h] = null;
        return temp;
    }
    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(4);
        hashTable.put("Buriro","Masood");
        hashTable.put("Jamali","Mubashir");
        hashTable.put("Shahani","Jawad");
        hashTable.put("Chandio","Saifullah");
        System.out.println(hashTable.get("Shahani"));
    }
}