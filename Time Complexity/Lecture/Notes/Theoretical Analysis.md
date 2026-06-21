# Theoretical Analysis

- Operations such as conditionals, relational and mathematical operators are
considered unit operations

- However, a loop that runs unit operation `n` times, perform `n` operations

- Instead of counting the exact number of operations, we assume a constant work
`k` is being done

```java
int ans = 1; // line a
for(int i = 0; i < n; i++)
{
    for(int j : arr)
    {
        ans *= i;
    }
}
return ans; // line b
```

- In the above example, we will assume work being done on lines `a` and `b` as
$k_1$

- Additionally, we assume $k_2$ work being done each iteration in the inner
loop

- Therefore, our final equation for the total work being done here will be:

$$
k_1 + k_2\cdot{n}
$$
