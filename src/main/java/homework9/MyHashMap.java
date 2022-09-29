package homework9;

import java.util.Arrays;
import java.util.Objects;

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

    private int arrayLength = 16;
    private int size;

    private final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Node<K, V> table[];

    public MyHashMap() {
        table = new Node[arrayLength];
        size = 0;
    }

    public int getHash(K key) {
        return (Objects.isNull(key)) ? 0 : key.hashCode() % arrayLength;
    }

    public void grow(){
        float threshold = arrayLength * DEFAULT_LOAD_FACTOR;
        if ((size + 1) >= threshold) {
            arrayLength = arrayLength * 2;
            Node<K, V>[] newTable = new Node[arrayLength];
            for (Node<K, V> node : table){
                if (Objects.nonNull(node)){
                    Node<K, V> headNode = node;
                    if (Objects.nonNull(node.next)){
                        Node<K,V> cur = node.next;
                        while (cur != null){
                            int hashNext = getHash((K)cur.getKey());
                            if (Objects.isNull(newTable[hashNext])){
                                newTable[hashNext] = cur;
                            }
                            else {
                                newTable[hashNext].next = cur;
                            }
                            cur = cur.next;
                        }
                    }
                    int hash = getHash(headNode.getKey());
                    if (Objects.isNull(newTable[hash])){
                        newTable[hash] = headNode;
                    }
                    else {
                        newTable[hash].next = headNode;
                    }
                    headNode.next = null;
                }
            }
            table = newTable;
        }
    }

    public V put(K key, V value){
        grow();
        int hash = getHash(key);
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

    public V get(K key){
        int hash = getHash(key);
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

    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    public V remove(K key){
        int hash = getHash(key);
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

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrayLength; i++){
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
