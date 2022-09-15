package homework9;

public class MyHashMap<K, V> {
    private class Node<K, V>{
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return this.key;
        }

        public V getValue(){
            return this.value;
        }

        public void setValue(V value){
            this.value = value;
        }

        @Override
        public String toString() {
            Node<K, V> temp = this;
            StringBuilder stringBuilder = new StringBuilder();
            while (temp != null){
                stringBuilder.append(temp.key + " -> " + temp.value + "; ");
                temp = temp.next;
            }
            return stringBuilder.toString();
        }
    }

    private final int ARRAY_LENGTH = 16;
    private int size;

    private Node<K, V> table[];

    public MyHashMap() {
        table = new Node[ARRAY_LENGTH];
        size = 0;
    }

    // Associates the specified value with the specified key in this map.
    // If the map previously contained a mapping for the key, the old value is replaced.
    public V put(K key, V value){
        int hash = key.hashCode() % ARRAY_LENGTH;
        Node<K, V> e = table[hash];

        if (e == null){
            table[hash] = new Node<K, V>(key, value);
            size++;
            return null;
        } else {
            while (e.next != null){
                if (e.getKey() == key){
                    V oldValue = e.getValue();
                    e.setValue(value);
                    return oldValue;
                }
                e = e.next;
            }
            // check last element key
            if (e.getKey() == key){
                V oldValue = e.getValue();
                e.setValue(value);
                return oldValue;
            }

            e.next = new Node<K, V>(key, value);
            size++;
        }
        return null;
    }

    // Returns the value to which the specified key is mapped,
    // or null if this map contains no mapping for the key.
    public V get(K key){
        int hash = key.hashCode() % ARRAY_LENGTH;
        Node<K, V> e = table[hash];

        if (e == null){
            return null;
        }

        //traverse through all keys by comparing with input key value
        while (e != null){
            if (e.getKey() == key){
                return e.getValue();
            }
            e = e.next;
        }
        // if key is not found
        return null;
    }

    // Removes all the mappings from this map.
    public void clear() {
        for (int i = 0; i < ARRAY_LENGTH; i++){
            Node<K, V> temp;
            Node<K, V> start = table[i];

            if(start == null){
                continue;
            }
            while (start != null){
                temp = start.next;
                start.next = null;
                start = temp;
            }
            table[i] = start;
        }
        size = 0;
    }

    // Removes the mapping for the specified key from this map if present.
    public V remove(K key){
        int hash = key.hashCode() % ARRAY_LENGTH;
        Node<K, V> e = table[hash];

        if (e == null){
            return null;
        }

        if (e.getKey() == key){
            table[hash] = e.next;
            e.next = null;
            size--;
            return e.getValue();
        }

        Node<K, V> prev = e;
        e = e.next;

        while (e != null) {
            if (e.getKey() == key) {
                prev.next = e.next;
                e.next = null;
                size--;
                return e.getValue();
            }
            prev = e;
            e = e.next;
        }

        return null;
    }

    // Returns the number of key-value mappings in this map.
    public int size() {
        return size;
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ARRAY_LENGTH; i++){
            if (table[i] != null) {
                stringBuilder.append(i + " " + table[i] + "\n");
            }
            else {
                stringBuilder.append(i + " " + "null" + "\n");
            }
        }
        return stringBuilder.toString();
    }
}
