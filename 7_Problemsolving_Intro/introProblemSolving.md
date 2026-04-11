# Java Fundamentals - Introduction to Problem Solving

## Quick Reference (1-Minute Recall)

- Problem solving in programming means breaking down a real-world task into logical steps and then coding those steps.
- Every problem can be solved by identifying: inputs, outputs, and the process to go from inputs to outputs.
- You now know enough to solve simple but real problems: counting factors, checking prime numbers, summing numbers, finding square roots, and basic math operations.
- The key is to think step-by-step before writing code, never jump directly to typing.
- Time complexity matters: $O(n)$ is better than $O(n^2)$, and optimizing to $O(\sqrt{n})$ is often possible.
- Always start with a simple example, dry-run it by hand, then convert to code.
- Functions and loops are tools you use to solve problems, not the goal itself.

---

## Why Problem Solving Matters

Up to this point, you have learned the building blocks of programming: how to write variables, make decisions, repeat actions, organize code with functions, and build patterns.

But knowing the tools is not the same as knowing how to use them.

Problem solving is where programming becomes useful.

When you solve a problem, you are:

- Taking a real-world task.
- Breaking it into smaller steps.
- Using variables, loops, conditionals, and functions to implement those steps.
- Testing your solution against examples.

This is the jump from "learning programming" to "programming to solve problems."

The good news is: you already know all the language features you need. Now you just need to practice applying them.

The problems we will solve today are simple, but the thinking process is the same for harder problems later.

---

## 1. The Problem-Solving Framework

Every programming problem has three parts:

### Part 1: Understand the Problem

Before you code, you must understand what is being asked.

- What are the inputs?
- What are the outputs?
- What does "solve" mean for this problem?

### Part 2: Plan the Solution

Think through the steps logically.

- Do I need a loop?
- Do I need a function?
- What variables do I need?

### Part 3: Implement and Test

Write the code.

Then test it with the examples given in the problem.

### Example

**Problem**: Count the number of factors of a number `n`.

**Understand**:
- Input: a number `n` (like 24)
- Output: how many factors it has (like 8)
- A factor of `n` is any number that divides `n` evenly.

**Plan**:
- I need to check every number from 1 to `n`.
- For each number `i`, check if `n % i == 0`.
- If yes, it is a factor, so count it.

**Implement**:
- Use a loop to iterate from 1 to `n`.
- Use an if-statement to check divisibility.
- Use a counter variable to keep track of factors.

---

## 2. First Problem: Count the Factors of a Number

One of the first problems beginners solve is counting factors.

### What Is a Factor?

A factor of `n` is any number that divides `n` evenly (with no remainder).

For example:
- Factors of 24: 1, 2, 3, 4, 6, 8, 12, 24 (total: 8 factors)
- Factors of 36: 1, 2, 3, 4, 6, 9, 12, 18, 36 (total: 9 factors)

### The Naive Approach

Check every number from 1 to `n` and count how many divide evenly.

```java
int n = 24;
int count = 0;

for (int i = 1; i <= n; i++) {
	if (n % i == 0) {
		count++;
	}
}

System.out.println(count);
```

Output:

```text
8
```

### How This Works

1. Start with `count = 0`.
2. Loop from `i = 1` to `i = 24`.
3. For each `i`, check if `24 % i == 0` (no remainder).
4. If true, the number is a factor, so add 1 to count.
5. Print the total count.

### Dry Run Example

For `n = 24`:

- `i = 1`: `24 % 1 = 0` ✓ count = 1
- `i = 2`: `24 % 2 = 0` ✓ count = 2
- `i = 3`: `24 % 3 = 0` ✓ count = 3
- `i = 4`: `24 % 4 = 0` ✓ count = 4
- `i = 5`: `24 % 5 = 4` ✗ (skip)
- `i = 6`: `24 % 6 = 0` ✓ count = 5
- ...continuing...
- `i = 24`: `24 % 24 = 0` ✓ count = 8

Final count: 8

### Complete Program

```java
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int count = 0;

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				count++;
			}
		}

		System.out.println(count);
	}
}
```

### Input and Output

Input: `24`
Output: `8`

Input: `36`
Output: `9`

### Time Complexity

This solution runs a loop from 1 to `n`, so it takes $O(n)$ time.

For large `n`, this can be slow. But for now, this is the natural solution.

---

## 3. Why Factors Matter

Before we move on, understand why we solve this problem.

Counting factors is just one example. The thinking process is the same for many problems:

- Check each candidate.
- Apply a test (divisibility, primality, etc.).
- Count or track the results.

This loop-and-test pattern appears in almost every programming problem.

---

## 4. Second Problem: Check if a Number Is Prime

