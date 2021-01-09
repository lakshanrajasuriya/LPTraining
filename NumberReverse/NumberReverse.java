import java.util.Scanner;
//import java.lang.Object;
//import java.lang.Number;
import java.lang.Integer;

public class NumberReverse {

 public static void main(String [] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int number = scanner.nextInt();
 // int y = Integer.reverse(number);
 // int yy = Integer.rotateRight(number,1);
 // int j=number.byteValue();
 // Byte xx=new Byte(y);

  int reverseNumber=Integer.reverseBytes(number);
//  System.out.println("Reverse Number: " + reverseNumber);
 }
}