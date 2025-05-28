package study.practice.dataStructure.CircularDoublyLinkedList;

public class CircularDoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public CircularDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private Node<E> search(int index){
        Node<E> n;
        if((size / 2) > index){
            n = head;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
        }else{
            n = tail;
            for (int i = size - 1; i > index; i--) {
                n = n.prev;
            }
        }
        return n;
    }

    public void addFirst(E value){
        Node<E> first = head;
        Node<E> last = tail;

        Node<E> newNode = new Node<>(null, value, first);
        size++;
        head = newNode;

        if(first == null){
            tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        }else{
            first.prev = newNode;
            last.next = newNode;
            newNode.prev = last;
        }
    }

    public void addLast(E value){
        Node<E> first = head;
        Node<E> last = tail;

        Node<E> newNode = new Node<>(last, value, null);
        size++;
        tail = newNode;

        if(last == null){
            head = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        }else{
            last.next = newNode;
            newNode.next = first;
            first.prev = newNode;
        }
    }

    public boolean add(E value){
        addLast(value);
        return true;
    }

    public void add(int index, E value){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
        }

        if(index == 0){
            addFirst(value);
            return;
        }

        if(index == size){
            addLast(value);
            return;
        }

        Node<E> nextNode = search(index);
        Node<E> prevNode = nextNode.prev;
        Node<E> newNode = new Node<>(prevNode, value, nextNode);

        size++;
        prevNode.next = newNode;
        nextNode.prev = newNode;
    }

    public E removeFirst() {
        if (head == null) {
            throw  new RuntimeException();
        }

        E returnValue = head.item;
        Node<E> first = head.next;
        head.next = null;
        head.item = null;
        head = first;
        size--;

        if(head == null){
            tail = null;
        }
        return returnValue;
    }

    @Override
    public String toString(){
        if(head == null){
            return "[]";
        }

        Node<E> n = head;
        StringBuilder result = new StringBuilder("[");

        while (n.next != null){
            result.append(n.item).append(", ");
            n = n.next;
        }
        result.append(n.item).append("]");
        return result.toString();
    }

    public String toString2() {
        if (head == null) {
            return "[]";
        }

        Node<E> n = head;
        StringBuilder result = new StringBuilder();

        result.append("[\n");

        for(int i = 0; i< size; i++) {

            result.append("  Node@").append(String.format("%-10s", n.hashCode())).append("  →  ");

            if (n.prev != null) {
                result.append("[").append(n.prev.hashCode()).append(" | ");
            } else {
                result.append("[").append("null").append(" | ");
            }

            result.append(n.item).append(" | ");

            if (n.next != null) {
                result.append(n.next.hashCode()).append("]");
            } else {
                result.append("null").append("]");
            }

            result.append(", \n");

            n = n.next;
        }

        result.append("]");

        return result.toString();
    }
}