A prime number is a natural number greater than 1 that has no factors other than 1 and itself.

### What Is a Prime Number?

- 2, 3, 5, 7, 11, 13, 17, 19, 23 are prime.
- 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20 are not prime.

A number is prime if it has exactly 2 factors: 1 and itself.

### Approach 1: Using Factor Counting

A simple way is to count all factors. If the count is exactly 2, it is prime.

```java
int n = 7;
int count = 0;

for (int i = 1; i <= n; i++) {
	if (n % i == 0) {
		count++;
	}
}

if (count == 2) {
	System.out.println("Prime");
} else {
	System.out.println("Not Prime");
}
```

Output:

```text
Prime
```

### Approach 2: Optimized Primality Check

A faster way is to check if any number from 2 to `n-1` divides `n`.

If we find even one such number, `n` is not prime.

```java
int n = 7;
boolean isPrime = true;

for (int i = 2; i < n; i++) {
	if (n % i == 0) {
		isPrime = false;
		break;
	}
}

if (isPrime) {
	System.out.println("Prime");
} else {
	System.out.println("Not Prime");
}
```

Output:

```text
Prime
```

### Why Approach 2 Is Better

- Approach 1 checks every number from 1 to `n`.
- Approach 2 checks from 2 to `n-1` and stops early if a divisor is found.
- If we find any divisor, we already know the answer, so we `break`.

This is an example of optimization: the same logic, but faster.

### Even More Optimized: Check Only Up to Square Root

Here is a secret: if `n` has a factor greater than $\sqrt{n}$, it must also have a factor less than $\sqrt{n}$.

So we only need to check up to $\sqrt{n}$.

```java
int n = 7;
boolean isPrime = true;

for (int i = 2; i * i <= n; i++) {
	if (n % i == 0) {
		isPrime = false;
		break;
	}
}

if (isPrime) {
	System.out.println("Prime");
} else {
	System.out.println("Not Prime");
}
```

Output:

```text
Prime
```

### Why This Works

For `n = 36`:

- We check `i = 2`: `2 * 2 = 4 <= 36` ✓ Check if `36 % 2 == 0` → Yes, so not prime.
- We break immediately.

For `n = 7`:

- We check `i = 2`: `2 * 2 = 4 <= 7` ✓ Check if `7 % 2 == 0` → No.
- We check `i = 3`: `3 * 3 = 9 > 7` ✗ Stop.
- No divisors found, so it is prime.

### Complete Program

```java
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		boolean isPrime = true;

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}

		if (isPrime) {
			System.out.println("Prime");
		} else {
			System.out.println("Not Prime");
		}
	}
}
```

### Time Complexity

- Approach 1: $O(n)$
- Approach 2: $O(n)$ but with early termination (faster in practice)
- Approach 3 (square root): $O(\sqrt{n})$ (significantly faster for large `n`)

---

## 5. Optimization Idea: Square Root Check

The square root optimization is your first real optimization technique.

### Why It Works

If `n = a × b` and `a ≤ b`, then `a ≤ √n ≤ b`.

So if `a` is a factor, we will find it by checking only up to `√n`.

### Example

For `n = 36`:

- Factors are: 1, 2, 3, 4, 6, 9, 12, 18, 36.
- $\sqrt{36} = 6$.
- Factors up to 6: 1, 2, 3, 4, 6.
- We only need to check up to 6.

### How to Code It

Use `i * i <= n` instead of `i <= sqrt(n)` to avoid floating-point issues.

```java
for (int i = 2; i * i <= n; i++) {
	// check divisibility
}
```

This is cleaner and avoids rounding errors with square roots.

---

## 6. Third Problem: Sum of First `n` Natural Numbers

Another classic problem: find the sum of the first `n` natural numbers.

### What Does This Mean?

Sum of first `n` natural numbers = 1 + 2 + 3 + ... + n

For example:
- `n = 5`: 1 + 2 + 3 + 4 + 5 = 15
- `n = 10`: 1 + 2 + 3 + ... + 10 = 55

### Approach 1: Using a Loop

Use a loop to add each number from 1 to `n`.

```java
int n = 5;
int sum = 0;

for (int i = 1; i <= n; i++) {
	sum = sum + i;
}

System.out.println(sum);
```

Output:

```text
15
```

### Dry Run

For `n = 5`:

- `i = 1`: sum = 0 + 1 = 1
- `i = 2`: sum = 1 + 2 = 3
- `i = 3`: sum = 3 + 3 = 6
- `i = 4`: sum = 6 + 4 = 10
- `i = 5`: sum = 10 + 5 = 15

Final sum: 15

### Approach 2: Using a Formula

