# Java Fundamentals - Patterns

## Quick Reference (1-Minute Recall)

- Pattern problems are mostly about nested loops and careful output control.
- The outer loop usually controls rows.
- The inner loop usually controls columns or repeated symbols within a row.
- Most patterns follow a structure: spaces first, then stars or numbers.
- Many pyramid-style patterns are easiest to build with `nst` (number of stars) and `nsp` (number of spaces).
- Right triangles, inverted triangles, pyramids, diamonds, and number patterns are the most common beginner forms.
- A dry run is the fastest way to understand pattern output.
- Many pattern problems have time complexity $O(n^2)$ because they print a grid of size roughly `n x n`.

## Why Patterns Matter

After learning loops, pattern printing becomes one of the best ways to practice them.

Why? Because patterns force you to think in terms of rows, columns, spacing, and repetition all at once. That means you cannot solve them by memorizing a single formula alone. You have to understand how the nested loops move.

Pattern questions may look like simple star art at first, but they actually build several important skills:

- Loop control
- Nested loop thinking
- Boundary management
- Output formatting
- Dry-run discipline

If you can solve pattern problems cleanly, you are usually getting much better at loops overall.

---

## 1. The Core Pattern Mindset

Before writing code, do not look at the pattern as a picture only. Break it into parts.

Ask yourself:

1. How many rows are there?
2. How many columns are there in each row?
3. What is printed in the beginning of each row?
4. What repeats inside the row?
5. Does the pattern use spaces, stars, numbers, or both?

That is the basic thinking style behind almost every pattern problem.

### The Usual Structure

Most pattern programs look like this:

```java
for (int row = 1; row <= n; row++) {
	for (int col = 1; col <= someValue; col++) {
		// print something
	}
	System.out.println();
}
```

The outer loop creates rows.
The inner loop creates the repeated content in each row.

### Why Newline Matters

If you forget `System.out.println();` at the end of a row, everything will continue on the same line and the pattern will not form properly.

---

## 2. The Simplest Pattern: Solid Rectangle

The solid rectangle is one of the easiest pattern problems and a good starting point.

### Example: 4 Rows and 5 Columns

```java
int rows = 4;
int cols = 5;

for (int row = 1; row <= rows; row++) {
	for (int col = 1; col <= cols; col++) {
		System.out.print("* ");
	}
	System.out.println();
}
```

Output:

```text
* * * * *
* * * * *
* * * * *
* * * * *
```

### What is happening?

- For each row, we print 5 stars.
- After that, we move to the next line.
- This repeats 4 times.

### Why This Pattern Matters

This is the base shape for many other patterns. Once you understand it, you can modify either the number of stars, the spaces, or the starting position to form more complex shapes.

---

## 3. The `nst` and `nsp` Method

Some pattern lectures do not start with rows and columns alone. Instead, they use two small variables:

- `nst` = number of stars in the current row
- `nsp` = number of spaces in the current row

This style is very common in pyramid and diamond problems because it makes the row logic easier to see.

### Example: Pyramid Using `nst` and `nsp`

```java
int n = 5;
int nst = 1;
int nsp = n - 1;

for (int row = 1; row <= n; row++) {
	for (int space = 1; space <= nsp; space++) {
		System.out.print(" ");
	}
	for (int star = 1; star <= nst; star++) {
		System.out.print("*");
	}
	System.out.println();

	nst += 2;
	nsp--;
}
```

Output:

```text
    *
   ***
  *****
 *******
*********
```

### Why This Style Is Useful

- `nst` tells you how many stars to print.
- `nsp` tells you how many spaces to print.
- After each row, stars increase and spaces decrease.

This is the same logic you saw in the lecture notes, just written in a cleaner teaching format.

### How to Read the Update Pattern

- `nst += 2` means every next row has two more stars.
- `nsp--` means every next row has one fewer leading space.

That is exactly what creates the pyramid shape.

---

## 4. Right Triangle Pattern

The right triangle is one of the most common beginner patterns.

### Example

```java
int n = 5;

for (int row = 1; row <= n; row++) {
	for (int col = 1; col <= row; col++) {
		System.out.print("* ");
	}
	System.out.println();
}
```

Output:

```text
* 
* * 
* * * 
* * * * 
* * * * * 
```

### How to Think About It

- Row 1 prints 1 star.
- Row 2 prints 2 stars.
- Row 3 prints 3 stars.
- And so on until row `n`.

This pattern is very useful because it teaches you the idea of a growing inner loop.

### Dry Run for `n = 4`

- Row 1: print 1 star
- Row 2: print 2 stars
- Row 3: print 3 stars
- Row 4: print 4 stars

That is all the loop is doing.

---

## 5. Inverted Right Triangle

Now we reverse the right triangle.

### Example

