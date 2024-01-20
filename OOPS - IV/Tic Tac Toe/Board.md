# Board

```Java
public class Board 
{
    private char[][] matrix;    
    private int size;

    public Board(int size)
    {
        createBoard(size);
    }

    public void createBoard(int size)
    {
        if(size == 0)
        {
            throw new NullPointerException("invalid board size: 0");
        }
        matrix = new char[size][size];
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty(int i, int j)
    {
        return get(i, j) == '\0';
    }

    public char get(int i, int j)
    {
        return matrix[i][j];
    }

    public void set(char value, int i, int j)
    {
        if(value == '\0')
        {
            throw new NullPointerException("null value in board");
        }
        matrix[i][j] = value;
    }
}
```
