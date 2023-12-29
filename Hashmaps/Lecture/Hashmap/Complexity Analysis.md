# Complexity Analysis

## Insertion

- Insertions in a Hashmap depends on the complexity of the **hash function**

- This function is different for different data types and is not necessarily **O(1)**

- For example, the hash function of string has a time complexity of **O(*l*)**,
where *l* is the length of the string

- However, if the average length of string wrt size of the Hashmap is too small,
it can be considered **O(1)**

- Hence, generally, the time complexity of **hash function** is considered **O(1)**

## Retrieval

- The time complexity is **O(n/b)** where **b** is the size of the bucket array
in *closed hashing*

- In *open addressing*, the time complexity is **O(1/(1 - a))** where **a** is the
**load factor**

- **Load factor** is a measure of how full the table is allowed to get before its
capacity is increased

- Generally, the load factor is a constant value of **0.75**

- If the load factor is constant the time complexity will become **O(1)**

## Rehashing

- Rehashing requires time and space complexity of **O(n)**

- Although, it is done very few times per 1000 entries keeping the average complexity
as **O(1)**
