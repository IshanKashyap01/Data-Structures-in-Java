# Use Cases of Recursion

- Theoretically, recursion and iteration are interchangeable

- That is, any problem that can be solved with a loop can also be solved with
recursion and vice versa

- However, in practice, there are cases where one is easier than the other

## Examples

We will use recursion where you'd typically use iteration in the following:

### Return Factorial of a Number

- We know that factorial of any number `n` is $n \times (n - 1)!$

- So call the function for `n - 1` and return its value multiplied by `n`

- The base case returns the answer for the smallest input

```java
public static int factorial(int n)
{
    // base case
    if(n == 0)
    {
        return 1;
    }
    // assumption/induction hypothesis
    return n * factorial(n - 1);
}
```

**Note**: Without a base case, the function will never stop calling itself

### Print First N Natural Numbers

1. We take our base case for `n = 0` where we do nothing

2. We assume that our function will print the first `n - 1` numbers so we call
it with `n - 1` first

3. Then, we just print `n`

```java
public static void printNNaturalNumbers(int n)
{
    if(n == 0)
    {
        return;
    }
    printNNaturalNumbers(n - 1);
    System.out.println(n);
}
```
