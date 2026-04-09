# Java Fundamentals - Loops

## Quick Reference (1-Minute Recall)

- `if-else` helps you choose between two paths.
- `while` repeats a block as long as a condition stays `true`.
- `do-while` runs the block at least once, then checks the condition.
- `for` is used when you know how many times you want to repeat something.
- Nested loops are used when one repetition depends on another (for example, rows and columns).
- `break` exits a loop immediately.
- `continue` skips the rest of the current iteration and moves to the next one.
- Off-by-one errors happen when loop boundaries (`<`, `<=`) are chosen incorrectly.
- A variable declared inside a loop block exists only inside that block.
- Time complexity of a single simple loop is usually linear, written as $O(n)$.
- Use `%` to check divisibility, which is especially useful in loop problems.

## Why Loops Matter

In the previous lesson, you learned how to make decisions with `if`, `if-else`, and `if-else if-else`. That gave your program the ability to choose between different paths.

Loops take that one step further. Instead of choosing a path once, they let your program repeat a path many times. That is the difference between writing code for a single action and writing code for a pattern of actions.

If your task is to print something once, an `if` statement might be enough. But if your task is to print something 10 times, check every number from 1 to `n`, or keep asking until the user enters a valid value, then loops are the right tool.

There are two big ideas in this lesson:

- `while` loops focus on repetition based on a condition.
- `for` loops focus on repetition with a clear start, stop, and update.

We will also look at `break` and `continue`, because those two statements help you control a loop from the inside.

---

## 1. A Quick Revision of `if-else`

Before jumping into loops, it helps to remember how `if-else` works, because loops often use the same kind of boolean conditions.

### Basic Idea

If the condition is `true`, run one block. If it is `false`, run another block.

```java
int budget = 3000;

if (budget >= 7000) {
	System.out.println("Shimla trip is possible");
} else {
	System.out.println("Need a cheaper destination");
}
```

Here the program makes a decision based on the value of `budget`.

### Example: Even or Odd

One of the simplest `if-else` examples is checking whether a number is even or odd.

```java
import java.util.Scanner;

Scanner scn = new Scanner(System.in);
int n = scn.nextInt();

if (n % 2 == 0) {
	System.out.println("Even");
} else {
	System.out.println("Odd");
}
```

Reasoning:

- An even number is divisible by 2.
- If `n % 2` is `0`, there is no remainder.
- If there is a remainder, the number is odd.

This same kind of condition shows up again and again in loop problems.

---

## 2. The `while` Loop: Repeat Until the Condition Stops Being True

The `while` loop is the most direct loop in Java. It keeps running a block of code as long as its condition is `true`.

### Syntax

```java
while (condition) {
	// statements to repeat
}
```

### How It Works

1. Check the condition.
2. If it is `true`, run the loop body.
3. Go back and check the condition again.
4. Stop when the condition becomes `false`.

That makes `while` perfect for problems where you do not always know the exact number of repetitions in advance.

### Example: Print Numbers from 1 to 5

```java
int i = 1;

while (i <= 5) {
	System.out.println(i);
	i++;
}
```

What happens here:

- Start with `i = 1`.
- Check `i <= 5`.
- Print the current value of `i`.
- Increase `i` by 1.
- Repeat until `i` becomes `6`.

Output:

```text
1
2
3
4
5
```

### The Three Parts of a Loop

Every loop needs three things:

- Initialization: where the variable starts.
- Condition: when the loop should keep running.
- Update: how the variable changes after each iteration.

For the example above:

- Initialization: `int i = 1;`
- Condition: `i <= 5`
- Update: `i++`

If you forget the update, the loop can become infinite.

### Example: Countdown

```java
int i = 5;

while (i >= 1) {
	System.out.println(i);
	i--;
}
```

Output:

```text
5
4
3
2
1
```

This is the same pattern, just moving in the opposite direction.

### Common While Loop Mistake

```java
int i = 1;

while (i <= 5) {
	System.out.println(i);
}
```

This looks fine at first, but it never changes `i`. The condition stays `true` forever, so the loop never ends.

That is why the update step matters.

### While Loop Quiz

**Quiz 1**

```java
int i = 3;

while (i <= 5) {
	System.out.println(i);
	i++;
}
```

Output:

```text
3
4
5
```

**Quiz 2**

```java
int i = 5;

while (i < 5) {
	System.out.println(i);
	i++;
}
```

Output:

```text
```

