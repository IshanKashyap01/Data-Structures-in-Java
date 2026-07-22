# Overlapping Intervals

## Problem Statement

You have been given the start and end times of `N` intervals. Write a function
to check if any two intervals overlap with each other.

**Note**: If an interval ends at time T and another interval starts at the same
time, they are not considered overlapping intervals.

## Detailed Explanation

### Input format

The first line contains an Integer `T` which denotes the number of test cases
or queries to be run. Then the test cases follow.

The first line of each test case or query contains an integer `N` representing
the total number of intervals.

The second line contains `N` single space-separated integers representing the
starting time of the intervals.

The third line contains `N` single space-separated integers representing the
end time of the intervals.

### Output Format

For each test case, return true if overlapping intervals are present.
Otherwise, return false.

Output for every test case will be printed in a separate line.

**Note**: You do not have to print anything. Just return the boolean value.

### Constraints

$1 <= T <= 10^2$

$0 <= N <= 10^5$

$0 <= Start[i] <= 10^15$

$1 <= End[i] <= 10^15  $

Time Limit: $1 sec$

```ltf
Sample Input 1:
1
3
1 2 3
2 3 4
Sample Output 1:
false
Explanation For Sample Input 1:
Here, in given intervals [1, 2], [2, 3], [3, 4], there are no overlapping intervals present.
Sample Input 2:
2
1
100
200
2
2 1
3 4
Sample Output 2:
false
true
```

## Solution

```java
import java.util.*;

public class Solution 
{
    /*
    * Time complexity  : O(n)
    * Space complexity : O(n)
    */
    public static boolean checkOverlappingIntervals (long[] startTime, long[] endTime) 
    {
        PriorityQueue<Interval> pq = new PriorityQueue<>();
        int n = startTime.length;
        // Add all intervals to the priority queue
        for(int i = 0; i < n; i++)
        {
            pq.add(new Interval(startTime[i], endTime[i]));
        }
        Interval prev = new Interval(-1, -1);
        Interval curr;
        // if curr doesn't overlap with prev, it doesn't overlap with anything before prev either
        while(!pq.isEmpty())
        {
            curr = pq.poll();
            if(Interval.areOverlapping(curr, prev))
            {
                return true;
            }
            prev = curr;
        }
        return false;
    }
}

class Interval implements Comparable<Interval>
{
    private long startTime;
    private long endTime;

    public Interval(long startTime, long endTime)
    {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Interval interval)
    {
        // whichever starts first should come before
        if(this.startTime < interval.startTime)
        {
            return -1;
        }
        if(this.startTime > interval.startTime)
        {
            return 1;
        }
        // whichever is longer should come before
        if(interval.interval() < this.interval())
        {
            return -1;
        }
        else if(interval.interval() > this.interval())
        {
            return 1;
        }
        return 0;
    }

    public long interval()
    {
        return endTime - startTime;
    }

    public long start()
    {
        return this.startTime;
    }

    public long end()
    {
        return this.endTime;
    }

    public static boolean areOverlapping(Interval a, Interval b)
    {
        // if one begins after or where the other ends, there's no overlap
        if(a.start() >= b.end() || b.start() >= a.end())
        {
            return false;
        }
        return true;
    }
}
```
