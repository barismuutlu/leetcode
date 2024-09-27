import java.util.HashMap;
import java.util.Map;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String, List<String>> newMap = new HashMap<>();
       for(String words : strs)
       {
            char[] charString = words.toCharArray();
            Arrays.sort(charString);
            if(!(newMap.containsKey(new String(charString))))
            {
                newMap.put(new String(charString), new ArrayList<>());
            }
            newMap.get(new String(charString)).add(words);
       }
      return new ArrayList<>(newMap.values());
    }
    /* It is working like that:
    1-Input strings one by one in a foreach loop 
    2-Sorting words to see if they are anagrams
    eat- tea- ate => aet=aet=aet
    3-We make the sorted version the index of the HashMap, create a list accordingly and add the anagrams
    Example input and HashMap state
    Input: eat, tea, ate, bca, cab, feg, gef
    HashMap 
    aet: food, tea, food
    abc: bca, cab
    efg: feg, gef
    4.Then with newMap.values() we get only the ArrayList<> from the HashMap and return.

    Söyle calisiyor:
    1-Inputtaki stringleri tek tek foreach dongusune alıyor(satir 6)
    2-Kelimmeleri sortlayarak Anagram olup olmadiklarini anliyor yani
    eat- tea- ate => aet=aet=aet
    3-Sortlanmis halini HashMap'in Indexi yapip ona gore list olusturup anagramlarini ekliyoruz
    Ornek input ve HashMap hali
    Input: eat, tea, ate, bca, cab, feg, gef
    HashMap: 
    aet: eat, tea, ate
    abc: bca, cab
    efg: feg, gef
    4.Daha sonra newMap.values() ile sadece ArrayList<>'leri aliyoruz HashMap'tan ve return ediyoruz. Sortlanmis Index Stringler kaliyor
}

/* First Try: Very slow way (2664 ms)
 public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> returnList = new ArrayList<List<String>>();
        for(int i = 0; i < strs.length; i++)
        {
                 if(strs[i] == null)
                {

                }
                else
                {
              
            List<String> subList = new ArrayList<String>();
            subList.add(strs[i]);
            for(int a = i + 1; a <= strs.length - 1; a++)
            {
                    if(isTwoAnagram(strs[i], strs[a]))
                    {
                        subList.add(strs[a]);
                        strs[a] = null;        
                    }
               
            }
             returnList.add(subList);
            }
        }
        return returnList;
    }    

boolean isTwoAnagram(String str1, String str2)
    {
        if (str1 == null || str2 == null || str1.length() != str2.length())
        {
            return false;
        }
        Map<Character, Integer> newMap1 = new HashMap<>();
        Map<Character, Integer> newMap2 = new HashMap<>();
        for(char c: str1.toCharArray())
        {
            newMap1.put(c, newMap1.getOrDefault(c, 0) + 1);
        }
        for(char c: str2.toCharArray())
        {
            newMap2.put(c, newMap2.getOrDefault(c, 0) + 1);
        }
        if(newMap1.equals(newMap2))
        {
            return true;

        }
        return false;
        
    }

    */
