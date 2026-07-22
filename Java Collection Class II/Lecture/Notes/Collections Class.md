# `Collections` Class in Java

- It is a utility class for `Collection` objects

```java
Collections.addAll(collection, element1, element2, element3);
Collections.swap(list, index1, index2);
Collection.sort(list, Collections.reverseOrder());
Collections.fill(collection, object);
```

- `addAll()` adds all provided elements to the given `Collection` object

- `swap()` swaps the positions of two elements of a `List` object

- `sort()` sorts a `List` object the natural ordering of its elements

- `reverseOrder()` returns a `Comparator` that imposes reverse of the natural
ordering of an object

  - If passed a `Comparator`, it returns its inverse

- `max()` returns the greatest value stored in a `Collection`

- `min()` returns the minimum value store in a `Collection`

- `fill()` replaces all elements of the specified `List` with the given value
