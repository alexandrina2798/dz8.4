package main.java;

public class Fruit {

    private String sort = String.valueOf(getClass());

    private boolean fresh = true;

    public final void setFresh(final boolean fresh) {
        this.fresh = fresh;
    }

    public final boolean getFresh() {
        return this.fresh;
    }

    @Override
    public final String toString() {
        switch (sort) {
            case ("class main.java.Orange"):
                sort = "апельсин";
                break;
            case ("class main.java.Apple"):
                sort = "яблоко";
                break;
            default:
                sort = "неизвестный фрукт";
                break;
        }

        if (getFresh()) {
            return ("свежий " +  sort);
        } else {
            return ("не первой свежести " +  sort);
        }

    }
}
