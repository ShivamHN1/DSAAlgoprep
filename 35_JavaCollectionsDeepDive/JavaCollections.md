# Java Collections Framework - First Complete Lesson

## Quick Reference (1-Minute Recall)

- Arrays are fixed-size; collections are dynamic-sized.
- Java Collections Framework (JCF) gives ready-to-use data structures in `java.util`.
- Main families: `List`, `Set`, `Queue`, and `Map` (Map is separate from Collection but part of JCF).
- `List` keeps order and allows duplicates.
- `Set` removes duplicates.
- `Queue` is for processing order (FIFO/priority/deque behavior).
- `Map` stores key-value pairs with unique keys.
- Generics (like `List<String>`) give type safety at compile time.
- Collections store objects, so primitives are used through wrapper types (`int` -> `Integer`).
- Utility helpers in `Collections` class provide sorting, reversing, shuffling, etc.
- Internal implementations matter for performance: hash table, tree, dynamic array, linked nodes.

---

## Why We Need Collections

When you begin Java, arrays are usually your first tool for storing multiple values.

Arrays are simple and useful, but they have an important limitation: once created, their size is fixed.

If you need more capacity later, you must:

1. Create a bigger array.
2. Copy old elements.
3. Add new elements.

That is tedious and easy to get wrong.

Arrays also do not give built-in methods for many common tasks like easy insertion/removal in dynamic data, automatic duplicate handling, or collection-wide helper operations.

This is exactly why the Java Collections Framework exists.

### Array Thinking vs Collection Thinking

When using arrays, you usually think:

- How much size should I allocate now?
- What if data grows later?

When using collections, you think:

- Which data behavior do I need (order, uniqueness, key lookup, queue processing)?
- Which interface fits that behavior best?

This mindset shift is the real beginning of mastering collections.

---

## 1. What Is the Java Collections Framework (JCF)?

The Java Collections Framework is a unified architecture in `java.util` for storing and manipulating groups of objects.

It gives you:

- Standard interfaces (`List`, `Set`, `Queue`, `Map`)
- Multiple implementations (`ArrayList`, `HashSet`, `HashMap`, etc.)
- Common algorithms through utility classes (`Collections`, `Arrays`)

Collections are dynamic. They can grow or shrink based on your data.

Most collection types store objects, not primitives. So primitive values are stored using wrapper classes (`Integer`, `Double`, `Character`, etc.), with autoboxing and unboxing handled automatically by Java.

This means you spend less time managing memory manually and more time solving the actual problem.

---

## 2. The Concept of a Framework (Hierarchy)

The JCF is not random classes. It is organized in a hierarchy.

### Top Layer: Iterable

`Iterable` allows objects to be traversed with enhanced for-each loops.

```java
for (String name : names) {
	System.out.println(name);
}
```

### Next Layer: Collection

`Collection` is the root interface for groups of elements and defines operations like:

- `add()`
- `remove()`
- `size()`
- `contains()`
- `clear()`

From `Collection`, the hierarchy splits mainly into:

- `List`: ordered, duplicates allowed.
- `Set`: unique elements, duplicates not allowed.
- `Queue`: elements processed in queue-like order.

### Parallel Family: Map

`Map` is not a subtype of `Collection`, but it is a core part of JCF.

`Map` stores data as key-value pairs:

- Keys must be unique.
- Values can repeat.

### First Big Best Practice: Program to Interface

Prefer this style:

```java
List<Integer> a = new ArrayList<>();
Set<String> b = new HashSet<>();
Map<String, Integer> c = new HashMap<>();
```

Instead of tightly coupling to implementation type:

```java
ArrayList<Integer> a = new ArrayList<>();
HashSet<String> b = new HashSet<>();
HashMap<String, Integer> c = new HashMap<>();
```

Why this helps:

- Your code is easier to change later.
- You can switch implementation with minimal edits.
- It improves readability: intent first, implementation second.

