package pl.karol.java.functional.chapter3.exercise1;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        EmailValidator emailValidator = new EmailValidator();

        emailValidator.validate("karoll.gajda@gmail.com").bind(success, logError);
        emailValidator.validate("karo").bind(success, logError);
        emailValidator.validate("").bind(success, logError);
        emailValidator.validate(null).bind(success, logError);
    }


    static Consumer<String> success = s -> System.out.println("E-mail został wysłany: " + s);
    static Consumer<String> logError = s -> System.err.println("Błąd: " + s);

}
