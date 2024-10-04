class Solution {
    public int trap(int[] height) {
        int low = 0;
        int high = height.length -1;
        int leftMax =0;
        int rightMax = 0;
        int returnValue =0;
        while(low < high)
        {
            if(height[low]<height[high])
            {
                leftMax =  Math.max(height[low], leftMax);
                returnValue +=  leftMax - height[low];
                low++; 
            }
            else
            {
                rightMax =  Math.max(height[high], rightMax);
                returnValue +=  rightMax - height[high];
                high--;
            }

        }
        return returnValue;
        }
    }


/*First Try: Time Limit Exceeded ->

class Solution {
    public int trap(int[] height) {
        int returnValue = 0;
        for(int i=0; i< height.length; i++)
        {
            int leftMax = 0;
            int rightMax = 0;
            for(int j = i; j >=0; j--)
            {
                leftMax = Math.max(leftMax, height[j]);
            }
            for(int j=i; j < height.length; j++)
            {
                rightMax = Math.max(rightMax, height[j]);
            }
            returnValue += Math.min(rightMax, leftMax) - height[i] ;
        }
        return returnValue;
    }
}

*/

