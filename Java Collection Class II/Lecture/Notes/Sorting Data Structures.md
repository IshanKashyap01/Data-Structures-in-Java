# Different Ways of Sorting Data Structures

- For arrays, the `Arrays` class provides a built-in sorting method that sorts
the data in ascending order

- `List`s can be sorted by using the `Collections.sort()` function

- The `Collections.reverseOrder()` allows sorting in reverse order

```java
// Returns a comparator that imposes reverse of the natural ordering on a collection
// does not work with primitives
Arrays.sort(arr, Collections.reverseOrder())
// can also be used to invert a custom comparator as well
Collections.sort(list, Collections.reverseOrder(new CustomComparator()));
```

- Lambda functions can also be used to achieve simple comparison algorithms
with minimal code

```java
Arrays.sort(arr, (a, b) -> b - a);
```
