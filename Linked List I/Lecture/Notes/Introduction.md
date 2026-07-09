# Introduction to Data Structures

- A data structure is a way to organise data in memory

- Different data structures optimise for different operations such as finding,
adding or deleting elements

- They also control access to data by restricting how data can be read,
deleted, etc.

## Arrays

- Data is stored in a continuous, linear block of memory

- That is, each element is stored in the block of memory right next to the
previous one

- Therefore, any index can be accessed in constant time

## `ArrayList`

- `ArrayList` is a built-in dynamic array data structure in Java

- It uses an array to store data and expands it when it reaches full capacity

```java
ArrayList<Integer> arr = new ArrayList<>();
arr.add(1);
arr.add(30);
arr.add(0, 20);
arr.set(1, 10);
arr.remove(0);
System.out.print(arr.get(0) + arr.size());
```

- When it reaches full capacity, it creates a new array $1.5$ times larger

- The default capacity is `10` but you can also specify it in the constructor
