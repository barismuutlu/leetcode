import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> newStack = new Stack<>();
        char[] charVersion = s.toCharArray();
        for(int i=0; i< s.length(); i++)
        {   
            if(charVersion[i] == '(' || charVersion[i] == '{' || charVersion[i] == '[')
            {
                newStack.push(charVersion[i]);
            }
            if(charVersion[i] == ')' || charVersion[i] == '}' || charVersion[i] == ']')
            {
                if(newStack.empty())
                {
                    return false;
                }
                char lastThing = newStack.pop();
                if((lastThing == '(' && charVersion[i] != ')') || (lastThing == '[' && charVersion[i] != ']') || (lastThing == '{' && charVersion[i] != '}')) 
                {
                    return false;
                }
            }
        }
        if(!(newStack.isEmpty()))
        {
            return false;
        }
        return true;
    }
}
