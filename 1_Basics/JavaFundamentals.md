# Java Fundamentals - A Beginner's Guide

## Quick Reference (1-Minute Recall)

- Computer follows exact steps, not intent.
- Java starts at `main(String[] args)`.
- Code runs top to bottom.
- Output: `System.out.println(...)`.
- `+` does math with numbers, joins with strings.
- Operator order: `()`, `* / %`, `+ -`.
- Data types: `int`, `double`, `boolean`, `char`, `String`.
- Variable flow: declare -> initialize -> use -> reassign.
- Assignment direction: right -> left.
- Input: `Scanner scn = new Scanner(System.in);` then `nextInt()`, `nextLine()` etc.
- Avoid common bugs: integer division, quote mismatch, uninitialized variables.

## Understanding the Basics

### Why Computers Are "Dumb"

Computers are incredibly literal machines. They don't think for themselves—they need explicit, step-by-step instructions to do anything. Think of it like giving driving directions:

**Example:** If you tell someone to "make tea," they understand the concept. But a computer needs exactly this:
```
a. Get up from bed
b. Go to the kitchen  
c. Get a glass
d. Fill the glass with water
e. Bring the glass to me
f. Heat the water
g. Add tea leaves
... and so on
```

That's why we have programming languages—they provide the exact syntax and rules for communicating with computers.

---

## Java Syntax and Rules

### Why Grammar Matters

Just like English has grammatical rules, **Java has syntax rules**. If you violate them, your code won't compile.

**Key Point:** Java won't let you run broken code. The compiler will complain first.

### Common Java Tools

- **IDE (Integrated Development Environment):** Software that helps you write Java
  - Eclipse, IntelliJ, VS Code, etc.
  - Provides: editor, compiler, debugger all in one place

---

## Java Program Structure and Flow

### The Main Method - Your Program's Entry Point

Every Java program MUST have a `main` method. This is where your code starts executing:

```java
public class FirstProgram {
    public static void main(String[] args) {
        // Your code starts here
        System.out.println("Hello, World!");
    }
}
```

**Breaking down the main method signature:**

```
public             → Anyone can access this method
static             → Belongs to the class, not an instance (we'll learn this later)
void               → This method doesn't return any value
main(String[] args) → The special starting point; args receives command-line inputs
```

**Why this exact structure?** Java looks specifically for `public static void main(String[] args)` to know where to start. If you change it, your program won't run.

### How a Java Program Executes

```
1. You write code in a .java file (e.g., MyProgram.java)
   ↓
2. Compiler converts it to bytecode (.class file)
   ↓
3. Java Virtual Machine (JVM) runs the bytecode
   ↓
4. JVM calls main() method
   ↓
5. Your code executes line by line from top to bottom
   ↓
6. Program ends when main() finishes
```

### What Happens Inside Main?

Code inside `main()` executes sequentially:

```java
public static void main(String[] args) {
    System.out.println("Line 1");  // Runs 1st
    System.out.println("Line 2");  // Runs 2nd
    System.out.println("Line 3");  // Runs 3rd
}  // Program ends here
```

Output:
```
Line 1
Line 2
Line 3
```

---

## Comments - Explaining Your Code

### What Are Comments?

Comments are text that Java ignores—they're for YOU and other programmers to read.

### Single-line Comments

Use `//` for comments on a single line:

```java
// This is a comment
int age = 25;  // This variable stores a person's age

// System.out.println("Temporarily disabled");
```

### Multi-line Comments

Use `/* */` for longer comments:

```java
/* This is a multi-line comment
   It can span multiple lines
   Very useful for explaining complex logic */
int calculation = 5 + 3 * 2;
```

### Good Commenting Practices

✅ Good:
```java
// Calculate average of three numbers
int average = (num1 + num2 + num3) / 3;
```

❌ Bad:
```java
// Add the numbers and divide by 3
int average = (num1 + num2 + num3) / 3;  // This is obvious!
```

**Pro Tip:** Comment the "why," not the "what." Code shows what it does; comments should explain why it's done that way.

---

## Escape Sequences - Special Characters in Strings

### What Are Escape Sequences?

Sometimes you need special characters in your output. Escape sequences let you insert them:

| Sequence | What it Does | Example |
|----------|------------|----------|
| `\n` | Newline (starts a new line) | `"Hello\nWorld"` |
| `\t` | Tab (indentation) | `"Name\tAge"` |
| `\\` | Backslash | `"Path: C:\\Users"` |
| `\"` | Double quote (inside string) | `"He said \"Hello\""` |
| `\'` | Single quote (inside string) | `"It\'s Java"` |

