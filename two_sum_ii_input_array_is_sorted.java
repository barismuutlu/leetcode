class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while(high > low)
        {
            if(numbers[high] + numbers[low] == target)
            {
                int[] returnArray = {low+1, high+1};
                return returnArray;
            }
            else if(numbers[high] + numbers[low] > target)
            {
                high--;
            }
            else if(numbers[high] + numbers[low] < target)
            {
                low++;
            }
        }
        int[] returnArray = {30, 30};
        return returnArray;

    }
}
