# Java Fundamentals - Classes and Objects

## Quick Reference (1-Minute Recall)

- A class is a blueprint for creating objects.
- An object is a real instance of a class.
- A class lets you group related data and behavior together.
- Constructors are special methods used to initialize objects.
- Constructors have the same name as the class and no return type.
- `new` creates an object and calls the constructor.
- Object creation can set values in one step.
- Access modifiers control who can access fields and methods (public, private).
- The `this` keyword refers to the current object.
- Static members belong to the class, not to individual objects.
- Nested classes are classes written inside another class.
- Classes are a core idea behind object-oriented programming.

---

## Why Classes and Objects Matter

Up to this point, you have learned variables, conditionals, loops, functions, and problem solving.

Now you move to a new idea: organizing code around things.

That is the main purpose of classes and objects.

Instead of writing everything as separate variables and functions, you can group related information and actions together inside one unit.

For example:

- A student has a name, roll number, and marks.
- A car has a brand, color, and speed.
- A bank account has an account number, balance, and owner.

These are all examples of things that naturally fit into a class.

---

## 1. The Basic Idea of a Class

A class is a custom structure that you define yourself.

### A Better Way to Think About It

At first, it may sound like a class is just a custom data type.

That is a useful beginner-level idea, but it is not the full picture.

A more accurate idea is this:

- A class is an idea or template.
- The default built-in things in Java, like `int`, `char`, and `double`, are already implemented versions of this idea.
- A class lets you create your own custom version of that same organizing idea.

So the class is not just about storing data.
It is about defining a structure that can hold data and behavior together.

### Simple Meaning

A class tells Java:

- what data a thing should have
- what actions that thing can do

---

## 2. Class vs Object

These two words are related but not the same.

### Class

A class is the blueprint.

### Object

An object is the actual thing made from that blueprint.

### Example

If `Car` is the class, then:

- one Toyota car is an object
- one Honda car is an object
- one BMW car is an object

All are objects created from the same class.

### Easy Analogy

- Class = cookie cutter
- Object = cookie made using that cutter

---

## 3. A Simple Class Example

Here is a basic class for a student.

```java
class Student {
	String name;
	int roll;
	float marks;
}
```

### What This Means

This class says that every `Student` object can have:

- a `name`
- a `roll`
- `marks`

These are called fields or instance variables.

---

## 4. Creating Objects

Once a class is written, you can create objects from it.

### Example

```java
Student s1 = new Student();
```

### What This Means

- `Student` is the class name.
- `s1` is the object name.
- `new Student()` creates a new object.

### Visual Meaning

This line creates one student object in memory.

Then you can store values in it:

```java
s1.name = "Rahul";
s1.roll = 12;
s1.marks = 91.5f;
```

Now that object holds actual data.

---

## 5. Accessing Object Data

To use the fields inside an object, use the dot operator `.`.

### Example

```java
System.out.println(s1.name);
System.out.println(s1.roll);
System.out.println(s1.marks);
```

### Why This Works

The object keeps its own copy of the data.
That is why different objects of the same class can store different values.

---

## 6. Why Objects Are Useful

Without classes, you would write separate variables for each thing.

With classes, you can group related values together.

### Without a Class

```java
String name1 = "Rahul";
int roll1 = 12;
float marks1 = 91.5f;
```

This is fine for one student, but it becomes messy for many students.

### With a Class

```java
Student s1 = new Student();
Student s2 = new Student();
```

Now each object can hold a separate student’s data.

---

## 7. Objects as Real-World Models

Classes help you model real-world things.

### Example: Car

```java
class Car {
	String brand;
	String color;
	int speed;
}
```

Then you can create objects like:

```java
Car c1 = new Car();
Car c2 = new Car();
```

Each object can have different values.

This is one of the main reasons classes exist: to model real entities in code.

---

## 8. Constructors

A constructor is a special method used to initialize an object.

### Why Constructors Are Needed

If you create an object and then set every field separately, it takes multiple lines.

A constructor lets you do the initialization in one step.

### Simple Constructor Example

```java
class Student {
	String name;
	int roll;
	float marks;

	Student(String n, int r, float m) {
		name = n;
		roll = r;
		marks = m;
	}
}
```

### How It Works

When you create the object, you can pass values right away.

```java
Student s1 = new Student("Rahul", 12, 91.5f);
```