### Examples

```java
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
```

---

## Output - Printing to Console

### The Golden Rule of Output

To print anything to the console in Java, use:
```java
System.out.println(something);
```

Breaking it down:
- `System` → predefined Java object
- `out` → pointing to console output
- `println()` → print line (adds newline after)

### Examples

**Printing numbers:**
```java
System.out.println(7);      // Prints: 7
System.out.println(10);     // Prints: 10
System.out.println(50);     // Prints: 50
System.out.println(100);    // Prints: 100
```

**Printing text (strings):**
```java
System.out.println("Hello");     // Prints: Hello
System.out.println("World");     // Prints: World
```

**Concatenation - Combining with the + operator:**
```java
System.out.println(7 + 10);           // Prints: 17 (mathematical addition)
System.out.println("7" + "10");       // Prints: 710 (string concatenation)
System.out.println("Answer: " + 42);  // Prints: Answer: 42
System.out.println(5 + 5 + " is ten"); // Prints: 10 is ten
```

**Key Point:** When you use `+` between numbers, it adds. When you use `+` with strings, it concatenates (joins).

---

## Operators

### Understanding BODMAS

Just like in math class, Java follows an order of operations (BODMAS/PEMDAS):

| Rank | Operation | Example |
|------|-----------|---------|
| 1 | Parentheses - `()` | `(5 + 3) * 2` evaluates parentheses first |
| 2 | Division `/` and Multiplication `*` | `10 / 2 * 3` → left to right |
| 3 | Addition `+` and Subtraction `-` | `5 + 3 - 2` → left to right |

**Example:**
```
5 + 5 * 6
= 5 + 30     (multiply first)
= 35
```

**Left-to-Right Processing:**
```
10 / 2 * 5
= 5 * 5      (left to right for same rank operators)
= 25
```

### Arithmetic Operators

```java
+ Addition       → 5 + 3 = 8
- Subtraction    → 10 - 4 = 6
* Multiplication → 7 * 2 = 14
/ Division       → 20 / 4 = 5
% Modulo (remainder) → 10 % 3 = 1
```

### Comparison Operators (Used for making decisions)

These operators compare values and return `true` or `false`. *We'll use these heavily with if/else statements, which we'll learn next.*

```java
== Equal to          → 5 == 5 is true
!= Not equal to      → 5 != 3 is true
<  Less than         → 3 < 5 is true
>  Greater than      → 5 > 3 is true
<= Less than or equal → 5 <= 5 is true
>= Greater than or equal → 10 >= 5 is true
```

### Assignment and Compound Operators

Quick ways to modify variable values:

```java
int x = 10;

x += 5;   // Same as: x = x + 5     → x becomes 15
x -= 3;   // Same as: x = x - 3     → x becomes 12
x *= 2;   // Same as: x = x * 2     → x becomes 24
x /= 4;   // Same as: x = x / 4     → x becomes 6
```

### Increment and Decrement Operators

