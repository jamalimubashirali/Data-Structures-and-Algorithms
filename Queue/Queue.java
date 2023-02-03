package Queue;

public interface Queue {
    public void add(Object data);
    public Object remove();
    public Object first();
    public int size();
}
