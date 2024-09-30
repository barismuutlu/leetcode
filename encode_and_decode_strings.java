public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        int howManyWords = strs.size();
        String returnString = "";
        for(int i=0; i < howManyWords; i++)
        {
            String aktuellword = strs.get(i);
            if (aktuellword.length() < 1)
            {
                aktuellword = "0null0";
            }
            if(howManyWords == 1)
            {
                return strs.get(0);
            }
            if(i != howManyWords - 1)
            {
                 returnString = returnString + aktuellword + "#a.a.a#";
            }
            if(i == howManyWords - 1)
            {
                 returnString = returnString + aktuellword;
            }
        }
        return returnString;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] parts = s.split("#a.a.a#");
        for(int i = 0; i< parts.length; i++)
        {
            if(parts[i].equals("0null0"))
            {
                parts[i] = "";
            }
        }
        return Arrays.asList(parts);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
