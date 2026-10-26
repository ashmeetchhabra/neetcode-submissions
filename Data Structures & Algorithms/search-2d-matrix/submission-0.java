class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIdx = searchForPotentialRow(matrix, target);
        if(rowIdx==-1)
            return false;
        return searchInRow(rowIdx, matrix, target);
    }

    private int searchForPotentialRow(int[][] matrix, int target){
        int low = 0;
        int high = matrix.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[mid][0]<=target && target<=matrix[mid][matrix[0].length-1])
                return mid;
            else if(matrix[mid][0]<target)
                low=mid+1;
            else high = mid-1;
        }
        return -1;
    }

    private boolean searchInRow(int rowIdx, int[][] matrix, int target){
        int low = 0;
        int high = matrix[0].length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[rowIdx][mid]==target)
                return true;
            else if(matrix[rowIdx][mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return false;
    }
}
