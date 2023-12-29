# HashMaps

- Internally, a Hashmap contains an ```Array```/```ArrayList``` called as a
**Bucket array**

- It passes the **key** through a **hash function** that returns its **hash code**

- This code is **compressed** using the *size* of the *bucket array*

- The resultant value will be the **index** of the key-value pair

- In order to maintain low time complexity, the *bucket array* is **expanded**
regularly
