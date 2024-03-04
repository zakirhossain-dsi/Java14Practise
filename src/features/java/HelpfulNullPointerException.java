package features.java;

/*
* Advantages:
* No need to debug the code
* Easily fix the exception
* VM Options:
* -XX:+ShowCodeDetailsInExceptionMessages
*
*/
public class HelpfulNullPointerException {
    public static void main(String[] args) {
        String name = null;
        System.out.println(name.length());
    }
}
