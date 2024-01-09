# Search Words

```Java
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

    public boolean search(String word){
        return search(root, word, 0);
    }

    /*
     * Time complexity  : O(n)
     * Space complexity : O(n)
     */
    private boolean search(TrieNode root, String word, int index) 
    {
        // special case
        if(index == word.length())
        {
            return true;
        }
        //base cases
        if(root.children[word.charAt(index) - 'a'] == null)
        {
            return false;
        }
        if(index == word.length() - 1)
        {
            return root.children[word.charAt(index) - 'a'].isTerminating;
        }
        // recursion
        return search(root.children[word.charAt(index) - 'a'], word, index + 1);
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
}
```
