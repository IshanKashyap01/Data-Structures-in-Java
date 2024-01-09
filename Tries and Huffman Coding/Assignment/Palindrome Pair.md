# Palindrome Pair

```Java
import java.util.*;
class TrieNode
{
    char data;
    boolean isEnding;
    boolean isRestPalindrome;
    TrieNode children[];
    int childCount;

    public TrieNode(char data)
    {
        this.data = data;
        children = new TrieNode[26];
    }
}

public class Trie 
{
    private TrieNode root;
    public int count;

    public Trie() 
    {
        root = new TrieNode('\0');
    }

    private void add(TrieNode root, String word)
    {
        if(word.length() == 0)
        {
            root.isEnding = true;
            return;
        }
        if(isPalindrome(word.substring(1)))
        {
            root.isRestPalindrome = true;
        }                            
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        if(child == null)
        {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        add(child, word.substring(1));
    }

    public void add(String word)
    {
        add(root, reverse(word));
    }

    private boolean search(TrieNode root, String word) 
    {
        if(word.length() == 0) {
            return root.isEnding;
        }

        int childIndex=word.charAt(0) - 'a';
        TrieNode child=root.children[childIndex];

        if(child == null) {
            return false;
        }

        return search(child,word.substring(1));

    }

    public boolean search(String word) 
    {
        return search(root,word);
    }

    private void print(TrieNode root, String word)
    {
        if (root == null) {
            return;
        }
        
        if (root.isEnding) {
            System.out.println(word);
        }
        
        for (TrieNode child : root.children) {
            if (child == null) {
                continue;
            }
            String fwd = word + child.data;
            print(child, fwd);
        }
    }
    
    public void print() 
    {
        print(this.root, "");
    }

    public static boolean isPalindrome(String s)
    {
        for(int i = 0, j = s.length() - 1; i < j; i++, j--)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return false;
            }
        }
        return true;
    }

    public static String reverse(String s)
    {
        StringBuilder builder = new StringBuilder();
        for(int i = s.length() - 1; i > -1; i--)
        {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    /*..................... Palindrome Pair................... */

    public boolean isPalindromePair(ArrayList<String> words)
    {
        for(String word : words)
        {
            add(word);
        }
        for(String word : words)
        {
            if(match(root, word, 0))
            {
                return true;
            }
        }
        return false;
    }

    private boolean match(TrieNode root, String word, int index)
    {
        if(index == word.length())
        {
            return root.isRestPalindrome || root.isEnding;
        }
        if(root.isEnding && isPalindrome(word.substring(index)))
        {
            return true;
        }        
        int childIndex = word.charAt(index) - 'a';
        if(root.children[childIndex] == null)
        {
            return false;
        }
        return match(root.children[childIndex], word, index + 1);
    }
} 
```
