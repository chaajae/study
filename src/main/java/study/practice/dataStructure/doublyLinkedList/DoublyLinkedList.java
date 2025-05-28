package study.practice.dataStructure.doublyLinkedList;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class DoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private static class Node<E>{
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
        Node<E> newNode = new Node<>(null, value, first);
        size++;
        head = newNode;

        if(first == null){
            tail = newNode;
        }else{
            first.prev = newNode;
        }
    }

    public void addLast(E value){
        Node<E> last = tail;
        Node<E> newNode = new Node<>(last, value, null);

        size++;
        tail = newNode;

        if(last == null){
            head = newNode;
        }else{
            last.next = newNode;
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

    public E removeFirst(){
        if(head == null){
            throw new NoSuchElementException();
        }

        E value = head.item;
        Node<E> first = head.next;

        head.next = null;
        head.item = null;
        size--;
        head = first;

        if(first == null){
            tail = null;
        }else{
            first.prev = null;
        }

        return value;
    }

    public E remove(){
        return removeFirst();
    }

    public E removeLast(){
        if(tail == null){
            throw new NoSuchElementException();
        }

        E value = tail.item;
        Node<E> last = tail.prev;

        tail.item = null;
        tail.prev = null;
        size--;
        tail = last;

        if(last == null){
            head = null;
        }else{
            last.next = null;
        }
        return value;
    }

    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            return removeFirst();
        }

        if(index == size - 1){
            return removeLast();
        }

        Node<E> delNode = search(index);
        Node<E> prevNode = delNode.prev;
        Node<E> nextNode = delNode.next;

        E value = delNode.item;

        delNode.item = null;
        delNode.prev = null;
        delNode.next = null;

        size--;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        return value;
    }

    public boolean remove(Object value){
        Node<E> delNode = null;
        Node<E> i = head;

        while (i != null){
            if(Objects.equals(i.item, value)){
                delNode = i;
                break;
            }
            i = i.next;
        }

        if(delNode == null){
            return false;
        }

        if(delNode == head){
            removeFirst();
            return true;
        }

        if(delNode == tail){
            removeLast();
            return true;
        }

        Node<E> prevNode = delNode.prev;
        Node<E> nextNode = delNode.next;

        delNode.item = null;
        delNode.prev = null;
        delNode.next = null;

        size--;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        return true;
    }

    public E get(int index){
        if(index < 0 || index >= size){
            throw  new IndexOutOfBoundsException();
        }
        return search(index).item;
    }

    public void set(int index, E value){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node<E> replaceNode = search(index);
        replaceNode.item = value;
    }

    public int indexOf(Object value){
        Node<E> n = head;
        int i = 0;
        while (n != null){
            if(Objects.equals(value, n.item)){
                return i;
            }
            i++;
            n = n.next;
        }
        return -1;
    }

    public int lastIndexOf(Object value){
        Node<E> n = tail;
        int i = size - 1;
        while (n != null){
            if(Objects.equals(value, n.item)){
                return i;
            }
            i--;
            n = n.prev;
        }
        return -1;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear() {

        for (Node<E> i = head; i.next != null;){
            Node<E> nextNode = i.next;

            i.item = null;
            i.prev = null;
            i.next = null;
            i = nextNode;
        }

        head = null;
        tail = null;
        size = 0;
    }

    public boolean contains(Object value){
        return indexOf(value) != -1;
    }

    @Override
    public String toString(){
        if(head == null){
            return "[]";
        }

        Object[] arr = new Object[size];

        int index = 0;
        Node<E> n = head;
        while (n != null){
            arr[index] = (E) n.item;
            index++;
            n = n.next;
        }

        return Arrays.toString(arr);
    }

    public String toString2(){
        if(head == null){
            return "[]";
        }

        Node<E> n = head;
        StringBuilder result = new StringBuilder();
        result.append("[\n");

        for (int i = 0; i < size; i++) {
            result.append(" Node@").append(String.format("%-10s", n.hashCode())).append(" -> ");
            if(n.prev != null){
                result.append("[").append(n.prev.hashCode()).append(" | ");
            }else{
                result.append("[").append("null").append(" | ");
            }

            result.append(n.item).append(" | ");
            if(n.next != null){
                result.append(n.next.hashCode()).append("]");
            }else{
                result.append("null").append("]");
            }

            result.append(", \n");
            n = n.next;
        }

        result.append("]");
        return result.toString();
    }
}
