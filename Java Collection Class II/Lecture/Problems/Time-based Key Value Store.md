# Time-based Key Value Store

## Problem Statement

You are given a stream of tuples which constitute three things `Key`, `Val`,
and the `Timestamp`.

Your task is to implement the `TimeBased` class having the two functions:

### `setKey(string Key, string Val, int Timestamp)`

Stores the `Key` and the `Val` along with the `Timestamp`.

### `getValue(string TargetKey, int TargetTimestamp)`

Returns the value of `Val` associated with the `TargetKey` such that its
`Timestamp` value is less than or equal to the `TargetTimestamp`. If there are
multiple values of `Val`, return the value of `Val` with the highest value of
`Timestamp` among the valid ones. If there is no valid value of `Val` return
"-1" as a string.

`Timestamps` will always be in strictly increasing order.

## Detailed Explanation

### Input format

The first line of input contains an integer `T`, denoting the number of test
cases.

The first line of each test case contains an integer `N`, representing the
total number of queries.

Then the next `N` lines contain `N` queries. A query can be of two types:

1. Key Val Timestamp → stores the Key and the Val along with the Timestamp

2. TargetKey TargetTimestamp → returns the value of `Val`

### Output format

For each test case, print the value of `Val` for each query of type 2 only,
output the answer to the query in a single line.

**Note**: You do not need to print anything. It has already been taken care of.
Just implement the given functions.

### Constraints

$1 <= T <= 10$

$1 <= N <= 3 * 10^4$

$1 <= | Val |, | Key | <= 10$

$1 <= Timestamp <= 10^7$

Where `T` represents the number of test cases, `N` represents the number of
queries, `Val`, `Key` and `Timestamp` are added to the stream.

Time Limit: $1 sec$

```ltf
Sample Input 1:
2
4
1 abc def 10
1 abc ghi 20
2 abc 10
2 abc 5
3
1 bbb ccc 5
1 ddd ccc 5
2 ddd 6 
Sample Output 1:
def  -1
ccc
Sample Input 2:
2
3
1 yyy zzz 3
1 yyy xxx 4
2 yyy 4
4
2 fff 13
1 fff ggg 13
1 fff hhh 14
2 fff 14 
Sample Output 2:
xxx
-1 hhh
```

## Solution

```java
import java.util.*;

public class Timebased 
{
    private HashMap<String, TreeMap<Integer, String>> map;

    Timebased() 
    {
        // Initialise your data structure here.
        this.map = new HashMap<>();
    }
    /*
    * Time complexity  : O(logn)
    * Space complexity : O(1)
    */
    public void setKey(String key, String val, int timestamp) 
    {
        TreeMap<Integer, String> timeMap;
        if(this.map.containsKey(key))
        {
            timeMap = this.map.get(key);
        }
        else
        {
            timeMap = new TreeMap<>();
            this.map.put(key, timeMap);
        }
        timeMap.put(timestamp, val);
    }
    /*
    * Time complexity  : O(logn)
    * Space complexity : O(1)
    */
    public String getValue(String key, int timestamp) 
    {
        if(!this.map.containsKey(key))
        {
            return "-1";
        }
        TreeMap<Integer, String> timeMap = this.map.get(key);
        Integer closestTimestamp = timeMap.floorKey(timestamp);
        return closestTimestamp != null ? timeMap.get(closestTimestamp) : "-1";
    }
}
```
