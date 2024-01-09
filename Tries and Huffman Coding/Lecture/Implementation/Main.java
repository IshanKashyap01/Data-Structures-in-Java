public class Main 
{
    private static final String FAIL_STRING = "FAILED at ";
    private static String[] words = 
    {
        "Longing", "Rusted", "Seventeen", "Daybreak", "Furnace", "Nine",
        "Benign", "Homecoming", "One", "Freight Car", "Cars"
    };
    private static String[] substrings = 
    {
        "L", "Sev", "Da", "Furnac", "Car",
        "Molto", "Bene", "A", "Presto", "Ezio"
    };

    public static void main(String[] args) 
    {
        try
        {
            testTrie(words, substrings);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void testTrie(String[] words, String[] substrings)
    {
        Trie dict = new Trie();
        dict.addAll(words);

        System.out.print("Testing for words: ");
        testWords(dict, words);


        System.out.print("\nTesting for substrings: ");
        testStrings(dict, substrings);
    }

    public static void testWords(Trie dict, String[] words)
    {
        for(String word : words)
        {
            if(!dict.contains(word))
            {
                System.out.println(FAIL_STRING + word);
                return;
            }
        }
        System.out.println("PASSED");
    }

    public static void testStrings(Trie dict, String[] strings)
    {
        for(int i = 0; i < strings.length / 2; i++)
        {
            if(!dict.containsString(strings[i]))
            {
                System.out.println(FAIL_STRING + strings[i]);
                return;
            }
        }
        for(int i = strings.length / 2; i < strings.length; i++)
        {
            if(dict.containsString(strings[i]))
            {
                System.out.println(FAIL_STRING + strings[i]);
                return;
            }
        }
        System.out.println("PASSED");
    }
}
