package features.java;

import java.util.function.Function;

public class FunctionChaining {
    public static void main(String[] args) {
        Function<String, String> upperCase = s -> s.toUpperCase();
        Function<String, String> first9Character = s -> s.substring(0, 9);

        System.out.println(upperCase.apply("ZakirHossain"));
        System.out.println(first9Character.apply("ZakirHossain"));
        System.out.println(upperCase.andThen(first9Character).apply("ZakirHossain"));
        System.out.println(upperCase.compose(first9Character).apply("ZakirHossain"));
    }
}
