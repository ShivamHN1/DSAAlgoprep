# Java Fundamentals - Conditional Statements

# technical Debt:

- Covering literals and primitives and objects in java a bit for understanding whats happening behind the scenes or just being aware of their existence.

## Quick Reference (1-Minute Recall)

- Conditional statements use **comparison operators** to check conditions.z
- Comparison operators: `==`, `!=`, `<`, `>`, `<=`, `>=`
- `if` executes a block of code only if a condition is `true`.
- `if-else` executes one block if the condition is `true`, another if it's `false`.
- `if-else if-else` chains multiple conditions to check them sequentially.
- Comparison operators always return a **boolean value**: `true` or `false`.
- When mixing data types in operations, Java has specific rules for what the result type will be.
- Explicit casting is required when converting from a larger type to a smaller type.

## Understanding the Fundamentals

You've now completed two foundational lessons: first, you learned how to write Java statements and make your first program run; second, you learned how to work with different data types, variables, and type conversions. This third lesson builds directly on that knowledge by introducing **conditional logic**—the ability for your program to make decisions.

Here's the crucial insight: without conditional statements, your program will always execute the exact same way, every single time, regardless of what input it receives. But with conditionals, your program becomes intelligent. It can check the value of a variable, evaluate a condition, and then decide which code to run based on that evaluation. This is where programming transitions from merely executing statements to making actual decisions. This is where your code becomes truly dynamic and responsive to different situations.

Think of it like this: if you write code without conditionals, you're giving a computer a fixed list of instructions. But with conditionals, you're giving it a set of rules and the ability to follow different paths based on what it encounters. That's the real power of programming.

---

## 1. Review: Float and Double (Decimal Types)

Before we dive into conditional statements, let's refresh our understanding of how Java handles decimal values. This is important because you'll often be comparing decimal numbers when writing conditional logic, and precision matters.

### The Default Decimal Type: `double`

In Java, whenever you write a decimal literal—a number with a decimal point—like `2.5` or `99.99`, Java treats it as a `double` by default. This is an important design choice in Java: `double` is the standard floating-point type because it offers more precision than `float`.

```java
double price = 99.99;
double temperature = 36.5;
double pi = 3.14159265358979;
```

All of these are automatically `double` values. Java made this choice because `double` provides approximately 14-15 decimal places of precision, which is sufficient for most real-world calculations.

### When You Need `float`: The Suffix Requirement

Sometimes, you might want to use `float` instead—perhaps to save memory in a large-scale application or for specific hardware requirements. However, Java will not let you store a decimal literal in a `float` variable without explicit permission. You must write the letter `f` (or `F`) at the end of the literal to tell Java: "Yes, I know this is a decimal, and yes, I specifically want it as a `float`."

```java
float temperature = 98.6f;  // the 'f' suffix is required
float pi = 3.14f;            // another float
```

Without the `f`, Java will treat `98.6` as a `double` and you'll get a compilation error like: "possible loss of precision." This is Java protecting you from unintended data loss.

### Precision Differences: Why This Matters

- **`float`**: Provides about 6-7 decimal places of precision
- **`double`**: Provides about 14-15 decimal places of precision

For most applications, this difference doesn't matter. But in scientific computing, financial calculations, or when you're doing many chained operations, the extra precision of `double` prevents rounding errors from accumulating.

### Practical Examples

```java
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
double pi = 3.14159265;        // implicitly double

//This is float 
System.out.println(2.38f)     // float: 2.38
```

Think of the `f` suffix as a safety mechanism: it forces you to be intentional about using the lower-precision `float` type.

---

## 2. Golden Rules of Type Casting

Type casting is the process of converting a value from one data type to another. This is a common operation in Java, and understanding when Java allows it automatically versus when it requires explicit permission is crucial to writing correct code.

### The First Golden Rule: Safe Conversions Are Automatic (Implicit Casting)

If there is a **guarantee** that no data will be lost during the conversion—that is, if the destination type can hold any value that the source type can hold—then Java performs the conversion automatically without requiring you to write anything special. This is called **implicit casting** or **widening conversion**.

Why the name "widening"? Because you're converting to a type that has a wider range of possible values.

Examples of safe conversions:
- `int` to `long`: A `long` can hold any integer value that an `int` can hold (and more)
- `float` to `double`: A `double` has more precision than a `float`

```java
int age = 100;
long bigNumber = age;  // automatic conversion, no cast needed
// bigNumber is now 100 as a long

float temperature = 37.5f;
double moreAccurate = temperature;  // automatic conversion
// moreAccurate is now 37.5 with double precision
```

Java handles these conversions silently in the background. You don't need to write a cast operator, and in fact, it would be redundant to do so.

### The Second Golden Rule: Risky Conversions Require Explicit Permission (Explicit Casting)

If there is a **possibility** that data could be lost during the conversion—if the destination type cannot hold all values that the source type can hold—then Java will not allow the conversion automatically. You must explicitly write the cast to tell Java: "I understand the risk, and I'm taking responsibility for this conversion."

This is called **explicit casting** or **narrowing conversion** because you're converting to a type with a narrower range of possible values.

Examples of risky conversions:
- `long` to `int`: A `long` can hold numbers much larger than an `int` can hold
- `double` to `float`: A `double` has more precision than a `float`

```java
long bigNumber = 100000L;
int smaller = (int) bigNumber;  // explicit cast required
// The (int) tells Java we know this might lose information

double precise = 3.14159265;
float lessAccurate = (float) precise;  // explicit cast required
// The (float) tells Java we accept the loss of precision
```

The cast syntax `(Type)` must be written directly before the value or variable. It's your way of saying to the compiler: "I've thought about this, and I'm deliberate about this conversion."

