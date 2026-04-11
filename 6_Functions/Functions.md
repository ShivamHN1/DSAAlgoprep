# Java Fundamentals - Functions

## Quick Reference (1-Minute Recall)

- A function is a reusable block of code that performs a specific task.
- Functions help you break a problem into smaller, manageable parts.
- A function can take input through parameters.
- A function can give output through `return`.
- `void` means the function does not return a value.
- `main` is the starting point of a Java program, but it can call other functions.
- Functions make code shorter, clearer, and easier to test.
- Factorial and `nCr` are classic beginner problems that are best solved with functions.

## Why Functions Matter

Up to this point, you have learned how to write statements, make decisions, repeat actions, and build visual patterns.

Now we move to a deeper programming idea: functions.

A function is not just a Java feature. It is a programming concept. The idea is simple: if a piece of logic is needed more than once, or if a problem can be broken into smaller parts, then that logic should be placed inside a function.

That is the real value of functions:

- They reduce repetition.
- They make programs easier to read.
- They let you focus on one small task at a time.
- They make debugging easier because each function has one purpose.

If loops taught you how to repeat actions, functions teach you how to organize actions.

---

## 1. What Is a Function?

A function is a named block of code that does a specific job.

You can think of it like a small machine:

- You give it input.
- It performs some work.
- It may return a result.

### Simple Idea

If you need to calculate a factorial, print a greeting, or add two numbers, you do not always want to write that logic directly inside `main`. Instead, you can place that logic in a function and call it whenever needed.

### Why This Helps

Without functions, your code becomes harder to manage as it grows. With functions, each part of the problem gets its own place.

---

## 2. The Basic Structure of a Function in Java

The general shape of a function looks like this:

```java
returnType functionName(parameterList) {
	// body
	return value;
}
```

### What Each Part Means

- `returnType`: the type of value the function gives back.
- `functionName`: the name you use to call the function.
- `parameterList`: the input the function receives.
- body: the work the function performs.
- `return value`: sends a result back to the caller if the function is not `void`.

### Example Skeleton

```java
public static int add(int a, int b) {
	int sum = a + b;
	return sum;
}
```

**Note on `public static`**: You will see these words in front of every function you write. For now, just type them before each function definition. You do not need to understand what they mean yet—we will learn about them later. Think of them as a Java requirement for now.

This function takes two integers, adds them, and returns the result.

---

## 3. Why `main` Is Special

Every Java program starts from the `main` function.

```java
public static void main(String[] args) {
	// program starts here
}
```

But `main` does not need to hold all of your logic.

The better practice is:

- Keep `main` focused on input/output and high-level flow.
- Put the actual logic into separate functions.

That way, `main` becomes the manager, and the functions become the workers.

---

## 4. Void Functions and Return Functions

Functions in Java usually fall into two broad groups.

### Void Functions

A `void` function does not return a value.

```java
public static void greet() {
	System.out.println("Hello");
}
```

This function simply prints something.

### Return Functions

A return function sends a value back.

```java
public static int add(int a, int b) {
	return a + b;
}
```

This function gives back a number.

### When to Use Which

- Use `void` when the function’s job is to perform an action.
- Use a return type when the function’s job is to calculate and provide a result.

---

## 5. Calling a Function

Defining a function and calling a function are two different things.

### Definition

You write the function body.

```java
public static int cube(int a) {
	return a * a * a;
}
```

### Call

You use the function.

```java
int result = cube(3);
System.out.println(result);
```

Output:

```text
27
```

### Why This Matters

The function definition is the recipe.
The function call is actually using the recipe.

---

## 6. Parameters and Arguments

These two words sound similar, so beginners often confuse them.

### Parameter

A parameter is the variable written in the function definition.

```java
public static int add(int a, int b) {
	return a + b;
}
```

Here, `a` and `b` are parameters.

### Argument

An argument is the actual value passed into the function call.

```java
int sum = add(3, 4);
```

Here, `3` and `4` are arguments.

### Easy Memory Trick

- Parameter = variable in the function definition.
- Argument = value given when the function is called.

---

## 7. A First Example: Factorial

One of the most common beginner uses of functions is factorial.

### What Is Factorial?

The factorial of a number `n` is:

```text
n! = 1 x 2 x 3 x ... x n
```

For example:

- `4! = 1 x 2 x 3 x 4 = 24`
- `5! = 1 x 2 x 3 x 4 x 5 = 120`

### Why Factorial Is a Good Function Problem

It is a small, clear problem where you can separate the logic from the input handling. That makes it ideal for learning functions.

### Without a Function

```java
int n = 4;
int ans = 1;

for (int i = 1; i <= n; i++) {
	ans = ans * i;
}

System.out.println(ans);
```

This works, but the logic is still sitting directly inside the flow of the program.

### With a Function

```java
public static int fact(int n) {
	int ans = 1;

	for (int i = 1; i <= n; i++) {
		ans = ans * i;
	}

	return ans;
}
```

Then you can use it like this:

```java
int result = fact(4);
System.out.println(result);
```

Output:

```text
24
```

### How the Function Works

- Start with `ans = 1`.
- Multiply it by every number from `1` to `n`.
- Return the final result.

### Factorial Quiz

For `n = 5`, the function does:

- `1 x 1 = 1`
- `1 x 2 = 2`
- `2 x 3 = 6`
- `6 x 4 = 24`
- `24 x 5 = 120`

So `fact(5)` returns `120`.

---

## 8. `nCr` Using Functions

Another classic use of functions is combinations.

### What Is `nCr`?

`nCr` means the number of ways to choose `r` items from `n` items.

The formula is:

$$
nCr = \frac{n!}{r!(n-r)!}
$$

