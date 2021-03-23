package main.java;

public class BoxUtil {

    // скопировать содержимое из одной коробки в другую
    //Box(dest) в которую будем копировать может быть типизирована любым родителем объекта содержащимся в Box(src)
    public static <T> void copyFromBoxToBox(final Box<?> src, final Box<T> dest) {
        try {
            dest.put((T) src.get());
        }        catch (NullPointerException e) {
            System.out.println("Невозможно выполнить: в коробке пусто");
        }
    }

    // скопировать содержимое из Box(src) которая может быть типизирована только классом Fruit и его наследниками,
    // при условии, что содержащийся фрукт свежий (fresh == true).
    //Box(dest) в которую будем копировать может быть типизирована любым родителем объекта содержащимся в Box(src)
    public static <T> void copyFreshFruitFromBoxToBox(final Box<?> src, final Box<T> dest) {
        try {
            Box<Fruit> box1 = (Box<Fruit>) src;
            if (box1.get().getFresh()) {
                dest.put((T) box1.get());
            }
        }        catch (NullPointerException e) {
            System.out.println("Невозможно выполнить: в коробке пусто");
        }
    }

    //вывести в консоль (toString()) объект второй коробки
    public static <T extends Box<T>> void printElementFromTwoBoxes(final Box<T> box) {
        System.out.println("Внутри коробки " + box + " коробка " + box.get());
        try {
            System.out.println("А внутри коробка " + box.get().get().toString() + "!");
        } catch (ClassCastException exception) {
            System.out.println("А внутри " + box.get().get() + "!");
        }

    }

    /**
     * вывести в консоль (toString()) объект последней коробки
     *
     * box Box, которая содержит в себе любое кол-во вложенных Box, в последней из которых может быть любой объект.
     * @param box
     */

    public static <T extends Box<T>> void printElementFromBoxes(final Box<?> box) {
        Box<?> tempoBox = box;
        int error = 0;
        while (error == 0) {
            try {
                tempoBox = (Box<Apple>) ((Box<?>) tempoBox).get();
            } catch (ClassCastException exception) {
                error += 1;
            }

        }
        System.out.println("в последней коробке лежит " + tempoBox.get());

    }
}