Reason: the condition is false at the start, so the loop body never runs.

**Quiz 3**

```java
int i = 1;

while (i <= 3) {
	System.out.println(i);
	i += 2;
}
```

Output:

```text
1
3
```

---

## 3. The `for` Loop: When You Know the Count

The `for` loop is a cleaner way to write repetition when you already know the pattern.

### Syntax

```java
for (initialization; condition; update) {
	// statements to repeat
}
```

### What Each Part Means

- Initialization runs once at the beginning.
- Condition is checked before every iteration.
- Update runs after every iteration.

### Example: Print 1 to 5

```java
for (int i = 1; i <= 5; i++) {
	System.out.println(i);
}
```

This does exactly the same thing as the `while` loop version, but the structure is tighter and easier to read.

### Why `for` Is Popular

When you are counting from one value to another, `for` makes the loop logic very clear. You can see the start, stop, and update in one line.

That is why you will often see `for` loops in:

- Counting problems
- Array traversal
- Pattern printing
- Basic math and logic exercises

### Example: Print Even Numbers from 2 to 10

```java
for (int i = 2; i <= 10; i += 2) {
	System.out.println(i);
}
```

Output:

```text
2
4
6
8
10
```

### Example: Print the Last Digit of a Number Repeatedly While Shrinking It

Sometimes a loop is used to slowly break a number apart.

```java
int n = 26348;

while (n > 0) {
	int lastDigit = n % 10;
	System.out.println(lastDigit);
	n = n / 10;
}
```

What happens here:

- `n % 10` gives the last digit.
- `n / 10` removes the last digit.
- The loop keeps shrinking the number until `n` becomes 0.

For `26348`, the printed digits will be:

```text
8
4
3
6
2
```

This kind of pattern is very common in beginner loop questions.

### For Loop Quiz

**Quiz 4**

```java
for (int i = 1; i <= 3; i++) {
	System.out.println(i);
}
```

Output:

```text
1
2
3
```

**Quiz 5**

```java
for (int i = 5; i >= 1; i--) {
	System.out.println(i);
}
```

Output:

```text
5
4
3
2
1
```

**Quiz 6**

```java
for (int i = 0; i < 5; i += 2) {
	System.out.println(i);
}
```

Output:

```text
0
2
4
```

---

## 4. Scope Inside a Loop

One small detail that matters a lot in Java is variable scope.

If you declare a variable inside a loop block, that variable only exists inside that block.

```java
for (int i = 1; i <= 3; i++) {
	int lastDigit = i % 10;
	System.out.println(lastDigit);
}
```

Here, `lastDigit` is created inside the loop body. Once one iteration finishes, that variable is gone. On the next iteration, a fresh `lastDigit` is created again.

That is why the rule is often stated like this:

- A variable created inside a loop gets deleted once the iteration is complete.

More precisely, it goes out of scope at the end of the block.

### Why This Matters

This prevents accidental reuse of temporary values outside the place where they were meant to exist. It also keeps your code cleaner.

### Example

```java
for (int i = 1; i <= 3; i++) {
	int square = i * i;
	System.out.println(square);
}

// square cannot be used here
```

If you try to use `square` after the loop, Java will complain because `square` only lived inside the loop.

---

## 5. Counting Factors of a Number

One classic beginner loop problem is finding the factors of a positive number.

A factor of a number is any value that divides it completely, with no remainder.

### Example

For `12`, the factors are:

```text
1, 2, 3, 4, 6, 12
```

For `17`, the factors are:

```text
1, 17
```

For `24`, the factors are:

```text
1, 2, 3, 4, 6, 8, 12, 24
```

### Important Observation

Every positive number has at least two factors:

- Minimum factor: `1`
- Maximum factor: the number itself

### Simple Factor-Finding Loop

```java
int n = 10;

for (int i = 1; i <= n; i++) {
	if (n % i == 0) {
		System.out.println(i);
	}
}
```

How it works:

- Test every number from `1` to `n`.
- If `n % i == 0`, then `i` is a factor.
- Print all such values.

For `n = 10`, the output is:

```text
1
2
5
10
```

### Factor Quiz Walkthrough

If `n = 24`, the loop checks every number from `1` to `24`.

- `24 % 1 == 0` so `1` is a factor.
- `24 % 2 == 0` so `2` is a factor.
- `24 % 3 == 0` so `3` is a factor.
- `24 % 4 == 0` so `4` is a factor.
- `24 % 6 == 0` so `6` is a factor.
- `24 % 8 == 0` so `8` is a factor.
- `24 % 12 == 0` so `12` is a factor.
- `24 % 24 == 0` so `24` is a factor.

