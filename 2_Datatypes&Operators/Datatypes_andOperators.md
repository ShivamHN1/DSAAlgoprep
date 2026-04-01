# Java Fundamentals - Data Types and Operators

## Quick Reference (1-Minute Recall)

- Java variable names are case-sensitive.
- A valid name can use letters, digits, `_`, and `$`.
- A variable name cannot start with a digit.
- Reserved words like `static`, `void`, and `int` cannot be used as names.
- `System.out.println()` prints output.
- `int` is the default type for whole-number literals.
- Smaller integer types: `byte`, `short`, `int`, `long`.
- Decimal types are `float` and `double`, and `double` is the default.
- Implicit casting goes from smaller to larger types.
- Explicit casting is needed from larger to smaller types.
- `Scanner` reads input from the keyboard.
- Basic operators include `+`, `-`, `*`, `/`, `%`, `=`, `==`, `++`, and `--`.

## Understanding the Basics

The first lesson explained how Java programs start, how output works, and how variables store values. This lesson continues from there by showing what kinds of values variables can hold, how to name them properly, how Java stores numbers, how operators work on those values, and how to safely convert between data types. It also connects those ideas to input, because once you know how to print output, the next useful step is reading data from the user.

If the first file taught you how to write and run simple Java statements, this one teaches you how to work with those values in a careful, predictable way.

---

## 1. Output Syntax Review

The standard way to print in Java is:

```java
System.out.println("Hello Java");
System.out.println(20);
System.out.println(10 + 5);
```

The important part is the exact syntax. Java is strict about spelling, capitalization, and punctuation.

Common mistakes from beginner notes:

```java
System out point n
System.out.printer
```

Correct form:

```java
System.out.println("Correct syntax");
```

### What `println` Does

- `System` is the built-in Java class for system-level features.
- `out` is the output stream.
- `println()` prints the value and then moves to the next line.

If you want output without a new line, Java also has `System.out.print()`, but `println()` is the one used most often at this stage.

This matters because later quizzes often ask for exact output, including line breaks.

---

## Java Syntax and Rules

Before getting into values, remember that Java is strict about spelling, capitalization, and symbol use. That is why `System.out.println()` works, why `Scanner` must start with a capital `S`, and why `static` cannot be used as a variable name.

## 2. Operators and Assignment

Operators are symbols that tell Java to perform work on values.

### Arithmetic Operators

```java
int a = 20;
int b = 5;

System.out.println(a + b);  // 25
System.out.println(a - b);  // 15
System.out.println(a * b);  // 100
System.out.println(a / b);  // 4
System.out.println(a % b);  // 0
```

### What Each Operator Means

- `+` adds values.
- `-` subtracts values.
- `*` multiplies values.
- `/` divides values.
- `%` gives the remainder.

### Assignment Operator

The assignment operator `=` means: take the value on the right and store it in the variable on the left.

```java
int x = 10;
x = 25;
```

That is not a comparison. It does not mean “equal to.” It means “store this value here.”

### Compound Assignment

```java
int value = 10;
value += 5;   // value = value + 5
value -= 2;   // value = value - 2
value *= 3;   // value = value * 3
value /= 2;   // value = value / 2
```

These are useful because they shorten common update patterns.

### Operator Order

Java follows the usual order of operations:

- Parentheses first
- Multiplication, division, and remainder next
- Addition and subtraction last

When operators have the same priority, Java evaluates left to right.

This is the same idea as normal math class, and it is essential when you begin predicting output from expressions.

```java
System.out.println(5 + 5 * 6);   // 35
System.out.println((5 + 5) * 6); // 60
System.out.println(10 / 2 * 5);  // 25
```

### Comparison Operators

Comparison operators check two values and return `true` or `false`.

```java
int a = 10;
int b = 20;

System.out.println(a == b);  // false
System.out.println(a != b);  // true
System.out.println(a < b);   // true
System.out.println(a > b);   // false
System.out.println(a <= b);  // true
System.out.println(a >= b);  // false
```

Use `==` to compare values. Do not confuse it with `=`.

### Increment and Decrement

These are shorthand operators that change a number by 1.

```java
int count = 5;
count++;  // count becomes 6
count--;  // count becomes 5 again
```

These are common in loops, but they are also useful to understand now.

---

## 3. Variables and Assignment

A variable stores a value in memory.

```java
int a = 20;
int b = 30;
```

The assignment operator section above is the key idea here: variables are created, given values, and then updated when needed.

---

## 4. Variable Naming Rules

Variable names in Java must follow these rules:

1. They can contain lowercase letters, uppercase letters, digits, `_`, and `$`.
2. The first character cannot be a number.
3. Reserved words cannot be used as variable names.

Reserved words are words already used by Java, such as `public`, `static`, `void`, `int`, `class`, and `new`.

### Valid Examples

```java
int age = 20;
int totalMarks = 95;
int _score = 40;
int marks2 = 80;
```

