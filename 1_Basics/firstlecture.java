public class firstlecture{
    public static void main(String[] args) {
        System.out.println("Hello World");
        // This is a single line comment
        /*
         * This is a multi line comment
         * This is the second line of the multi line comment
         */
        // In Java the main method is the entry point of the program
        // The main method must be declared as public static void main(String[] args)
        // The main method is the starting point of the program and is executed when the program is run
        // The main method can be used to call other methods and perform various operations
        // In Java, we can use the System.out.println() method to print output to the console
        // The System.out.println() method is used to print a line of text to the console

        // The System.out.print() method is used to print text to the console without a new line
        System.out.print("see this is printed without a new line");
        System.out.print(" see this is printed on the same line");
        // The System.out.printf() method is used to print formatted text to the console
        System.out.printf("The value of x is %d", 5);
        // The %d is a format specifier that is used to indicate that the value being printed is an integer, we will learn about format specifiers in more detail in the future lectures
    }
}
