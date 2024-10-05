public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];  
            cars[i][1] = (double)(target - position[i]) / speed[i];  
        }
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            double currTime = cars[i][1]; 
            if (!stack.isEmpty() && currTime <= stack.peek()) {
                continue;  
            }
            stack.push(currTime);
        }
        return stack.size();
    }
}

/* First Try: without using stack (at least as expected way): 
class Solution {
boolean isCanCatch(int firstLoc, int firstSpeed, int secondLoc, int secSpeed, int target) {
    if (firstSpeed == secSpeed) {
        return false;
    }

    // long yerine double kullanımı yapıyoruz
    double speedDff = (double) secSpeed - (double) firstSpeed;
    double locDff = (double) firstLoc - (double) secondLoc;

    // Tamsayı yerine double bölme işlemi
    double time2catch = locDff / speedDff;
    double timeOfFirstArrive = ((double) target - (double) firstLoc) / (double) firstSpeed;

    return time2catch <= timeOfFirstArrive;
}

    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Integer> stack = new Stack<>();
        int[][] positionNspeed = new int[position.length][2];
        for(int i = 0; i < position.length; i++)
        {
            positionNspeed[i][0] = position[i];
            positionNspeed[i][1] = speed[i];
        }
        Arrays.sort(positionNspeed, new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return Integer.compare(a[0], b[0]);
            }
        });
        boolean lastIncluded = false;
        for(int i = position.length-1; i>0; i--)
        {
            if(positionNspeed[i][1] >= positionNspeed[i-1][1])
            stack.push(positionNspeed[i][0]);
            else
            {
                int j = i;
                while(isCanCatch(positionNspeed[i][0], positionNspeed[i][1], positionNspeed[j-1][0], positionNspeed[j-1][1], target) && positionNspeed[i][1] < positionNspeed[j-1][1])
                {
                    if(j == 1){
                        lastIncluded = true;
                        break;}
                    j--;
                }
                stack.push(positionNspeed[i][0]);
                i = j;
            }
            
        }
        if(lastIncluded == true)
        {
            return stack.size();
        }
        return stack.size() + 1;
    }

    
}
*/
