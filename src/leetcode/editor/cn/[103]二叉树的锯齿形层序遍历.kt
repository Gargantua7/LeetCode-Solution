//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 501 👎 0


package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList

/**
 * 103
 * 二叉树的锯齿形层序遍历
 *
 * @author Gargantua丶
 * 2021-08-26 00:18:56
 */
class BinaryTreeZigzagLevelOrderTraversal { 
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
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        root ?: return emptyList()
        val ans = ArrayList<List<Int>>()
        val queue = LinkedList<TreeNode>() as Queue<TreeNode>
        queue.offer(root)
        var depth = 0
        while (queue.isNotEmpty()) {
            val curr = ArrayList<Int>()
            for (i in queue.indices) {
                val node = queue.poll()
                curr += node.`val`
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
            if (depth % 2 != 0) curr.reverse()
            ans += curr
            depth++
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}