```java
int n = 5;

for (int row = n; row >= 1; row--) {
	for (int col = 1; col <= row; col++) {
		System.out.print("* ");
	}
	System.out.println();
}
```

Output:

```text
* * * * * 
* * * * 
* * * 
* * 
* 
```

### Key Idea

The row count is going downward instead of upward.

This is a very common trick in pattern problems: if the count should shrink each line, let the outer loop move in reverse.

---

## 6. Number Triangle

Patterns do not always use stars. Sometimes they use numbers.

### Example

```java
int n = 5;

for (int row = 1; row <= n; row++) {
	for (int col = 1; col <= row; col++) {
		System.out.print(col + " ");
	}
	System.out.println();
}
```

Output:

```text
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
```

### Why It Works

- The outer loop decides the row number.
- The inner loop prints all numbers from `1` to the current row.

This pattern is a simple extension of the right triangle.

---

## 7. Floyd's Triangle

Floyd's triangle is a classic number pattern where numbers continue across rows instead of restarting in each row.

### Example

```java
int n = 4;
int num = 1;

for (int row = 1; row <= n; row++) {
	for (int col = 1; col <= row; col++) {
		System.out.print(num + " ");
		num++;
	}
	System.out.println();
}
```

Output:

```text
1
2 3
4 5 6
7 8 9 10
```

### What is happening?

- `num` is a single variable outside the loops.
- It keeps increasing across all rows.
- The inner loop prints one number at a time and increments it.

This pattern shows why variable placement matters.

---

## 8. Right-Aligned Triangle with Spaces

Many pattern problems are really about spaces plus stars.

### Example

```java
int n = 5;

for (int row = 1; row <= n; row++) {
	for (int space = 1; space <= n - row; space++) {
		System.out.print("  ");
	}
	for (int star = 1; star <= row; star++) {
		System.out.print("* ");
	}
	System.out.println();
}
```

Output:

```text
        * 
      * * 
    * * * 
  * * * * 
* * * * * 
```

### The Logic

- First print spaces.
- Then print stars.
- The number of spaces decreases each row.
- The number of stars increases each row.

This is one of the most important mental models in pattern printing.

---

## 9. Pyramid Pattern

The pyramid is a classic shape that combines spaces and stars in a symmetric way.

### Example

```java
int n = 5;

for (int row = 1; row <= n; row++) {
	for (int space = 1; space <= n - row; space++) {
		System.out.print(" ");
	}
	for (int star = 1; star <= 2 * row - 1; star++) {
		System.out.print("*");
	}
	System.out.println();
}
```

Output:

```text
    *
   ***
  *****
 *******
*********
```

### Why the Formula `2 * row - 1`?

Because the star count grows like this:

- Row 1: 1 star
- Row 2: 3 stars
- Row 3: 5 stars
- Row 4: 7 stars

That is the odd-number pattern.

### Important Note

In this type of pattern, spaces matter just as much as stars. If the spaces are off, the pyramid shape breaks.

---

## 10. Inverted Pyramid Pattern

Now we reverse the pyramid.

### Example

```java
int n = 5;

for (int row = n; row >= 1; row--) {
	for (int space = 1; space <= n - row; space++) {
		System.out.print(" ");
	}
	for (int star = 1; star <= 2 * row - 1; star++) {
		System.out.print("*");
	}
	System.out.println();
}
```

Output:

```text
*********
 *******
  *****
   ***
    *
```

This is just the pyramid turned upside down.

---

## 11. Diamond Pattern

The diamond is really two pyramids joined together.

### Example

```java
int n = 5;

// Upper half
for (int row = 1; row <= n; row++) {
	for (int space = 1; space <= n - row; space++) {
		System.out.print(" ");
	}
	for (int star = 1; star <= 2 * row - 1; star++) {
		System.out.print("*");
	}
	System.out.println();
}

// Lower half
for (int row = n - 1; row >= 1; row--) {
	for (int space = 1; space <= n - row; space++) {
		System.out.print(" ");
	}
	for (int star = 1; star <= 2 * row - 1; star++) {
		System.out.print("*");
	}
	System.out.println();
}
```

Output:

```text
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
```

### How to Understand It

- The upper half grows.
- The lower half shrinks.
- The middle row is the widest row.

Diamond patterns are a strong test of whether you understand both increasing and decreasing loops.

---

## 12. Hollow Rectangle

In a hollow rectangle, only the border is printed.

### Example

```java
int rows = 4;
int cols = 6;

for (int row = 1; row <= rows; row++) {
	for (int col = 1; col <= cols; col++) {
		if (row == 1 || row == rows || col == 1 || col == cols) {
			System.out.print("* ");
		} else {
			System.out.print("  ");
		}
	}
	System.out.println();
}
```

Output:

```text
* * * * * *
*         *
*         *
* * * * * *
```

### What to Notice

- First row is full.
- Last row is full.
- First and last columns are full.
- Everything else is empty.

