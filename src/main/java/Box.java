package main.java;

public class Box<T> {

    private T element;

    public void put(T element){
        this.element = element;
    }

    public T get(){
        return this.element;
    }

}
