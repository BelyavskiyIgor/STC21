/**
 * @autor Igor Belyavskiy
 * Node for Class GenericApp
 */
public class Node<K, V> {
        K k;
        V v;
        Node next;

        public Node(K k, V v, Node next) {
            k = k;
            v = v;
            this.next = next;
        }

        public K getK() {
            return k;
        }

        public void setK(K k) {
            k = k;
        }

        public V getV() {
            return v;
        }

        public void setV(V v) {
            v = v;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "K=" + k +
                    ", V=" + v +
                    ", next=" + next +
                    '}';
        }
    }