This is the first pattern in this chapter where conditionals appear inside nested loops.

---

## 13. X and Cross Style Thinking

Some patterns depend on relationships between row and column indices.

For example, if `row == col`, you are on the main diagonal.
If `row + col == n + 1`, you are on the other diagonal.

### Example: Print an `X` in a Square Grid

```java
int n = 5;

for (int row = 1; row <= n; row++) {
	for (int col = 1; col <= n; col++) {
		if (row == col || row + col == n + 1) {
			System.out.print("* ");
		} else {
			System.out.print("  ");
		}
	}
	System.out.println();
}
```

Output:

```text
*       *
  *   *
    *
  *   *
*       *
```

### Why This Is Useful

It teaches you to use coordinates, not just counts.

That is a major step forward in pattern thinking.

---

## 14. Number Insertion Patterns

Sometimes the pattern is not about shape alone. It is about how numbers grow, repeat, or reset.

### Example: Repeated Number Rows

```java
int n = 4;

for (int row = 1; row <= n; row++) {
	for (int col = 1; col <= row; col++) {
		System.out.print(row + " ");
	}
	System.out.println();
}
```

Output:

```text
1
2 2
3 3 3
4 4 4 4
```

### Example: Alternating `1` and `0`

```java
int n = 5;

for (int row = 1; row <= n; row++) {
	for (int col = 1; col <= row; col++) {
		if ((row + col) % 2 == 0) {
			System.out.print("1 ");
		} else {
			System.out.print("0 ");
		}
	}
	System.out.println();
}
```

This creates a simple alternating-number pattern based on parity.

---

## 15. How to Solve Pattern Problems Step by Step

When a pattern looks complicated, do not panic. Reduce it.

### The Method

1. Count the rows.
2. For each row, count the spaces.
3. For each row, count the symbols.
4. Decide whether the row is increasing or decreasing.
5. Write the outer loop first.
6. Add spaces.
7. Add stars or numbers.
8. Print a newline.

### Example Strategy

If you see this:

```text
    *
   ***
  *****
```

Think:

- Row 1 has 4 spaces and 1 star.
- Row 2 has 3 spaces and 3 stars.
- Row 3 has 2 spaces and 5 stars.

Then the formulas become easier to write.

### Dry Run Is Everything

Pattern programs are best understood by simulating them row by row.

That is often faster than guessing the output from the code directly.

---

## 16. Common Beginner Mistakes in Patterns

### Mistake 1: Forgetting the Newline

If you do not print a newline after each row, the pattern collapses into one line.

### Mistake 2: Mixing Up Rows and Columns

The outer loop should usually control rows.
The inner loop should usually control items within the row.

### Mistake 3: Wrong Space Count

Most pyramid-like patterns fail because the spaces are not counted correctly.

### Mistake 4: Using the Wrong Comparison Boundary

One small change from `<` to `<=` can change the entire shape.

### Mistake 5: Not Separating Shape and Content

First understand the shape.
Then decide what each cell should print.

This keeps the problem manageable.

---

## 17. Pattern Time Complexity

Most basic pattern questions use nested loops, so they are usually quadratic in nature.

### Example

If a pattern has `n` rows, and each row does about `n` work, the total cost is usually about $O(n^2)$.

That is normal for pattern problems because you are printing a 2D shape.

### Why This Matters

In beginner DSA, you do not need to optimize every pattern heavily. But you should understand that the amount of printed output itself is often already large.

---

## 18. Mini Practice Set

1. Print a solid rectangle of stars.
2. Print a right triangle.
3. Print an inverted right triangle.
4. Print a pyramid.
5. Print a diamond.
6. Print a hollow rectangle.
7. Print an `X` pattern inside a square.
8. Print Floyd's triangle.
9. Print a triangle where each row contains the row number.
10. Print an alternating `1` and `0` pattern.

If you can solve these cleanly, you are in good shape for the next topics.

---

## Final Revision Box

### Essential Concepts

- Pattern printing is mostly nested-loop practice.
- The outer loop usually controls rows.
- The inner loop usually controls spaces, stars, or numbers.
- Many patterns are built from simple parts like rectangles, triangles, pyramids, and diagonals.
- `if` statements inside loops are useful for hollow or diagonal patterns.
- Dry runs help you map each row before writing code.
- Most beginner pattern problems have $O(n^2)$ time complexity.

### What You Can Now Do

✓ Build solid shapes with nested loops
✓ Print triangles, pyramids, diamonds, and hollow figures
✓ Use row-column logic to place stars and spaces correctly
✓ Solve number-based pattern problems
✓ Avoid the usual row, column, and spacing mistakes
✓ Estimate the complexity of pattern-printing code

Patterns are where loop thinking becomes visual. Once these shapes feel natural, the move into arrays and more structured problem solving becomes much smoother.
