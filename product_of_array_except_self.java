class Solution {
    public int[] productExceptSelf(int[] nums) {
            int prefix = 1;
            int suffix = 1;
            int[] resultArray = new int[nums.length];
            for(int i=0; i< nums.length; i++)
            {
                if(i != 0){prefix = prefix * nums[i - 1];}
                 resultArray[i] = prefix;
            }
            for(int i=nums.length -1; i >= 0; i--)
            {
                if(i != nums.length -1){suffix = suffix * nums[i + 1];}
                resultArray[i] = resultArray[i] * suffix;
            }
            return resultArray;
    }
}
