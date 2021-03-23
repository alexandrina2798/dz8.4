package main.java;

final class Box<T> {

    private T element;
    void put(final T element) {
        this.element = element;
    }

    public T get() {
        return this.element;
    }

}
