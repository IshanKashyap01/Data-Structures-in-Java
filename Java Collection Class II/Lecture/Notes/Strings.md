# `String` Class in Java

## String Pool

- `String`s are immutable in Java, i.e. once created, they cannot be changed

- Whenever a `String` object is created as a literal, it is stored in the
*string pool*

- When a new `String` literal is created, it is matched by existing ones in the
pool

- If a match is found, its returned, otherwise a new `String` is created

- This prevents duplicate `String`s from being created and saves memory

- However, dynamically created `String`s (using `new`) are stored in the heap

## Useful Functions

- `toLowerCase()` converts the string to lower case

- `toUpperCase()` converts the string to upper case

- `trim()` removes white spaces before and after the string

- `equals()` compares every character between the two strings for equality

- `concat()` appends the given string behind the calling string object

- `split()` splits the calling string at every occurrence of the given string
