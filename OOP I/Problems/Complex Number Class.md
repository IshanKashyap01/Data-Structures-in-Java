# Complex Number Class

## Problem Statement

A ComplexNumber class contains two data members: one is the real part (R) and
the other is imaginary (I) (both integers).

Implement the Complex numbers class that contains following functions:

### Constructor

You need to create the appropriate constructor.

### Plus

This function adds two given complex numbers and updates the first complex
number ex:

if $C_1 = 4 + i5$ and $C_2 = 3 +i1$

`C1.plus(C2)` results in:

$C_1 = 7 + i6$ and $C_2 = 3 + i1$

### Multiply

This function multiplies two given complex numbers and updates the first complex number.

e.g.

if $C_1 = 4 + i5$ and $C_2 = 1 + i2$

C1.multiply(C2) results in:

$C_1 = -6 + i13$ and $C_2 = 1 + i2$

### Print

This function prints the given complex number in the following format: $a + ib$

**Note**: There is space before and after `+` (plus sign) and no space between
`i` (iota symbol) and b.

## Detailed Explanation

### Input Format

Two integers - real and imaginary part of 1st complex number

Two integers - real and imaginary part of 2nd complex number

An integer representing choice (1 or 2) (1 represents plus function will be
called and 2 represents multiply function will be called)

### Output format

Check details of `print` function given above.

```ltf
Sample Input 1:
4 5
6 7
1
Sample Output 1:
10 + i12
Sample Input 2:
4 5
6 7
2
Sample Output 2:
-11 + i58
```

## Solution

```java
/******************
 * Following is the main function we are using internally.
 * Refer this for completing the ComplexNumbers class
 * 
 
 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int real1 = s.nextInt();
        int imaginary1 = s.nextInt();

        int real2 = s.nextInt();
        int imaginary2 = s.nextInt();

        ComplexNumbers c1 = new ComplexNumbers(real1, imaginary1);
        ComplexNumbers c2 = new ComplexNumbers(real2, imaginary2);

        int choice = s.nextInt();
         
        if(choice == 1) {
            // Add
            c1.plus(c2);
            c1.print();
        }
        else if(choice == 2) {
            // Multiply
            c1.multiply(c2);
            c1.print();
        }
        else {
            return;
        }
    }
 ******************/

public class ComplexNumbers 
{
    private int real;
    private int imaginary;

    public ComplexNumbers(int real, int imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }

    public int getReal()
    {
        return this.real;
    }
        
    public int getImaginary()
    {
        return this.imaginary;
    }

    public void plus(ComplexNumbers cNum)
    {
        this.real += cNum.real;
        this.imaginary += cNum.imaginary;
    }

    public void multiply(ComplexNumbers cNum)
    {
        // (r1 + im1) * (r2 + im2) = r1r2 + ir1m2 + ir2m1 - m1m2
        // = (r1r2 - m1m2) + i(r1m2 + r2m1)
        int real = this.real * cNum.real - this.imaginary * cNum.imaginary;
        int imaginary = this.real * cNum.imaginary + cNum.real * this.imaginary;

        this.real = real;
        this.imaginary = imaginary;
    }

    public void print()
    {
        String num = "" + this.real;
        num += this.imaginary < 0 ? " - " : " + ";
        num += "i" + this.imaginary;

        System.out.println(num);
    }
}
```
