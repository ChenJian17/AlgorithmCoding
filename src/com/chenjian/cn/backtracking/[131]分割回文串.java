package com.chenjian.cn.backtracking;//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 732 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution131 {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;

    }

    public void backtracking(String s, int startIndex){
        if (startIndex >= s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i=startIndex; i<s.length(); i++){
            if (isPalindrome(s,startIndex,i)){

                path.add(s.substring(startIndex,i+1));
            }else
                continue;

            backtracking(s, i+1);
            path.remove(path.size()-1);

        }

    }

    public boolean isPalindrome(String sb, int start, int end){
        for (int i=start,j=end; i<j; i++,j--){
            if (sb.charAt(i) != sb.charAt(j))
                return false;

        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