There is a mathematical formula for the sum of first `n` natural numbers:

$$
\text{Sum} = \frac{n(n+1)}{2}
$$

This means we can calculate it in one line, without a loop.

```java
int n = 5;
int sum = n * (n + 1) / 2;

System.out.println(sum);
```

Output:

```text
15
```

### Why the Formula Works

For `n = 5`:

$$
\text{Sum} = \frac{5 \times 6}{2} = \frac{30}{2} = 15
$$

### Comparison

- **Approach 1** (loop): Easy to understand. Works for any formula. Time: $O(n)$.
- **Approach 2** (formula): Very fast. Specific to this problem. Time: $O(1)$.

For beginners, always start with the loop approach. If the problem is solved many times, a formula may exist.

### Complete Program (Loop Approach)

```java
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int sum = 0;

		for (int i = 1; i <= n; i++) {
			sum = sum + i;
		}

		System.out.println(sum);
	}
}
```

---

## 7. Basic Math Operations: Absolute Value, Floor, Ceiling, Square Root

Sometimes problems require basic math operations. Here are the most common ones.

### Absolute Value

Absolute value of a number is its distance from zero, ignoring sign.

$|−5| = 5$, $|5| = 5$

In Java:

```java
int x = -5;
int absX = Math.abs(x);

System.out.println(absX);  // 5
```

### Floor and Ceiling

- **Floor** of a number is the largest integer less than or equal to it.
- **Ceiling** of a number is the smallest integer greater than or equal to it.

For example:

- Floor of 3.7 is 3.
- Ceiling of 3.7 is 4.
- Floor of 3.2 is 3.
- Ceiling of 3.2 is 4.

In Java:

```java
double x = 3.7;

int floor = (int) Math.floor(x);
int ceil = (int) Math.ceil(x);

System.out.println(floor);  // 3
System.out.println(ceil);   // 4
```

### Square Root

Square root of a number is the value that, when multiplied by itself, gives the original number.

$\sqrt{16} = 4$ because $4 \times 4 = 16$.

In Java:

```java
double x = 16;
double sqrtX = Math.sqrt(x);

System.out.println(sqrtX);  // 4.0
```

### When to Use Math Functions

- `Math.abs()`: When you need the magnitude of a number.
- `Math.floor()` and `Math.ceil()`: When rounding divisions or dealing with probabilities.
- `Math.sqrt()`: When checking primes (as we did with `i * i <= n`), or calculating distances.

---

## 8. Fourth Problem: Find the Floor Square Root of a Number

So far, we have used `Math.sqrt()`. But what if we want to find the square root ourselves, without using a built-in function?

This is a classic beginner problem that teaches you how to think algorithmically.

### What Is Floor Square Root?

The floor square root of `n` is the largest integer whose square is less than or equal to `n`.

For example:

- Floor square root of 16 is 4 (because $4 \times 4 = 16$).
- Floor square root of 20 is 4 (because $4 \times 4 = 16$ and $5 \times 5 = 25$, so 4 is the largest).
- Floor square root of 60 is 7 (because $7 \times 7 = 49$ and $8 \times 8 = 64$, so 7 is the largest).

### Approach 1: Brute Force Loop

Loop from 1 to `n` and keep track of the largest `i` where `i * i <= n`.

```java
int n = 20;
int ans = 1;

for (int i = 1; i * i <= n; i++) {
	ans = i;
}

System.out.println(ans);
```

Output:

```text
4
```

### How This Works

1. Start with `ans = 1`.
2. Loop while `i * i <= n`.
3. Keep updating `ans = i`.
4. When `i * i > n`, the loop stops.
5. `ans` holds the floor square root.

### Dry Run for n = 20

- `i = 1`: `1 * 1 = 1 <= 20` ✓ ans = 1
- `i = 2`: `2 * 2 = 4 <= 20` ✓ ans = 2
- `i = 3`: `3 * 3 = 9 <= 20` ✓ ans = 3
- `i = 4`: `4 * 4 = 16 <= 20` ✓ ans = 4
- `i = 5`: `5 * 5 = 25 > 20` ✗ Stop

Final answer: 4

### Examples

- Floor square root of 16: ans = 4 (because $4 \times 4 = 16$)
- Floor square root of 31: ans = 5 (because $5 \times 5 = 25$ and $6 \times 6 = 36$)
- Floor square root of 29: ans = 5 (because $5 \times 5 = 25$ and $6 \times 6 = 36$)
- Floor square root of 60: ans = 7 (because $7 \times 7 = 49$ and $8 \times 8 = 64$)

### Complete Program

