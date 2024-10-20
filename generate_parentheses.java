class Solution {
    private void backtracking(List<String> answer, StringBuilder aktuellstring, int leftCount, int rightCount, int n)
    {
        if(aktuellstring.length() == n*2)
        {
            answer.add(aktuellstring.toString());
            return;
        }
        if(leftCount < n){
            aktuellstring.append("(");
            backtracking(answer, aktuellstring, leftCount + 1, rightCount, n);
            aktuellstring.deleteCharAt(aktuellstring.length() - 1);
        }
        if(leftCount > rightCount)
        {
            aktuellstring.append(")");
            backtracking(answer, aktuellstring, leftCount, rightCount + 1, n);
            aktuellstring.deleteCharAt(aktuellstring.length() - 1);
        }

    }
    public List<String> generateParenthesis(int n) {
         List<String> answer = new ArrayList<>();
        backtracking(answer, new StringBuilder(), 0, 0, n);

        return answer;
    }
}
