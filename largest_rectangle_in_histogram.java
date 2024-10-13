class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int n=  heights.length;
        int maxArea = 0;
        for(int i=0; i<n; i++)
        {
            while(stack.peek() != -1 && heights[i] < heights[stack.peek()])
            {
                int currentHeight = heights[stack.pop()];
                int currenWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currenWidth);
            }
            stack.push(i);
        } 
        while(stack.peek() != -1)
        {
                int currentHeight = heights[stack.pop()];
                int currenWidth = n - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currenWidth);
        }

        return maxArea;
    }
    /*Kendimize not nasıl yaptığımızı anlamak için:

    Açıklaması çok uzun bu sorunun ama tutorial'ı çok güzel 
    İzlemeni tavsiye ederim gelecekteki Baris Mutlu :) */
}