```java
import java.util.Scanner;

public class Main {
	public static int floorSqrt(int n) {
		int ans = 1;

		for (int i = 1; i * i <= n; i++) {
			ans = i;
		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int result = floorSqrt(n);
		System.out.println(result);
	}
}
```

### Input and Output

Input: `20`
Output: `4`

Input: `60`
Output: `7`

### Time Complexity

This solution runs a loop from 1 to approximately $\sqrt{n}$, so it takes $O(\sqrt{n})$ time.

This is already much faster than checking every number up to `n`.

### Why Learn This?

Learning to calculate square root manually teaches you:

- How to think in terms of mathematical properties (if `i * i > n`, we have gone too far).
- How to use a loop to find a value that satisfies a condition.
- The concept of searching for a boundary (the largest `i` where `i * i <= n`).

This thinking applies to many other problems as well.

---

## 9. Put It Together: A Complete Example

Let us solve a slightly harder problem using what we have learned.

### Problem: Find All Prime Numbers Up to `n`

Given a number `n`, print all prime numbers from 2 to `n`.

### Approach

- Loop through numbers from 2 to `n`.
- For each number, check if it is prime.
- If it is, print it.

### Code

```java
import java.util.Scanner;

public class Main {
	public static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}

		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}
}
```

### How It Works

- We create a helper function `isPrime()` that checks if a number is prime.
- In `main()`, we loop from 2 to `n`.
- For each number, we call `isPrime()`.
- If it returns true, we print the number.

### Sample Run

Input: `20`

Output:

```text
2
3
5
7
11
13
17
19
```

### Why This Example Is Important

It shows how to:

1. Use functions to organize logic.
2. Call functions repeatedly in a loop.
3. Combine multiple concepts (loops, functions, conditionals).

This is the essence of problem solving.

---

## 10. Common Problem Patterns: Recognizing Similar Structures

As you solve more problems, you will notice that many problems follow the same logical patterns. Learning these patterns helps you solve new problems faster.

### Pattern 1: Counting

You need to count how many items satisfy a condition.

**Structure:**
```java
int count = 0;

for (int i = start; i <= end; i++) {
	if (condition) {
		count++;
	}
}
```

**Examples:** Count factors, count primes up to n, count even numbers, count vowels.

### Pattern 2: Summing (Accumulation)

You need to add up values that satisfy a condition.

**Structure:**
```java
int sum = 0;

for (int i = start; i <= end; i++) {
	sum = sum + i;  // or sum += i
}
```

**Examples:** Sum of natural numbers, sum of odd numbers, sum of digits.

### Pattern 3: Finding a Maximum

You need to find the largest value in a range or matching a condition.

**Structure:**
```java
int max = Integer.MIN_VALUE;  // or the first element

for (int i = start; i <= end; i++) {
	if (array[i] > max) {
		max = array[i];
	}
}
```

**Examples:** Largest factor, largest prime below n, highest digit.

### Pattern 4: Searching

You need to find if something exists or where it is.

**Structure:**
```java
boolean found = false;

for (int i = start; i <= end; i++) {
	if (condition) {
		found = true;
		break;
	}
}
```

**Examples:** Check if prime, find a specific number, check if digit exists.

### Pattern 5: Boundary Finding

You need to find the largest value that satisfies a condition (like floor square root).

**Structure:**
```java
int ans = startValue;

for (int i = start; condition; i++) {
	ans = i;
}
```

**Examples:** Floor square root, largest factor, binary search (advanced).

### Why Patterns Matter

When you see a new problem:

1. Identify what it is asking for (count? sum? find max?).
2. Match it to a pattern.
3. Adapt the pattern to your specific problem.

This reduces the thinking time and increases accuracy.

---

## 11. Understanding Loop Boundaries: `<=` vs `<`

One of the trickiest parts of writing loops is deciding whether to use `<=` or `<` in the condition. Getting this wrong causes off-by-one errors.

### The Core Rule

- `i <= n` means: process when `i` equals `n` (inclusive).
- `i < n` means: stop before `i` equals `n` (exclusive).

### Example 1: Counting Factors

Factors of 24 are: 1, 2, 3, 4, 6, 8, 12, 24.

Notice that 24 itself is a factor. So you must include 24 in the check.

```java
for (int i = 1; i <= n; i++) {  // Use <= to include n
	if (n % i == 0) {
		count++;
	}
}
```

If you used `i < n`, you would miss the factor `n` itself.

### Example 2: Sum of First n Natural Numbers

To sum 1, 2, 3, ..., n, you must include `n`.

```java
for (int i = 1; i <= n; i++) {  // Use <= to include n
	sum = sum + i;
}
```

With `i < n`, you would get 1 + 2 + ... + (n-1), which is wrong.

