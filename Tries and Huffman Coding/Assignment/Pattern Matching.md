# Pattern Matching

```Java
import java.util.ArrayList;

class TrieNode{

    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }

    public void add(char data)
    {
        int index = data - 'a';
        if(children[index] == null)
        {
            children[index] = new TrieNode(data);
        }
    }

    public TrieNode get(char data)
    {
        return children[data - 'a'];
    }
}


public class Trie {

    private TrieNode root;
    public int count;
    public Trie() {
        root = new TrieNode('\0');
    }

    public boolean search(String word){
        return search(root, word);
    }

    private boolean search(TrieNode root, String word) {
        if(word.length() == 0){
            return true;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            return false;
        }
        return search(child, word.substring(1));
    }

    /*
     * Time complexity  : O(n^3)
     * Space complexity : O(1)
     */
    public boolean patternMatching(ArrayList<String> vect, String pattern) 
    {
        for(String word : vect)
        {
            add(word);
        }
        return search(pattern);
    }

    /*
     * Time complexity  : O(n^2)
     * Space complexity : O(1)
     */
    public void add(String word)
    {
        while(!word.isEmpty())
        {
            addWord(word);
            word = word.substring(1);
        }
    }

    /*
     * Time complexity  : O(n)
     * Space complexity : O(1)
     */
    public void addWord(String word)
    {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++)
        {
            curr.add(word.charAt(i));
            curr = curr.get(word.charAt(i));
        }
        curr.isTerminating = true;
    }
}
```
