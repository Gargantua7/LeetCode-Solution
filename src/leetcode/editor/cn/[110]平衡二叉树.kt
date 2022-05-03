//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 942 👎 0

package leetcode.editor.cn

/**
 * 110
 * 平衡二叉树
 * 
 * @author Gargantua丶
 * 2022-03-29 01:59:35
 */
class BalancedBinaryTree {
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
    fun isBalanced(root: TreeNode?): Boolean {
        return dfs(root?:return true) != -1
    }

    fun dfs(root: TreeNode): Int {
        val left = root.left?.let { dfs(it) } ?: 0
        if (left == -1) return -1
        val right = root.right?.let { dfs(it) } ?: 0
        if (right == -1) return -1
        if (left - right !in -1..1) return -1
        return maxOf(left, right) + 1
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