### Example 3: Check Divisibility for Prime

To check if `n` is prime, you check divisors from 2 to `√n`.

But should you include `√n`?

For `n = 36`, we check: 2, 3, 4, 5, 6.

Notice: 6 × 6 = 36, so 6 is a divisor of 36. We must check it.

```java
for (int i = 2; i * i <= n; i++) {  // Use <= to include the boundary
	if (n % i == 0) {
		return false;
	}
}
```

### How to Decide

Ask yourself: **Should the boundary value be included in the processing?**

- **Counting factors**: Yes, include `n`. Use `<=`.
- **Summing 1 to n**: Yes, include `n`. Use `<=`.
- **Checking primes**: Yes, include the boundary. Use `i * i <= n`.
- **Skipping first element**: No, exclude index 0. Use `i < n` (start from 1).

### The Off-by-One Error

An off-by-one error happens when your loop is off by exactly one iteration.

- Using `<` when you meant `<=` → You skip one element.
- Using `<=` when you meant `<` → You process one extra element.

---

## 12. Variable Initialization: Why Starting Values Matter

The initial value of a variable is critical. Choosing the wrong starting value breaks your entire solution.

### Pattern 1: Counting

Start with `count = 0`.

```java
int count = 0;

for (int i = 1; i <= n; i++) {
	if (n % i == 0) {
		count++;
	}
}
```

**Why 0?** Because you have counted 0 things before the loop starts. Then you increment for each thing found.

**Wrong:** Starting with `count = 1` would give you a count that is off by 1.

### Pattern 2: Summing

Start with `sum = 0`.

```java
int sum = 0;

for (int i = 1; i <= n; i++) {
	sum = sum + i;
}
```

**Why 0?** Because 0 is the identity for addition. Adding 0 to anything gives the same thing.

**Wrong:** Starting with `sum = 1` would make your answer wrong by 1.

### Pattern 3: Finding Maximum

Start with `Integer.MIN_VALUE` (or the smallest possible value).

```java
int max = Integer.MIN_VALUE;

for (int i = 1; i <= n; i++) {
	if (array[i] > max) {
		max = array[i];
	}
}
```

**Why `Integer.MIN_VALUE`?** Because all real values are greater than it. This ensures the first real value will be captured as the max.

**Wrong:** Starting with `max = 0` would miss negative numbers.

### Pattern 4: Finding Floor Square Root

Start with `ans = 1` (or the smallest meaningful value).

```java
int ans = 1;

for (int i = 1; i * i <= n; i++) {
	ans = i;
}
```

**Why 1?** Because the floor square root of any number ≥ 1 is at least 1.

**Wrong:** Starting with `ans = 0` would give wrong answers.

### The Rule

- **For counting**: Start with 0.
- **For summing**: Start with 0.
- **For maximum**: Start with `Integer.MIN_VALUE` or the first element.
- **For minimum**: Start with `Integer.MAX_VALUE` or the first element.
- **For boundary finding**: Start with the smallest valid value for the problem.

---

## 13. Input Validation: Checking Before Processing

Before you process input, check if it is valid. This prevents crashes and wrong answers.

### Why Validate?

Users might give negative numbers, zero, or extremely large numbers when your algorithm expects positive integers only.

### Example: Prime Number Checker

Prime numbers are defined for numbers greater than 1.

```java
int n = scn.nextInt();

if (n < 2) {
	System.out.println("Not Prime");  // 0, 1, and negative are not prime
	return;
}

// Now safely check the rest
boolean isPrime = true;
for (int i = 2; i * i <= n; i++) {
	if (n % i == 0) {
		isPrime = false;
		break;
	}
}
```

### Example: Sum of First n Natural Numbers

This only makes sense for n ≥ 0.

```java
int n = scn.nextInt();

if (n < 0) {
	System.out.println("Invalid input");
	return;
}

int sum = (n * (n + 1)) / 2;
System.out.println(sum);
```

### Common Input Checks

- **Negative numbers**: Use `if (n < 0)`.
- **Zero**: Use `if (n == 0)`.
- **Range**: Use `if (n < min || n > max)`.
- **Type mismatch**: Use try-catch for parseInt errors (advanced).

### Best Practice

Always test with:
- Normal cases (what you expect).
- Edge cases (0, 1, negative).
- Boundary cases (max int, very large numbers).

---

## 14. Debugging Your Code: Finding and Fixing Logic Errors

Debugging is the process of finding and fixing bugs in your code. This is as important as writing code in the first place.

### Common Debugging Steps

### Step 1: Identify the Bug

Run your code with an example. Does the output match the expected output?

