# Complex Number Problem

```Java
public class ComplexNumbers 
{
    private int real;
    private int img;

    public ComplexNumbers(int real, int img)        
    {
        this.real = real;
        this.img = img;
    }

    public void plus(ComplexNumbers number)
    {
        this.real += number.real;
        this.img += number.img;
    }

    /* (a + ib) * (c + id) = ac + iad + ibc - bd
     * = (ac - bd) + i(ad + bc)
     */
    public void multiply(ComplexNumbers number)
    {
        int r = real * number.real - img * number.img;
        int i = real * number.img + img * number.real;

        this.real = r;
        this.img = i;
    }

    public void print()
    {
        char sign = img > 0 ? '+' : '-';
        System.out.println(real + " "+sign+" i" + img);
    }
}
```
