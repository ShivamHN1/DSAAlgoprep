# Java Arrays - Introduction to Array Problem Solving

## Quick Reference (1-Minute Recall)

- An array is a fixed-size collection of elements of the same type.
- Array indices start at `0` and end at `arr.length - 1`.
- Use a loop to traverse an array, read values, count values, or compute a sum.
- Arrays are passed to functions by reference to the same underlying object, so changes inside a function affect the original array.
- A common array pattern is: traverse, inspect, accumulate, and update.
- To swap two elements, store one value in a temporary variable first.
- When you only need to read an array, use a simple traversal. When you need to modify it, be careful about side effects.
- Time complexity for a full array traversal is usually $O(n)$.

---

## Today's Agenda

- Introduction to arrays
- Returning the sum of array elements
- Arrays and functions
- Swapping two indices in an array

---

## Why Arrays Matter

Many real problems involve a collection of related values:

- marks of students
- temperatures over a week
- prices of items in a cart
- numbers in a sequence

If you store each value in a separate variable, your code quickly becomes messy.

Arrays solve this by storing many values in one name, with each value accessible by index.

This makes arrays one of the most important building blocks in programming.

---

## 1. What Is an Array?

An array is a container that stores multiple values of the same type in contiguous memory locations.

The key word is **contiguous**: all elements sit next to each other in memory, which makes arrays very fast to access.

### Example

```java
int[] arr = {10, 20, 30, 40, 50};
```

This array contains 5 integers.

Internally, the memory looks like this:

```
Memory Address   Value
1000             10
1004             20
1008             30
1012             40
1016             50
```

The variable `arr` stores the **address of the first element** (1000 in this example).

When you access `arr[i]`, Java calculates the address as: `(address of arr) + (i × size of int)`.

### Indexing

Each element has an index:

- `arr[0] = 10` (first element)
- `arr[1] = 20` (second element)
- `arr[2] = 30` (third element)
- `arr[3] = 40` (fourth element)
- `arr[4] = 50` (fifth element)

Remember:

- First index is `0`
- Last index is `arr.length - 1`
- `arr.length` gives the total number of elements (5 in this case)

### Why Indexing Starts at 0

Java arrays are zero-based.

That means the first element is at position `0`, not `1`.

This comes from how memory addressing works: the first element is at offset 0 from the start address.

This is important because array loops use this pattern:

```java
for (int i = 0; i < arr.length; i++) {
	// process arr[i]
}
```

### Important: Arrays Are Objects

In Java, arrays are **objects**, not primitive values.

This distinction is critical:

- A primitive value like `int x = 10` stores the actual value in memory.
- An array reference like `int[] arr` stores an **address** (a pointer) to the array object.

The array object itself lives on the **heap** (a large memory region for objects).

The reference variable `arr` lives on the **stack** (a smaller memory region for local variables).

---

## 2. Declaring and Creating Arrays

There are two common ways to create an array.

### Method 1: Direct Initialization

```java
int[] arr = {10, 20, 30, 40};
```

This is useful when you already know the values.

What happens:

1. Java creates an array object on the heap with 4 `int` values.
2. It allocates 4 × 4 = 16 bytes (each `int` is 4 bytes).
3. It stores the values 10, 20, 30, 40 in these memory locations.
4. The variable `arr` on the stack stores the **address** of this array object.
5. `arr.length` is automatically set to 4.

### Method 2: Create Size First, Fill Later

```java
int[] arr = new int[5];
```

This creates an array of size 5 on the heap.

What happens:

1. Java allocates 5 × 4 = 20 bytes on the heap.
2. All 5 elements are initialized with the default value `0`.
3. The variable `arr` on the stack stores the **address** of this array object.
4. `arr.length` is set to 5.

You can then assign values later:

```java
arr[0] = 10;
arr[1] = 20;
arr[2] = 30;
arr[3] = 40;
arr[4] = 50;
```

### Method 3: Declare Without Initializing

```java
int[] arr;  // Declare but don't create yet
arr = new int[5];  // Now create the array
```

You can separate declaration from creation, but you must create the array before using it.

### Important Rules

**Array size is fixed after creation.**

You cannot change `arr.length` later.

If you need a different size, you must create a new array.

**All elements are initialized.**

For `int` arrays, default is `0`.

For `boolean` arrays, default is `false`.

For object arrays (like `String[]`), default is `null`.

---

## 3. Traversing an Array

Traversal means visiting each element one by one.

### Basic Traversal Pattern

```java
for (int i = 0; i < arr.length; i++) {
	System.out.println(arr[i]);
}
```

### Dry Run Example

For `arr = {10, 20, 30}`:

- `i = 0` → print `10`
- `i = 1` → print `20`
- `i = 2` → print `30`

### Why This Pattern Is So Important

Almost every array problem starts with traversal.

You may then:

- count something
- sum something
- find a maximum
- search for a value
- modify values

---

## 4. Return Sum of Array Elements

This is one of the first array problems.

### Problem

Given an array of integers, return the sum of all elements.

### Example

Input array:

```java
int[] arr = {10, 20, 30, 40};
```

Output:

```text
100
```

### Approach

- Start with `sum = 0`
- Traverse the array
- Add each element to `sum`

### Code

```java
public static int arraySum(int[] arr) {
	int sum = 0;

	for (int i = 0; i < arr.length; i++) {
		sum = sum + arr[i];
	}

	return sum;
}
```

### Dry Run

For `arr = {10, 20, 30, 40}`:

- `sum = 0`
- add `10` → `sum = 10`
- add `20` → `sum = 30`
- add `30` → `sum = 60`
- add `40` → `sum = 100`

### Complete Program

```java
import java.util.Scanner;

public class Main {
	public static int arraySum(int[] arr) {
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		System.out.println(arraySum(arr));
	}
}
```

### Time Complexity

The loop visits every element once, so the time complexity is $O(n)$.

The space complexity is $O(1)$ extra space.

---

## 5. Arrays and Functions: Pass-by-Reference Explained

This is the part many beginners find confusing.

Understanding this is crucial because it explains why arrays behave differently from simple variables when passed to functions.

### The Key Difference: Primitives vs Arrays

**Primitive variables (int, double, boolean):**

When you pass a primitive to a function, Java **copies the value**.

```java
public static void addOne(int x) {
    x = x + 1;
}

int num = 5;
addOne(num);
System.out.println(num);  // Still 5
```

The function receives a **copy** of 5, not the original variable.

Changing the copy does not affect the original.

**Array variables:**

When you pass an array to a function, Java **copies the reference** (the address).

```java
public static void changeArray(int[] arr) {
    arr[0] = 999;
}

int[] nums = {5, 10, 15};
changeArray(nums);
System.out.println(nums[0]);  // Now 999
```

The function receives a **copy of the address**, which points to the **same array object**.

Changing elements inside the array **does affect** the original.

### Memory Picture

Let's see what happens in memory:

**Before calling the function:**

```
Stack (main):              Heap:
int[] nums ───────────────> [5, 10, 15]
 (stores address 2000)
```

**When the function is called:**

```
Stack (main):              Stack (changeArray):       Heap:
int[] nums ───────────────> int[] arr ────────────────> [5, 10, 15]
 (address 2000)            (address 2000)
```

Both `nums` and `arr` hold the **same address** (2000).

So both point to the **same array object** on the heap.

When we modify through `arr[0] = 999`, we are modifying the array on the heap.

When we check `nums[0]` back in `main()`, we see 999 because it is the same array.

### Example Program: Step by Step

```java
public class Main {
    public static void changeArray(int[] arr) {
        arr[0] = 100;  // Modifying the array that arr points to
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        
        System.out.println("Before: " + arr[0]);  // 10
        
        changeArray(arr);
        
        System.out.println("After: " + arr[0]);   // 100
    }
}
```

Output:

```text
Before: 10
After: 100
```

The change persists because both variables point to the same array object.

### Example Program 2: Multiple Functions

```java
public class Main {
    public static void increment(int[] arr) {
        arr[0]++;
    }
    
    public static void doubleValue(int[] arr) {
        arr[1] = arr[1] * 2;
    }

    public static void main(String[] args) {
        int[] data = {5, 10, 15};
        
        increment(data);      // data[0] becomes 6
        doubleValue(data);    // data[1] becomes 20
        
        System.out.println(data[0] + " " + data[1] + " " + data[2]);
    }
}
```

Output:

```text
6 20 15
```

Each function receives a reference to the same array, so all changes accumulate.

### Why This Matters

This is useful when you want to:

- modify the original array
- sort or swap elements in-place
- compute results using the same data

It also means you must be careful, because a function can accidentally change the original array.

### Safe Pattern: Read-Only Functions

If a function is only supposed to read the array, do not modify it.

Make this clear by adding comments:

```java
public static int arraySum(int[] arr) {
    int sum = 0;
    
    // Only reading, not modifying
    for (int i = 0; i < arr.length; i++) {
        sum += arr[i];
    }
    
    return sum;  // Return result, don't change the array
}
```

This function only reads values, so it has no side effects.

### Anti-Pattern: Unintended Modification

Be careful not to accidentally modify the array:

```java
public static void processArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        arr[i] = 0;  // BUG: This changes the original array!
    }
}
```

If you meant to only process the values but not modify the original, this is a bug.

---

## 6. Stack, Heap, and Array References: The Deep Dive

This is the most important concept for understanding how arrays really work.

### Two Kinds of Memory in Java

**Stack (fast, small, organized):**

- Stores primitive values (int, boolean, double, etc.)
- Stores references (addresses) to objects
- Memory is automatically freed when a variable goes out of scope
- Each function call gets its own stack frame

**Heap (slower, large, flexible):**

- Stores all objects (including arrays)
- Memory is freed by garbage collector when no references point to it
- Shared across all function calls

### Arrays Live on the Heap

When you write:

```java
int[] arr = {10, 20, 30};
```

Two things happen:

1. **On the stack:** Variable `arr` is created and stores an address (reference).
2. **On the heap:** The actual array object `{10, 20, 30}` is created.

Visually:

```
Stack (in main):           Heap:
int[] arr ───────────────> [10, 20, 30]
 (stores address)          (actual data)
```

### Multiple References to the Same Array

```java
int[] arr = {5, 10, 15};
int[] ref = arr;

ref[0] = 99;

System.out.println(arr[0]);  // 99
```

What happens:

```
Stack:                     Heap:
int[] arr ─┐               
           ├───────────────> [99, 10, 15]
int[] ref ─┘
```

Both `arr` and `ref` store the **same address**.

When you modify through `ref`, you are modifying the array that `arr` also points to.

So `arr[0]` sees the change.

### Arrays in Functions: The Full Picture

```java
public static void swapFirst(int[] arr) {
    int temp = arr[0];
    arr[0] = arr[1];
    arr[1] = temp;
}

public static void main(String[] args) {
    int[] data = {5, 10, 15};
    
    swapFirst(data);
    
    System.out.println(data[0]);  // 10
}
```

**In main():**

```
Stack (main):
int[] data ───────────────> Heap: [5, 10, 15]
```

**When swapFirst is called:**

```
Stack (main):              Stack (swapFirst):
int[] data ─┐              int[] arr ─┐
            └──────────────────────────┼──> Heap: [5, 10, 15]
                                       │
            (parameter arr gets a copy of the address)
```

Inside `swapFirst()`, when we modify `arr[0]` and `arr[1]`, we are modifying the **same heap array** that `data` points to.

When the function returns, `data` in `main()` still points to the same array, which now contains `[10, 5, 15]`.

### What Gets Copied?

**When you pass a primitive:**

```java
void addOne(int x) {
    x = x + 1;  // Modifying the copy, not the original
}
```

The actual value is copied. Changing it doesn't affect the original.

**When you pass an array:**

```java
void modify(int[] arr) {
    arr[0] = 999;  // Modifying through the copied reference
}
```

The reference (address) is copied. Both point to the same object. Changes affect the original.

### Why This Is Important

1. **Performance:** Arrays are not copied element-by-element. Passing an array is fast, no matter how big it is.
2. **Efficiency:** Multiple functions can work on the same data without duplication.
3. **Caution:** Functions can accidentally modify the original array if you're not careful.

### Example: Demonstrating the Difference

```java
public class Main {
    public static void changePrimitive(int x) {
        x = 999;  // Changes x locally only
    }
    
    public static void changeArray(int[] arr) {
        arr[0] = 999;  // Changes the original array
    }
    
    public static void main(String[] args) {
        int num = 5;
        int[] arr = {5};
        
        changePrimitive(num);
        changeArray(arr);
        
        System.out.println(num);       // Still 5 (not changed)
        System.out.println(arr[0]);    // 999 (changed)
    }
}
```

Output:

```text
5
999
```

The primitive value was not changed, but the array element was.

---

## 7. Swapping Two Elements in an Array

Swapping means exchanging the values at two positions.

### Problem

Given an array and two indices `idx1` and `idx2`, swap the elements at those positions.

### Example

```java
int[] arr = {10, 20, 30, 40};
idx1 = 1;
idx2 = 3;
```

After swapping:

```java
{10, 40, 30, 20}
```

### Basic Swap Logic

Use a temporary variable.

```java
int temp = arr[idx1];
arr[idx1] = arr[idx2];
arr[idx2] = temp;
```

### Why We Need `temp`

If you directly assign one value to the other without saving the original first, you lose data.

### Complete Function

```java
public static void swap(int[] arr, int idx1, int idx2) {
	int temp = arr[idx1];
	arr[idx1] = arr[idx2];
	arr[idx2] = temp;
}
```

### Complete Program

