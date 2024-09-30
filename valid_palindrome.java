class Solution {
    public boolean isPalindrome(String s) {
        int a = s.length();
        char[] charArray = s.toCharArray();

        for(int i = 0; i < s.length() ; i++)
        {
            if(i > a)
            {
                break;
            }
            if(!(Character.isLetter(charArray[i])) && !(Character.isDigit(charArray[i])))
            {
                continue;
            }
            while(!(Character.isLetter(charArray[a-1])) && !(Character.isDigit(charArray[a-1])))
            {
                a--;
            }
            if(Character.toLowerCase(charArray[i]) != Character.toLowerCase(charArray[a - 1]))
            {
                System.out.println(charArray[a-1]);

                return false;
            }
            a--;
        }
        return true;
    }
}
