class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numberStack = new Stack<>();
        for(String str : tokens)
        {
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
            {
                int operand2 = numberStack.pop();
                int operand1 = numberStack.pop();
                if(str.equals("+"))
                {
                    numberStack.push(operand1 + operand2);
                }
                 if(str.equals("-"))
                {
                    numberStack.push(operand1 - operand2);
                }
                 if(str.equals("*"))
                {
                    numberStack.push(operand1 * operand2);
                }
                 if(str.equals("/"))
                {
                    numberStack.push(operand1 / operand2);
                }
            }
            else
            {
                numberStack.push(Integer.valueOf(str));
            }
        }
        return numberStack.peek();
    }
}
