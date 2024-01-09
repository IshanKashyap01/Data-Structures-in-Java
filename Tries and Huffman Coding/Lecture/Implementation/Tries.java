import java.util.Collection;

public interface Tries 
{
    boolean isEmpty();

    int size();

    void add(String word);

    void addAll(String[] words);

    void addAll(Collection<String> words);

    boolean contains(String word);
    
    void remove(String word);
}
