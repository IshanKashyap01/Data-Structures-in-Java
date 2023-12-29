# Collision Handling

## Closed Hashing (Separate Chaining)

- Each *index* maintains a list of pairs with same **hash code**

- This list can be either an ```ArrayList``` or a ```LinkedList```

## Open Addressing

- Indices are calculated by *hash function* and an **index function**

    $$h_i(a) = hash(a) + f(i)$$

- where i is the number of nodex with same hash code

- The index function may use any of the following:

    1. **Linear probing**: $$f(i) = i$$
    2. **Quadratic probing**: $$f(i) = i^2$$
    3. **Double hashing**: $$f(i) = i * h'(a)$$
