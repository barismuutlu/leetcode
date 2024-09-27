import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] frequenz = new char[27];
        for(char c: s.toCharArray())
        {
            frequenz[c % 26]++;
        }
        for(char c: t.toCharArray())
        {
            frequenz[c % 26]--;
        }
        for(int i : frequenz)
        {
            if(i != 0)
            {
                return false;
            }
        }
        return true;
    }
   
    /* METOT2 - with HashMap

     public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
        {
            return false;
        }
        Map<Character, Integer> map1 = letterCounter(s);
        Map<Character, Integer> map2 = letterCounter(t);
        if(map1.equals(map2))
        {
            return true;
        }
        return false;
    }

    public static Map<Character, Integer> letterCounter(String str)
    {
        Map<Character, Integer> newMap = new HashMap<>();
        for (char c : str.toCharArray())
        {
            newMap.put(c, newMap.getOrDefault(c, 0) + 1);
        }
        return newMap;
    }

    */
}
