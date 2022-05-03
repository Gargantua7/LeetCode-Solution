//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
//  [20,9],
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
// Related Topics 树 广度优先搜索 二叉树 
// 👍 120 👎 0


package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList

/**
 * 剑指 Offer 32 - III
 * 从上到下打印二叉树 III
 *
 * @author Gargantua丶
 * 2021-08-10 00:51:11
 */
class CongShangDaoXiaDaYinErChaShuIiiLcof {
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