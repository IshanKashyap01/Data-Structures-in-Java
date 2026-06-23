# Theoretical Analysis: Fibonacci Series (Recursive)

```java
public static void fibonacci(int n)
{
    if(n == 0 || n == 1)
    {
        return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

## Time Complexity

- In the above code, each function calls two functions with a smaller output

$$
T(n) = k\cdot{T(n - 1)} + k\cdot{T(n - 2)}
$$

- If we trace the number of calls, we'll find that there will be $2^n$ function
calls

$$
T(n - 1) = k\cdot{T(n - 2)} + k\cdot{T(n - 3)}\\
T(n - 2) = k\cdot{T(n - 3)} + k\cdot{T(n - 4)}\\
.\\
.\\
T(1) = k\\
T(0) = k
$$

- That is, we'll have $2^n$ equation, and adding them, we'll get:

$$
T(n) = 2^n k
$$

- Therefore, the time complexity of this code will be:

$$
O(2^n)
$$

## Space Complexity

- Although the total number of function calls will be $2^n$, they won't all be
present in the call stack at once

- Each function will first call `fibonacci(n - 1)` and only call
`fibonacci(n - 2)` after the first one returns

- The first put will call `n - 1` functions in the call stack

- Therefore, the maximum number of functions in the call stack at any moment
will be `n`

- Hence, the space complexity of the algorithm will be:

$$
O(n)
$$