---

## 3. Lists

A `List` is an ordered collection:

- Maintains insertion order.
- Allows duplicates.
- Supports index-based access.

Use a `List` when order and position matter.

### Common List Implementations

### ArrayList

- Internally uses a resizable array.
- Fast random access (`get(index)` is usually $O(1)$).
- Appending at end is usually fast.
- Insertion/deletion in the middle is slower ($O(n)$ shift cost).

```java
import java.util.ArrayList;
import java.util.List;

List<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Apple");

System.out.println(fruits);      // [Apple, Banana, Apple]
System.out.println(fruits.get(1)); // Banana
```

Mini dry run (`ArrayList` insert in middle):

- Start: `[10, 20, 30, 40]`
- Insert `99` at index `2`
- Elements from index `2` onward shift right
- Result: `[10, 20, 99, 30, 40]`

This shift is why middle insertion is $O(n)$.

### LinkedList

- Internally uses doubly linked nodes.
- Faster insert/delete at known positions or ends.
- Slower random access (`get(i)` walks nodes, $O(n)$).

```java
import java.util.LinkedList;
import java.util.List;

List<Integer> nums = new LinkedList<>();
nums.add(10);
nums.add(20);
nums.add(30);
```

Use `LinkedList` mainly when your dominant operation is frequent insertion/removal near ends or via iterator traversal.

### Vector

- Similar to `ArrayList` but synchronized.
- Thread-safe by default, but usually slower in single-threaded cases.
- Considered legacy for most modern use-cases.

### Try This Now (List)

Task: Create an `ArrayList<Integer>` with values `5, 10, 15`, insert `99` at index `1`, then print the list and `get(2)`.

Expected output:

```text
[5, 99, 10, 15]
10
```

---

## 4. Sets

A `Set` stores unique elements:

- No duplicates allowed.
- Best for uniqueness checks and de-duplication.

### Common Set Implementations

### HashSet

- Uses hashing internally.
- No guaranteed order.
- Very fast average-case insert/search/remove ($O(1)$).

```java
import java.util.HashSet;
import java.util.Set;

Set<String> users = new HashSet<>();
users.add("alice");
users.add("bob");
users.add("alice");

System.out.println(users); // duplicate "alice" is ignored
```

Mental model:

- `Set` answers: "Have I already seen this value?"
- Great for removing duplicates and fast membership checks.

### LinkedHashSet

- Hash table + linked structure.
- Maintains insertion order.
- Slightly more overhead than `HashSet`.

### TreeSet

- Stores elements in sorted ascending order.
- Internally uses a balanced tree (Red-Black tree).
- Operations are usually $O(log n)$.

```java
import java.util.Set;
import java.util.TreeSet;

Set<Integer> sorted = new TreeSet<>();
sorted.add(30);
sorted.add(10);
sorted.add(20);
System.out.println(sorted); // [10, 20, 30]
```

If you do not need sorted order, prefer `HashSet` for better average performance.

### Try This Now (Set)

Task: Add `"java", "python", "java", "c"` to a `HashSet<String>` and print the set and `contains("python")`.

Expected behavior:

- Final set has 3 unique elements.
- `contains("python")` is `true`.

---

## 5. Queues and Deques

`Queue` is designed for "process later" workflows.

Core queue operations:

- `offer()` add
- `poll()` remove front
- `peek()` view front

### Queue Behavior

- FIFO (First In, First Out) is common.

### Deque

`Deque` (double-ended queue) allows operations at both ends.

Good implementation: `ArrayDeque`.

```java
import java.util.ArrayDeque;
import java.util.Deque;

Deque<Integer> dq = new ArrayDeque<>();
dq.offerLast(10);
dq.offerLast(20);
dq.offerFirst(5);

System.out.println(dq.pollFirst()); // 5
System.out.println(dq.pollLast());  // 20
```

### PriorityQueue