### Invalid Examples

```java
int 2x = 10;            // starts with a digit
int static = 20;        // reserved word
int total-marks = 30;   // hyphen is not allowed
```

### Good Naming Style

Java programmers normally use `camelCase` for variables:

```java
int studentAge = 18;
int numberOfBooks = 5;
```

This is not just style. Clear names make code easier to read and debug.

---

## 5. Quiz Practice on Variable Names

These are the same kind of name-checking questions that appear in class quizzes. The point is to train your eye to spot invalid names quickly.

### Quiz 1

```java
int x = 10;
int y2 = 20;
int 3value = 30;
```

Correct variable names: `x`, `y2`

Reason: `3value` starts with a digit.

### Quiz 2

```java
int y = 10;
int ang = 20;
int n_a = 30;
int y2 = 45;
```

Correct variable names: all of them.

Reason: each one follows Java naming rules.

### Quiz 3

```java
int static = 10;
```

This is invalid because `static` is a reserved keyword.

### Quiz 4

How many correct variable names are there here?

```java
int x = 10;
int y2 = 20;
int 3value = 30;
```

Answer: 2

### Quiz 5

How many correct variable names are there here?

```java
int y = 10;
int ang = 20;
int n_a = 30;
int y2 = 45;
```

Answer: 4

---

## 6. Data Types

Java uses different data types for different kinds of values.

### Main Categories

- Numbers: `byte`, `short`, `int`, `long`, `float`, `double`
- Characters: `char`
- Boolean values: `boolean`
- Text: `String`

In the early lessons, the important idea is that the type tells Java what kind of value a variable can hold and how much memory it needs.

### Number Types at a Glance

- Whole numbers use integer types like `byte`, `short`, `int`, and `long`.
- Decimal numbers use `float` and `double`.
- `double` is the default decimal type in Java.

### Examples

```java
float temperature = 36.5f;
double price = 99.99;
boolean isOpen = true;
char grade = 'A';
String name = "Java";
```

Important details:

- Use `f` after a `float` literal, like `36.5f`.
- `double` is usually the better choice for decimal values.
- `char` uses single quotes.
- `String` uses double quotes.

### Integer Types

| Type | Size | Range |
|------|------|-------|
| `byte` | 1 byte | -128 to 127 |
| `short` | 2 bytes | -32,768 to 32,767 |
| `int` | 4 bytes | -2,147,483,648 to 2,147,483,647 |
| `long` | 8 bytes | -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 |

### What These Types Mean in Practice

- `byte` is for very small whole numbers.
- `short` is for small whole numbers.
- `int` is the default and most commonly used integer type.
- `long` is for very large whole numbers.

The exact range of each integer type comes from how many bits are used to store it. That bit-level explanation belongs in a later bits lesson, but for now you should memorize the ranges and use the correct type.

---

## 7. Default Literal Type

In Java, a whole-number literal like `10` is treated as an `int` by default.

```java
int a = 10;
```

If the number is too large for `int`, you must use `L` at the end.

```java
long bigNumber = 10000000000L;
```

This matters because Java will not silently guess a bigger integer type when the number is outside the `int` range.

### Quiz Idea

If you write:

```java
long x = 100;
```

that works because `100` is an `int` value and Java can safely widen it to `long`.

If the number is too large for `int`, use `L`:

```java
long x = 10000000000L;
```

---

## 8. Type Casting

Type casting means converting one data type into another.

### Implicit Casting

Java does this automatically when converting a smaller type to a larger type.

```java
int a = 10;
long b = a;
```

This works because `long` can hold every value that `int` can hold.

### Explicit Casting

You must do this manually when converting a larger type to a smaller type.

```java
long x = 1000L;
int y = (int) x;
```

The cast tells Java that you understand some information may be lost.

### Rule to Remember

- Smaller to larger: automatic.
- Larger to smaller: forced.

This matches the common quiz wording from class: automatic conversion is implicit casting, and forced conversion is explicit casting.

Another way to think about it: widening is usually safe, narrowing may lose information.

### Example with Decimal Values

```java
double price = 25.75;
int rounded = (int) price;
```

`rounded` becomes `25` because explicit casting removes the decimal part.

### Why This Matters

If you store a decimal in an integer variable, Java will not preserve the fractional part. That is not a bug. That is how the type works.

### Quiz Pattern

```java
long a = 174;
int b = (int) a;
```

This is allowed only because you wrote the cast explicitly.

---

## 9. Quiz Practice on Type Casting

### Quiz 1

```java
int a = 174;
long b = a;
System.out.println(b);
```

This works because `int` can be assigned to `long` automatically.

Output:

```java
174
```

### Quiz 2

```java
long x = 100000;
int y = (int) x;
System.out.println(y);
```

This is explicit casting.

### Quiz 3

```java
int a = 10;
long b = 20;
```

This is fine because `20` is treated as an `int` literal and can be stored in a `long` variable.

