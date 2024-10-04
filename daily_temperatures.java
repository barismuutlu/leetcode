class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Stack<Integer> indexOfWarmerDays = new Stack<>();
        for(int i = 0; i<temperatures.length; i++)
        {
            
                while(!(indexOfWarmerDays.empty()) && temperatures[i] > temperatures[indexOfWarmerDays.peek()])
                {
                    int lstday = indexOfWarmerDays.pop();
                    results[lstday] = i - lstday;
                }
            indexOfWarmerDays.push(i);
            
        }
        return results;
    }
}
/* First Try: Working but kind of slow 282 ms :(

    class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        for(int j = temperatures.length -1; j >= 0; j--)
        {
            if(j == temperatures.length - 1)
            {
                days[j] = 0;
            }
            else
            {
               if(temperatures[j] == temperatures[j+1])
               {
                    if(days[j + 1] == 0)
                    {
                        days[j] = 0;
                    }
                    else{
                    days[j] = days[j + 1] + 1;
                    }
                    continue;
               }
                for(int i = j; i<temperatures.length; i++)
                {
                    if(temperatures[i] > temperatures[j])
                    {
                        days[j] = i - j;
                        break;
                    }
                }
            }
        }
        return days;
        
    }
}

*/