- Elements come out by priority, not insertion order.
- Implemented as a heap.
- `offer()` / `poll()` are usually $O(log n)$.

```java
import java.util.PriorityQueue;
import java.util.Queue;

Queue<Integer> pq = new PriorityQueue<>();
pq.offer(40);
pq.offer(10);
pq.offer(30);

System.out.println(pq.poll()); // 10 (smallest first by default)
```

Important: Iterating a `PriorityQueue` does not guarantee sorted traversal output. Only repeated `poll()` gives priority order.

### Try This Now (Queue)

Task: Push `3, 1, 2` into a `PriorityQueue<Integer>`, then call `poll()` three times.

Expected output:

```text
1
2
3
```

---

## 6. Maps

`Map` stores key-value pairs.

- Keys are unique.
- Values can duplicate.
- Excellent for fast lookup by key.

### Common Map Implementations

### HashMap

- Fast average lookup/insert/remove ($O(1)$).
- No key order guarantee.

### LinkedHashMap

- Preserves insertion order of keys.
- Also useful for LRU-like patterns (with access-order mode).

### TreeMap

- Keys kept sorted.
- Backed by Red-Black tree.
- Typical operations $O(log n)$.

```java
import java.util.HashMap;
import java.util.Map;

Map<String, Integer> marks = new HashMap<>();
marks.put("Aman", 92);
marks.put("Riya", 88);
marks.put("Aman", 95); // updates existing key

System.out.println(marks.get("Aman")); // 95
```

### Dry Run: Frequency Counting with a Map

Input: `a, b, a, c, b, a`

Steps:

1. Start with `{}`
2. Read `a` -> `{a=1}`
3. Read `b` -> `{a=1, b=1}`
4. Read `a` -> `{a=2, b=1}`
5. Read `c` -> `{a=2, b=1, c=1}`
6. Read `b` -> `{a=2, b=2, c=1}`
7. Read `a` -> `{a=3, b=2, c=1}`

This pattern appears very often in problem solving.

### Try This Now (Map)

Task: Count frequency of characters in `"aabca"` using `Map<Character, Integer>`.

Expected counts:

- `a -> 3`
- `b -> 1`
- `c -> 1`

---

## 7. Generics and Type Safety

Generics are one of the most important parts of collections.

Without generics, collections can hold `Object`, which can cause runtime casting errors.

With generics, type checks happen at compile time.

```java
import java.util.ArrayList;
import java.util.List;

List<String> names = new ArrayList<>();
names.add("John");
// names.add(42); // Compile-time error

String first = names.get(0); // no cast needed
```

Benefits:

- Compile-time safety
- Cleaner code
- No manual casting in most cases

### Primitives and Autoboxing

Collections cannot use primitive type parameters directly.

Wrong:

```java
// List<int> nums = new ArrayList<>(); // invalid
```

Correct:

```java
List<Integer> nums = new ArrayList<>();
nums.add(10); // autoboxing: int -> Integer
int x = nums.get(0); // unboxing: Integer -> int
```

This is automatic, but you should know it is happening behind the scenes.

### Try This Now (Generics)

Task: Try to add a number to `List<String> words = new ArrayList<>();` and observe the compile-time error.

Learning goal:

- See type safety working before runtime.

---

## 8. Equality Rules in Hash-Based Collections

For `HashSet` and `HashMap`, correctness depends on `equals()` and `hashCode()`.

- `HashSet` uses them to decide duplicates.
- `HashMap` uses them to decide whether keys are the same.

If you create custom classes and do not override these methods properly, duplicate detection and key lookup can behave unexpectedly.

Rule of thumb:

- If two objects are equal by `equals()`, they must return the same `hashCode()`.

---

## 9. Sorted Collections and Ordering Rules

`TreeSet` and `TreeMap` maintain sorted order.

They require one of these:

- Natural ordering (`Comparable`)
- Custom ordering (`Comparator`)