Now the object is created and initialized at the same time.

---

## 9. Constructor Syntax

Constructors look a lot like methods, but they have some special rules.

### Similarities to Methods

- They have parentheses.
- They can take parameters.
- They can contain code inside the body.

### Differences from Methods

- A constructor has the same name as the class.
- A constructor has no return type, not even `void`.
- A constructor runs automatically when you create an object with `new`.

### Example

```java
class Student {
	String name;
	int roll;

	Student(String n, int r) {
		name = n;
		roll = r;
	}
}
```

This is the constructor.

When you write:

```java
Student s1 = new Student("Aman", 7);
```

the constructor is called automatically.

---

## 10. Initializing Values in One Step

This is the main advantage of constructors in the lecture.

### Without Constructor

```java
Student s1 = new Student();
s1.name = "Aman";
s1.roll = 7;
```

### With Constructor

```java
Student s1 = new Student("Aman", 7);
```

### Why This Matters

The constructor makes object creation cleaner, shorter, and safer.

You do not have to create the object first and then separately assign every field.

---

## 11. Default Constructor Idea

If you do not write any constructor, Java may provide a default one in some cases.

But once you define your own constructor, you are taking control of object initialization.

For now, the important idea is this:

- constructors set initial values
- constructors help avoid uninitialized objects

---

## 12. Class Syntax and Object Syntax Together

### Class Definition

```java
class Student {
	String name;
	int roll;

	Student(String n, int r) {
		name = n;
		roll = r;
	}
}
```

### Object Creation

```java
Student s1 = new Student("Riya", 10);
```

### Field Access

```java
System.out.println(s1.name);
System.out.println(s1.roll);
```

This is the full basic flow:

1. Define the class.
2. Write the constructor.
3. Create an object.
4. Access its fields.

---

## 13. `new` Keyword

The `new` keyword creates a new object in memory.

### Example

```java
Student s1 = new Student("Riya", 10);
```

### What Happens

- memory is allocated for the object
- the constructor runs
- the object gets initialized
- the object reference is stored in `s1`

This is how objects come into existence.

---

## 14. Objects Are Separate Instances

If you create two objects from the same class, they are still separate.

### Example

```java
Student s1 = new Student("Riya", 10);
Student s2 = new Student("Aman", 11);
```

These are two different objects.

Changing one does not automatically change the other.

That is another reason classes are powerful: one structure, many independent instances.

---

## 15. Constructors and Methods Are Not the Same

Constructors and methods look similar, but they do different jobs.

### Constructor

- used to initialize objects
- called automatically with `new`
- has the same name as the class
- has no return type

### Method

- used to perform an action
- called manually
- can have any valid name
- can return a value or be `void`

### Simple Comparison

```java
class Student {
	String name;

	Student(String n) {
		name = n;
	}

	void show() {
		System.out.println(name);
	}
}
```

Here:

- `Student(String n)` is the constructor
- `show()` is a method

---

## 16. Access Modifiers

Access modifiers control who can access fields and methods from outside the class.

### Why Access Modifiers Matter

When you create a class, some data should be private (only for the class to use).

Some data should be public (safe for others to use).

Java gives you keywords to control this.

### The Two Main Access Modifiers

#### `public`

A public field or method can be accessed from outside the class.

### Example

```java
class Student {
	public String name;

	public Student(String n) {
		name = n;
	}

	public void display() {
		System.out.println(name);
	}
}
```

Now you can access the public field from outside:

```java
Student s1 = new Student("Ravi");
System.out.println(s1.name);  // This works because name is public
s1.display();  // This works because display is public
```

#### `private`

A private field or method can only be accessed from inside the class.

It is hidden from the outside.

### Example

```java
class Student {
	private String name;

	public Student(String n) {
		name = n;  // This works because we are inside the class
	}

	public void display() {
		System.out.println(name);  // This works because we are inside the class
	}
}
```

Now you cannot access the private field from outside:

```java
Student s1 = new Student("Ravi");
System.out.println(s1.name);  // ERROR: name is private
```

But you can call the public method:

```java
s1.display();  // This works
```

### Why Use `private`?

Private fields protect your data from being changed incorrectly from outside.

They force users of your class to go through public methods instead.

This is safer and more controlled.

### Real-World Example

Think of a bank account:

```java
class BankAccount {
	private double balance;  // Only the bank can change this

	public void deposit(double amount) {
		if (amount > 0) {
			balance = balance + amount;
		}
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance = balance - amount;
		}
	}

	public double getBalance() {
		return balance;
	}
}
```

Here:

- `balance` is private (cannot be changed directly from outside)
- `deposit()` and `withdraw()` are public (users interact through these)
- They add safety checks before changing the balance
- Without private, someone could do `account.balance = -1000` and break the system

### Default (No Modifier)

If you do not write `public` or `private`, Java uses a default called package-private.

For now, stick to `public` and `private`.

---

## 17. The `this` Keyword

The `this` keyword refers to the current object.

It is useful when you need to refer to the object's own fields or methods.

### When Do You Need `this`?

#### In Constructors

When a parameter has the same name as a field, use `this` to refer to the field.

### Example Without `this`

```java
class Student {
	String name;

	Student(String name) {
		name = name;  // Which 'name' is which? CONFUSING!
	}
}
```

This does NOT work correctly because `name = name` is ambiguous.

### Example With `this`

```java
class Student {
	String name;

	Student(String name) {
		this.name = name;  // this.name is the field, name is the parameter
	}
}
```

Now it is clear:

- `this.name` is the field of the object
- `name` is the parameter

#### In Methods

You can use `this` to call other methods of the same object.

### Example

```java
class Student {
	String name;

	Student(String name) {
		this.name = name;
	}

	void display() {
		System.out.println(this.name);  // Using this to refer to the field
	}

	void greet() {
		this.display();  // Using this to call another method
	}
}
```

When you call:

```java
Student s1 = new Student("Ravi");
s1.greet();
```

It runs `greet()`, which calls `this.display()`, which prints the name.

### `this` is Implicit

Most of the time, you do NOT need to write `this`.

Java adds it automatically.

### Example

```java
class Student {
	String name;

	Student(String name) {
		this.name = name;
	}

	void display() {
		System.out.println(name);  // Java knows you mean 'this.name'
	}
}
```

You can write just `name` and Java understands it is `this.name`.

But writing `this.name` explicitly makes code clearer, especially for beginners.

### When You Must Use `this`

When a parameter name shadows a field name (is the same), you must use `this` to refer to the field.

Otherwise, the parameter hides the field.

### What Happens If You Don't Use `this` (When You Should)

If you forget `this` and write `name = name`, Java will not assign to the field.

Instead, it assigns the parameter to itself, which does nothing.

### Example of the Problem

```java
class Student {
	String name;

	Student(String name) {
		name = name;  // WRONG: assigns parameter to itself, field stays uninitialized
	}

	void display() {
		System.out.println(name);  // Will print null because name was never set
	}
}
```

When you run:

```java
Student s1 = new Student("Ravi");
s1.display();  // Output: null  (NOT "Ravi" as expected)
```

The field `name` is never initialized, so it remains `null`.

### Correct Use of `this`

```java
class Student {
	String name;

	Student(String name) {
		this.name = name;  // CORRECT: assigns parameter to field
	}

	void display() {
		System.out.println(name);
	}
}
```

Now:

```java
Student s1 = new Student("Ravi");
s1.display();  // Output: Ravi  (CORRECT)
```

### Java's Implicit `this` Rule

When Java sees a field name that does NOT match a parameter name, it automatically adds `this`:

```java
class Student {
	String studentName;

	Student(String name) {
		studentName = name;  // Java treats this as: this.studentName = name
	}
}
```

But when names match, Java cannot tell if you mean the field or the parameter, so you must write `this` explicitly.

---

## 18. Static Members and Static Methods

The `static` keyword means something belongs to the class, not to individual objects.

### Instance vs Static

#### Instance Members (Default)

Each object has its own copy.

```java
class Student {
	String name;  // Each student object has its own name
}
```

#### Static Members

All objects share one copy.

```java
class Student {
	static int studentCount = 0;  // All students share this count
}
```

### Why Use Static?

Sometimes you want data or behavior that is shared across all objects.

For example:

- a count of how many objects were created
- a constant that applies to all objects
- a utility method that does not need an object

### Static Fields

A static field is shared by all objects of the class.

### Example

```java
class Student {
	String name;
	static int studentCount = 0;

	Student(String name) {
		this.name = name;
		studentCount++;  // Increment the shared count
	}
}
```