This is exactly the kind of logic loops are built for.

### A Smarter Version

If you want to improve the basic approach later, you can check only up to `sqrt(n)`. But for now, the simple version is the best place to learn the idea clearly.

---

## 6. `continue`: Skip the Rest and Move On

The `continue` statement does not stop the loop. It simply skips the rest of the current iteration and jumps to the next one.

### Syntax

```java
for (int i = 1; i <= 5; i++) {
	if (i == 3) {
		continue;
	}
	System.out.println(i);
}
```

### What Happens

- When `i` is `1`, it prints `1`.
- When `i` is `2`, it prints `2`.
- When `i` is `3`, `continue` skips the print statement.
- Then the loop moves to `4` and `5`.

Output:

```text
1
2
4
5
```

### Why `continue` Is Useful

It is handy when you want to ignore some values without ending the whole loop.

For example:

```java
for (int i = 1; i <= 10; i++) {
	if (i % 2 == 0) {
		continue;
	}
	System.out.println(i);
}
```

This prints only the odd numbers.

### Continue Quiz

**Quiz 7**

```java
for (int i = 1; i <= 5; i++) {
	if (i == 4) {
		continue;
	}
	System.out.println(i);
}
```

Output:

```text
1
2
3
5
```

---

## 7. `break`: Stop the Loop Completely

If `continue` skips one iteration, `break` ends the loop immediately.

### Example

```java
for (int i = 1; i <= 5; i++) {
	if (i == 4) {
		break;
	}
	System.out.println(i);
}
```

Output:

```text
1
2
3
```

When `i` becomes `4`, the loop stops right there.

### Why `break` Is Useful

It is useful when you have found what you were looking for and no longer need to keep searching.

Examples include:

- Searching for a value
- Stopping after a match is found
- Exiting early from a loop when the goal is reached

### `break` vs `continue`

- `break` exits the loop.
- `continue` skips one iteration.

That distinction is important.

---

## 8. Putting It All Together

Once you know `if-else`, `while`, `for`, `break`, and `continue`, you can solve many beginner programming problems.

### Example: Print Only Numbers Divisible by 3

```java
for (int i = 1; i <= 20; i++) {
	if (i % 3 != 0) {
		continue;
	}
	System.out.println(i);
}
```

Output:

```text
3
6
9
12
15
18
```

### Example: Stop When a Number is Found

```java
for (int i = 1; i <= 10; i++) {
	if (i == 7) {
		System.out.println("Found 7");
		break;
	}
	System.out.println(i);
}
```

This prints numbers until `7` is reached, then stops.

---

## 9. Common Beginner Mistakes

### Mistake 1: Forgetting the Update Step

```java
int i = 1;

while (i <= 5) {
	System.out.println(i);
}
```

This becomes an infinite loop because `i` never changes.

### Mistake 2: Putting the Update in the Wrong Place

If the update happens only sometimes, the loop may behave in a confusing way. Usually, the update should happen once in every iteration unless there is a very specific reason not to.

### Mistake 3: Using the Wrong Condition

If the condition is wrong, the loop may run too many times or not run at all.

### Mistake 4: Confusing `break` and `continue`

- `break` stops the loop.
- `continue` skips the current pass.

### Mistake 5: Forgetting Scope Rules

Variables created inside the loop are not available outside it.

---

## 10. Practice Summary

Here is the short version of what you should remember from this lesson.

### Core Ideas

- Use `if-else` when you want to choose between two paths.
- Use `while` when the repetition depends on a condition.
- Use `for` when you know the repetition pattern clearly.
- Use `break` to exit a loop early.
- Use `continue` to skip one iteration.
- Remember that loop variables and temporary values may only exist inside the loop block.

### Loop Thinking Pattern

When solving a problem, ask yourself:

1. What should repeat?
2. What starts the loop?
3. When should the loop stop?
4. What should change after each iteration?

If you can answer those four questions, the loop usually becomes much easier to write.

---

## 11. Try These on Your Own

1. Print all numbers from 1 to 10 using a `for` loop.
2. Print all even numbers from 1 to 20 using a `while` loop.
3. Read a number and print all of its factors.
4. Print numbers from 1 to 10 but skip `5` using `continue`.
5. Print numbers from 1 to 10 and stop when you reach `7` using `break`.