If elements/keys are not mutually comparable, insertion can fail at runtime with `ClassCastException`.

```java
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

Set<String> byLength = new TreeSet<>(
	Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())
);
byLength.add("cat");
byLength.add("elephant");
byLength.add("dog");
System.out.println(byLength);
```

---

## 10. Collections Utility Class

Do not confuse:

- `Collection` (interface)
- `Collections` (utility class with static methods)

`Collections` helps with operations like sorting, reversing, shuffling, min/max, wrappers.

```java
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

List<Integer> nums = Arrays.asList(3, 1, 4, 2);
Collections.sort(nums);
Collections.reverse(nums);

System.out.println(nums); // [4, 3, 2, 1]
```

Other useful methods:

- `Collections.shuffle(list)`
- `Collections.min(collection)`
- `Collections.max(collection)`
- `Collections.unmodifiableList(list)`

### `Arrays.asList()` Important Pitfall

`Arrays.asList()` returns a fixed-size list view backed by the array.

- You can `set(index, value)`.
- You cannot `add()` or `remove()` (throws `UnsupportedOperationException`).

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

List<Integer> fixed = Arrays.asList(1, 2, 3);
// fixed.add(4); // throws UnsupportedOperationException

List<Integer> mutable = new ArrayList<>(fixed);
mutable.add(4); // works
```

---

## 11. How They Work Internally

Understanding internals helps you choose the right collection.

### Hash-Based Collections

`HashMap`, `HashSet` use hash tables.

- Fast average insert/lookup
- No sorted order

### Tree-Based Collections

`TreeMap`, `TreeSet` use Red-Black trees.

- Keep elements sorted
- Slower than hash structures for average-case raw lookup

### ArrayList Internals

- Backed by array
- Capacity grows automatically (typically resized by growth policy)
- Great for indexed access

### LinkedList Internals

- Doubly linked nodes
- Good at end insertions/removals
- Random access is slow

---

## 12. Choosing the Right Collection

Ask these questions:

1. Do I need ordering by index? Use `List`.
2. Do I need uniqueness? Use `Set`.
3. Do I need key-value lookup? Use `Map`.
4. Do I need sorted order? Use `TreeSet` / `TreeMap`.
5. Do I need FIFO processing? Use `Queue` / `ArrayDeque`.

Practical defaults:

- List default: `ArrayList`
- Set default: `HashSet`
- Map default: `HashMap`
- Queue default: `ArrayDeque`

### 5-Second Decision Flow

Ask in order:

1. Need key -> value mapping? Use `Map`.
2. Need unique values only? Use `Set`.
3. Need processing order (FIFO/priority/double-ended)? Use `Queue`/`Deque`.
4. Otherwise, if ordered and index-based access is needed, use `List`.

Then refine implementation:

- Fast lookup, no order -> `HashMap` / `HashSet`
- Preserve insertion order -> `LinkedHashMap` / `LinkedHashSet`
- Keep sorted order -> `TreeMap` / `TreeSet`
- Frequent indexed reads -> `ArrayList`
- Frequent end operations -> `ArrayDeque`

---

## 13. Common Beginner Mistakes

### Mistake 1: Confusing `Collection` and `Collections`

- `Collection` is an interface.
- `Collections` is a utility class.

### Mistake 2: Using raw types

Wrong:

```java
ArrayList list = new ArrayList();
```

Correct:

```java
ArrayList<Integer> list = new ArrayList<>();
```

### Mistake 3: Choosing `LinkedList` for random access

If you frequently call `get(i)`, `ArrayList` is usually better.

### Mistake 4: Assuming `HashMap` iteration order

`HashMap` does not guarantee key order.
Use `LinkedHashMap` or `TreeMap` if order matters.

### Mistake 5: Ignoring null behavior

Some collections allow nulls, some restrict them.
Know the implementation rules before inserting null values.

### Mistake 6: Modifying a collection during for-each iteration

Removing items directly inside a for-each loop can throw `ConcurrentModificationException`.

Use an `Iterator` and `iterator.remove()` when removing during traversal.

### Mistake 7: Using mutable objects as map keys without care

If a key's fields used in `equals()`/`hashCode()` are changed after insertion, retrieval can fail unexpectedly.

Best practice: keep map keys immutable (for example, `String`, boxed primitives, immutable custom objects).

---

## 14. Summary Table

| Interface / Family | Common Implementations | Order | Duplicates | Null Support* | Typical Use-Cases | Performance Notes | Key APIs / Tips |
| --- | --- | --- | --- | --- | --- | --- | --- |
| List | ArrayList, LinkedList, Vector | Maintains insertion order; index-based access | Allowed | Yes (elements) | Indexed reads, ordered data | ArrayList: $O(1)$ get/add-end, $O(n)$ middle insert/remove. LinkedList: $O(1)$ add/remove ends, $O(n)$ random access | `get`, `set`, `add`, `remove`, `indexOf`, `subList` |
| Set | HashSet, LinkedHashSet, TreeSet | HashSet: no order; LinkedHashSet: insertion order; TreeSet: sorted | Not allowed | HashSet/LinkedHashSet: one null; TreeSet: generally none unless comparator handles | Unique elements, membership tests, de-duplication | HashSet: $O(1)$ avg add/contains; TreeSet: $O(log n)$ add/contains | `add`, `contains`, `remove`, `iterator` |
| Queue / Deque | ArrayDeque, LinkedList, PriorityQueue | Queue: FIFO; Deque: both ends; PriorityQueue: heap-ordered | Allowed | ArrayDeque/PriorityQueue: no null; LinkedList: allows null (discouraged) | Task scheduling, BFS, buffering | ArrayDeque: $O(1)$ ends add/remove; PriorityQueue: $O(log n)$ add/poll | `offer`, `poll`, `peek`; `addFirst`, `pollLast` |
| Map | HashMap, LinkedHashMap, TreeMap | HashMap: no key order; LinkedHashMap: insertion/LRU order; TreeMap: sorted | Keys unique; values may duplicate | HashMap/LinkedHashMap: one null key + many null values; TreeMap: generally no null keys | Fast lookup by key, indexing, frequency maps | HashMap: $O(1)$ avg get/put; TreeMap: $O(log n)$ get/put | `get`, `put`, `containsKey`, `remove`, `keySet`, `values`, `entrySet` |
| Concurrent | ConcurrentHashMap, CopyOnWriteArrayList, ConcurrentLinkedQueue | Varies by implementation | As per underlying type | Often disallows nulls | Thread-safe reads/writes | Better throughput than synchronized wrappers in many multi-threaded cases | Prefer these over `Collections.synchronizedXxx` in high-concurrency use |
| Utilities | Collections (class), Arrays (class) | - | - | - | Sorting, shuffling, wrappers, views | - | `sort`, `reverse`, `shuffle`, `unmodifiableList/Set/Map`, `Arrays.asList` |

\* Null support varies by implementation and comparator behavior. Even when allowed, null is usually discouraged for clarity and safety.

---

## 15. Mini Practice Snippets

### Warm-Up Progression (Recommended Order)

1. Build a `List<Integer>`, add 5 numbers, print by index.
2. Convert it to a `Set<Integer>` and verify duplicates are removed.
3. Build a frequency `Map<Integer, Integer>` from the same list.
4. Push all elements into a `Queue<Integer>` and process using `poll()`.

If you can do these 4 in one sitting, your foundation is strong.

### Example 1: Remove Duplicates from a List

```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