**Example:** Checking if 9 is prime.

Expected: Not Prime
Your output: Prime → Bug detected!

### Step 2: Trace the Execution

Use a dry run to trace what your code does.

**Example:** Let's trace the prime-checking code for `n = 9`.

```java
boolean isPrime = true;

for (int i = 2; i * i <= 9; i++) {
	if (9 % i == 0) {
		isPrime = false;
		break;
	}
}

System.out.println(isPrime);  // What does this print?
```

**Trace:**
- `i = 2`: `2 * 2 = 4 <= 9` ✓ → Check `9 % 2 = 1` (not 0) → continue
- `i = 3`: `3 * 3 = 9 <= 9` ✓ → Check `9 % 3 = 0` → DIVISOR FOUND!
- `isPrime = false`, then `break`
- Loop ends

**Output:** `false` (correct! 9 is not prime)

This trace shows the code is working correctly. If your output was "Prime" instead, the bug is somewhere else (maybe you forgot to set `isPrime = false`, or you forgot the `break` statement, or you print the wrong variable).

### Step 3: Add Print Statements

Add `System.out.println()` at key points to see what values variables have.

```java
boolean isPrime = true;

for (int i = 2; i * i <= n; i++) {
	System.out.println("Checking i = " + i + ", n % i = " + (n % i));
	if (n % i == 0) {
		isPrime = false;
		break;
	}
}

System.out.println("isPrime = " + isPrime);
```

### Step 4: Compare with Expected Values

At each step, ask: Is this value what I expected?

- If yes, move to the next step.
- If no, the bug is near this step.

### Common Bugs to Look For

1. **Wrong operator**: Using `+` instead of `*`, or `>` instead of `>=`.
2. **Wrong variable**: Using `i` instead of `n`, or `count` instead of `sum`.
3. **Missing break**: Loop continues after finding the answer.
4. **Wrong initialization**: Starting with the wrong value.
5. **Off-by-one**: Using `<` instead of `<=` or vice versa.

### Example: Fixing a Bug

**Wrong Code:**
```java
int count = 1;  // BUG: should be 0

for (int i = 1; i <= n; i++) {
	if (n % i == 0) {
		count++;
	}
}
```

**Trace:** For n = 6:
- count starts at 1 (should be 0!)
- i = 1: 6 % 1 = 0 → count = 2
- i = 2: 6 % 2 = 0 → count = 3
- i = 3: 6 % 3 = 0 → count = 4
- i = 4: 6 % 4 = 2 → skip
- i = 5: 6 % 5 = 1 → skip
- i = 6: 6 % 6 = 0 → count = 5

**Output:** 5 (wrong! Should be 4)

**Fix:** Change `int count = 1` to `int count = 0`.

---

## 15. Off-by-One Errors: The Most Notorious Beginner Mistake

Off-by-one errors are so common and so frustrating that they deserve their own section. An off-by-one error means your code is off by exactly one: you process one too few or one too many items.

### Why Off-by-One Errors Happen

They happen at the boundary of loops: the place where you decide if the loop should stop or continue.

### Example 1: Counting Factors (Classic Off-by-One)

**Wrong Code:**
```java
int count = 0;

for (int i = 1; i < n; i++) {  // BUG: using < instead of <=
	if (n % i == 0) {
		count++;
	}
}

System.out.println(count);
```

**For n = 6:**

Factors are: 1, 2, 3, 6 (total: 4 factors)

But your loop goes from `i = 1` to `i = 5` (stops before 6).

- `i = 1`: 6 % 1 = 0 ✓ count = 1
- `i = 2`: 6 % 2 = 0 ✓ count = 2
- `i = 3`: 6 % 3 = 0 ✓ count = 3
- `i = 4`: 6 % 4 = 2 ✗
- `i = 5`: 6 % 5 = 1 ✗
- (Loop stops, never checks i = 6)

**Output:** 3 (wrong! Should be 4)

**Fix:** Use `i <= n` instead of `i < n`.

### Example 2: Summing 1 to n (Another Classic)

**Wrong Code:**
```java
int sum = 0;

for (int i = 1; i < n; i++) {  // BUG: using < instead of <=
	sum = sum + i;
}

System.out.println(sum);
```

**For n = 5:**

Expected: 1 + 2 + 3 + 4 + 5 = 15

But your loop goes from 1 to 4:

- sum = 0 + 1 + 2 + 3 + 4 = 10

**Output:** 10 (wrong! Should be 15)

**Fix:** Use `i <= n` instead of `i < n`.

### Example 3: Array Indexing (Different Kind)

