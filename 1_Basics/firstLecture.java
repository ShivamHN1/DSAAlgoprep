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

        // 6. Operators in Java:
        // Java provides various operators for performing operations on variables and values. These include:
        // Arithmetic Operators: +, -, *, /, %
        // Relational Operators: ==, !=, >, <, >=, <=
        // Logical Operators: &&, ||, !
        // Assignment Operators: =, +=, -=, *=, /=, %=
        // Example of using operators:
        int g = 10;
        int h = 5;
        // Arithmetic Operators in Java:
        System.out.println("g + h = " + (g + h)); // Output: g + h = 15 as addition is being performed and the '+' operator is called the addition operator. It takes two operands (g and h) and returns their sum. In this case, it adds 10 and 5 to get 15.
        System.out.println("g - h = " + (g - h)); // Output: g - h = 5 as subtraction is being performed and the '-' operator is called the subtraction operator. It takes two operands (g and h) and returns their difference. In this case, it subtracts 5 from 10 to get 5.
        System.out.println("g * h = " + (g * h)); // Output: g * h = 50 as multiplication is being performed and the '*' operator is called the multiplication operator. It takes two operands (g and h) and returns their product. In this case, it multiplies 10 and 5 to get 50.
        System.out.println("g / h = " + (g / h)); // Output: g / h = 2 as division is being performed and the '/' operator is called the division operator. It takes two operands (g and h) and returns their quotient. In this case, it divides 10 by 5 to get 2.
        System.out.println("g % h = " + (g % h)); // Output: g % h = 0 as modulus is being performed and the '%' operator is called the modulus operator. It takes two operands (g and h) and returns their remainder. In this case, it finds the remainder when 10 is divided by 5.
        /*
        Note - Operator Precedence in Java:
        In Java, operators have a specific precedence that determines the order in which they are evaluated in an expression. For example, multiplication and division have higher precedence than addition and subtraction. This means that in the expression g + h * i, the multiplication will be performed before the addition. You can use parentheses to change the order of evaluation. For example, (g + h) * i will perform the addition first before the multiplication. Understanding operator precedence is important to ensure that your expressions are evaluated correctly and to avoid unexpected results in your Java programs.
        So , in simple format 
        1. Parentheses ()
        2. Unary operators (like !, ++, --)
        3. Multiplication *, Division /, Modulus %
        4. Addition +, Subtraction -
        5. Relational operators (==, !=, >, <, >=, <=)
        6. Logical operators (&&, ||)
        Also, when operators have the same precedence, they are evaluated from left to right. For example, in the expression g - h + i, both subtraction and addition have the same precedence, so they will be evaluated from left to right, resulting in (g - h) + i. Understanding operator precedence and associativity is crucial for writing correct and efficient Java code.
        Another Note - Learning precedence properly involes a lot of stuff for most of the time knowing precedence withing the arithmetic operators like *, /, % and +, - is sufficient for most of the cases. So, you can focus on those operators first and then gradually learn about the precedence of other operators as you progress in your Java programming journey.
        And simply use parantheses to ensure the correct order of evaluation in complex expressions, which can help you avoid confusion and make your code more readable and keep the code as simple as possible unless doing micro optimization is required.
        */

        // Relational Operators in Java:
        System.out.println("g == h: " + (g == h)); // Output: g == h: false as equality comparison is being performed and the '==' operator is called the equality operator. It takes two operands (g and h) and returns true if they are equal, false otherwise. In this case, it compares 10 and 5 and returns false.
        System.out.println("g != h: " + (g != h)); // Output: g != h: true as inequality comparison is being performed and the '!=' operator is called the inequality operator. It takes two operands (g and h) and returns true if they are not equal, false otherwise. In this case, it compares 10 and 5 and returns true.
        System.out.println("g > h: " + (g > h)); // Output: g > h: true as greater-than comparison is being performed and the '>' operator is called the greater-than operator. It takes two operands (g and h) and returns true if g is greater than h, false otherwise. In this case, it compares 10 and 5 and returns true.
        System.out.println("g < h: " + (g < h)); // Output: g < h: false as less-than comparison is being performed and the '<' operator is called the less-than operator. It takes two operands (g and h) and returns true if g is less than h, false otherwise. In this case, it compares 10 and 5 and returns false.
        System.out.println("g >= h: " + (g >= h)); // Output: g >= h: true as greater-than-or-equal comparison is being performed and the '>=' operator is called the greater-than-or-equal operator. It takes two operands (g and h) and returns true if g is greater than or equal to h, false otherwise. In this case, it compares 10 and 5 and returns true.
        System.out.println("g <= h: " + (g <= h)); // Output: g <= h: false as less-than-or-equal comparison is being performed and the '<=' operator is called the less-than-or-equal operator. It takes two operands (g and h) and returns true if g is less than or equal to h, false otherwise. In this case, it compares 10 and 5 and returns false.

        // Logical Operators in Java:
        System.out.println("g > 0 && b > 0: " + (g > 0 && b > 0)); // Output: g > 0 && b > 0: true as logical AND is being performed and the '&&' operator is called the logical AND operator. It takes two operands (g > 0 and b > 0) and returns true if both are true, false otherwise. In this case, it checks if both 10 and 5 are positive and returns true.
        System.out.println("g > 0 || b < 0: " + (g > 0 || b < 0)); // Output: g > 0 || b < 0: true as logical OR is being performed and the '||' operator is called the logical OR operator. It takes two operands (g > 0 and b < 0) and returns true if at least one is true, false otherwise. In this case, it checks if either 10 is positive or 5 is negative and returns true.
        System.out.println("!(g > h): " + !(g > h)); // Output: !(g > h): false as logical NOT is being performed and the '!' operator is called the logical NOT operator. It takes one operand (g > h) and returns the opposite boolean value. In this case, it negates the result of the comparison between 10 and 5.

        // Assignment Operators in Java:
        int a = 10; // Simple assignment
        a += 5; // Equivalent to a = a + 5; Output: a = 15
        a -= 3; // Equivalent to a = a - 3; Output: a = 12
        a *= 2; // Equivalent to a = a * 2; Output: a = 24
        a /= 4; // Equivalent to a = a / 4; Output: a = 6
        a %= 5; // Equivalent to a = a % 5; Output: a = 1
        System.out.println("Final value of a: " + a); // Output: Final value of a: 1
    }
}