//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 562 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 111
 * 二叉树的最小深度
 *
 * @author Gargantua丶
 * 2021-08-20 00:43:11
 */
class MinimumDepthOfBinaryTree { 
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
    fun minDepth(root: TreeNode?): Int {
        root?: return 0
        var depth = 1
        val first: Queue<TreeNode> = LinkedList()
        val second: Queue<TreeNode> = LinkedList()
        first.offer(root)
        while (first.isNotEmpty()) {
            val node = first.poll()
            if (node.left == null && node.right == null) return depth
            node.left?.let { second.offer(it) }
            node.right?.let { second.offer(it) }

            if (first.isEmpty()) {
                first += second
                second.clear()
                depth++
            }
        }
        return depth
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}