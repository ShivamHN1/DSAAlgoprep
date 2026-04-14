import java.util.Scanner;
public class cube {
    public static int cube(int n) {
        return n * n * n;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scn.nextInt();
        int result = cube(num);
        System.out.println("The cube of " + num + " is: " + result);
    }
}