### Example

For `n = 5` and `r = 2`:

$$
5C2 = \frac{5!}{2!3!} = \frac{120}{2 \times 6} = 10
$$

### Why Functions Help Here

Without functions, the formula becomes cluttered.

With a factorial function, the solution becomes cleaner and easier to read.

### Example Code

```java
public static int fact(int n) {
	int ans = 1;

	for (int i = 1; i <= n; i++) {
		ans = ans * i;
	}

	return ans;
}

public static int nCr(int n, int r) {
	int nfact = fact(n);
	int rfact = fact(r);
	int nmrfact = fact(n - r);

	int ans = nfact / (rfact * nmrfact);
	return ans;
}
```

### Example Call

```java
int result = nCr(5, 2);
System.out.println(result);
```

Output:

```text
10
```

### What to Notice

- `fact(n)` is reused several times.
- The `nCr` function combines those factorial values.
- This is exactly why functions exist: reuse and clarity.

---

## 9. A Simple `add` Function

Sometimes a function is just a clean way to group a small task.

### Example

```java
public static int add(int a, int b) {
	return a + b;
}
```

### Usage

```java
int result = add(3, 4);
System.out.println(result);
```

Output:

```text
7
```

### Why This Example Matters

This is not about complexity. It is about understanding the function structure:

- input in the form of parameters
- work inside the function
- output using `return`

---

## 10. A Simple `cube` Function

Another beginner function is cube.

### Example

```java
public static int cube(int a) {
	return a * a * a;
}
```

### Usage

```java
int result = cube(3);
System.out.println(result);
```

Output:

```text
27
```

### Why This Is Useful

It shows that a function can be built for a single task and then reused whenever needed.

---

## 11. Full Example: Input, Function Call, Output

Here is a complete program structure.

```java
import java.util.Scanner;

public class Main {
	public static int fact(int n) {
		int ans = 1;

		for (int i = 1; i <= n; i++) {
			ans = ans * i;
		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int result = fact(n);
		System.out.println(result);
	}
}
```

### How to Read This Program

- `main` reads the input.
- `fact` does the factorial work.
- `main` prints the result.

That separation is good programming style.

---

## 12. Function Flow: What Happens Step by Step

When you call a function, Java follows a clear flow.

### Example

```java
int result = add(5, 6);
```

### What Happens Internally

1. Java reaches the function call.
2. It passes `5` and `6` into `add`.
3. The function runs its body.
4. The function returns `11`.
5. The returned value is stored in `result`.

This is the mental model you should always keep in mind.

---

## 13. Return Statement Rules

The `return` statement sends a value back from a function.

### Important Rule

Once Java sees `return`, the function ends immediately.

```java
public static int sample() {
	return 5;
	// anything below here will never run
}
```

### Why This Matters

You should place `return` where the answer is already ready. Do not keep code after a return unless it is in a different branch.

---

## 14. Common Beginner Mistakes in Functions

### Mistake 1: Forgetting to Return a Value

If a function says it returns `int`, Java expects an `int` value back.

```java
public static int add(int a, int b) {
	int sum = a + b;
}
```

This is incomplete because nothing is returned.

### Mistake 2: Using the Wrong Return Type

If the function is only printing something, use `void`.
If the function is calculating something, use an appropriate return type.

### Mistake 3: Mixing Up Parameters and Arguments

Parameters are in the definition.
Arguments are in the call.

### Mistake 4: Writing All Logic Inside `main`

That works for tiny programs, but it does not scale well. Functions make code easier to understand.

### Mistake 5: Ignoring Reusability

If you write the same logic two or three times, that logic probably belongs in a function.

---

## 15. The Real Programming Idea Behind Functions

Functions are not only a Java feature. They are part of programming itself.

The big ideas are:

- Break a problem into small pieces.
- Give each piece one job.
- Reuse the same piece whenever needed.
- Keep the main flow of the program simple.

This is why functions matter so much.

They let you think like a programmer instead of just writing code line by line.

---

## 16. How to Think When Writing a Function

Before writing a function, ask:

1. What is this function supposed to do?
2. What inputs does it need?
3. Does it need to return a value?
4. Can I test it with one small example?
5. Can I reuse it somewhere else?

If you can answer those questions, the function usually writes itself.

---

## 17. Practice Summary

Here is the short version of what you should remember.

### Core Ideas

- A function is a reusable block of code with a single responsibility.
- `void` functions perform actions.
- Return functions calculate and send back results.
- Parameters are written in the function definition.
- Arguments are passed in the function call.
- `main` is the entry point, but not the place where all logic must live.

### Mental Model

Think of a function as a small machine:

- Input goes in.
- Work happens inside.
- Output comes out, if needed.

### Why This Is Powerful

- Better organization
- Less repetition
- Easier debugging
- Better reuse
- Cleaner programs

---

## 18. Try These on Your Own

1. Write a function to find the factorial of a number.
2. Write a function to calculate `nCr` using factorial.
3. Write a function that adds two numbers.
4. Write a function that returns the cube of a number.
5. Write a function that prints a greeting message.

---

## Final Revision Box

### Essential Concepts

- Functions solve the problem of repetition and structure.
- A function can take parameters and return a value.
- `void` means no return value.
- `main` starts the program, but helper functions hold the logic.
- Factorial, `nCr`, add, and cube are standard beginner examples.
- Functions are a programming idea as much as a Java feature.

### What You Can Now Do

✓ Define and call functions
✓ Use parameters and return values correctly
✓ Build reusable logic for factorial, `nCr`, add, and cube
✓ Separate program flow from problem-solving logic
✓ Write cleaner and more modular code

Functions are where your code starts becoming organized software instead of just a sequence of statements.