This also matches the beginner quiz idea that small whole numbers can move into larger integer types without a cast.

### Quiz 6

```java
long a = 174;
int b = a;
```

This is not allowed without an explicit cast, because Java will not narrow a `long` into an `int` automatically.

### Quiz 4

```java
long x = 100000;
int y = x;
```

This is not allowed without a cast, because it is a larger-to-smaller conversion.

Correct version:

```java
int y = (int) x;
```

### Quiz 5

```java
double price = 25.75;
int rounded = (int) price;
```

Output value of `rounded`: `25`

---

## 10. Input Using Scanner

To read input from the user, use `Scanner`.

```java
import java.util.Scanner;

Scanner scn = new Scanner(System.in);
```

Breaking it down:

- `Scanner` is the class that reads input.
- `System.in` means keyboard input.
- `scn` is the variable name holding the scanner object.

### Reading One Integer

```java
int n = scn.nextInt();
```

### Reading Multiple Integers

```java
int x = scn.nextInt();
int y = scn.nextInt();
System.out.println(x + y);
```

### Common Mistake

```java
Scanner scn = new scanner(System.in);
```

This is wrong because Java is case-sensitive. `Scanner` must start with a capital `S`.

Correct form:

```java
Scanner scn = new Scanner(System.in);
```

If you forget to import the class, the compiler will also complain:

```java
import java.util.Scanner;
```

### Reading Text

```java
String name = scn.nextLine();
```

Use `nextLine()` when you want a full line of text instead of a number.

---

## 11. Quiz Practice on Input

### Quiz 1

Input:

```text
30
```

Code:

```java
Scanner scn = new Scanner(System.in);
int n = scn.nextInt();
System.out.println(n);
```

Output:

```java
30
```

### Quiz 2

Input:

```text
24 30
```

Code:

```java
Scanner scn = new Scanner(System.in);
int x = scn.nextInt();
int y = scn.nextInt();
System.out.println(x + y);
```

Output:

```java
54
```

### Quiz 3

Input:

```text
24 30
```

Code:

```java
Scanner scn = new Scanner(System.in);
int x = scn.nextInt();
int y = scn.nextInt();
System.out.println(x);
System.out.println(y);
```

Output:

```java
24
30
```

This helps you see that `nextInt()` reads one integer at a time from the input stream.

### Quiz 4

```java
Scanner scn = new Scanner(System.in);
String name = scn.nextLine();
System.out.println(name);
```

This is the correct pattern when the input is text.

---

## 12. Mini Quiz Answers

### Which variable names are valid?

Valid:

- `age`
- `totalMarks`
- `_count`

Invalid:

- `2x` because it starts with a digit
- `static` because it is a reserved keyword
- `total-marks` because `-` is not allowed in variable names

### What is the default type for a whole-number literal?

Answer: `int`

### What happens here?

```java
long a = 10;
int b = (int) a;
```

This is explicit casting from `long` to `int`.

### What about this?

```java
int a = 174;
long b = a;
```

This is implicit casting from `int` to `long`.

---

## 13. Common Beginner Mistakes

### 1. Using the Wrong Case

```java
scanner scn = new scanner(System.in);
```

Correct:

```java
Scanner scn = new Scanner(System.in);
```

### 2. Using a Reserved Word as a Name

```java
int static = 10;
```

Correct:

```java
int staticValue = 10;
```

### 3. Forgetting That `int` Is the Default

```java
long x = 100;
```

This is fine because Java can widen an `int` to `long`.

### 4. Expecting `int` to Store Decimals

```java
int price = 9.99;
```

This is wrong because decimal literals are not integers.

Correct:

```java
double price = 9.99;
```

Note: Java treats `9.99` as a decimal value, and decimal values belong in `float` or `double`, not `int`.

### 5. Forgetting to Cast on Narrowing Conversion

```java
long x = 100000;
int y = x;
```

Correct:

```java
int y = (int) x;
```

---

## 14. Practice Summary

If you remember only a few things from this lesson, remember these:

- Variable names must follow Java rules.
- Java is strict about capitalization and spelling.
- `int` is the default type for whole numbers.
- `double` is the default type for decimal values.
- `long` is used for larger integer values.
- Implicit casting is safe widening.
- Explicit casting is needed for narrowing.
- Use `Scanner` for keyboard input.
- Use operators carefully and remember order of operations.
- Remember that `=` assigns and `==` compares.

---

## 15. How This Connects to the Next Topic

Now that you know the basic data types and how Java handles input and casting, the natural next step is operators and expressions in more detail. That includes arithmetic operators, comparison operators, assignment operators, and how Java evaluates expressions from left to right.

This is the bridge from “I can store values” to “I can compute with values.”

---

## Final Revision Box

- Naming rules matter.
- Data type choice matters.
- Casting changes how Java treats values.
- Input and output must use correct syntax.
- Practice by reading code and predicting the result.
- Operators follow precedence and left-to-right evaluation when needed.
