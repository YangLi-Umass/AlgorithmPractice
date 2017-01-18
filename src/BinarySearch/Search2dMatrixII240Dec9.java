package BinarySearch;

/**
 * Created by li on 12/9/2016.
 */
public class Search2dMatrixII240Dec9 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return helper(matrix,target,0,matrix.length-1,0,matrix[0].length-1);
    }

    public boolean helper(int[][] matrix, int target, int up, int down, int left, int right) {
        if(up < 0 || down >= matrix.length || left < 0 || right >= matrix[0].length || left > right || up > down) return false;
        if(up == down && left == right) {
            if(matrix[up][left] == target) return true;
            else return false;
        }
        int midR = (up+down)/2, midC = (left+right)/2;
        if(matrix[midR][midC] == target) return true;
        else if(matrix[midR][midC] > target) {
            if(helper(matrix,target,up,midR-1,midC,right)) return true;
            if(helper(matrix,target,midR,down,left,midC-1)) return true;
            if(midR-1>=0 && midC-1 >=0 && matrix[midR-1][midC-1] < target) return false;
            else return helper(matrix,target,up,midR-1,left,midC-1);
        } else {
            if(helper(matrix,target,up,midR,midC+1,right)) return true;
            if(helper(matrix,target,midR+1,down,left,midC)) return true;
            if(midR+1<matrix.length && midC+1<matrix[0].length && matrix[midR+1][midC+1] > target) return false;
            else return helper(matrix,target,midR+1,down,midC+1,right);
        }
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int row = 0, column = matrix[0].length-1;
        while(row < matrix.length && column > -1) {
            if(matrix[row][column] == target) {
                return true;
            } else if(matrix[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }
}
