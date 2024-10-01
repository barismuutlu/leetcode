import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> uniqueTriples = new HashSet<>();
        Arrays.sort(nums);
        for (int mainIndex = 0; mainIndex < nums.length - 2; mainIndex++) {
            int low = mainIndex + 1;
            int high = nums.length - 1;
            
            // Duplicates bypass
            if (mainIndex > 0 && nums[mainIndex] == nums[mainIndex - 1]) continue;

            while (low < high) {
                int sum = nums[mainIndex] + nums[low] + nums[high];

                if (sum == 0) {
                    List<Integer> triplet = Arrays.asList(nums[mainIndex], nums[low], nums[high]);
                    //The Favorite Line in the Code :
                    uniqueTriples.add(triplet);

                    // Duplicates bypass
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;

                    low++;
                    high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        result.addAll(uniqueTriples);
        return result;
    }
}
