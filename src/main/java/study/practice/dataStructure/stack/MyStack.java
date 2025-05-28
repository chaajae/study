package study.practice.dataStructure.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<E> {
    private static final int DEFAULT_CAPACITY = 6;
    private Object[] arr;
    private int top;

    public MyStack(){
        this.arr = new Object[DEFAULT_CAPACITY];
        this.top = -1;
    }

    public boolean isFull(){
        return top == arr.length - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    private void resize(){
        int arrCapacity = arr.length - 1;
        if(top == arrCapacity){
            int newCapacity = arr.length * 2;
            arr = Arrays.copyOf(arr, newCapacity);
            return;
        }

        if(top < (arrCapacity / 2)){
            int halfCapacity = arr.length / 2;
            arr = Arrays.copyOf(arr, Math.max(halfCapacity, DEFAULT_CAPACITY));
        }
    }

    public E push(E value){
        if(isFull()){
            resize();
        }
        top++;
        arr[top] = value;
        return value;
    }

    @SuppressWarnings("unchecked")
    public E pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E value = (E) arr[top];
        arr[top] = null;
        top--;
        resize();
        return value;
    }

    @SuppressWarnings("unchecked")
    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return (E) arr[top];
    }

    public int search(E value){
        for (int i = top; i >= 0; i--) {
            if(arr[i].equals(value)){
                return top - i + 1;
            }
        }
        return -1;
    }

    @Override
    public String toString(){
        return Arrays.toString(arr);
    }

}
