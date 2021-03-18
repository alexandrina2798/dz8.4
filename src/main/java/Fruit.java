package main.java;

public class Fruit {

    String sort = String.valueOf(getClass());

    boolean fresh = true;

    public void setFresh(boolean fresh){
        this.fresh = fresh;
    }

    public boolean getFresh(){
        return this.fresh;
    }

    @Override
    public String toString() {
        switch (sort){
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

        if (getFresh()){
            return ("свежий " +  sort);
        } else {
            return ("не первой свежести " +  sort);
        }

    }
}
