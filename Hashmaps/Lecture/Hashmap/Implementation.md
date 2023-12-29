# HashMap Implementation

HashMap class:

```Java
import java.util.*;

public class HashMap<K, V>
{
    private ArrayList<MapNode<K, V>> bucket;
    private int size;
    private int bucketSize;
    private static final int DEFAULT_BUCKET_CAPACITY = 20;
    private static final double LOAD_FACTOR = 0.75;

    public HashMap()
    {
        this.bucket = getBucket(DEFAULT_BUCKET_CAPACITY);
        bucketSize = DEFAULT_BUCKET_CAPACITY;
    }

    private static final <K, V> ArrayList<MapNode<K, V>> getBucket(int capacity)
    {
        ArrayList<MapNode<K, V>> bucket = new ArrayList<>(capacity);
        // Fill the bucket with empty mapnodes upto capacity
        for(int i = 0; i < capacity; i++)
        {
            bucket.add(new MapNode<>());
        }
        return bucket;
    }
    
    private int getBucketIndex(K key)
    {
        return key.hashCode() % bucketSize;
    }

    public void put(K key, V value)
    {
        int index = getBucketIndex(key);
        bucket.get(index).add(key, value);
        size++;
        if((double) size / bucketSize > LOAD_FACTOR)
        {
            rehash();
        }
    }

    public V get(K key)
    {
        int index = getBucketIndex(key);
        MapNode<K, V> node = bucket.get(index);
        return node.get(key).value;
    }

    public void remove(K key)
    {
        int index = getBucketIndex(key);
        bucket.get(index).remove(key);
        size--;
    }

    public boolean containsKey(K key)
    {
        int index = getBucketIndex(key);
        return bucket.get(index).contains(key);
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    private static <K> int getBucketIndex(K key, int bucketSize)
    {
        return key.hashCode() % bucketSize;
    }

    private void rehash()
    {
        int newCapacity = 2 * this.bucketSize;
        ArrayList<MapNode<K, V>> newBucket = getBucket(newCapacity);
        // For each entry in the bucket
        for(MapNode<K, V> list : bucket)
        {
            // Add all pairs to the new bucket
            for(Node<K, V> pair : list.pairs)
            {
                int index = getBucketIndex(pair.key, newCapacity);
                newBucket.get(index).add(pair.key, pair.value);
            }
        }
        this.bucket = newBucket;
        this.bucketSize = newCapacity;
    }
}
```

MapNode class:

```Java
class MapNode<K, V>
{
    List<Node<K, V>> pairs;

    public MapNode()
    {
        pairs = new ArrayList<>();
    }

    public void add(K key, V value)
    {
        if(contains(key))
        {
            get(key).value = value;
        }
        else
        {
            Node<K, V> node = new Node<>(key, value);
            pairs.add(node);
        }
    }

    public void remove(K key)
    {
        pairs.remove(get(key));
    }

    public boolean contains(K key)
    {
        for(Node<K, V> node : pairs)
        {
            if(node.key.equals(key))
            {
                return true;
            }
        }
        return false;
    }

    public Node<K, V> get(K key)
    {
        for(Node<K, V> node : pairs)
        {
            if(node.key.equals(key))
            {
                return node;
            }
        }
        return null;
    }
}
```

Node class:

```Java
class Node<K, V>
{
    K key;
    V value;

    public Node(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
}
```
