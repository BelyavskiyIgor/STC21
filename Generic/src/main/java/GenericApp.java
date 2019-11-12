import java.util.*;

/**
 * @autor Igor Belyavskiy
 * HashMap from Generic
 */
public class GenericApp<K, V> implements Map<K, V> {
    private int size = 0; // счетчик элементов (Node)
    private final int LengthMap = 2; // размер мапы
    private Node[] entry = new Node[LengthMap];// массив Node

    //возвращаем размер мапы
    @Override
    public  int size() {

        return size;
    }

    //Put
    public V put(K key, V value){
        Node currendNode = entry[indexFor(key)];
        while (currendNode != null){
            if(currendNode.getK().equals(key)) {
                currendNode.setV(value);
                return value;
            }
            currendNode = currendNode.next;
        }
        entry[indexFor(key)] = new Node(key, value, entry[indexFor(key)]);// кладем в ноду значение
        size++;

        return value;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(Object key) {

        if(size !=0 && this.get((K)key) != null){
            return true;

        }
        return false;
    }

    public boolean containsValue(Object value) {
        return values().contains(value);
    }
    //remove
    public V remove(Object key){
        Node currendNode = entry[indexFor(key)];
        Node prevNode = null;

        while (currendNode != null){
            if(currendNode.getK().equals(key)) {
                if (prevNode == null)
                    entry[indexFor(key)] = currendNode.next;
                else
                    prevNode.next = currendNode.next;

                size--;
                return (V) currendNode.getV();
            }

            prevNode = currendNode;
            currendNode = currendNode.next;
        }
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry1 : m.entrySet()) {
            this.put(entry1.getKey(), entry1.getValue());
        }

    }

    public void clear() {
        entry = new Node[LengthMap];
        size = 0;

    }

    public Set<K> keySet() {
        Set set = new HashSet();
        for (Entry<K, V> node: entrySet()) {
            set.add(node.getKey());

        }
        return set;
    }

    public Collection<V> values() {
        ArrayList list = new ArrayList();
        for (Entry<K, V> node: entrySet()) {
            list.add(node.getValue());

        }
        return list;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entryresult = new HashSet();
        for (Node node: entry) {
            while (node != null ){
                entryresult.add((Entry<K, V>) node);
                node = node.next;
            }

        }

        return entryresult;
    }

    // update

    //Получаем значение по ключу
    public V get(Object key) {
        Node<K, V> node = entry[indexFor(key)];
        //пока нода не равна 0
        while (node != null) {
            if (node.k.equals(key))
                return node.getV();
            node = node.next;
        }
        return null;

        //return node.getV();
    }
    private int indexFor(Object key){ //Метод определения индекса из HashCode в индекс массива
        //если key ==null то вернум 0. Иначе элемент попадает м ячейку остаток от деления.
        return key == null ? 0 : Math.abs(key.hashCode()) % LengthMap;

    }
    @Override
    public String toString() {
        return "MyHashMap{" +
                "LengthMap=" + LengthMap +
                ", entry=" + Arrays.toString(entry) +
                '}';
    }
}
