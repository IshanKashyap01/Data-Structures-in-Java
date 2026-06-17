# Recursion with Strings

- We can access and iterate through each character of a `String` through the
`charAt()` function

- Therefore, also making it possible to recurse through `String`s

## Example

Suppose we need to replace every occurrence of a character with another

- We can work for the first character and let recursion handle the rest

```java
if(str.charAt(index) == target)
{
    return replacement + recurse(str.substring(1));
}
return str.charAt(index) + recurse(str.substring(1));
```

- For longer strings, we can use `StringBuilder` to build the string

- And use a variable to keep track of current index instead of creating a
substring each time
