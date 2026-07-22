# Closest Distance Pair

## Problem Statement

You are given an array containing `N` points in the plane. The task is to find
out the distance of the closest points.

**Note**: Where distance between two points (x1, y1) and (x2, y2) is calculated
as $[(x1 - x2) ^ 2] + [(y1 - y2) ^ 2]$.

## Detailed Explanation

### Input Format

The first line contains a single integer `N` denoting the number of points.

The next `N` lines contain two integers separated by a single space, where the
first integer represents the x coordinate and the second integer represents the
y coordinate.

### Output Format

The only line contains the minimum distance between the `N` points.

**Note**: You do not need to print anything, it has already been taken care of.
Just implement the given function.

### Constraints

$2 <= `N` <= 10^5$

$-10^5 <= `x` <= 10^5$

$-10^5 <= `y` <= 10^5$

Time Limit: $1 sec$

```ltf
Sample Input 1:
5
1 2
2 3
3 4
5 6
2 1
Sample Output 1:
2

Explanation of Sample Output 1:
We have 2 pairs which are probable answers (1, 2) with (2, 3) and (2, 3) with
(3, 4). The distance between both of them is equal to 2.

Sample Input 2 :
3
0 0
-3 -4
6 4
Sample Output 2 :
25

Explanation of Sample Output 1 :
If we choose the pairs (0, 0) and (-3, -4), the distance between them is
3^2 + 4^2 = 25. This is the optimal answer for this test case.
```

## Solution

```java
import java.util.*;

public class Solution
{
    public static long closestPair(point points[], int n)
    {
        Arrays.sort(points, (p1, p2) -> p1.x - p2.x);
        return helper(points, 0, n - 1);
    }
    /*
    * Time complexity  : O(nk^2logn)
    * Space complexity : O(klogn)
    */
    private static long helper(point[] points, int start, int end)
    {
        // base case: there are three or less points
        if(end - start <= 3)
        {
            return handleBaseCase(points, start, end);
        }
        int mid = (end - start) / 2 + start;
        // assume recursion can find the smallest distance on both sides
        long min = Math.min(helper(points, start, mid), helper(points, mid + 1, end));
        // find points closer to the vertical line and the min distance between them
        return Math.min(min, smallestDistanceInStrip(points, start, end, min));
    }
    /*
    * Time complexity  : O(k^2)
    * Space complexity : O(k)
    */
    private static long smallestDistanceInStrip(point[] points, int start, int end, long min)
    {
        int mid = (end - start) / 2 + start;
        // find all points closer to the mid point than min
        ArrayList<point> strip = new ArrayList<>();
        for(int i = start; i <= end; i++)
        {
            if(Math.abs(points[mid].x - points[i].x) < min)
            {
                strip.add(points[i]);
            }
        }
        for(int i = 0; i < strip.size(); i++)
        {
            for(int j = i + 1; j < strip.size(); j++)
            {
                min = Math.min(min, getDistance(strip.get(i), strip.get(j)));
            }
        }
        return min;
    }

    private static long handleBaseCase(point[] points, int start, int end)
    {
        long d1 = getDistance(points[start], points[end]);
        switch(end - start)
        {
            case 3:
            {
                long d2 = getDistance(points[start], points[start + 1]);
                long d3 = getDistance(points[start + 1], points[end]);
                return Math.min(d1, Math.min(d2, d3));
            }
            case 2: return d1;
            default: return Long.MAX_VALUE;
        }
    }

    private static long getDistance(point p1, point p2)
    {
        return (long) (Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }
}
```
