# `Arrays` Class

- It is a utility class with `static` methods that allows various operations
on arrays

```java
int[] arr1 = {1, 2, 3, 4, 5};
int[] arr2 = new int[5]
// [1, 2, 3, 4, 5]
System.out.println(Arrays.toString(arr1))
// false
System.out.println(Arrays.equals(arr1, arr2));
// [5, 5, 5, 5, 5]
Arrays.fill(arr2, 5);
```

- `toString()` converts the given array into a string

- `sort()` sorts the given array in ascending order

- `equals()` compares each element of the two given arrays to check if they're
same

- `fill()` fills every position in the given array with the given value
