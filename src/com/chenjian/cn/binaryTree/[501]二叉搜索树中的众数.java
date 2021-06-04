package com.chenjian.cn.binaryTree;//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 306 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.chenjian.cn.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution501 {
    int maxCount =0, count =0;//最大频率，频率、
    List<Integer> list = new ArrayList<>();
    TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        DFS(root);
        int[] res = new int[list.size()];
        for (int i=0; i<res.length; i++)
            res[i] = list.get(i);
        return res;


    }

    public void DFS(TreeNode cur){
        if (cur == null) return;
        DFS(cur.left);

        if (pre == null){
            count = 1;
        }else if (pre.val == cur.val){
            count ++;
        }else {
            count = 1;
        }
        pre = cur;

        if (count == maxCount)
            list.add(cur.val);
        if (count > maxCount){
            maxCount = count;
            list.clear();
            list.add(cur.val);
        }
        DFS(cur.right);
        return;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
