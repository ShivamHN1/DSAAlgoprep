import java.util.Scanner;
// Program Structure and Flow of Control in Java
// In Java, the structure of a program is defined by classes and methods. The main method is the entry point of the program, where the execution starts. The flow of control in a Java program is determined by the sequence of statements and the use of control structures such as loops and conditional statements.
// Every Java program MUST have a main method. This is where your code starts executing:
/* 
public class FirstProgram {
    public static void main(String[] args) {
        // Your code starts here
    }
}
*/
/*
    # Breaking down the main method signature:

    - public             → Anyone can access this method
    - static             → Belongs to the class, not an instance (we'll learn this later)
    - void               → This method doesn't return any value
    - main(String[] args) → The special starting point; args receives command-line inputs
    - Why this exact structure? Java looks specifically for public static void main(String[] args) to know where to start. If you change it, your program won't run.
*/

public class firstLecture {
    public static void main (String[] args) {
        // The standard input and output in Java is handled through the System class.

        // 1. Standard Output in Java:
        // System.out.println() is used to print output to the console.
        System.out.println("Hello World!");
        // Printing without a newline
        System.out.print("Hello ");
        System.out.print("World!");
        System.out.println("-------");
        // Syntax of the print statement in detail with explanation
        // Syntax : System.out.println(message);
        // Here, "message" can be a string, a variable, or any expression that evaluates to a value. The println() method will print the message followed by a newline character, which means that the next output will be printed on a new line.
        // Other things it can take as input:
        // 1.1 Escape Characters/Escape Sequences in Java:
        // 1.1.1 - Tab(indentation) \t : This is a tab character, which adds a horizontal space in the output.
        // 1.1.2 - Newline (Starts a New Line)\n : This is a newline character, which moves the cursor to the next line in the output.
        // 1.1.3 - Backspace \b : This is a backspace character, which moves the cursor one position back in the output.
        // 1.1.4 - Carriage Return \r : This is a carriage return character, which moves the cursor to the beginning of the current line in the output.
        // 1.1.5 - Form Feed \f : This is a form feed character, which moves the cursor to the next page in the output.
        // 1.1.6 - Backslash(inside string) \\ : This is an escape character for the backslash itself, allowing you to print a single backslash in the output.
        // 1.1.7 - Double Quote(inside string) \" : This is an escape character for the double quote, allowing you to print a double quote in the output.
        // 1.1.8 - Single Quote(inside string) \' : This is an escape character for the single quote, allowing you to print a single quote in the output.

        // How to use the above characters in the print statement:
        // Newline example
        System.out.println("First line\nSecond line");
        // Output:
        // First line
        // Second line

        // Tab example
      System.out.println("Name\tAge\nAlice\t25\nBob\t30");
        // Output:
        // Name    Age
        // Alice   25
        // Bob     30

        // Quote example
        System.out.println("He said \"Java is fun!\"");
        // Output: He said "Java is fun!"


        // System.out.println() is a method that belongs to the System class in Java.
        // The System class is part of the java.lang package, which is automatically imported in every Java program.
        // The println() method is used to print a message to the console, followed by a newline character. This means that after printing the message, the cursor moves to the next line.
        // The print() method, on the other hand, does not add a newline character after printing the message, so the cursor remains on the same line.

        // 1.2 - Concatenation in Java(String Concatenation):
        // Concatenation is the process of combining two or more strings together. In Java, you can concatenate strings using the + operator. For example:
        String firstName = "John";
        String lastName = "Doe";
        String fullName = firstName + " " + lastName; // Concatenating firstName and lastName with a space in between
        System.out.println(fullName); // Output: John Doe

        // 2. Standard Input in Java:
        // The standard input in Java is handled through the Scanner class.
        // To use the Scanner class, you need to import it first: import java.util.Scanner;
        // Then, you can create an object of the Scanner class: Scanner scn = new Scanner(System.in);
        // The System.in represents the standard input stream, which is typically the keyboard.
        // You can then use various methods of the Scanner class to read input from the user.
        // For example, scn.nextInt() reads an integer from the user, and scn.nextLine() reads a string from the user.
        // Syntax of the Scanner class in detail with explanation:
        // Scanner scn = new Scanner(System.in);
        // Here, we are creating an object named "scn" of the Scanner class. The Scanner class is used to read input from various sources, including the standard input (keyboard).
        // The System.in is passed as an argument to the Scanner constructor, which tells the Scanner to read input from the standard input stream. Once you have created the Scanner object, you can use its methods to read different types of input from the user, such as integers, strings, etc.
        // Taking input can be done using various methods of the Scanner class, such as:
        // scn.nextInt() - Reads an integer from the user.
        // scn.nextLine() - Reads a line of text from the user.
        // scn.nextDouble() - Reads a double value from the user.
        // scn.next() - Reads a single word from the user.
        // Example of taking input from the user:
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int x = scn.nextInt();
        scn.close(); // It's a good practice to close the Scanner object when you're done using it to free up system resources.
        System.out.println("You entered: " + x);

        // 3. Commenting in Java:
        // Comments are used to explain the code and make it more readable. They are ignored by the compiler and do not affect the execution of the program. In Java, there are two types of comments:
        // 1. Single-line comments: These comments start with // and continue until the end of the line. For example:
        // This is a single-line comment
        // 2. Multi-line comments: These comments start with /* and end with */. They can span multiple lines. For example:
        /* This is a multi-line comment
            It can span multiple lines
            and is useful for providing detailed explanations or commenting out blocks of code. */
        // It's important to use comments effectively to improve the readability and maintainability of your code.

        // 4. Variables in Java:
        // A variable is a named storage location in memory that can hold a value. In Java, you need to declare a variable before using it. The syntax for declaring a variable is:
        // dataType variableName;
        // For example:
        int age; // Declaring an integer variable named "age"
        age = 25; // Assigning a value to the variable "age"
        System.out.println("Age: " + age); // Output: Age: 25
        // Assignment can also be done at the time of declaration:
        int height = 180; // Declaring and assigning a value to the variable "height"
        System.out.println("Height: " + height); // Output: Height: 180

        // 5. Data Types in Java:
        // Java has several primitive data types, including:
        // byte: 8-bit signed integer (-128 to 127)
        // short: 16-bit signed integer (-32,768 to 32,767)
        // int: 32-bit signed integer (-2,147,483,648 to 2,147,483,647)
        // long: 64-bit signed integer (-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807)
        // float: 32-bit floating-point number (approximately 6-7 decimal digits of precision)
        // double: 64-bit floating-point number (approximately 15-16 decimal digits of precision)
        // char: 16-bit Unicode character
        // boolean: Represents true or false values
        // Each data type has a specific range of values it can hold. For example, an int can hold values from -2,147,483,648 to 2,147,483,647.
        // Example of using different data types:
        byte b = 100;
        short s = 10000;
        int i = 100000;
        long l = 10000000000L; // Note the 'L' at the end to indicate a long literal
        float f = 3.14f; // Note the 'f' at the end to indicate a float literal
        double d = 3.14159; // Double literal
        char c = 'A'; // Character literal
        String str = "Namaste Duniya"; // String literal
        boolean bool = true; // Boolean literal
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("String: " + str);
        System.out.println("boolean: " + bool);
        // Why do we need different data types? Different data types allow us to store different kinds of data efficiently. For example, if you only need to store small integers, using a byte or short can save memory compared to using an int or long. Similarly, using a float instead of a double can save memory when you only need a few decimal places of precision. Using the appropriate data type for your variables can help optimize memory usage and improve performance in your Java programs.
    }
}