//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 124 👎 0


package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList

/**
 * 剑指 Offer 32 - II
 * 从上到下打印二叉树 II
 *
 * @author Gargantua丶
 * 2021-08-10 00:51:12
 */
class CongShangDaoXiaDaYinErChaShuIiLcof { 
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
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        root ?: return emptyList()
        val ans = ArrayList<List<Int>>()
        val queue = LinkedList<TreeNode>() as Queue<TreeNode>
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val curr = ArrayList<Int>()
            for (i in queue.indices) {
                val node = queue.poll()
                curr += node.`val`
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
            ans += curr
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}