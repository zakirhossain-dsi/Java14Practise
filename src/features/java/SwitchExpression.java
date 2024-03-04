/*
package features.java;

import java.util.Scanner;

public class SwitchExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter day of week: ");
        String day = scanner.next().toUpperCase();

        String result = switch (day){
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "WEEKDAY";
            case "SATURDAY", "SUNDAY" -> "WEEKEND";
            default -> {
                if(day.isEmpty()) {
                    yield "Please enter a name of a day.";
                }else {
                    yield "Invalid day.";
                }
            }
        };

        System.out.println(result);
    }
}
*/