Very common in loops (which we'll learn later):

```java
int count = 5;
count++;  // Increment by 1 → count becomes 6
count--;  // Decrement by 1 → count becomes 5
```

---

## Data Types

### What Are Data Types?

A data type tells Java what kind of value a variable will hold.

**Common Data Types:**

| Type | Description | Examples |
|------|-------------|----------|
| `int` | Whole numbers | 5, 42, -100, 0 |
| `double` | Decimal numbers | 3.14, 9.99, -2.5 |
| `boolean` | True or False | true, false |
| `char` | Single character | 'A', '5', '@' |
| `String` | Text/words (not primitive) | "Hello", "Java" |

---

## Variables - The Container Concept

### What is a Variable?

A variable is like a **labeled box** that stores a value. Think of it like this:

```
Variable name: "temperature"
Variable type: int (whole numbers)
Current value: 20
```

### Declaring vs Initializing

**Declaration** - Creating the variable (empty box):
```java
int temperature;    // I'm creating a box named "temperature" that holds integers
```

**Initialization** - Putting a value in the variable:
```java
temperature = 20;   // I'm putting the value 20 in the box
```

**Combined (Declare + Initialize):**
```java
int temperature = 20;   // Create the box and put 20 in it immediately
```

### Assignment - Changing Values

Once a variable exists, you can change its value:

```java
int temp = 20;           // temp contains 20
System.out.println(temp);  // Prints: 20

temp = 100;              // Change temp to 100
System.out.println(temp);  // Prints: 100

temp = 50;               // Change temp to 50
System.out.println(temp);  // Prints: 50
```

**Key Rule:** The value on the right side gets assigned to the variable on the left side.

### Example: Swapping Values

```java
int temp = 100;
System.out.println(temp);  // Prints: 100

temp = 20;                 // Reassign to 20
System.out.println(temp);  // Prints: 20
```

### Important: No Name Reuse

Once you declare a variable with a name, **you cannot declare it again** in the same scope:

```java
int temp = 20;
int temp = 30;  // ERROR! temp already exists
```

### Variable Naming Conventions

Follow these rules for variable names (Java enforces some, others are just best practice):

✅ **Do:**
```java
int age = 25;                    // Clear, descriptive
String firstName = "Alice";     // camelCase (first word lowercase, rest capitalized)
int numberOfStudents = 50;      // Readable, meaningful
```

❌ **Don't:**
```java
int a = 25;                   // Too vague
int Age = 25;                 // Wrong case (should be camelCase)
int number_of_students = 50;  // Python style, not Java
int 123invalid = 5;           // Can't start with a number
int int = 10;                 // Can't use Java keywords as names
```

---

## Input - Getting Data from Users

### Reading Input with Scanner

To get input from a user, we use the `Scanner` class:

```java
import java.util.Scanner;

Scanner scn = new Scanner(System.in);
```

**Breaking it down:**
- `Scanner` → object that reads input
- `System.in` → tells it to read from keyboard
- `scn` → the name we give to our Scanner

### Reading Different Types

**Reading an integer:**
```java
int number = scn.nextInt();
```

**Reading text:**
```java
String name = scn.nextLine();
```

### Complete Example

```java
import java.util.Scanner;

public class SimpleInput {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        System.out.println("Enter your age: ");
        int age = scn.nextInt();
        
        System.out.println("You are " + age + " years old");
    }
}
```

### Common Input Errors

**NoSuchElementException:**
- This happens when you call `scn.nextInt()` but the user hasn't provided input
- **Solution:** Make sure you're actually entering a value when prompted

**InputMismatchException:**
- This happens when you ask for an integer but the user enters text
- **Example:** Code expects `scn.nextInt()` but user types "hello"
- **Solution:** We'll learn better error handling later

---

## Putting It All Together: A Complete Program

```java
import java.util.Scanner;

public class FirstProgram {
    public static void main(String[] args) {
        // Declare and initialize variables
        int num1 = 10;
        int num2 = 20;
        
        // Output
        System.out.println("First number: " + num1);
        System.out.println("Second number: " + num2);
        
        // Operations
        int sum = num1 + num2;
        int product = num1 * num2;
        
        // More output
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        
        // Get input from user
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int userNumber = scn.nextInt();
        
        System.out.println("You entered: " + userNumber);
    }
}
```

---

## Common Mistakes

### 1. Integer Division Loses Precision

```java
int result = 7 / 2;        // Result: 3 (not 3.5!)
System.out.println(result); // Prints: 3
```

Why? Both are `int`, so Java drops the decimal part.

**Solution:** Use `double` if you need decimals:
```java
double result = 7.0 / 2.0;  // Result: 3.5
```

### 2. Forgetting to Initialize Variables

```java
int age;                    // Declared but not initialized
System.out.println(age);    // ERROR! age has no value
```

**Solution:** Always initialize:
```java
int age = 0;                // Now it's safe
```

### 3. Using Integer Instead of Double for Decimals

```java
int price = 9.99;  // ERROR! 9.99 is not an integer
```

**Solution:** Use the right data type:
```java
double price = 9.99;  // Correct
```

### 4. String vs Double Quotes

```java
String name = 'Alice';         // WRONG! Single quotes are for char only
char letter = "A";            // WRONG! Double quotes are for String

String name = "Alice";        // Correct
char letter = 'A';            // Correct
```

### 5. Comparing with Wrong Operator

```java
if (age = 25)  // WRONG! This assigns, doesn't compare
if (age == 25) // Correct! Double equals compares
```

We'll cover this more when learning conditionals, but it's a super common mistake.

### 6. Variable Scope Issues

```java
public static void main(String[] args) {
    int x = 10;
    {
        int x = 20;  // ERROR! Same name in nested block
    }
}
```

**Solution:** Use different names or avoid nesting (we'll learn more about this later).

---

## Pro Tips for Experienced Programmers

**Switching from Python?**
- Java requires explicit type declarations (no type inference in Java 8 and earlier)
- Use `Scanner` for input instead of Python's `input()`
- `System.out.println()` is your `print()` equivalent
- Remember: Java is compiled, not interpreted (it compiles to bytecode first)

**Switching from C?**
- Memory management is automatic (no pointers!)
- String is a class, not char array
- No header files or `#include`
- Use `import` instead of `#include`
- No pointer arithmetic; use references instead

**Coming from JavaScript?**
- Java is strongly typed; you can't freely change variable types
- Use `===` concept (Java's `==` checks value, not reference, for primitives)
- Method and variable names use camelCase (same as JS, good!)
- `console.log()` → `System.out.println()`

---

## Summary Checklist

✅ **Computers are literal** - they need exact instructions  
✅ **Java starts from** `main(String[] args)`  
✅ **Program flow is sequential** (top to bottom)  
✅ **Comments** help explain intent (`//`, `/* ... */`)  
✅ **Output uses** `System.out.println()`  
✅ **Escape sequences** format output (`\n`, `\t`, `\"`)  
✅ **Operators follow** BODMAS and left-to-right for same rank  
✅ **Data types** define what values are valid  
✅ **Variables** are declared, initialized, then reused/reassigned  
✅ **Assignment** is right-side to left-side  
✅ **Input** uses Scanner methods like `nextInt()` and `nextLine()`  
✅ **You can spot beginner errors** like type mismatch and integer division  

---

## Practice Questions

1. Predict the exact output:
```java
System.out.println(8 + 2 * 3);
System.out.println((8 + 2) * 3);
```
Hint: Same numbers, different grouping.

2. Predict the output order:
```java
System.out.println("A" + 5 + 2);
System.out.println(5 + 2 + "A");
```
Hint: Java evaluates left to right.

3. Fix this code so it compiles and prints your name and age:
```java
String name = 'Alex';
int age = "19";
System.out.println(name + " " + age);
```
Hint: Check quote type and variable type.

4. Write a program that stores two integers and prints:
`Sum`, `Difference`, `Product`, `Quotient`, `Remainder`.
Hint: You already know all five arithmetic operators.

5. What will this print, and why?
```java
int result = 9 / 4;
System.out.println(result);
```
Hint: Both operands are the same data type.

6. Rewrite Question 5 so the output becomes `2.25`.
Hint: Change the operands, not just the variable on the left.

7. Find and fix all errors:
```java
int score;
System.out.println(score);
score = 100;
int score = 200;
```
Hint: Think initialization first, redeclaration second.

8. Write a program that asks user for two integers and prints their sum.
Hint: You need `Scanner`, `nextInt()`, and one output line.

9. Write a program that takes first name and age as input, then prints:
`Hello <name>, next year you will be <age+1>`
Hint: One input is text, one is numeric.

10. Predict output:
```java
System.out.println("Name\tAge");
System.out.println("Riya\t21");
```
Hint: Visual spacing matters here.

11. Write one line that prints exactly:
`He said "Java is easy"`
Hint: You need an escape sequence for quotes.

12. In your own words, explain each part of:
`public static void main(String[] args)`
Hint: Four keywords/parts, four meanings.

13. Create three valid variable names and three invalid ones.
For each invalid name, say why it's invalid.
Hint: Check starting character, keyword usage, and naming style.

14. Trace this code and write final value of `x`:
```java
int x = 10;
x += 5;
x *= 2;
x -= 4;
System.out.println(x);
```
Hint: Treat each line as state change.

15. Mini challenge: Write a short program that prints a formatted 2-row table:
`Item`, `Price` on first line, and two sample items below it.
Hint: Use `\t` and `\n` together.

---

## Topics We'll Cover Later

You've now got the foundation! These important topics are coming next:

- **Conditional Statements** (if/else/switch) - Make decisions in your code
- **Loops** (for/while) - Repeat code multiple times
- **Methods** - Write reusable blocks of code
- **Arrays** - Store multiple values in one variable
- **Object-Oriented Programming** - Classes, objects, inheritance
- **Exception Handling** - Handle errors gracefully
- **File I/O** - Read and write files

For now, focus on mastering the basics!

---

## Next Steps

Now that you understand the basics:
- Practice writing simple programs with variables and output
- Experiment with different data types
- Try taking user input and doing calculations with it
- Practice using comments to explain your code
- Use escape sequences to format your output nicely
- Move on to conditional statements (if/else) for decision-making
