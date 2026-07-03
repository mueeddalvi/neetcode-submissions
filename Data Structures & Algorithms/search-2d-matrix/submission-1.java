class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, i = 0, m = matrix[n - 1].length;

        while (i < n) {
            if (matrix[i][m-1] == target) {
                return true;
            } else if (matrix[i][m-1] < target) {
                i++;
            }

            else {
                return bs(matrix[i], target);
            }
        }

        return false;
    }

    public boolean bs(int arr[], int target) {
        int n = arr.length, l = 0, r = n - 1, mid = 0;

        while (l <= r) {
            mid = (l + r) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}