Now:

```java
Student s1 = new Student("Ravi");
Student s2 = new Student("Aman");
System.out.println(Student.studentCount);  // Prints 2
```

Note: You access static fields using the class name, not the object.

### Static Methods

A static method does not belong to any object.

It belongs to the class itself.

### Example

```java
class MathHelper {
	static int add(int a, int b) {
		return a + b;
	}
}
```

You call it using the class name:

```java
int result = MathHelper.add(5, 3);  // Prints 8
```

You do NOT need to create an object first.

### When to Use Static Methods

Static methods are useful for utility operations that do not depend on object state.

Examples:

- Converting temperature from Celsius to Fahrenheit
- Checking if a number is prime
- Parsing a string to an integer

### Instance Methods vs Static Methods

#### Instance Method

```java
class Student {
	String name;

	void display() {
		System.out.println(name);  // Uses the object's 'name'
	}
}
```

You must create an object first:

```java
Student s1 = new Student("Ravi");
s1.display();  // Works
```

#### Static Method

```java
class MathHelper {
	static int square(int x) {
		return x * x;  // Does NOT use any object data
	}
}
```

You do NOT need an object:

```java
int result = MathHelper.square(5);  // Works without an object
```

### Static Fields in DSA

Static is useful in data structures.

For example, when you create a Node class for a linked list:

```java
class Node {
	int data;
	Node next;
	static int nodeCount = 0;  // Track total nodes created

	Node(int data) {
		this.data = data;
		this.next = null;
		nodeCount++;  // Increment shared count every time a node is created
	}
}
```

Now every time you create a new Node, the shared `nodeCount` increases:

```java
Node n1 = new Node(10);  // nodeCount = 1
Node n2 = new Node(20);  // nodeCount = 2
Node n3 = new Node(30);  // nodeCount = 3
System.out.println(Node.nodeCount);  // Prints 3
```

Without static, you would have to count nodes manually.

With static, the class itself keeps track.

### Why Access Static as `ClassName.staticMember`?

Static members belong to the class, not to individual objects.

So you access them using the class name, not an object name.

```java
// Access static field
Student.studentCount = 100;
System.out.println(Student.studentCount);

// Access static method
int result = MathHelper.add(5, 3);
```

This makes it clear: "I am using a class-level feature, not an object-specific feature."

You CAN technically use `object.staticMember` in Java, but it is confusing and bad practice:

```java
Student s1 = new Student("Ravi");
s1.studentCount++;  // Works but confusing! This is a shared field, not s1's field
```

This looks like you are modifying s1's data, but you are actually modifying shared data.

So always use `ClassName.staticMember` to be clear.

### Static vs Instance: Side-by-Side Comparison

Think of it this way:

- Instance fields: "My data" - each object has its own copy
- Static fields: "Our data" - all objects share one copy

```java
class Team {
	String playerName;        // Instance: each player has their own name
	static String teamName;   // Static: all players share the same team name

	Team(String playerName) {
		this.playerName = playerName;
		// teamName is shared, so we do not set it here
	}
}
```

When you set the team name once, all players see the same team name:

```java
Team.teamName = "Thunder";

Team p1 = new Team("Ravi");
Team p2 = new Team("Aman");

System.out.println(p1.playerName);  // "Ravi"
System.out.println(p2.playerName);  // "Aman"
System.out.println(p1.teamName);    // "Thunder" (same for both because it is static)
System.out.println(p2.teamName);    // "Thunder" (same for both because it is static)
```

### Static in DSA Use Cases

Static is common in data structure implementations:

1. **Counting nodes:** Track how many nodes exist in a linked list
2. **Tracking sentinels:** A dummy node shared by all operations
3. **Utility functions:** Helper methods that do not depend on any object
4. **Constants:** Values shared by all objects (like a maximum size)

---

## 19. Nested Classes

The lecture next moved to nested classes.

A nested class is a class written inside another class.

### Basic Idea

```java
class Outer {
	class Inner {
	}
}
```

### Why Use Nested Classes?

Sometimes one class is logically part of another class.

For example:

- a `Car` may contain an `Engine`
- a `School` may contain a `StudentRecord`
- a `Computer` may contain a `CPU`

Nested classes help group related structures together.

### Simple Example

