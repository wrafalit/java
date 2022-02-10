import java.util.Scanner;

public class MyClass {
    public static void main(String args[]) {
      System.out.println("Give a year: ");
      Scanner reader = new Scanner(System.in);
      int year = Integer.valueOf(reader.nextLine());
      
      if (year % 4 == 0) {
          if (year % 100 == 0) {
              if (year % 100 == 0) {
                  System.out.println("The year is a leap year.");
              } else {
                  System.out.println("The year is not a leap year.");
              }
          } else {
              System.out.println("The year is a leap year.");
          }
      } else {
          System.out.println("The year is not a leap year.");
      }
    }
}
