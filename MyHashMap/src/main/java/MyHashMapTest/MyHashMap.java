package MyHashMapTest;

import sun.security.util.Length;

import javax.swing.text.html.parser.Entity;
import java.util.Arrays;

public class MyHashMap {
    private int size = 0; // счетчик элементов (Node)
    private int LengthMap = 2; // размер мапы
    private Node[] entry = new Node[LengthMap];// массив Node

    //возвращаем размер мапы
    public  int getSize() {

        return size;
    }

    //Put
    public void  put(Object key, Object value){
        Node currendNode = entry[indexFor(key)];
        while (currendNode != null){
            if(currendNode.getK().equals(key)) {
                currendNode.setV(value);
                return;
            }
            currendNode = currendNode.next;
        }
        entry[indexFor(key)] = new Node(key, value, entry[indexFor(key)]);// кладем в ноду значение
        size++;

    }
    //remove
    public  Object remove(Object key){
        Node currendNode = entry[indexFor(key)];
        Node prevNode = null;

        while (currendNode != null){
          if(currendNode.getK().equals(key)) {
              if (prevNode == null)
                entry[indexFor(key)] = currendNode.next;
              else
                  prevNode.next = currendNode.next;

              size--;
              return currendNode.getV();
          }

          prevNode = currendNode;
          currendNode = currendNode.next;
        }
        return size;
    }
    // update
    public void  update(Object key, Object value){
        Node currendNode = entry[indexFor(key)];

        while (currendNode != null){
            if(currendNode.getK().equals(key)) {
                currendNode.setV(value);
                return;
            }
            currendNode = currendNode.next;
        }
        return;

    }
    //Получаем значение по ключу
    public Object getValue(Object key){

        Node node = entry[indexFor(key)];

        //пока нода не равна 0
        while (node != null) {

            if (node.K.equals(key))
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
