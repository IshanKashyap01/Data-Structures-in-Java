# Comparators

- `Comparator` is an interface that allows *custom sorting strategies* for
`Comparable` objects

- `Comparable` defines the default/natural ordering of an object that
implements it

- It provides one function: `compare()` that must be overridden

- The function must:

    1. Return a negative number if the first object is lesser than the second

    2. Return zero if they're equal

    3. Return a positive number if the first object is greater

```java
TreeSet<Integer> set = new TreeSet<>(new CustomComparator());
TreeMap<Integer> map = new TreeMap<>(new CustomComparator());
```

- Comparators can also be used while initialising ordered data structures

## Example

```java
import java.util.Comparator;
class DescendingOrder implements Comparator<Integer>
{
    @Override
    public int compare(Integer a, Integer b)
    {
        return b - a;
    }
}
```

- The above class can be used to sort an array in descending order as follows:

```java
Integer[] arr = {1, 2, 3, 4, 5};
Arrays.sort(arr, new DescendingOrder());
```

- Instead of creating a new class, Java also allows in *inline* alternative

```java
Arrays.sort(arr, new Comparator<Integer>(){
    @Override
    public int compare(Integer a, Integer b)
    {
        return b - a;
    }
});
```