### Why This Rule Exists: Java's Safety Philosophy

Java is designed to be safer than languages like C. In C, type conversions can happen silently and unexpectedly, leading to subtle bugs. Java forces you to be explicit about risky conversions so that you—the programmer—make an informed decision. This is a feature, not a limitation.

### Real-World Consequences of Implicit Casting

```java
int a = 100;
long b = a;  // automatic: a is converted to long
System.out.println(b);  // 100
```

This works perfectly. No data is lost.

### Real-World Examples of Explicit Casting

```java
long x = 100000L;
int y = (int) x;  // explicit cast required
System.out.println(y);  // 100000 (fits fine)

long hugeNumber = 999999999999L;
int small = (int) hugeNumber;  // explicit cast required
System.out.println(small);  // might print cryptic result due to overflow
```

Notice that even though the cast is explicit, Java still performs it. The cast doesn't prevent overflow; it just makes you acknowledge that you're aware of the risk.

### Casting with Decimal Values

Converting between `double` and `float` works the same way, but the impact is different:

```java
double price = 25.789654;
float rounded = (float) price;  // explicit cast required
System.out.println(rounded);  // 25.789654 (but with less precision internally)
```

No data is thrown away (it's still 25.789...), but the precision is reduced. If you print it, it might show as `25.789654` on screen, but internally it's stored with only ~7 decimal places of precision.

### Quiz Practice on Type Casting

**Quiz 1: Implicit Casting (float to double)**

```java
float f = 3.3f;
double d = f;
System.out.println(d);
```

Output:
```
3.3
```

Reason: `float` to `double` is safe; Java performs it automatically. The value remains precise.

**Quiz 2: Explicit Casting (double to float)**

```java
double d = 3.4;
float f = (float) d;  // cast required
System.out.println(f);
```

Output:
```
3.4
```

Reason: `double` to `float` requires explicit casting because precision might be lost. The cast operator `(float)` is mandatory.

**Quiz 3: This Will NOT Compile (Missing Cast)**

```java
double d = 3.4;
float f = d;  // ERROR: incompatible types
```

Java refuses to compile this because the `double` to `float` conversion is risky. You must write:

```java
double d = 3.4;
float f = (float) d;  // now it compiles
System.out.println(f);
```

**Quiz 4: Implicit Casting (int to long)**

```java
int count = 174;
long bigCount = count;
System.out.println(bigCount);
```

Output:
```
174
```

Reason: `int` to `long` is safe; Java performs it automatically.

---

## 3. Operation Rules: When You Mix Types in Calculations

Suppose you write an expression that combines two different data types—for instance, adding an `int` and a `double`. What type will the result be? Java has specific rules for this situation, and understanding these rules will help you predict exactly what will happen when you perform operations.

### Rule 1: Mixed Category Operations Always Produce the Larger Type

When you perform an arithmetic operation between two values of **different categories** (for example, decimal and non-decimal), the result will always be in the **larger category**. More specifically, if you mix a decimal type with an integer type, the result becomes a decimal.

Why? Because a decimal type is more general; it can represent any integer value, but an integer type cannot represent decimal values. So Java converts the integer to the decimal type before the operation.

```java
int wholeNumbers = 10;
double decimals = 3.5;
double result = wholeNumbers + decimals;
// The int (10) is converted to double (10.0)
// 10.0 + 3.5 = 13.5
System.out.println(result);  // 13.5
```

Here's another example:

```java
int count = 5;
float price = 19.99f;
// What's the result type?
// int + float = ?
// float is the "larger" (more general) decimal type
// So the int is converted to float, and the result is float
```

### Rule 2: Same Category, Different Sizes: Result Is the Larger Size

When both operands are in the same category (both integers or both decimals) but have different sizes, the result will be the **larger type**. This makes sense: if you add a small container to a large container, you need a container at least as large as the largest one.

Common examples:
- `int + long` = `long` (because long is larger than int)
- `float + double` = `double` (because double is larger than float)

```java
int smallInt = 1000;
long bigInt = 2000;
long result = smallInt + bigInt;
// int + long = long
System.out.println(result);  // 3000 (as a long)
```

Another example:

```java
int x = 100;
int y = 200;
int result = x + y;
// int + int = int (same type, same size)
System.out.println(result);  // 300 (as an int)
```

### Why These Rules Matter: Integer Overflow Is a Real Problem

Consider this carefully: what happens when you add two large integers together?

```java
int a = 1000;
int b = 1000;
int c = a + b;
System.out.println(c);  // 2000
```

This works fine. But what if the numbers are at the edge of the `int` range? An `int` can hold values up to about 2.1 billion. If you add two large `int` values:

```java
int a = 1_000_000_000;  // 1 billion
int b = 1_000_000_000;  // 1 billion
int c = a + b;          // tries to add to 2 billion
System.out.println(c);  // might print a negative number!
```

This is **integer overflow**. The sum exceeds what an `int` can hold, so the number wraps around. To prevent this, you can cast one operand to `long`:

```java
int a = 1_000_000_000;
int b = 1_000_000_000;
long c = (long) a + b;  // now int + long = long
System.out.println(c);  // 2000000000 (correct)
```

### Detailed Examples with Explanations

**Example 1: Two Integers (Same Type, Same Size)**

```java
int x = 100;
int y = 200;
int z = x + y;
System.out.println(z);  // 300
```

Operation: `int + int` → `int`
Result: 300 as an `int`

**Example 2: Integer and Long (Same Category, Different Sizes)**

```java
int small = 1000;
long big = 2000;
long result = small + big;
System.out.println(result);  // 3000
```

Operation: `int + long` → `long` (the larger size wins)
The `int` is automatically converted to `long` before addition.

**Example 3: Integer and Double (Mixed Categories)**

```java
int wholeNumber = 10;
double decimal = 5.5;
double result = wholeNumber + decimal;
System.out.println(result);  // 15.5
```

Operation: `int + double` → `double` (decimal wins)
The `int` is automatically converted to `double` before addition.

### Quiz Practice on Operations

**Quiz 5: int + int**

```java
int a = 1000;
int b = 1000;
int c = a + b;
System.out.println(c);
```

Output:
```
2000
```

Reason: Both operands are `int`, so the result is `int`. Simple addition.

**Quiz 6: int + int stored in long**

```java
int a = 1000;
int b = 1000;
long c = a + b;
System.out.println(c);
```

Output:
```
2000
```

Reason: The operation `a + b` produces `int` (because both are `int`), giving us 2000 as an `int`. Then this `int` result is stored in the `long` variable `c` (implicit casting from `int` to `long`). So `c` contains 2000 as a `long`.

**Quiz 7: Casting Before Operation (int cast to long + int)**

```java
int a = 1000;
int b = 1000;
long c = (long) a + b;  // cast a to long first
System.out.println(c);
```

Output:
```
2000
```

Reason: The cast `(long) a` happens first, converting `a` to a `long`. Now the operation is `long + int`, which results in `long`. The result is 2000 as a `long`.

**Quiz 8: Casting with Different Values**

```java
int a = 1000;
int b = 1010;
long c = (long) a + b;
System.out.println(c);
```

Output:
```
2010
```

Reason: `a` is cast to `long`, so `long + int` = `long`. The addition is 1000L + 1010 = 2010L.

---

## 4. Arithmetic Operators and Their Behavior

You've already learned the basic arithmetic operators in lesson two. But now, as we move into working with conditionals, there's one critical behavior you need to understand deeply: **how Java handles integer division**. This is crucial because it often surprises beginners and leads to logic errors.

### The Five Arithmetic Operators

```java
int a = 10;
int b = 3;

System.out.println(a + b);  // 13, addition
System.out.println(a - b);  // 7, subtraction
System.out.println(a * b);  // 30, multiplication
System.out.println(a / b);  // 3, integer division (not 3.333...)
System.out.println(a % b);  // 1, remainder (modulo)
```

Each operator does what you'd expect—mostly. But division is where things get interesting.

### The Integer Division Trap: Discarding Decimals

Here's the critical rule: **when you divide two integers in Java, the result is always an integer. Any decimal part is truncated (cut off), not rounded.** This happens regardless of how close the result is to the next integer.

```java
System.out.println(5 / 2);    // NOT 2.5, this prints 2
System.out.println(7 / 2);    // NOT 3.5, this prints 3
System.out.println(10 / 3);   // NOT 3.333..., this prints 3
System.out.println(9 / 2);    // NOT 4.5, this prints 4
```

This happens because the `/` operator sees two integer operands, so it performs integer division. There's no rounding; the decimal portion is simply discarded.

Why is this a "trap"? Because if you're not careful, you can write code that looks correct but produces unexpected results:

```java
// Attempting to calculate an average
int score1 = 85;
int score2 = 90;
int score3 = 88;
int average = (score1 + score2 + score3) / 3;
// (85 + 90 + 88) / 3 = 263 / 3 = 87.666...
// But we get 87, not 87.666...
System.out.println(average);  // 87
```

The calculation is mathematically correct, but if you need the precise average with decimal places, you've lost that information.

### Getting Decimal Division: Involve a Decimal Type

If you want the true division result with decimal places, you must ensure that at least one operand is a decimal type (`float` or `double`). Then the entire operation is performed in decimal arithmetic:

```java
System.out.println(5.0 / 2);    // 2.5 (one operand is double)
System.out.println(5 / 2.0);    // 2.5 (one operand is double)
System.out.println(5.0 / 2.0);  // 2.5 (both operands are double)
```

This applies to the operation rules we learned: when you mix decimal and non-decimal types, the result becomes decimal. The non-decimal operand is converted before division occurs.

### The Modulo Operator: Getting the Remainder

The `%` operator gives you the **remainder** after division. This is useful for checking divisibility or for certain calculations:

```java
System.out.println(10 % 3);   // 1 (10 divided by 3 is 3 remainder 1)
System.out.println(10 % 2);   // 0 (10 divided by 2 is 5 remainder 0)
System.out.println(7 % 4);    // 3 (7 divided by 4 is 1 remainder 3)
```

A common use case: checking if a number is even or odd.

```java
int number = 5;
if (number % 2 == 0) {
    System.out.println("Even");
} else {
    System.out.println("Odd");  // 5 % 2 = 1, so it's odd
}
```

### Quiz Practice on Arithmetic and Division

**Quiz 9: Mixed Operations**

```java
System.out.println(43 + 5);   // Addition
System.out.println(43 / 5);   // Division
```

Output 1:
```
48
```

Output 2:
```
8
```

Reason for output 2: Integer division. 43 / 5 = 8.6, but the decimal part (0.6) is discarded, so we get 8.

**Quiz 10: Another Division Example**

```java
System.out.println(28 / 8);
```

Output:
```
3
```

Reason: 28 / 8 = 3.5 in real math, but integer division gives us 3.

**Quiz 11: Order of Operations with Division**

```java
System.out.println(35 / 9 + 8);
```

Output:
```
11
```

Reason: Division happens before addition (order of operations). First: 35 / 9 = 3 (integer division). Then: 3 + 8 = 11.

---

## 5. Comparison Operators: The Foundation of Conditional Logic

Now we arrive at one of the most important concepts in programming: **comparison operators**. These are the tools you use to ask questions about values. Questions like "Is this number greater than that number?" or "Are these two strings the same?" Every conditional statement in your code rests on comparison operators.

A comparison operator takes two values, compares them, and returns a **boolean result**: either `true` or `false`. There are no other options. Java uses these boolean values to decide whether to execute a block of code or skip it.

### All Six Comparison Operators

| Operator | Meaning | Example | Result |
|----------|---------|---------|--------|
| `==` | equal to | `5 == 5` | true |
| `!=` | not equal to | `5 != 3` | true |
| `<` | less than | `3 < 5` | true |
| `>` | greater than | `5 > 3` | true |
| `<=` | less than or equal to | `5 <= 5` | true |
| `>=` | greater than or equal to | `5 >= 3` | true |

### Understanding the Operators

- **`==` (Equal To)**: Checks if two values are exactly the same. `5 == 5` is `true`; `5 == 3` is `false`.
- **`!=` (Not Equal To)**: Checks if two values are different. `5 != 3` is `true`; `5 != 5` is `false`.
- **`<` (Less Than)**: Checks if the left value is smaller than the right. `3 < 5` is `true`; `5 < 3` is `false`.
- **`>` (Greater Than)**: Checks if the left value is larger than the right. `5 > 3` is `true`; `3 > 5` is `false`.
- **`<=` (Less Than or Equal)**: Checks if the left value is smaller than or exactly equal to the right. `5 <= 5` is `true`; `3 <= 5` is `true`.
- **`>=` (Greater Than or Equal)**: Checks if the left value is larger than or exactly equal to the right. `5 >= 5` is `true`; `5 >= 3` is `true`.

### Comprehensive Truth Table: How Comparisons Work

Let's see these operators in action with specific values. Using `n = 7` and `y = 10`, here's what each comparison returns:

| Operator | Expression | Result | Why? |
|----------|------------|--------|------|
| `<` | `7 < 10` | true | 7 is less than 10 |
| `<` | `10 < 7` | false | 10 is not less than 7 |
| `<` | `7 < 7` | false | 7 is not less than 7 (it's equal) |
| `>` | `7 > 10` | false | 7 is not greater than 10 |
| `>` | `10 > 7` | true | 10 is greater than 7 |
| `>` | `7 > 7` | false | 7 is not greater than 7 (it's equal) |
| `>=` | `7 >= 10` | false | 7 is not greater than or equal to 10 |
| `>=` | `10 >= 7` | true | 10 is greater than 7 |
| `>=` | `7 >= 7` | true | 7 is equal to 7 |
| `<=` | `7 <= 10` | true | 7 is less than 10 |
| `<=` | `10 <= 7` | false | 10 is not less than 7 |
| `<=` | `7 <= 7` | true | 7 is equal to 7 |
| `==` | `7 == 10` | false | 7 is not equal to 10 |
| `==` | `7 == 7` | true | 7 is equal to 7 |
| `!=` | `7 != 10` | true | 7 is not equal to 10 |
| `!=` | `7 != 7` | false | 7 is equal to 7 |

### Practical Examples with Real Variables

```java
int age = 18;
int limit = 21;

System.out.println(age == limit);  // false (18 ≠ 21)
System.out.println(age != limit);  // true (18 ≠ 21)
System.out.println(age < limit);   // true (18 < 21)
System.out.println(age > limit);   // false (18 is not > 21)
System.out.println(age <= limit);  // true (18 ≤ 21)
System.out.println(age >= limit);  // false (18 is not ≥ 21)
```

### The Critical Distinction: `=` vs. `==`

This is one of the most common mistakes beginners make, so pay close attention. There are two different operators that look similar:

- **`=` (assignment)**: Stores a value in a variable. `int x = 10;` means "put 10 into x."
- **`==` (comparison)**: Checks if two values are equal. `x == 10` asks the question "Is x equal to 10?"

They are **fundamentally different**. One changes the state of your program; the other just asks a question without changing anything.

```java
int x = 10;      // assignment: x now holds 10

if (x = 5) {     // ERROR: this tries to assign, not compare!
    System.out.println("This won't compile");
}

if (x == 5) {    // CORRECT: this compares
    System.out.println("This compiles and works");
}
```

If you accidentally write `=` in an if statement, your code will either not compile or produce unexpected behavior. Always double-check that comparisons use `==`.

### Comparison Operators Return Boolean Values

Remember that comparison operators always return a boolean. You can even store the result in a variable:

```java
int x = 10;
boolean isLargerThanFive = x > 5;  // isLargerThanFive gets true
System.out.println(isLargerThanFive);  // prints: true
```

This is useful for making your code more readable:

```java
int temperature = 35;
boolean isTooHot = temperature > 30;
if (isTooHot) {
    System.out.println("It's too hot!");
}
```

---

## 6. The If Statement: Conditional Execution

Now we combine everything we've learned about comparison operators with the first conditional statement: the **if statement**. This is where your code becomes truly dynamic.

The if statement is the simplest form of conditional: it asks a question (the condition), and if the answer is `true`, it executes a block of code. If the answer is `false`, the block is skipped entirely.

### Syntax and Flow

```java
if (condition) {
    // This block executes ONLY if the condition is true
    // If the condition is false, this block is skipped entirely
}
```

The condition must be surrounded by parentheses. It must evaluate to a boolean value (`true` or `false`). The code to execute must be inside curly braces `{ }`.

### Understanding the Flow

```
├─ Check the condition
│  ├─ If TRUE: Execute the code block inside the braces
│  └─ If FALSE: Skip the code block entirely
└─ Continue with the rest of your program
```

### Real-World Example 1: Driving License Eligibility

One of the most practical uses of `if` is to validate input against requirements:

```java
int age = 20;

if (age >= 18) {
    System.out.println("You are eligible for a driving license");
}
```

Here's what happens:
- Java evaluates the condition: `age >= 18`
- Since age is 20, the condition is `true`
- The block executes, printing the message
- Program continues

Now, if we change the age:

```java
int age = 15;

if (age >= 18) {
    System.out.println("You are eligible for a driving license");
}
```

This time:
- Java evaluates the condition: `age >= 18`
- Since age is 15, the condition is `false`
- The block is skipped completely
- Nothing is printed
- Program continues

### Real-World Example 2: Weight Requirement for Sports

```java
int weight = 65;

if (weight > 100) {
    System.out.println("You can participate");
}
System.out.println("Program continues here");
```

Since `weight = 65` and `65 > 100` is `false`, the first message is never printed. But the second print statement executes regardless because it's outside the if block. Output:

```
Program continues here
```

### Real-World Example 3: Score Check

```java
int score = 35;

if (score >= 40) {
    System.out.println("You passed");
}
```

Since `score < 40`, the condition is false, so nothing is printed.

### Important: The If Block Must Use Braces

While Java technically allows you to write an if without braces if there's only one statement, this is dangerous:

```java
// DANGEROUS - works but risky
if (x > 10)
    System.out.println("Greater");
    System.out.println("This ALWAYS prints");  // always executes!
```

The second print always runs because it's not actually part of the if statement (only the first statement is). To be safe and clear, **always use braces**:

```java
// SAFE - always use braces
if (x > 10) {
    System.out.println("Greater");
    System.out.println("Both print only if x > 10");
}
```

### Detailed If Statement Quiz Walkthrough

**Quiz 1: Simple True Condition**

```java
int x = 15;

if (x > 10) {
    System.out.println("x is greater than 10");
}
```

Step-by-step execution:
- Condition: `15 > 10` → true
- The block executes
- Output: `x is greater than 10`

**Quiz 2: False Condition**

```java
int x = 5;

if (x > 10) {
    System.out.println("x is greater than 10");
}
```

Step-by-step execution:
- Condition: `5 > 10` → false
- The block is skipped
- Output: (nothing)

**Quiz 12: If with Multiple Statements and External Code**

```java
int z = 20;

if (z > 15) {
    System.out.println("Hello");
}
System.out.println("Hello");
```

Step-by-step execution:
- Condition: `20 > 15` → true
- First if block executes: prints "Hello"
- Then the code outside the if executes (always): prints "Hello" again
- Output:
  ```
  Hello
  Hello
  ```

**Quiz 13: Two Separate If Statements**

```java
int x = 20;
int y = 25;

if (x > y) {
    System.out.println("Algorithm");
}

if (y > x) {
    System.out.println("Algorithm");
}
```

Step-by-step execution:
- First if: `20 > 25` → false, skipped
- Second if: `25 > 20` → true, executes
- Output:
  ```
  Algorithm
  ```

Only the second if block runs.

**Quiz 14: Multiple Prints in One If Block**

```java
if (10 > 6) {
    System.out.println("Algorithm");
    System.out.println("Algorithm");
}

if (15 > 25) {
    System.out.println("2nd");
}
```

Step-by-step execution:
- First if: `10 > 6` → true, both prints execute
- Second if: `15 > 25` → false, skipped
- Output:
  ```
  Algorithm
  Algorithm
  ```

**Quiz 15: Modifying Variables Between If Statements**

```java
int z = 55;
int y = 65;

if (z > y) {
    System.out.println("first");
}

z = z + 2;  // z becomes 57

if (y > z) {
    System.out.println("second");
}

y = y - 2;  // y becomes 63
System.out.println(z + y);
```

Step-by-step execution:
- First if: `55 > 65` → false, skipped
- Modify z: z becomes 57
- Second if: `65 > 57` → true, prints "second"
- Modify y: y becomes 63
- Print sum: `57 + 63 = 120`
- Output:
  ```
  second
  120
  ```

### Using If with User Input

One of the most common uses of if statements is to make decisions based on input from the user:

```java
import java.util.Scanner;

Scanner scn = new Scanner(System.in);

System.out.println("Enter your age:");
int age = scn.nextInt();

if (age >= 18) {
    System.out.println("Eligible for voting");
}
```

If the user enters 18 or higher, the message prints. Otherwise, nothing happens.

Another example:

```java
import java.util.Scanner;

Scanner scn = new Scanner(System.in);

System.out.println("Enter your weight (kg):");
int weight = scn.nextInt();

if (weight > 100) {
    System.out.println("You can participate in the sports event");
}
```

This program only prints the participation message if the user's weight exceeds 100 kg.

---

## 7. The If-Else Statement: Handling Both Outcomes

The if statement we just learned handles one scenario: "if this is true, do something." But real-world situations usually have two possible outcomes: either something is true, or something is false. The **if-else statement** lets you handle both paths.

With if-else, you provide two blocks of code: one executes if the condition is `true`, and a different one executes if the condition is `false`. Your program will **always** execute exactly one of the two blocks—never both, never neither.

### Syntax and Flow

```java
if (condition) {
    // This block executes if condition is TRUE
} else {
    // This block executes if condition is FALSE
}
```

The flow diagram makes this clear:

```
     Check condition
           |
      _____|_____
     |           |
   TRUE        FALSE
     |           |
  Execute    Execute
   if code    else code
     |           |
     |___________|
         |
    Continue program
```

This is a complete either-or situation. Exactly one path will execute.

### Real Example 1: Adult vs. Minor Classification

```java
int age = 15;

if (age >= 18) {
    System.out.println("You are an adult");
} else {
    System.out.println("You are a minor");
}
```

Step-by-step:
- Condition: `15 >= 18` → false
- The if block is skipped
- The else block executes
- Output: `You are a minor`

Now, with a different age:

```java
int age = 25;

if (age >= 18) {
    System.out.println("You are an adult");
} else {
    System.out.println("You are a minor");
}
```

Step-by-step:
- Condition: `25 >= 18` → true
- The if block executes
- The else block is skipped
- Output: `You are an adult`

### Real Example 2: Pass or Fail Decision

```java
int score = 50;

if (score >= 40) {
    System.out.println("You passed");
} else {
    System.out.println("You failed");
}
```

Since `50 >= 40` is true, the output is:
```
You passed
```

If we change the score:

```java
int score = 35;

if (score >= 40) {
    System.out.println("You passed");
} else {
    System.out.println("You failed");
}
```

Now `35 >= 40` is false, so the output is:
```
You failed
```

### Understanding Code Flow with If-Else

Here's an important principle: code after the entire if-else construct **always** executes, regardless of which block ran:

```java
int x = 5;

if (x > 10) {
    System.out.println("Greater than 10");
} else {
    System.out.println("Not greater than 10");
}

System.out.println("This always prints");
```

Output:
```
Not greater than 10
This always prints
```

The final print statement executes regardless of what happened in the if-else.

### Detailed If-Else Examples

**Example 1: Simple True Condition**

```java
int x = 8;

if (x > 10) {
    System.out.println("Greater");
} else {
    System.out.println("Not greater");
}
```

- Condition: `8 > 10` → false
- Else block executes
- Output: `Not greater`

**Example 2: True Condition with Different Logic**

```java
int marks = 45;

if (marks >= 40) {
    System.out.println("Pass");
} else {
    System.out.println("Fail");
}
```

- Condition: `45 >= 40` → true
- If block executes
- Output: `Pass`

**Example 3: Checking Even or Odd**

```java
int number = 7;

if (number % 2 == 0) {
    System.out.println("Even");
} else {
    System.out.println("Odd");
}
```

- Condition: `7 % 2 == 0` → `1 == 0` → false
- Else block executes
- Output: `Odd`

### Multiple Statements in If-Else Blocks

Each block can contain multiple statements:

```java
int temperature = 35;

if (temperature > 30) {
    System.out.println("It's hot");
    System.out.println("Drink water");
    System.out.println("Stay hydrated");
} else {
    System.out.println("It's pleasant");
    System.out.println("Go outside");
}
```

If the temperature is 35, all three statements in the if block execute. All statements execute together within their block.

---

## 8. The If-Else If-Else Statement: Handling Multiple Conditions

So far, we've learned to handle two scenarios: true or false. But the real world often has more than two possibilities. For example, a student's grade might be A, B, C, D, or F—five possibilities, not two. This is where **else if** comes in.

The else if statement lets you chain multiple conditions together. Java will check each condition from top to bottom, and as soon as it finds one that's `true`, it executes that block and skips all the remaining conditions.

### Syntax and Flow

```java
if (condition1) {
    // Executes if condition1 is TRUE
} else if (condition2) {
    // Executes if condition1 is FALSE and condition2 is TRUE
} else if (condition3) {
    // Executes if condition1 and condition2 are both FALSE and condition3 is TRUE
} else {
    // Executes if ALL previous conditions are FALSE
}
```

The flow shows the sequential checking:

```
  Check condition1
       |
     TRUE → Execute block1 and skip rest
       |
     FALSE
       |
  Check condition2
       |
     TRUE → Execute block2 and skip rest
       |
     FALSE
       |
  Check condition3
       |
     TRUE → Execute block3 and skip rest
       |
     FALSE
       |
  Execute else block
```

### Critical Concept: First True Wins

This is crucial to understand: Java checks conditions **from top to bottom** and executes the block of the **first condition that is true**. It doesn't check any conditions after that. This is called **short-circuit evaluation**.

```java
int x = 15;

if (x > 10) {
    System.out.println("Greater than 10");
} else if (x > 5) {
    System.out.println("Greater than 5 but not 10");
} else {
    System.out.println("5 or less");
}
```

Even though `x > 5` is also true, Java never checks it because `x > 10` was already true. Output:
```
Greater than 10
```

This short-circuit behavior is by design and is very important for performance and logic correctness.

### Real Example 1: Grade Assignment

One of the most common uses of if-else if-else is assigning grades based on scores:

```java
int score = 75;

if (score >= 80) {
    System.out.println("Grade: A");
} else if (score >= 60) {
    System.out.println("Grade: B");
} else if (score >= 40) {
    System.out.println("Grade: C");
} else {
    System.out.println("Grade: F");
}
```

Step-by-step for score = 75:
- Is 75 >= 80? No, go to next
- Is 75 >= 60? Yes! Execute this block
- Output: `Grade: B`
- Java never checks the remaining conditions

The else block (Grade F) is a safety net for any score less than 40.

### Real Example 2: Age Classification

```java
int age = 25;

if (age < 13) {
    System.out.println("Child");
} else if (age < 18) {
    System.out.println("Teenager");
} else if (age < 65) {
    System.out.println("Adult");
} else {
    System.out.println("Senior");
}
```

For age = 25:
- Is 25 < 13? No
- Is 25 < 18? No
- Is 25 < 65? Yes! Execute this block
- Output: `Adult`

### Real Example 3: Sign of a Number

```java
int num = 0;

if (num > 0) {
    System.out.println("Positive");
} else if (num < 0) {
    System.out.println("Negative");
} else {
    System.out.println("Zero");
}
```

For num = 0:
- Is 0 > 0? No
- Is 0 < 0? No
- Execute else block
- Output: `Zero`

### Important: The Else Block Is Optional

You don't always need an else block at the end. If none of the conditions are true, the program simply continues:

```java
int x = 5;

if (x > 20) {
    System.out.println("Very large");
} else if (x > 10) {
    System.out.println("Large");
}

System.out.println("Program continues");
```

Since x = 5, neither condition is true, so both if blocks are skipped. Output:
```
Program continues
```

But when you want to handle "all other cases," the final else block is useful:

```java
int x = 5;

if (x > 20) {
    System.out.println("Very large");
} else if (x > 10) {
    System.out.println("Large");
} else {
    System.out.println("Small or medium");
}
```

Now the else block catches everything:
```
Small or medium
```

### Detailed If-Else If-Else Examples

**Example 1: Three Ranges**

```java
int age = 25;

if (age < 13) {
    System.out.println("Child");
} else if (age < 18) {
    System.out.println("Teen");
} else {
    System.out.println("Adult");
}
```

- Is 25 < 13? No
- Is 25 < 18? No
- Execute else block
- Output: `Adult`

**Example 2: Categorizing Performance**

```java
int score = 45;

if (score >= 80) {
    System.out.println("Excellent");
} else if (score >= 60) {
    System.out.println("Good");
} else if (score >= 40) {
    System.out.println("Passing");
} else {
    System.out.println("Failing");
}
```

- Is 45 >= 80? No
- Is 45 >= 60? No
- Is 45 >= 40? Yes! Execute this block
- Output: `Passing`

**Example 3: Positive, Negative, or Zero**

```java
int num = -5;

if (num > 0) {
    System.out.println("Positive");
} else if (num < 0) {
    System.out.println("Negative");
} else {
    System.out.println("Zero");
}
```

- Is -5 > 0? No
- Is -5 < 0? Yes! Execute this block
- Output: `Negative`

### Design Principle: Write Ranges from Specific to General

When using else if, it's often better to check specific ranges before general ones. For example:

```java
int temperature = 35;

// GOOD: Specific cases first
if (temperature > 40) {
    System.out.println("Extreme heat");
} else if (temperature > 30) {
    System.out.println("Hot");
} else if (temperature > 20) {
    System.out.println("Warm");
} else {
    System.out.println("Cold");
}
```

This is clearer and easier to debug than having ranges that overlap unexpectedly.

---

## 9. Common Beginner Mistakes in Conditional Statements

Learning programming involves making mistakes, and learning from them is how you improve. Here are the most common mistakes beginners make with conditional statements.

### Mistake 1: Using Assignment `=` Instead of Comparison `==`

This is the **number one mistake** and happens to almost everyone. When you compare two values, you must use `==` (two equals signs), not `=` (one equals sign).

```java
int x = 10;

// WRONG: This tries to assign 5 to x, not compare
if (x = 5) {
    System.out.println("x is 5");
}
```

This either won't compile or will cause unexpected behavior. The correct version:

```java
if (x == 5) {
    System.out.println("x is 5");
}
```

To remember the difference:
- `=` is the **assignment operator**. It stores a value. Used in statements like `int x = 10;`
- `==` is the **comparison operator**. It asks a question. Used in conditions like `if (x == 10)`

One equals sign stores. Two equals signs compare.

### Mistake 2: Forgetting the `f` Suffix on Float Literals

When you write a decimal number and want it to be a `float`, you must include the `f` suffix:

```java
// WRONG: Treated as double, causes error
float temperature = 36.5;  // compilation error

// CORRECT: Explicitly float
float temperature = 36.5f;
```

Java's compiler will refuse to compile the first version because it sees a `double` literal and you're trying to store it in a `float` variable. By writing `36.5f`, you tell Java: "This is a float literal, not a double."

### Mistake 3: Confusing Integer and Float Division

When you divide two integers, you get **integer division** (no decimals). The result is always truncated toward zero:

```java
int result = 7 / 2;
System.out.println(result);  // prints 3, not 3.5
```

If you expect 3.5, you need at least one decimal operand:

```java
double result = 7.0 / 2;
System.out.println(result);  // prints 3.5
```

Or:

```java
double result = 7 / 2.0;
System.out.println(result);  // prints 3.5
```

### Mistake 4: Forgetting Braces in If-Else Blocks

While Java technically allows single-statement blocks without braces, it's dangerous because the scope is ambiguous:

```java
// DANGEROUS - hard to see what's inside the if
if (x > 5)
    System.out.println("Greater");
    System.out.println("This always runs");  // NOT part of if!
```

Only the first statement is part of the if block. The second statement always executes. To be safe and clear, always use braces:

```java
// SAFE and CLEAR
if (x > 5) {
    System.out.println("Greater");
    System.out.println("Both lines only if x > 5");
}
```

### Mistake 5: Misunderstanding Comparison Operators

Beginners sometimes confuse comparison operators. Remember:

- `<` means "less than" (left side is smaller)
- `>` means "greater than" (left side is bigger)
- `<=` means "less than or equal" (includes the equals case)
- `>=` means "greater than or equal" (includes the equals case)

```java
// Test your understanding
int x = 5;
int y = 5;

System.out.println(x < y);   // false (5 is not less than 5)
System.out.println(x > y);   // false (5 is not greater than 5)
System.out.println(x <= y);  // true (5 equals 5)
System.out.println(x >= y);  // true (5 equals 5)
System.out.println(x == y);  // true (5 equals 5)
```

### Mistake 6: Returning True or False Directly from Conditionals

Sometimes beginners write unnecessarily verbose conditionals:

```java
// WRONG: Overcomplicated
boolean isAdult;
if (age >= 18) {
    isAdult = true;
} else {
    isAdult = false;
}
```

You can simplify this significantly:

```java
// CORRECT: Direct assignment
boolean isAdult = (age >= 18);
```

The comparison operator `age >= 18` already returns a boolean, so you don't need the if-else.

### Mistake 7: Neglecting to Consider Float Precision Issues

When working with floating-point numbers, be aware that precision can be an issue:

```java
double price = 0.1 + 0.2;
System.out.println(price);  // might print 0.30000000000000004

if (price == 0.3) {
    System.out.println("Equal");
} else {
    System.out.println("Not equal");  // likely output
}
```

Due to how computers represent decimal numbers in binary, floating-point comparisons can be tricky. For most beginner work, this won't matter, but it's good to be aware of.

### Mistake 8: Not Understanding Short-Circuit Evaluation in If-Else If

In if-else if chains, once a condition is true, the rest are not checked:

```java
int x = 20;

if (x > 10) {
    System.out.println("Greater than 10");
} else if (x > 15) {  // This is never checked
    System.out.println("Greater than 15");
}
```

Even though `x > 15` is also true, it's never evaluated because `x > 10` was already true. This is not a bug—it's intentional and actually improves performance.

---

## 10. Practice Summary: Key Takeaways

This lesson covers a lot of ground—from type casting and operation rules to three separate conditional statement forms. Here's what you should remember and practice until it becomes second nature:

### Fundamental Rules to Memorize

1. **Type Casting Rule**: Safe conversions (like `int` to `long`) are automatic. Risky conversions (like `long` to `int`) require an explicit cast with the syntax `(Type) value`.

2. **Operation Rules**: When mixing types, the result is the larger/more general type. `int + double = double`; `int + long = long`.

3. **Integer Division**: `int / int` always gives an `int` result. The decimal part is discarded. To get decimal division, ensure at least one operand is a decimal type.

4. **Comparison Operators Return Booleans**: Every comparison (`<`, `>`, `<=`, `>=`, `==`, `!=`) returns either `true` or `false`. Nothing else.

5. **Conditional Execution**: `if` checks a condition and executes code if it's `true`. `if-else` handles both `true` and `false` cases. `if-else if-else` chains multiple conditions, checking from top to bottom until one is `true`.

### Code Writing Practices

- Always use braces in conditional blocks, even for single statements: `if (x > 5) { ... }`
- Use `==` to compare, not `=` to assign
- Write the `f` suffix on float literals: `36.5f` not `36.5`
- Organize `else if` chains from specific to general for clarity
- Remember that `else if` conditions stop being checked once the first true condition is found

### Comparison Operator Reference

| Operator | Meaning | Example | Result (if a=7, b=10) |
|----------|---------|---------|--------|
| `==` | equal | `a == b` | false |
| `!=` | not equal | `a != b` | true |
| `<` | less than | `a < b` | true |
| `>` | greater than | `a > b` | false |
| `<=` | less or equal | `a <= b` | true |
| `>=` | greater or equal | `a >= b` | false |

### The If Statement Family

```
if (condition) { ... }
            ↓
if (condition) { ... } else { ... }
            ↓
if (condition1) { ... } else if (condition2) { ... } else { ... }
```

Each form gives you more control and flexibility for different situations.

---

## 11. Testing Your Understanding

Try these challenges to solidify your knowledge:

**Challenge 1**: Write code that reads two numbers from the user and prints the larger one.

**Challenge 2**: Write code that classifies a temperature value:
- Less than 0: "Freezing"
- 0 to 15: "Cold"
- 16 to 25: "Comfortable"
- 26+: "Hot"

**Challenge 3**: Write code that checks if a number is positive, negative, or zero.

**Challenge 4**: Given a score out of 100, assign a grade (A, B, C, D, F) based on ranges you define.

**Challenge 5**: Write code that determines if a person is eligible for a student discount (age <= 25) or a senior discount (age >= 60).

---

## 12. How This Connects to the Next Topic

You now understand how to ask questions (comparisons) and make decisions (conditionals). But decisions are only half of controlling program flow. What if you want to **repeat** an action multiple times? That's where **loops** come in.

Loops let you write code once and have Java execute it multiple times based on a condition. Combined with what you've learned about conditionals, loops will allow you to write sophisticated programs that can solve real problems.

Here's the progression:
- **Lesson 1**: Basic statements and output
- **Lesson 2**: Variables, types, and casting
- **Lesson 3** (this lesson): Conditionals and decision-making
- **Lesson 4**: Loops and repetition
- **Beyond**: Arrays, functions, object-oriented programming

Each lesson builds on the previous. Mastering conditionals is essential for everything that comes next.

---

## Final Revision Box

### Essential Concepts

- **Comparison operators** (`==`, `!=`, `<`, `>`, `<=`, `>=`) always return boolean values
- **`=`** is assignment; **`==`** is comparison
- **`if`** executes code if true; **`if-else`** handles both true and false
- **`else if`** chains multiple conditions; first true wins
- **Type safety**: Implicit casting for safe conversions, explicit casting for risky ones
- **Integer division** discards decimals: `int / int = int`
- **Operation rules** determine result types when mixing types
- **Float literals** require the `f` suffix: `2.5f`
- **Always use braces** in conditional blocks for clarity
- **Code after if-else always executes** (unless there's a return or exit)

### What You Can Now Do

✓ Compare values using all six comparison operators  
✓ Make decisions with if, if-else, and if-else if-else  
✓ Understand how Java handles different data types in operations  
✓ Prevent type casting errors with implicit and explicit conversions  
✓ Write clear, readable conditional code  
✓ Understand program flow and how conditions direct execution  
✓ Avoid common beginner mistakes in conditionals  

You have completed the foundation of decision-making in Java. You're ready for loops.
