/*  
public class SecondLecture {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        
//         int x= 100000000;
//         System.out.println(x);
        
//         long y = 100000000000L;
//         System.out.println(y);
        
        // long x = 100000;
        // int y = (int)x; // explicitly typecasting 
        // System.out.println(y);
        
        // long x = 10000000000L;
        // int y = (int)x;
        // System.out.println(y);
        
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        System.out.println(x);
    }
}
*/ 

public class secondLecture {
    public static void main(String args[]) {
        // In the previous lecture we have seen the concept of variables and how to declare and initialize them in java. We have also seen the concept of input and output in java using the Scanner class and System.out.println() method along with the program flow in java. We have also seen the concept of comments in java and how to use them to make our code more readable and understandable. We have also seen the concept of data types in java and how to use them to declare variables of different types in java.. We have also seen the concept of input and output in java using the Scanner class and System.out.println() method along with the program flow in java.
        // In this lecture we will be learning about datatypes and operators in java along with seeing the concept of typecasting in java and revisiting the concept of variables with more depth this time.

        // 1. Variables in Java:
        // Concept of variables in java is very important as it is the basic building block of any programming language. A variable is a container that holds a value that can be changed during the execution of a program. In java, we can declare variables of different types such as int, long, float, double, char, boolean, etc. We can also initialize variables with a value at the time of declaration or later in the program. For example:
        int a = 10; // declaring and initializing an integer variable
        long b = 10000000000L; // declaring and initializing a long variable
        float c = 3.14f; // declaring and initializing a float variable
        double d = 3.141592653589793; // declaring and initializing a double variable
        char e = 'A'; // declaring and initializing a char variable
        boolean f = true; // declaring and initializing a boolean variable
        // Declaring variables without initializing them:
        int x; // declaring an integer variable without initializing it
        long y; // declaring a long variable without initializing it
        // Declaration of a variable is the process of creating a variable and specifying its type, while initialization is the process of assigning a value to a variable. It is important to note that in java, we cannot use a variable before it has been initialized, as it will result in a compile-time error. Therefore, it is good practice to initialize variables at the time of declaration or before using them in the program to avoid any errors and ensure that our code runs smoothly. Since, Java is a statically-typed language, we need to specify the type of a variable at the time of declaration, and once a variable is declared with a specific type, it cannot hold values of other types without explicit typecasting. This helps in catching errors at compile time and ensures type safety in our Java programs.
        // Initializing variables later in the program:
        x = 20; // initializing the integer variable x
        y = 20000000000L; // initializing the long variable y
        System.out.println("Value of a: " + a); // Output: Value of a: 10
        System.out.println("Value of b: " + b); // Output: Value of b: 10000000000
        // Declaring multiple variables of the same type in a single line:
        int p = 1, q = 2, r = 3; // declaring and initializing multiple integer variables in a single line
        System.out.println("Value of p: "+ p); // Output: Value of p: 1
        System.out.println("Value of q: "+ q); // Output: Value of q: 2
        System.out.println("Value of r: "+ r); // Output: Value of r: 3
        // Declaration of a variable is the process of creating a variable and specifying its type, while initialization is the process of assigning a value to a variable. It is important to note that in java, we cannot use a variable before it has been initialized, as it will result in a compile-time error. Therefore, it is good practice to initialize variables at the time of declaration or before using them in the program to avoid any errors and ensure that our code runs smoothly. Since, Java is a statically-typed language, we need to specify the type of a variable at the time of declaration, and once a variable is declared with a specific type, it cannot hold values of other types without explicit typecasting. This helps in catching errors at compile time and ensures type safety in our Java programs.

        /* 
         Note - Variable Naming Conventions in Java:
            In Java, there are certain conventions for naming variables that help improve code readability and maintainability. Some of the common conventions include:
            1. Use meaningful names: Variable names should be descriptive and indicate the purpose of the variable. For example, instead of naming a variable 'x', you can name it 'age' if it holds the age of a person.
            2. Use camelCase: In Java, variable names should follow the camelCase convention, where the first word is in lowercase and subsequent words are capitalized. For example, 'firstName', 'totalAmount', etc.
            3. Avoid using reserved keywords: Java has a set of reserved keywords that cannot be used as variable names. For example, 'int', 'class', 'public', etc. are reserved keywords and cannot be used as variable names.
            4. Avoid using special characters: Variable names should not contain special characters such as @, #, $, %, etc. They should only contain letters, digits, and underscores.
            5. Avoid using spaces: Variable names should not contain spaces. If you want to use multiple words in a variable name, you can use camelCase or underscores to separate the words. For example, 'first_name' or 'firstName' are valid variable names, while 'first name' is not valid.
            6. Be consistent: It is important to be consistent with your variable naming conventions throughout your codebase. This helps improve code readability and makes it easier for other developers to understand your code. For example, if you choose to use camelCase for variable names, make sure to use it consistently for all variable names in your code.
            7. Avoid using single-letter variable names: While it may be tempting to use single-letter variable names for simplicity, it is generally not recommended as it can make your code less readable and harder to understand. It is better to use meaningful variable names that convey the purpose of the variable, even if it means using longer names. For example, instead of using 'x' as a variable name, you can use 'totalPrice' or 'numberOfItems' to make it clear what the variable represents.
        */
        /*
            Note - Variable Scope in Java:
                In Java, the scope of a variable refers to the region of the program where the variable is accessible and can be used. There are three main types of variable scope in Java:
                1. Local Variables: Local variables are declared within a method or a block of code and are only accessible within that method or block. They are created when the method is called and destroyed when the method finishes executing. Local variables cannot be accessed outside of their scope.
                2. Instance Variables: Instance variables are declared within a class but outside of any method. They are associated with an instance of the class and can be accessed by all methods within the class. Each instance of the class has its own copy of the instance variables.
                3. Static Variables: Static variables are declared within a class with the 'static' keyword. They are shared among all instances of the class and can be accessed without creating an instance of the class. Static variables are also known as class variables and are initialized only once when the class is loaded.
                Understanding variable scope is important for writing efficient and maintainable code in Java. It helps prevent naming conflicts and allows you to control the visibility and accessibility of variables in your program. It is good practice to declare variables with the appropriate scope to ensure that they are only accessible where they are needed and to avoid unintended side effects in your code.
        */
       /*
          How does variable work behind the scenes in Java:
            When a variable is declared in Java, the Java Virtual Machine (JVM) allocates memory for that variable based on its data type. The memory allocated for a variable is used to store the value assigned to that variable during the execution of the program. The JVM keeps track of the variables and their values in a data structure called the symbol table. When a variable is accessed or modified in the code, the JVM looks up the variable in the symbol table to retrieve its value or update it accordingly. The JVM also manages the scope of variables, ensuring that they are only accessible within their defined scope. This allows for efficient memory management and helps prevent naming conflicts between variables in different scopes. Overall, variables play a crucial role in storing and manipulating data in Java programs, and understanding how they work behind the scenes can help you write more efficient and effective code.
       */

        // 2. Operators in Java:
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
        int k = 10; // Simple assignment
        k += 5; // Equivalent to k = k + 5; Output: k = 15
        k -= 3; // Equivalent to k = k - 3; Output: k = 12
        k *= 2; // Equivalent to k = k * 2; Output: k = 24
        k /= 4; // Equivalent to k = k / 4; Output: k = 6
        k %= 5; // Equivalent to k = k % 5; Output: k = 1
        System.out.println("Final value of k: " + k); // Output: Final value of k: 1
        
        // Now, lets take a look at typecasting in java:
        // Typecasting in Java:
        // Typecasting is the process of converting a variable from one data type to another. In Java, there are two types of typecasting: implicit typecasting and explicit typecasting.
        // Implicit Typecasting: This occurs when a smaller data type is automatically converted to a larger data type. For example, when an int is assigned to a long variable, the int value is automatically converted to a long value without any explicit typecasting. This is also known as widening conversion. For example:
        int i = 100;
        long j = i; // Implicit typecasting from int to long
        System.out.println("Value of j: " + j); // Output: Value of j: 100
        // Explicit Typecasting: This occurs when a larger data type is explicitly converted to a smaller data type. For example, when a long is assigned to an int variable, we need to explicitly typecast the long value to an int value. This is also known as narrowing conversion. For example:
        long m = 10000000000L;
        int l = (int) m; // Explicit typecasting from long to int
        System.out.println("Value of l: " + l); // Output: Value of l: -727379968 (Note: This is an example of overflow, as the long value exceeds the maximum value that an int can hold, resulting in a loss of data and an incorrect value being assigned to l.)
        // It is important to note that when performing explicit typecasting, there is a risk of data loss if the value being casted exceeds the range of the target data type. Therefore, it is important to be cautious when using explicit typecasting and ensure that the value being casted is within the range of the target data type to avoid unexpected results in your Java programs.
        // And that risk about explicit typecasting is also why it is a more tedious process than implicit typecasting to be performed, as it requires the programmer to explicitly specify the type conversion and be aware of the potential risks involved. It is generally recommended to use implicit typecasting whenever possible to avoid data loss and ensure that your code is more robust and less prone to errors.

        // How does typecasting work behind the scenes in Java:
        // When a typecasting operation is performed in Java, the Java Virtual Machine (JVM) checks the data types involved in the typecasting and determines whether it is an implicit or explicit typecasting operation. For implicit typecasting, the JVM automatically converts the smaller data type to the larger data type without any loss of data. For explicit typecasting, the JVM checks if the value being casted is within the range of the target data type. If it is within the range, the JVM performs the typecasting and assigns the value to the target variable. However, if the value exceeds the range of the target data type, the JVM may result in data loss or overflow, leading to unexpected results. The JVM also manages the memory allocation for the variables involved in the typecasting operation and ensures that the typecasting is performed correctly based on the rules of Java's type system. Overall, typecasting is an important aspect of Java programming that allows for flexibility in handling different data types, but it should be used with caution to avoid potential issues related to data loss and overflow. Understanding how typecasting works behind the scenes can help you write more efficient and error-free Java code when dealing with different data types in your programs.
    }
// Lesson Concluded!
}
