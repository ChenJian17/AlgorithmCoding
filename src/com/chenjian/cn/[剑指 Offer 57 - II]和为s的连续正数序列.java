package com.chenjian.cn;//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 218 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution57 {
    public static int[][] findContinuousSequence(int target) {
        int left=1, right =1;
        int sum = 0;
        List<int[]> result = new ArrayList<>();
        while(left <= target/2) {
            if(sum < target){
                right++;
                sum += right;
            }else if(sum > target){
                left++;
                sum -= left;
            }else {
                int[] array = new int[right-left];
                for(int i = left; i < right; i++){
                    array[i-left] = i;
                }
                result.add(array);

                left++;
                sum -= left;
            }

        }


        return result.toArray(new int[result.size()][]);


    }

    public static void main(String[] args) {
//        System.out.println(9);
        int[][] arr = findContinuousSequence(9);
        System.out.println("dha");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
