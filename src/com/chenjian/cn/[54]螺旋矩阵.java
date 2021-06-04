package com.chenjian.cn;//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 714 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution541 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix[0].length == 0){
            return result;
        }
        int left = 0;
        int right = matrix[0].length-1; //行
        int top = 0;
        int bottom = matrix.length-1; //列
        int sum = matrix.length * matrix[0].length;
        while(sum >= 1) {

            // 从左到右
            for (int i = left; i <= right; i++){
                result.add(matrix[left][i]);
                sum --;
            }

            right --;
            // 从右到下
            for (int i = right; i>= top; i--){

            }

            // 从右到左
//            for (int i = )
        }

        return null;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
