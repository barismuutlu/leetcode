import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] returnArray = new int[2];
        Map<Integer, Integer> newMap = new HashMap<>();
        for(int i =0; i< nums.length; i++)
        {
            newMap.put(nums[i], i);   
        }
        for(int i =0; i< nums.length; i++)
        {
            if(newMap.containsKey(target - nums[i]) && newMap.get(target - nums[i]) != i)
            {
                
                returnArray[0] = i;
                returnArray[1] = newMap.get(target - nums[i]);
                
            }
   
        }
        return returnArray;
    }
}