**Wrong Code:**
```java
int[] arr = {10, 20, 30, 40, 50};  // 5 elements, indices 0-4

for (int i = 0; i <= arr.length; i++) {  // BUG: using <= instead of <
	System.out.println(arr[i]);
}
```

**What happens:**

- `i = 0` to `i = 4`: Prints elements correctly (10, 20, 30, 40, 50)
- `i = 5`: Tries to access `arr[5]` → **ArrayIndexOutOfBoundsException**! The array only has indices 0-4.

**Fix:** Use `i < arr.length` instead of `i <= arr.length`.

### Why the Rule Differs

- **Counting factors**: The factor `n` is valid. Include it with `<=`.
- **Arrays**: Indices go from 0 to `length - 1`. Use `<` to exclude `length`.

### The Prevention Technique

Before writing the loop, ask:

1. **What is the first value I need to process?** (Usually 1 or 0)
2. **What is the last value I need to process?** (Is it `n`? Is it `n - 1`? Is it `arr.length - 1`?)
3. **Which comparison includes the last value in my range?**
   - If last value is `n`, use `<=`.
   - If last value is `n - 1`, use `<`.

### Example: Prime Check (Getting It Right)

**For `n = 36`:** We want to check divisors 2, 3, 4, 5, 6 (up to √36).

Question: Is 6 a valid boundary?
- Yes, because 6 × 6 = 36. We must check it.

So we use `i * i <= n` (includes 6).

**For `n = 35`:** We want to check divisors 2, 3, 4, 5 (up to √35 ≈ 5.9).

- `i = 5`: `5 * 5 = 25 <= 35` ✓ Check it.
- `i = 6`: `6 * 6 = 36 > 35` ✗ Don't check.

Using `i * i <= n` is correct.

### Debugging Off-by-One Errors

If you suspect an off-by-one error:

1. **Count the expected items manually**.
2. **Trace the loop** and count what it actually processes.
3. **Compare the two counts**. They should match.
4. **Check the boundary**: Is the last iteration included or excluded?

### A Mental Checklist

When you finish a loop, ask:

- [ ] Does my loop include the boundary value I intended?
- [ ] Have I manually counted expected vs actual items?
- [ ] For arrays, am I staying within valid indices (0 to length-1)?
- [ ] If I change `<=` to `<`, does the logic still make sense?

Off-by-one errors are frustrating, but they are also entirely preventable with careful thinking.

---

## 16. Common Beginner Mistakes in Problem Solving

### Mistake 1: Not Understanding the Problem

You start coding before you understand what the problem is asking.

**Fix:** Always read the problem twice. Write down the inputs and outputs. Think about examples.

### Mistake 2: Jumping Straight to Code

You get excited and start typing without planning.

**Fix:** Spend 2-3 minutes planning on paper. What loop do I need? What variables?

### Mistake 3: Not Testing with Examples

You write code and assume it works.

**Fix:** Always test your code with the given examples. Do a dry run by hand first.

### Mistake 4: Forgetting Edge Cases

You test with normal cases but forget special cases like `n = 0`, `n = 1`, or negative numbers.

**Fix:** Think about what happens at the boundaries. Test those cases.

### Mistake 5: Mixing Up Loops and Conditions

You use a while loop when a for loop is clearer, or a condition inside a loop that breaks it.

**Fix:** Choose the right tool for the job. Loops repeat. Conditions make decisions. Use both together.

### Mistake 6: Not Considering Time Complexity

You write a solution that works but is very slow for large inputs.

**Fix:** Think about how many operations your code does. Is it $O(n)$? $O(n^2)$? Can you do better?

---

## 17. The Problem-Solving Mindset

Great problem solvers follow a consistent process:

### Step 1: Understand

- Read the problem carefully.
- Identify the inputs and outputs.
- Work through the given example by hand.

### Step 2: Plan

- Sketch the algorithm on paper.
- Identify what loops and functions you need.
- Think about edge cases.

### Step 3: Code

- Write the code based on your plan.
- Use meaningful variable names.
- Add comments for complex parts.

### Step 4: Test

- Run the code with given examples.
- Test edge cases.
- Check for off-by-one errors.

### Step 5: Optimize

- Does the code run fast enough?
- Can the logic be simplified?
- Can you use a formula instead of a loop?

---

## 18. A Thinking Checklist for Every Problem

Before you submit a solution, ask:

1. Do I understand what the problem is asking?
2. Have I identified the inputs and outputs?
3. Have I written code that handles the given examples?
4. Have I tested edge cases (like `n = 0`, `n = 1`)?
5. Did I use a logical loop (for or while)?
6. Did I use a logical condition (if or if-else)?
7. Have I used meaningful variable names?
8. Does the time complexity seem reasonable?

