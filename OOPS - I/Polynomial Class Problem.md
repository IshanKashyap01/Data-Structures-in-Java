# Polynomial Class Problem

```Java
public class Polynomial 
{
    public DynamicArray array;
    
    public Polynomial()
    {
        array = new DynamicArray();
    }
    
    /* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
     *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
     *  is already present in the polynomial then previous coefficient is replaced by
     *  new coefficient value passed as function argument
    */
    public void setCoefficient(int degree, int coeff)
    {
        array.set(degree, coeff);
    }
    
    public int getDegree()
    {
        for(int i = array.size() - 1; i >= 0; i--)
        {
            if(array.get(i) != 0)
            {
                return i;
            }
        }
        return 0;
    }
    
    // Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
    public void print()
    {
        for(int i = 0; i < array.size(); i++)
        {
            if(array.get(i) != 0)
            {
                System.out.print(array.get(i) + "x" + i + " ");
            }
        }
    }

    
    // Adds two polynomials and returns a new polynomial which has result
    public Polynomial add(Polynomial p)
    {
        Polynomial result = new Polynomial();
        if(this.getDegree() > p.getDegree())
        {
            for(int i = 0; i <= this.getDegree(); i++)
            {
                result.setCoefficient(i, (this.array.get(i) + p.array.get(i)));
            }
        }
        else
        {
            for(int i = 0; i <= p.getDegree(); i++)
            {
                result.setCoefficient(i, (this.array.get(i) + p.array.get(i)));
            }
        }
        return result;
    }
    
    // Subtracts two polynomials and returns a new polynomial which has result
    public Polynomial subtract(Polynomial p)
    {
        Polynomial result = new Polynomial();
        if(this.getDegree() > p.getDegree())
        {
            for(int i = 0; i <= this.getDegree(); i++)
            {
                result.setCoefficient(i, (this.array.get(i) - p.array.get(i)));
            }
        }
        else
        {
            for(int i = 0; i <= p.getDegree(); i++)
            {
                result.setCoefficient(i, (this.array.get(i) - p.array.get(i)));
            }
        }
        return result;            
    }
    
    // Multiply two polynomials and returns a new polynomial which has result
    public Polynomial multiply(Polynomial p)
    {
        Polynomial result = new Polynomial();
        int nm = this.getDegree() + p.getDegree();
        int coeff = 0;
        for(int k = 0; k <= nm; k++)
        {
            coeff = 0;
            for(int l = 0; l <= k; l++)
            {
                coeff += this.array.get(l) * p.array.get(k - l);
            }
            result.setCoefficient(k, coeff);
        }
        return result;        
    }
    
    public class DynamicArray 
    {
        private int[] data;
        private int lastIndex;

        public DynamicArray()
        {
            data = new int[5];
            lastIndex = 0;
        }

        public int size()
        {
            return lastIndex;
        }

        public boolean isEmpty()
        {
            return lastIndex == 0;
        }

        public int get(int index)
        {
            if(index >= lastIndex)
            {
                return 0;
            }
            return data[index];
        }

        public void set(int index, int num)
        {
            while(index >= data.length)
            {
                doubleCapacity();
            }
            data[index] = num;
            if(index == lastIndex)
            {
                lastIndex++;
            }
            if(index > lastIndex)
            {
                lastIndex = index + 1;
            }
        }

        public void add(int num)
        {
            if(lastIndex == data.length)
            {
                doubleCapacity();
            }
            data[lastIndex] = num;
            lastIndex++;
        }

        private void doubleCapacity()
        {
            int[] temp = data;
            data = new int[2 * temp.length];
            for(int i = 0; i < temp.length; i++)
            {
                data[i] = temp[i];
            }
        }

        public int removeLast()
        {
            if(lastIndex == 0)
            {
                return -1;
            }
            int temp = data[lastIndex - 1];
            data[lastIndex - 1] = 0;
            lastIndex--;
            return temp;
        }
    }
}
```
