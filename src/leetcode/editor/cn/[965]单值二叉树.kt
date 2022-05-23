//如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。 
//
// 只有给定的树是单值二叉树时，才返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[1,1,1,1,1,null,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 输入：[2,2,2,5,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 给定树的节点数范围是 [1, 100]。 
// 每个节点的值都是整数，范围为 [0, 99] 。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 110 👎 0

package leetcode.editor.cn

/**
 * 965
 * 单值二叉树
 * 
 * @author Gargantua丶
 * 2022-05-24 00:26:50
 */
class UnivaluedBinaryTree {
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
    fun isUnivalTree(root: TreeNode?): Boolean {
        return dfs(root?: return false, root.`val`)
    }

    fun dfs(node: TreeNode, n: Int): Boolean {
        if (node.`val` != n) return false
        node.left?.let { t ->
            dfs(t, n).let {
                if (!it) return false
            }
        }
        node.right?.let { t ->
            dfs(t, n).let {
                if (!it) return false
            }
        }
        return true
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
