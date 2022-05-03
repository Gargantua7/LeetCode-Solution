package leetcode.editor.cn

import java.util.*

//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 180 👎 0


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
class Solution993 {

    fun isCousins(root: TreeNode, x: Int, y: Int): Boolean {
        if (root.`val` == x || root.`val` == y) return false
        val arr = arrayOf(x, y)
        var queue: Queue<TreeNode> = LinkedList()
        var new: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node.left?.`val` in arr && node.right?.`val` in arr)
                return false
            if (node.left != null) new.offer(node.left)
            if (node.right != null) new.offer(node.right)
            if (queue.isEmpty() && new.isNotEmpty()) {
                var flag = false
                for (i in new) {
                    if (i.`val` in arr) {
                        if (flag) return true
                        else flag = true
                    }
                }
                if (flag) return false
                queue = new
                new = LinkedList()
            }
        }
        return false
    }
}
//leetcode submit region end(Prohibit modification and deletion)