```java
class Outer {
	class Inner {
		void show() {
			System.out.println("Inside inner class");
		}
	}
}
```

### Creating an Inner Class Object

```java
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();
inner.show();
```

### What to Remember

- The inner class belongs inside the outer class.
- You often need an outer object to create an inner object.
- This is a structural feature, not a separate topic unrelated to classes.

---

## 20. Why This Is Still Part of the Same Lecture

You mentioned there is no separate OOP lecture in this playlist, and that is important.

So in this chapter, classes and objects are not just one isolated topic.
They are the starting point of object-oriented thinking.

That means this chapter should cover:

- what a class is
- what an object is
- how constructors initialize objects
- how access modifiers protect data
- how `this` refers to the current object
- how static members are shared
- how nested classes fit inside classes

This is the foundation you need before moving further.

---

## 21. Common Beginner Mistakes

### Mistake 1: Thinking a Class Is the Object

A class is the blueprint.
The object is the actual thing.

### Mistake 2: Forgetting `new`

You must create the object before using it.

### Mistake 3: Forgetting the Constructor Name Rule

The constructor name must match the class name.

### Mistake 4: Adding a Return Type to a Constructor

Constructors do not have return types.

### Mistake 5: Mixing Up Class Fields and Local Variables

Fields belong to the object.
Local variables exist only inside the method or constructor.

### Mistake 6: Not Using Constructors for Initialization

Constructors help set values in one step and reduce repeated code.

Without a constructor, you must create the object and then assign each field separately, which is error-prone and verbose.

### Mistake 7: Forgetting to Use `private` for Sensitive Data

Always mark fields as private unless they need to be public.

### Mistake 8: Confusing Instance and Static Members

Instance members are per-object. Static members are per-class.

### Mistake 9: Forgetting to Use `this` When Parameter Names Shadow Fields

When a parameter name matches a field name, use `this.fieldName` to avoid confusion.

---

## 22. Common Beginner Mistakes (Additional)

These are additional mistakes specific to the new concepts:

### Mistake 10: Accessing Private Members from Outside

Private fields and methods are hidden from outside the class. You must use public methods instead.

### Mistake 11: Trying to Use Instance Data in Static Methods

Static methods cannot access instance variables directly because they do not belong to any specific object.

### Mistake 12: Forgetting that Static Fields Are Shared

If you modify a static field in one object, it changes for all objects because they all share the same field.

---

## 22. Practice Summary

Here is the short version of what you should remember.

### Core Ideas

- A class is a blueprint or custom structure.
- An object is an instance created from a class.
- Classes organize data and behavior together.
- Constructors initialize objects.
- Constructors have the same name as the class and no return type.
- `new` creates an object and calls the constructor.
- Access modifiers (public, private) control visibility.
- The `this` keyword refers to the current object.
- Static members are shared across all objects of the class.
- Nested classes are classes written inside other classes.

### Mental Model

Think of a class as a design and an object as the actual product built from that design.

### Why This Is Powerful

- It helps you model real-world things.
- It keeps related data together.
- It makes initialization cleaner.
- It prepares you for object-oriented programming.

---

## 23. Try These on Your Own

1. Write a `Student` class with `name`, `roll`, and `marks`.
2. Create two student objects and give them different values.
3. Add a constructor to initialize the student fields in one step.
4. Write a `Car` class with `brand`, `color`, and `speed`.
5. Create a `BankAccount` class with private `balance`, and public `deposit()` and `withdraw()` methods.
6. Write a class with a `static` field that counts how many objects were created.
7. Use `this` in a constructor to distinguish between parameters and fields.
8. Create a nested class inside another class and call one method from it.
9. Compare object creation with and without constructors.

---

## Final Revision Box

### Essential Concepts

- Classes are the idea behind creating custom structures.
- Objects are actual instances created from classes.
- Constructors initialize objects automatically.
- `new` creates a new object in memory.
- Constructors look like methods but are not methods.
- Nested classes place one class inside another.
- Classes and objects are the first step into object-oriented programming.

### What You Can Now Do

✓ Define a class
✓ Create objects from a class
✓ Initialize values using a constructor
✓ Understand why constructors are useful
✓ Recognize and create nested classes
✓ Explain the difference between a class and an object

Classes and objects are where your code starts modeling real things instead of only performing standalone steps.
