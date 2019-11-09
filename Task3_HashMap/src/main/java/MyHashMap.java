import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

 public class MyHashMap<K, V> implements Map<K, V> {
    private int size = 0;
    private float loadFactor;
    private Node[] node; // Создали ноду
    private static final float DEFAULT_LOAD_FACTOR = 0.75f; //переменная нужна для конструктора без параметров
    private static  int DEFAULT_INITIAL_CAPACITY = 16; //задали размерность Map

     public MyHashMap(){
         this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
     }
     public MyHashMap(int size, float loadFactor){
//         this.size = size;
         node = new Node[size];
         this.loadFactor = loadFactor;

     }
     //Метод вычисления из хеш кода индекс массива.
     private int indexFor(Object key) {
         return key == null ? 0 : Math.abs(key.hashCode()) % node.length;
     }

     public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
        return false;
    }

    public V get(Object key) {
        return null;
    }

    public V put(K key, V value) {
        Node currendNode = node[indexFor(key)];
        while (currendNode != null){
            if(currendNode.getKey().equals(key)) {
//               V currendValue = (V) currendNode.getValue();
                currendNode.setValue(value);
                //return currendValue;
            }
            currendNode = currendNode.getNext();
        }
        node[indexFor(key)] = new Node(key, value, node[indexFor(key)]);// кладем в ноду значение
        size++;
        return value;
    }

    public V remove(Object key) {
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> m) {


    }

    public void clear() {

    }

    public Set<K> keySet() {
        return null;
    }

    public Collection<V> values() {
        return null;
    }

    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
