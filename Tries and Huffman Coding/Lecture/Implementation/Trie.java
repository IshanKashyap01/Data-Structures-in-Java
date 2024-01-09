import java.util.Collection;
/*
 * A very simple trie implementation that just stores words
 */
public class Trie implements Tries
{
    private TrieNode root;
    private int size;

    public Trie()
    {
        root = new TrieNode('\0');
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public void add(String word)
    {
        if(word != null && word.length() > 0)
        {
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++)
            {
                curr.add(word.charAt(i));
                curr = curr.get(word.charAt(i));
            }
            curr.setTerminal(true);
            size++;
        }
    }

    @Override
    public void remove(String word)
    {
        remove(root, word, 0);
        size--;
    }

    /*
     * Removes the word from trie if there are no terminal nodes
     */
    private void remove(TrieNode root, String word, int index)
    {
        if(index == word.length())
        {
            root.setTerminal(false);
        }
        else
        {
            if(root.hasChild(word.charAt(index)))
            {
                TrieNode child = root.get(word.charAt(index));
                remove(child, word, index + 1);
                if(!child.isTerminal() && !child.hasChildren())
                {
                    root.removeChild(child.data());
                }
            }
        }
    }

    @Override
    public boolean contains(String word)
    {
       TrieNode last = lastTrieNode(word);
       return last != null && last.isTerminal();
    }

    /*
     * Only different from contains() in the sense it doesn't care
     * if the last element is a terminal node or not
     * Not equivalent for pattern matching
     */
    public boolean containsString(String string)
    {
        return lastTrieNode(string) != null;
    }

    @Override
    public void addAll(String[] words)
    {
        for(String word : words)
        {
            add(word);
        }
    }

    @Override
    public void addAll(Collection<String> collection)
    {
        for(String word : collection)
        {
            add(word);
        }
    }

    private TrieNode lastTrieNode(String word)
    {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++)
        {
            if(!curr.hasChild(word.charAt(i)))
            {
                return null;
            }
            curr = curr.get(word.charAt(i));
        }
        return curr;
    }
}