class Solution {
    public int getValue(char s) {
    switch (s) {
        case 'I':
            return 1;
        case 'V':
            return 5;
        case 'X':
            return 10;
        case 'L':
            return 50;
        case 'C':
            return 100;
        case 'D':
            return 500;
        case 'M':
            return 1000;
        default:
            throw new IllegalArgumentException("Invalid Roman numeral character: " + s);
    }
}
    public int romanToInt(String s) {
        char[] charRoman = s.toCharArray();
        int total =0;
        for (int i =0; i<charRoman.length -1; i++)
        {
            if(getValue(charRoman[i]) >= getValue(charRoman[i + 1]))
            {
               total += getValue(charRoman[i]); 
            }
            else
            {
                total -= getValue(charRoman[i]); 

            }

        }
         total += getValue(charRoman[charRoman.length -1]); 
 
        return total;
    }
}
