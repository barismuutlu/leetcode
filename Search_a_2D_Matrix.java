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
}
