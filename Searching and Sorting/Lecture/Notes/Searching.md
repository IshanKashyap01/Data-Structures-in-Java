# Searching & Sorting

- **Searching** involves finding specific element in a collection

- In 99% cases you'll be using either *linear* search or *binary* search
algorithm

## Linear Search

In an unsorted collection, we go by every element one by one, until we find
what we're looking for

```java
public static int firstIndexOf(int[] array, int number)
{
    for(int i = 0; i < array.length; i++)
    {
        if(array[i] == number)
        {
            return i;
        }
    }
    return -1;
}
```

## Binary Search

- Suppose we have an array sorted in ascending order and we must find a number

- As the array is sorted, it must come after a smaller but before a larger
number

```java
public static boolean isNumberPresent(int[] array, int number)
{
    int start = 0, end = array.length - 1;
    int mid;
    while(start <= end)
    {
        // this avoids overflow with large numbers unlike (start + end) / 2
        mid = start + (end - start) / 2;
        if(number < array[mid])
        {
            end = mid - 1;
        }
        else if(number == array[mid])
        {
            return true;
        }
        else
        {
            start = mid + 1;
        }
    }
    return false;
}
```