List<Integer> data = new ArrayList<>();
data.add(1);
data.add(2);
data.add(2);
data.add(3);

Set<Integer> unique = new HashSet<>(data);
System.out.println(unique);
```

### Example 2: Frequency Count Using Map

```java
import java.util.HashMap;
import java.util.Map;

String[] arr = {"a", "b", "a", "c", "b", "a"};
Map<String, Integer> freq = new HashMap<>();

for (String s : arr) {
	freq.put(s, freq.getOrDefault(s, 0) + 1);
}

System.out.println(freq); // {a=3, b=2, c=1}
```

### Example 3: Queue Processing

```java
import java.util.ArrayDeque;
import java.util.Queue;

Queue<String> tasks = new ArrayDeque<>();
tasks.offer("compile");
tasks.offer("test");
tasks.offer("deploy");

while (!tasks.isEmpty()) {
	System.out.println("Processing: " + tasks.poll());
}
```

### Example 4: Safe Removal While Iterating

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5));
Iterator<Integer> it = nums.iterator();

while (it.hasNext()) {
	if (it.next() % 2 == 0) {
		it.remove();
	}
}

System.out.println(nums); // [1, 3, 5]
```

---

## 16. Section-End Quick Quiz

Answer these without looking above. If you get 4 or more correct, your foundation is strong.

