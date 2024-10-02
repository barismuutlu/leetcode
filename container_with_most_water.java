class Solution {
    public int maxArea(int[] height) {
        int low=0;
        int high = height.length - 1;
        int maximumsize =0;
        while(high > low)
        {
                int aktuell =0;
                if(height[low]>height[high])
                {
                    aktuell = height[high];
                }
                else 
                {
                    aktuell = height[low];
                }
                if(aktuell * (high - low) > maximumsize)
                {
                    maximumsize = aktuell * (high - low);
                }
                /*En uzak ikiliden başlıyoruz yani genişlik max'tan başlıyoruz ve
                hangi tarafın duvarı uzunsa orası sabit kalıyor diğer tarafın index hareket
                ediyor. Bu şekilde bir pointer baştan diğeri sondan ortada buluşmak üzere       
                gelirken yanlışlıkla en uzun iki duvarı bypass etme ihtimalleri ortadan kalkıyor.
                */
                //Duplicate atlama
                if(height[low] > height[high])
                {
                    high--;
                }
                else
                {
                    low++;
                }
                
        }
       return maximumsize;
    }
}

/* First Try : Tİme Limit Exceeded :(

     int max = 0;
        for(int i = 0; i < height.length - 1; i++)
        {
            for(int a = height.length -1; a>0; a--)
            {
                int aktuell =0;
                if(height[i]>height[a])
                {
                aktuell = height[a];
                }
                else 
                 {
                aktuell = height[i];
                }
                if(aktuell * (a - i) > max)
                {
                max = aktuell * (a - i);
                System.out.println(a);
                System.out.println(i);
                }
            }
            
        }
        return max;


        */
