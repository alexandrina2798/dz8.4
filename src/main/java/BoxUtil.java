package main.java;

public class BoxUtil {

    // скопировать содержимое из одной коробки в другую
    //Box(dest) в которую будем копировать может быть типизирована любым родителем объекта содержащимся в Box(src)
    public static <T> void copyFromBoxToBox(Box<T> src, Box<T> dest) {
        Box <T> box1 = src;
        Box <T> box2 = dest;
        box2.put(box1.get());
    }

    // скопировать содержимое из Box(src) которая может быть типизирована только классом Fruit и его наследниками,
    // при условии, что содержащийся фрукт свежий (fresh == true).
    //Box(dest) в которую будем копировать может быть типизирована любым родителем объекта содержащимся в Box(src)
    public static <T> void copyFreshFruitFromBoxToBox(Box<T> src, Box<T> dest) {
        Box <Fruit> box1 = (Box<Fruit>) src;
        Box <T> box2 = dest;
        if (box1.get().getFresh()){
            box2.put((T) box1.get());
        }
    }

    //вывести в консоль (toString()) объект второй коробки
    public static <T extends Box<T>> void printElementFromTwoBoxes(Box<T> box) {
        System.out.println("Внутри коробки " + box + " коробка "+ box.get());
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
     */
    public static <T extends Box<T>> void printElementFromBoxes(Box<T> box) {
        Box<T> tempoBox = box;
        int error = 0;
        while (error == 0) {
            try {
                tempoBox = tempoBox.get();
            } catch (ClassCastException exception) {
                error+=1;
            }

        }
        System.out.println("в последней коробке лежит " + tempoBox.get());

    }
}
