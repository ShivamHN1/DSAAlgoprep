import java.util.Scanner;
public class addition {
    public static int add(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = scn.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scn.nextInt();
        int result = add(num1, num2);
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + result);
    }
}
