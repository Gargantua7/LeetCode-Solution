//给定二叉树的根节点 root ，返回所有左叶子之和。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [3,9,20,null,null,15,7] 
//输出: 24 
//解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
// 
//
// 示例 2: 
//
// 
//输入: root = [1]
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 1000] 范围内 
// -1000 <= Node.val <= 1000 
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 415 👎 0

package leetcode.editor.cn

/**
 * 404
 * 左叶子之和
 * 
 * @author Gargantua丶
 * 2022-03-27 03:04:26
 */
class SumOfLeftLeaves {
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root == null) return 0
        var res = 0
        if (root.left != null && root.left!!.left == null && root.left!!.right == null) {
            res += root.left!!.`val`
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