1. Which collection should you choose if you need fast key-based lookup and do not care about key order?
2. Why can `HashSet` remove duplicates efficiently?
3. What is the difference between `Collection` and `Collections`?
4. Why is `List<int>` invalid but `List<Integer>` valid?
5. You need sorted unique elements. Which implementation is a direct fit?
6. Why can modifying a collection inside a for-each loop throw `ConcurrentModificationException`?
7. What is one practical difference between `ArrayList` and `LinkedList` for access patterns?

### Quick Answer Key

1. `HashMap`
2. It uses `hashCode()` + `equals()` to detect equivalent elements.
3. `Collection` is an interface; `Collections` is a utility class with static helper methods.
4. Generics require reference types; primitives use wrapper classes.
5. `TreeSet`
6. For-each uses an iterator under the hood; structural modification outside iterator rules triggers fail-fast behavior.
7. `ArrayList` is usually better for indexed reads; `LinkedList` is better for frequent insert/remove near ends or via iterator.

---

## 17. Final Revision Box

### Essential Concepts

- Java Collections Framework solves array limitations for dynamic data.
- Main interfaces: `List`, `Set`, `Queue`, `Map`.
- `List`: ordered + duplicates.
- `Set`: uniqueness.
- `Queue`: processing order.
- `Map`: key-value lookup with unique keys.
- Generics give compile-time type safety.
- Collections use wrapper types for primitives.
- `Collections` class provides utility algorithms.
- `equals()` + `hashCode()` are critical for hash-based collections.
- `Comparable`/`Comparator` are critical for tree-based sorting behavior.
- Internal design impacts performance.

### Self-Check Before Moving On

- Can you explain when to choose `ArrayList` vs `LinkedList`?
- Can you explain why `HashSet` removes duplicates?
- Can you explain why `TreeMap` operations are usually $O(log n)$?
- Can you explain why `List<int>` is invalid but `List<Integer>` is valid?
- Can you explain why modifying during for-each can throw `ConcurrentModificationException`?

### What You Can Now Do

- Pick the right collection for a real problem.
- Explain differences between `ArrayList`, `LinkedList`, and `Vector`.
- Use `HashSet`, `LinkedHashSet`, `TreeSet` correctly.
- Use `HashMap`, `LinkedHashMap`, `TreeMap` for key-value tasks.
- Apply generics for safe, clean collection code.
- Use `Collections.sort`, `reverse`, `shuffle`, and wrappers.
- Reason about $O(1)$ vs $O(log n)$ vs $O(n)$ operations.

### Beyond This Lesson

Next, you can go deeper into:

- Iterators and fail-fast behavior
- Comparable vs Comparator
- Streams with collections
- Immutable collections and defensive copying
- Concurrent collections in multi-threaded programs

Collections are a core skill in Java. Once this foundation is clear, problem solving becomes faster, cleaner, and more scalable.
