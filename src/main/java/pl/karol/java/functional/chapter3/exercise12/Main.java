package pl.karol.java.functional.chapter3.exercise12;


public class Main {

    public static void main(String[] args) {
        System.out.println("range: " + CollectionUtilites.unflold(1, i -> ++i, i -> i < 10));
    }

}
