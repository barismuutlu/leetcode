import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        List<Integer> counter = new ArrayList<>();
        int spesificCounter = 0;
        for(int i=0; i < nums.length; i++)
        {
            if(i != 0)
            {
               if(nums[i - 1] == nums[i])
               {
                    continue;
               } 
               if(nums[i - 1] + 1 == nums[i])
               {
                    spesificCounter++;
               }
               else
               {
                    counter.add(spesificCounter);
                    spesificCounter = 1;
               }
            }
            else
            {
                spesificCounter = 1;
            }
        }
        counter.add(spesificCounter);
        Collections.sort(counter);
        return counter.get(counter.size() - 1);
    }
}