```java
import java.util.Scanner;

public class Main {
	public static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		int idx1 = scn.nextInt();
		int idx2 = scn.nextInt();

		swap(arr, idx1, idx2);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
```

### Time Complexity

Swapping two elements takes $O(1)$ time.

---

## 8. Common Array Patterns

As you solve more array problems, you will see the same patterns again and again.

### Pattern 1: Traversal

Visit every element.

```java
for (int i = 0; i < arr.length; i++) {
	// process arr[i]
}
```

### Pattern 2: Sum / Accumulation

Add values as you traverse.

```java
int sum = 0;
for (int i = 0; i < arr.length; i++) {
	sum += arr[i];
}
```

### Pattern 3: Searching

Check whether a value exists.

```java
boolean found = false;
for (int i = 0; i < arr.length; i++) {
	if (arr[i] == target) {
		found = true;
		break;
	}
}
```

### Pattern 4: Updating

Change values in-place.

```java
arr[i] = arr[i] + 1;
```

### Pattern 5: Swapping

Exchange two positions.

```java
int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
```

---

## 9. Loop Boundaries in Arrays

Array loops are one of the main places where off-by-one errors happen.

### Correct Traversal

```java
for (int i = 0; i < arr.length; i++) {
	System.out.println(arr[i]);
}
```

### Why Not `<=`?

If `arr.length = 5`, valid indices are `0, 1, 2, 3, 4`.

If you use `i <= arr.length`, the loop tries to access `arr[5]`, which is invalid.

### Rule

- Use `< arr.length` for indexing arrays.
- Do not use `<= arr.length` unless you specifically want to go one step beyond the last index for a different reason.

---

## 10. Common Mistakes

### Mistake 1: Starting from 1

Arrays start from index `0`, so the first index is not `1`.

### Mistake 2: Going Out of Bounds

Accessing `arr[arr.length]` is invalid.

### Mistake 3: Forgetting That Arrays Are Shared

If a function changes the array, the original array changes too.

### Mistake 4: Losing Data While Swapping

Always use a temporary variable.

### Mistake 5: Confusing Length and Last Index

- `arr.length` = number of elements
- `arr.length - 1` = last valid index

---

## 11. Practice Summary

### Core Ideas

- Arrays store multiple values of the same type.
- Indexing starts at `0`.
- Use loops to traverse arrays.
- Sum of array elements is a common traversal problem.
- Arrays passed to functions can be modified inside those functions.
- Swapping two indices requires a temporary variable.
- Full traversal is usually $O(n)$.
- Swapping two elements is $O(1)$.

### What You Should Be Able to Do

✓ Declare and initialize arrays
✓ Access values by index
✓ Traverse an array using a loop
✓ Compute the sum of array elements
✓ Understand how arrays behave in functions
✓ Swap two array elements by index
✓ Avoid off-by-one mistakes in array loops

---

## 12. Revision Summary Table

| Topic | Key Idea | Example Pattern | Time Complexity |
| --- | --- | --- | --- |
| Array basics | Same-type values stored together | `int[] arr = {10, 20, 30}` | $O(1)$ access |
| Traversal | Visit every element once | `for (int i = 0; i < arr.length; i++)` | $O(n)$ |
| Sum of elements | Accumulate values while traversing | `sum += arr[i]` | $O(n)$ |
| Arrays in functions | Same array object is shared | `changeArray(arr)` modifies original | $O(1)$ reference passing |
| Swapping | Exchange two values using temp | `temp = arr[i]` | $O(1)$ |
| Boundaries | Use valid array indices only | `0` to `arr.length - 1` | Prevents errors |

---

## Final Revision Box

### Essential Concepts

- Arrays store multiple same-type values under one name.
- Indexing starts at `0` and ends at `arr.length - 1`.
- Array traversal is the foundation for most array problems.
- To return the sum of array elements, initialize `sum = 0` and add each value.
- Arrays passed to functions refer to the same underlying array object.
- Swapping two array elements requires a temporary variable.
- A full pass through an array is usually $O(n)$.
- Swapping two elements is $O(1)$.

### Key Patterns

- Traverse
- Sum
- Search
- Update
- Swap

### What You Can Now Do

✓ Explain what an array is and how indexing works
✓ Write a function to return the sum of an array
✓ Explain why arrays are connected across functions
✓ Swap two array elements by index
✓ Avoid common off-by-one mistakes in loops

---

## Try These on Your Own

1. Write a program to print all elements of an array.
2. Write a program to return the maximum element in an array.
3. Write a program to count how many elements are greater than 10.
4. Write a program to reverse an array.
5. Write a program to swap the first and last elements of an array.
6. Write a program to find whether a value exists in an array.

