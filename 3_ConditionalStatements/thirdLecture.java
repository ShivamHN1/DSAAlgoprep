public class thirdLecture {
    public static void main(String[] args) {
        // 1. Lets review the decimal digits and data types a bit in depth this time.
        // The Default decimal type : double
        // 1.1 The double data type is a double-precision 64-bit IEEE 754 floating point. It is used to store decimal numbers with a high degree of precision. The double data type can store values ranging from approximately 4.9e-324 to 1.7e+308, with a precision of about 15-17 decimal digits. It is commonly used for scientific calculations, financial applications, and any situation where a high level of precision is required for decimal numbers.
        // Code example for double:
        double pi = 3.141592653589793;
        System.out.println("Value of pi: " + pi);
        // 1.2 The float data type is a single-precision 32-bit IEEE 754 floating point. It is used to store decimal numbers with less precision than double. The float data type can store values ranging from approximately 1.4e-45 to 3.4e+38, with a precision of about 6-7 decimal digits. It is often used in situations where memory conservation is important, such as in graphics programming or when working with large arrays of decimal numbers.
        // Code example for float:
        float radius = 5.0f;
        System.out.println("Value of radius: " + radius);
        // As we can see above, for float data type we need to add 'f' at the end of the number to indicate that it is a float literal. If we don't add 'f', it will be treated as a double by default, which can lead to a compilation error when trying to assign it to a float variable.

        // Precision Differences: Why This Matters
        // float: Provides about 6-7 decimal places of precision
        // double: Provides about 14-15 decimal places of precision
        // For most applications, this difference doesn't matter. But in scientific computing, financial calculations, or when you're doing many chained operations, the extra precision of double prevents rounding errors from accumulating.

        // Practical Examples
        // All of these are double (the default)
        System.out.println(2.2);      // double: 2.2
        System.out.println(1.3);      // double: 1.3
        System.out.println(3.76);     // double: 3.76
        System.out.println(3.14159);  // double: 3.14159

        // These are explicitly float (with the f suffix)
        float temperature = 36.5f;     // explicitly float
        float discount = 0.15f;        // explicitly float

        // These are double (can also be explicit)
        double price = 99.99;          // implicitly double
        double decimal = 3.14159265;        // implicitly double

        // Example of precision difference
        double a = 1.0 / 3.0; // double precision
        float b = 1.0f / 3.0f; // float precision
        System.out.println("Double precision (a): " + a); // More precise
        System.out.println("Float precision (b): " + b);  // Less precise   

        // Example of Implicit Casting
        int m = 100;
        long n = m;  // automatic: a is converted to long
        System.out.println(n);  // 100

        // Example of Explicit Casting
        long x = 100000L;
        int y = (int) x;  // explicit cast required
        System.out.println(y);  // 100000 (fits fine)

        long hugeNumber = 999999999999L;
        int small = (int) hugeNumber;  // explicit cast required
        System.out.println(small);  // might print cryptic result due to overflow

        // Casting with Decimals
        double piDouble = 3.141592653589793;
        float piFloat = (float) piDouble;  // explicit cast from double to float
        System.out.println("Double precision (piDouble): " + piDouble);
        System.out.println("Float precision (piFloat): " + piFloat);
        // As you can see, piDouble retains more decimal places than piFloat due to the precision difference between double and float.

        // Operation Rules with Mixed Types
        // Sometimes we have to perform operations with mixed types. In such cases, some Rules apply:
        
        // R1. Mixed Category Operations always promote to the larger category. For example, if you add an int and a double, the result will be promoted to double.
        int wholeNumbers = 10;
        double decimals = 3.5;
        double result = wholeNumbers + decimals;
        // The int (10) is converted to double (10.0)
        // 10.0 + 3.5 = 13.5
        System.out.println(result);  // 13.5

        // R2: Same Category, Different Sizes: Result Is the Larger Size: If you perform an operation between two types of the same category but different sizes (e.g., int and long, float and double), the result will be promoted to the larger size (long and double in this case).
        int smallInt = 5;
        long largeLong = 100000L;
        long result2 = smallInt + largeLong;  // smallInt is promoted to long
        System.out.println(result2);  // 100005
        float smallFloat = 2.5f;
        double largeDouble = 3.14159;
        double result3 = smallFloat + largeDouble;  // smallFloat is promoted to double
        System.out.println(result3);  // 5.64159

        /*
        Why these rules matter ? 
        - Integer Overflow is a common issue when performing operations with smaller integer types (like byte or short). If the result exceeds the maximum value of the type, it wraps around to the minimum value, leading to incorrect results. For example, adding 1 to a byte with a value of 127 will result in -128 due to overflow.
        - Precision Loss can occur when performing operations with mixed types, especially when converting from a larger type to a smaller type (e.g., double to float). This can lead to loss of precision and inaccurate results, especially in scientific calculations or financial applications where precision is crucial.
        */

        // One Catch with Arithmetic Operations: Integer Division
        // When you divide two integers, the result is an integer (the fractional part is discarded). This can lead to unexpected results if you're not careful.
        int a1 = 5;
        int b1 = 2;
        int result4 = a1 / b1;  // This will perform integer division
        System.out.println(result4);  // Output will be 2, not 2.5

        // Getting Decimal Division: Involve a Decimal Type(Float or Double)
        System.out.println(5/2);
        System.out.println(5.0/2);  // 5.0 is a double, so the result is promoted to double
        System.out.println(5/2.0);  // 2.0 is a double, so the result is promoted to double
        System.out.println(5.0/2.0) ; // Both are double, so the result is double

        // The Modulo Operator (%): Getting the Remainder
        // The modulo operator (%) gives you the remainder of a division operation. It is useful for checking if a number is even or odd, for wrapping around values, and for various other applications.
        int dividend = 10;
        int divisor = 3;
        int quotient = dividend / divisor;  // This will give you the integer quotient
        int remainder = dividend % divisor;  // This will give you the remainder
        System.out.println("Quotient: " + quotient);  // Output will be 3
        System.out.println("Remainder: " + remainder);  // Output will be 1
        // or simply
        System.out.println(7%4);  // Output will be 3, because 7 divided by 4 gives a quotient of 1 and a remainder of 3

        // The Catch is Comparision Operators :
        // The critical distinciton between the assignment operator (=) and the equality operator (==) is that the assignment operator is used to assign a value to a variable, while the equality operator is used to compare two values for equality. Using the wrong operator can lead to syntax errors or logical errors in your code. For example, if you accidentally use = instead of == in an if statement, you will be assigning a value instead of comparing it, which can lead to unintended consequences.
        int numx = 12;
        if (numx == 12) {  // Correct: using == for comparison
            System.out.println("numx is equal to 12");
        }

        // Conditional Statements: If-Else
        // Conditional statements allow you to execute different blocks of code based on certain conditions. The most common conditional statement is the if-else statement, which allows you to execute one block of code if a condition is true, and another block of code if the condition is false.
        int age = 20;
        if (age >= 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are a minor.");
        }
        // Now, let's take a closer look at the if-else statement. The syntax is as follows:
        /*
        if (condition) {
            // code to execute if condition is true
            // If the condition evaluates to true, this block of code will be executed.
            // You can have multiple statements here, and they will all be executed if the condition is true.
            // If the condition is false, this block of code will be skipped, and the program will move on to the else block (if it exists).
        }
        also the '(condition)' is a boolean expression that evaluates to either true or false. It can be a simple comparison (e.g., age >= 18) or a more complex expression involving logical operators (e.g., (age >= 18 && hasID)), it just simply needs to evaluate to a boolean value.
        


        */ 
    }
}