package pl.karol.java.functional.chapter3.exercise1;

import java.util.function.Function;
import java.util.regex.Pattern;

public class EmailValidator {
    final static Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");

    final static Function<String, Result> emailChecker = mail -> {
        if (mail == null) {
            return Result.failure("E-mail nie może być NULL");
        } else if (mail.isEmpty()) {
            return Result.failure("E-mail nie może być pusty");

        } else if (emailPattern.matcher(mail).matches()) {
            return Result.success(mail);
        } else {
            return Result.failure("E-mail " + mail + " jest nie prawidłowy");

        }
    };

    Result validate(String mail) {
        return emailChecker.apply(mail);
    }

}