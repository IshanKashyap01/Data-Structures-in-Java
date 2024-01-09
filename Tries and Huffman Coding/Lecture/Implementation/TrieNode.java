/*
 * A crude and dumb node that serves as an abstraction for data storage in a Trie
 */
class TrieNode
{
    private char data;
    private boolean isTerminal;
    private TrieNode[] children;
    private int childCount;

    TrieNode()
    {
        children = new TrieNode[256];
    }

    TrieNode(char data)
    {
        children = new TrieNode[256];
        this.data = data;
    }

    TrieNode(char data, boolean isTerminal)
    {
        this.data = data;
        this.isTerminal = isTerminal;
    }

    void add(char child)
    {
        if(children[child] == null)
        {
            children[child] = new TrieNode(child);
            childCount++;
        }
    }

    TrieNode get(char child)
    {
        return children[child];
    }

    boolean isTerminal()
    {
        return isTerminal;
    }

    char data()
    {
        return data;
    }

    TrieNode[] children()
    {
        return children;
    }

    void removeChild(char child)
    {
        if(get(child) != null)
        {
            children[child] = null;
            childCount--;
        }
    }

    void setTerminal(boolean isTerminal)
    {
        this.isTerminal = isTerminal;
    }

    boolean hasChildren()
    {
        return childCount != 0;
    }

    boolean hasChild(char child)
    {
        return children[child] != null;
    }

    int childCount()
    {
        return childCount;
    }
}