# Auto Complete

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
}

public class Trie {
    private TrieNode root;
    public int count;
    public Trie() {
        root = new TrieNode('\0');
    }

    private void add(TrieNode root, String word){
        if(word.length() == 0){
            root.isTerminating = true;
            return;
        }        
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        add(child, word.substring(1));
    }

    public void add(String word){
        add(root, word);
    }
    
    
    public void autoComplete(ArrayList<String> input, String word) 
    {
        Trie trie = new Trie();
        for(String str : input)
        {
            trie.add(str);
        }
        TrieNode node = findWord(trie.root, word);
        if(node != null)
        {
            findAllPossibleWords(node, word, "");
        }
    }

    private TrieNode findWord(TrieNode root, String word)
    {
        if(word.length() == 0)
        {
            return null;
        }
        int index = word.charAt(0) - 'a';
        if(root.children[index] == null)
        {
            return null;
        }
        if(word.length() == 1)
        {
            return root.children[index];
        }
        return findWord(root.children[index], word.substring(1));
    }

    private void findAllPossibleWords(TrieNode root, String word, String output)
    {
        if(root.isTerminating)
        {
            System.out.println(word + output);
        }
        for(TrieNode child : root.children)
        {
            if(child != null)
            {
                findAllPossibleWords(child, word, output + child.data);
            }            
        }        
    }
}
```
