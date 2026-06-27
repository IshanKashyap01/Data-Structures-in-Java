# Polynomial Class

## Problem Statement

Implement a polynomial class, that contains following functions:

### `setCoefficient()`

This function sets coefficient for a particular degree value. If term with
given degree is not there in the polynomial, then corresponding term (with
specified degree and value) is added. If the term is already present in the
polynomial, then previous coefficient value is replaced by given coefficient
value.

### `add()`

Adds two polynomials and returns a new polynomial which has the result.

### `subtract()`

Subtracts two polynomials and returns a new polynomial which has the result.

### `multiply()`

Multiplies two polynomials and returns a new polynomial which has the result.

### `print()`

Prints all the terms (only terms with non zero coefficients are to be printed)
in increasing order of degree.

Print pattern for a single term: `x`

Multiple terms should be printed separated by space. For more clarity, refer
sample test cases.

**Note**: Only keep those terms which have non - zero coefficients.

## Detailed Explanation

### Input Format

The first line of input contains count of the number of coefficients in
polynomial 1(C1)

The next line of input has C1 degrees for polynomial 1.

The next line of input has C1 coefficients for polynomial 1.  

The next line of input contains count of the number of coefficients in
polynomial 2(C2)

The next line of input has C2 degrees for polynomial 2.

The next line of input has C2 coefficients for polynomial 2.  

The next line of input has the choice for the function you want to implement.

### Output Format

The output will be printed in case of print function same as that of print
function format.

```ltf
Sample Input 1:
P1: 1x2 2x3 4x6 
P2: 3x4 1x2
Sample Output 1:
P1 + P2 = 2x2 2x3 3x4 4x6
Sample Input 2:
P1: 1x2 2x3 4x6 
P2: 3x4 1x2
Sample Output 2:
P1 - P2 = 2x3 -3x4 4x6
```

## Solution

```java
public class Polynomial 
{
    private DynamicArray arr;
    private int degree;

    public Polynomial()
    {
        this.arr = new DynamicArray();
        this.degree = 0;
    }

    public void setCoefficient(int degree, int coeff)
    {
        if(degree >= this.arr.size())
        {
            while(degree > this.arr.size())
            {
                this.arr.add(0);
            }
            this.arr.add(coeff);
            if(coeff != 0)
            {
                this.degree = degree;
            }
        }
        else
        {
            this.arr.set(degree, coeff);
        }
    }

    public Polynomial add(Polynomial p)
    {
        Polynomial result = new Polynomial();
        Polynomial smaller = this.getDegree() < p.getDegree() ? this : p;
        Polynomial larger = smaller == p ? this : p;
        int i = 0, j = 0, k = 0;
        while(i <= smaller.getDegree())
        {
            result.setCoefficient(k++, smaller.get(i++) + larger.get(j++));
        }
        while(j <= larger.getDegree())
        {
            result.setCoefficient(k++, larger.get(j++));
        }
        return result;
    }

    public Polynomial subtract(Polynomial p)
    {
        Polynomial result = new Polynomial();
        int i = 0, j = 0, k = 0;
        while(i <= this.getDegree() && j <= p.getDegree())
        {
            result.setCoefficient(k++, this.get(i++) - p.get(j++));
        }
        while(i <= this.getDegree())
        {
            result.setCoefficient(k++, this.get(i++));
        }
        while(j <= p.getDegree())
        {
            result.setCoefficient(k++, -1 * p.get(j++));
        }
        return result;
    }

    public Polynomial multiply(Polynomial p)
    {
        Polynomial result = new Polynomial();
        int degree = this.getDegree() + p.getDegree();
        int coeff = 0;
        for(int i = 0; i <= degree; i++)
        {
            coeff = 0;
            for(int j = 0; j <= i; j++)
            {
                coeff += this.get(j) * p.get(i - j);
            }
            result.setCoefficient(i, coeff);
        }
        return result;
    }

    public void print()
    {
        for(int i = 0; i <= this.getDegree(); i++)
        {
            if(this.get(i) != 0)
            {
                System.out.print(this.get(i) + "x" + i + " ");
            }
        }
    }

    private int get(int degree)
    {
        return this.arr.get(degree);
    }

    private int getDegree()
    {
        return this.degree;
    }
}

class DynamicArray
{
    private int[] arr;
    private int size;
    private int capacity;

    public DynamicArray()
    {
        this.capacity = 10;
        this.size = 0;
        this.arr = new int[capacity];
    }

    public int get(int index)
    {
        if(index >= size)
        {
            return 0;
        }
        return arr[index];
    }

    public void set(int index, int num)
    {
        if(index < size)
        {
            arr[index] = num;
        }
    }

    public void add(int num)
    {
        if(this.size == this.capacity)
        {
            expandArray();
        }
        arr[size++] = num;
    }

    public int size()
    {
        return this.size;
    }

    private void expandArray()
    {
        int[] arr = new int[2 * this.capacity];
        for(int i = 0; i < this.size; i++)
        {
            arr[i] = this.arr[i];
        }
        this.arr = arr;
        this.capacity *= 2;
    }
}
```
