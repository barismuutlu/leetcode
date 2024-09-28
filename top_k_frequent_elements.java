import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> newMap = new HashMap<>();
        for(int i: nums)
        {
            newMap.put(i, newMap.getOrDefault(i, 0) + 1);             
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(newMap.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        int[] returnValue = new int[k];
        for(int i=0; i < k; i++)
        {
            returnValue[i] = entryList.get(entryList.size() - i - 1).getKey();
        }
        return returnValue;
    }
}
