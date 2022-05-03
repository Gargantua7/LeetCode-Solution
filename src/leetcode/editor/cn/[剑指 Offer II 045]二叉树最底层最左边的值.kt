//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//
// 注意：本题与主站 513 题相同： https://leetcode-cn.com/problems/find-bottom-left-tree-
//value/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 3 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 剑指 Offer II 045
 * 二叉树最底层最左边的值
 *
 * @author Gargantua丶
 * 2021-10-12 13:20:53
 */
class LwUNpT {
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

        fun findBottomLeftValue(root: TreeNode?): Int {
            val queue: Queue<TreeNode> = LinkedList()
            queue.offer(root)
            while (queue.isNotEmpty()) {
                val node = queue.poll()
                node.right?.let { queue.offer(it) }
                node.left?.let { queue.offer(it) }
                if (queue.isEmpty()) return node.`val`
            }
            return 0
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}