If you can answer yes to all of these, your solution is likely correct.

---

## 19. Practice Summary

Here is the short version of what you should take away from this lesson.

### Core Ideas

- Problem solving is step-by-step thinking, not random coding.
- Understand → Plan → Code → Test → Optimize.
- Factors and divisibility are checked using the modulo operator: `%`.
- Prime numbers have no factors other than 1 and themselves.
- The sum of first `n` natural numbers can be done with a loop or a formula.
- The square root optimization reduces the work from $O(n)$ to $O(\sqrt{n})$.
- Time complexity matters: prefer faster algorithms when possible.

### Common Problem Patterns

- **Counting**: `count = 0`, then `count++` for each match.
- **Summing**: `sum = 0`, then `sum += value` for each item.
- **Finding Maximum**: `max = Integer.MIN_VALUE`, then update if `value > max`.
- **Searching**: `found = false`, then set to true and `break` when found.
- **Boundary Finding**: `ans = start`, then update while condition holds.

### Critical Details

- **Loop Boundaries**: Use `<=` to include the boundary, use `<` to exclude it. Choose based on the problem.
- **Variable Initialization**: Counting starts at 0, summing starts at 0, finding max starts at `Integer.MIN_VALUE`.
- **Input Validation**: Always check if input is valid (non-negative, in range, etc.) before processing.
- **Debugging**: Use print statements and dry runs to trace execution. Compare actual vs expected values at each step.

### The Four Core Problems

1. **Count Factors**: Loop from 1 to `n`, check `n % i == 0`.
2. **Prime Check**: Loop from 2 to `√n`, check if any number divides the input.
3. **Sum of Natural Numbers**: Loop from 1 to `n` and add, or use the formula $\frac{n(n+1)}{2}$.
4. **Floor Square Root**: Loop while `i * i <= n`, keep track of largest `i`.

### The Pattern

Every problem follows:

- Read and understand.
- Loop and check.
- Count or calculate.
- Print the result.

---

## 20. Try These on Your Own

1. Write a program to count the number of factors of a given number.
2. Write a program to check if a number is prime.
3. Write a program to find the sum of first `n` natural numbers.
4. Write a program to find the floor square root of a number.
5. Write a program to find all prime numbers up to `n`.
6. Write a program to count the number of prime factors of a given number.
7. Write a program to find the greatest common divisor (GCD) of two numbers using a loop.
8. Write a program to check if a number is a perfect square.

---

## Final Revision Box

### Essential Concepts

- Problem solving is about understanding the problem, planning the solution, coding it, and testing it.
- **Common patterns**: Counting, summing, finding max, searching, boundary finding.
- **Loop boundaries**: Use `<=` to include boundary, `<` to exclude. Choose based on problem requirements.
- **Variable initialization**: Start with correct values (0 for count/sum, MIN_VALUE for max).
- **Input validation**: Check if input is reasonable before processing.
- **Factors and divisibility**: Use `n % i == 0` to check if `i` divides `n`.
- **Prime numbers**: A number is prime if it has exactly two factors (1 and itself).
- **Optimization**: The square root trick reduces checking from $O(n)$ to $O(\sqrt{n})$.
- **Debugging**: Use print statements and dry runs to find logic errors. Trace step-by-step.
- **Time complexity**: $O(n)$ is good, $O(\sqrt{n})$ is better, understand your algorithm's efficiency.

### What You Can Now Do

✓ Recognize and classify problems into pattern categories (count, sum, max, search, boundary)
✓ Understand and explain loop boundaries (`<=` vs `<`)
✓ Choose correct variable initialization for different patterns
✓ Validate input before processing
✓ Count factors of a number efficiently
✓ Check if a number is prime (optimized version with square root)
✓ Calculate the sum of natural numbers (both loop and formula)
✓ Find the floor square root of a number without Math.sqrt()
✓ Use `Math` functions like `abs()`, `floor()`, `ceil()`, `sqrt()`
✓ Combine loops, functions, and conditionals to solve real problems
✓ Think about time complexity while solving problems
✓ Test your solution with examples and edge cases
✓ Debug code using tracing, print statements, and dry runs
✓ Apply common problem patterns to solve new problems

### Beyond This Lesson

Problem solving is not just about learning patterns—it is about developing a mindset. Each problem you solve builds your intuition. With practice, you will:

- See patterns faster.
- Write fewer bugs.
- Optimize naturally without overthinking.
- Solve harder problems with the same framework.

The logic you learn here applies to all programming, whether you are building a web app, analyzing data, or writing a game. Master this foundation, and you can learn anything.

Problem solving is where you become a real programmer. The problems get harder from here, but the thinking process stays the same.