---

## 12. The `do-while` Loop: Execute First, Check Later

So far, you have seen loops where the condition is checked before the loop body runs (`while`, `for`).

`do-while` is different. It runs the body first and checks the condition after that. This guarantees at least one execution.

### Syntax

```java
do {
	// statements
} while (condition);
```

### Example

```java
int i = 1;

do {
	System.out.println(i);
	i++;
} while (i <= 3);
```

Output:

```text
1
2
3
```

### Why It Matters

Use `do-while` when you want the user to see a menu or prompt at least once.

```java
import java.util.Scanner;

Scanner scn = new Scanner(System.in);
int choice;

do {
	System.out.println("1. Play");
	System.out.println("2. Exit");
	choice = scn.nextInt();
} while (choice != 2);
```

Even if the user enters `2` immediately, the menu is shown once.

---

## 13. Nested Loops: Loop Inside Another Loop

A nested loop means one loop is placed inside another loop.

This is useful in cases like:

- Pattern printing
- 2D arrays (rows and columns)
- Comparing every pair of values

### Example: Print a 3x4 Grid of Stars

```java
for (int row = 1; row <= 3; row++) {
	for (int col = 1; col <= 4; col++) {
		System.out.print("* ");
	}
	System.out.println();
}
```

Output:

```text
* * * *
* * * *
* * * *
```

### How to Think About It

- Outer loop controls rows.
- Inner loop controls columns.
- For each single outer iteration, the inner loop runs completely.

---

## 14. Boundary Thinking and Off-by-One Errors

A very common loop bug is writing the wrong boundary condition.

### Example

```java
for (int i = 1; i < 5; i++) {
	System.out.println(i);
}
```

Output is:

```text
1
2
3
4
```

If you wanted to include `5`, the condition should be `i <= 5`.

### Rule of Thumb

- Use `< n` when you want exactly `n` iterations starting from `0`.
- Use `<= n` when you want to include the value `n`.

### Mini Dry-Run Method

Before executing code, test the first few iterations on paper:

1. Write initial value.
2. Check condition result.
3. Write output.
4. Apply update.
5. Repeat until condition becomes false.

This small habit catches most loop mistakes quickly.

---

## 15. Loop Time Complexity (Beginner View)

As you move toward DSA, loop complexity becomes important.

### Single Loop

```java
for (int i = 1; i <= n; i++) {
	// constant work
}
```

This runs `n` times, so time complexity is $O(n)$.

### Nested Loop

```java
for (int i = 1; i <= n; i++) {
	for (int j = 1; j <= n; j++) {
		// constant work
	}
}
```

This does about $n \times n$ operations, so time complexity is $O(n^2)$.

### Why You Should Care

Two solutions may both be correct, but the one with better time complexity scales better for large input sizes.

---

## 16. Bonus Practice (Very Relevant)

1. Read a number `n` and print the sum of digits using a loop.
2. Read a number `n` and print its reverse.
3. Check whether a number is prime using a loop.
4. Print a right triangle star pattern of height `n` using nested loops.
5. Find the count of numbers between 1 and `n` that are divisible by both 2 and 3.
6. Print all factors of `n`, then print the total count of factors.

These are direct applications of the same concepts in this chapter and form a strong bridge to the upcoming problem-solving lessons.

---

## Final Revision Box

### Essential Concepts

- `if-else` helps you make a decision.
- `while` repeats while the condition is true.
- `do-while` guarantees at least one execution.
- `for` packages initialization, condition, and update into one structure.
- Nested loops solve row-column style problems and many pattern tasks.
- `break` ends a loop early.
- `continue` skips the current iteration.
- Correct loop boundaries prevent off-by-one errors.
- Basic loop complexity: $O(n)$ for one loop, often $O(n^2)$ for two full nested loops.
- `%` is very useful for divisibility checks.
- Loop variables declared inside the loop are local to that block.

### What You Can Now Do

✓ Repeat code with `while` and `for`
✓ Use `do-while` for at-least-once execution
✓ Control loop flow with `break` and `continue`
✓ Write and reason about nested loops
✓ Check divisibility and count factors
✓ Avoid boundary mistakes with dry-run thinking
✓ Understand loop scope and update logic
✓ Estimate basic time complexity of loop-based solutions
✓ Combine conditionals with loops to solve basic problems

You now have the main tools for repetition in Java. The next step is to use these patterns in bigger problem-solving exercises.
