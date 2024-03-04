package features.java;

import java.util.function.Function;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Function<String, String> removeSpace = s -> s.replaceAll(" ", "");
        System.out.println(removeSpace.apply("Md. Zakir Hossain"));
    }
}
