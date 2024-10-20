class Solution {
    boolean binarySearch(int[]nums, int start, int end, int target)
    {
        if(start > end)
        {
            return false;
        }
        int mid = (start + end) / 2;
        if(nums[mid] == target)
        {
            return true;
        }
        if(nums[mid] > target)
        {
            return binarySearch(nums, start, mid-1, target);
        }
        return binarySearch(nums, mid+1, end, target);
    }
    boolean binarySearchInRow(int[][] matrix, int start, int end, int target)
    {
        boolean returnvalue = false;
        if(start > end)
        {
            return false;
        }
        int mid = (start + end) / 2;
        if(matrix[mid][0] == target)
        {
            return true;
        }
        if(matrix[mid][0] < target)
        {
            if(matrix[mid][matrix[mid].length -1] >= target)
            {
                return binarySearch(matrix[mid], 0, matrix[mid].length -1, target);
            }
            else
            {
                return binarySearchInRow(matrix, mid+1, end, target);
            }
             
        }
         return binarySearchInRow(matrix, start, mid-1, target);
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearchInRow(matrix, 0, matrix.length -1, target);
    }
}

/* First try: wrong way(but works)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean isNonDecreasing = true;
        boolean isTargetExistiert = false;
        for(int i=0; i < matrix.length; i++)
        {
            for(int a=0; a < matrix[i].length; a++)
            {
                if(matrix[i][a] == target)
                {
                    isTargetExistiert = true;
                }
                if(a == matrix[i].length -1)
                {
                    break;
                }
                if(matrix[i][a] > matrix[i][a+1])
                {
                    isNonDecreasing = false;
                }
            }
            if(i == matrix.length -1)
            {
                break;
            }
            if(matrix[i][0] > matrix[i+1][0])
            {
                isNonDecreasing = false;
            }
        }
        if (isNonDecreasing == true && isTargetExistiert == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}*/
