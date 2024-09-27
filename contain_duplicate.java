class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i < nums.length - 1; i++)
        {
            if(nums[i] == nums[i+1])
            {
                return true;
            }
        }
        return false;
    }

    /* First Try: Mostly working but Time Limit Exeeded 
    boolean returnvalue = false;
        for(int i =0; i < nums.length; i++)
        {
            for(int b=i+1; b< nums.length; b++)
            {
                if (nums[i] == nums[b])
                {
                    return true;
                }
                
            }
        }
        return false; */
        
}
