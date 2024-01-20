# Player

```Java
public class Player
{
    private String name;
    private char symbol;

    public Player()
    {

    }

    public Player(String name, char symbol)
    {
        setName(name);
        setSymbol(symbol);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        if(name.isEmpty())
        {
            throw new NullPointerException();
        }
        this.name = name;
    }

    public char getSymbol()
    {
        return symbol;
    }

    public void setSymbol(char symbol)
    {
        if(symbol == '\0')
        {
            throw new NullPointerException();
        }
        this.symbol = symbol;
    }
}
```
