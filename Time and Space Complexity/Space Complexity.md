# Space Complexity

## Rules For Calculating Space Complexity

1. Only account the maximum space required at any given point of time

    - A function may vary the space it takes during its execution $f(s)$

    - We only consider the maximum value of its range

2. Only take into account *auxiliary space*

    - Space taken up by input (function parameters) will not be counted

3. Recursion takes space in the *call stack*

    - Therefore, count the maximum number of functions the call stack will hold
    at any given point in time

## Examples

```java
public static void printUpTo(int n)
{
    for(int i = 0; i < n; i++)
    {
        System.out.println(i);
    }
}
```

- In the above code, we are printing the value of `i`, `n` times however,
we are not using any extra space to do so

$$
S(n) = k
\implies S(n) = k\cdot{n^0}
$$

- Therefore, our space complexity will be $O(1)$

- However, say we were initialising a new variable within the loop:

```java
for(int i = 0; i < n; i++)
{
    int j = 0;
    System.out.println(i);
}
```

- `j` will be released from memory after each iteration and re-initialised at
the start of the next one

- Therefore, our space complexity will still be $O(1)$

```java
public static
```
