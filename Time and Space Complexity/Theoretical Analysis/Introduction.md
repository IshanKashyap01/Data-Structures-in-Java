# Theoretical Analysis: Recursive Algorithms

- This lecture will cover analysing the time and space complexity of recursive
algorithms

- Consider the following implementation of *factorial of a number*:

```java
public static int factorial(int n)
{
    if(n == 0)
    {
        return 1;
    }
    return n * factorial(n - 1);
}
```

## Time Complexity

- In the above code we do some constant work and call the function with a
smaller input

- We can represent the time taken by the function as follows:

$$
T(n) = k + T(n - 1)
$$

- This is known as a **recurrence relation**. Following the same logic:

$$
T(n - 1) = k + T(n - 2)\\
T(n - 2) = k + T(n - 3)\\
.\\
.\\
T(1) = k + T(0)
$$

- If we add all the above equations, we get:

$$
T(n) = k_1\cdot{n} + T(0)\\
\implies T(n) = k_1\cdot{n} + k_2
$$

- Therefore, the time complexity in big O notation will be:

$$O(n)$$

## Space Complexity

- In this code, every function call does some constant work and there are `n`
number of function calls

- That's also the maximum number of calls present in the call stack at any
moment

- Therefore, the space complexity of the algorithm will be:

$$
O(n)
$$
