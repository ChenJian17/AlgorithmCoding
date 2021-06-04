package com.chenjian.cn.binaryTree;//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 1054 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.chenjian.cn.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
class Solution98 {
//    public boolean isValidBST(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        DFS(root, list);
//        for (int i =1; i<list.size(); i++){
//            if (list.get(i) <= list.get(i-1))
//                return false;
//        }
//        return true;
//
//    }
//
//    public void DFS(TreeNode root,List<Integer> list){
//        if (root == null) return;
//        DFS(root.left, list);
//        list.add(root.val);
//        DFS(root.right, list);
//
//    }

    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root){
        return DFS(root);
    }

    public boolean DFS(TreeNode root){
        if (root == null) return true;
        boolean left = DFS(root.left);
        if (pre >= root.val)
            return false;
        else
            pre = root.val;
        boolean right = DFS(root.right);
        return left && right;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
