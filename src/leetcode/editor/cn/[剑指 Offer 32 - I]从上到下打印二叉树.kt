//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
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
// 👍 111 👎 0


package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList

/**
 * 剑指 Offer 32 - I
 * 从上到下打印二叉树
 *
 * @author Gargantua丶
 * 2021-08-10 00:39:10
 */
class CongShangDaoXiaDaYinErChaShuLcof {
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

        fun levelOrder(root: TreeNode?): IntArray {
            root ?: return emptyList<Int>().toIntArray()
            val ans = ArrayList<Int>()
            val queue = LinkedList<TreeNode>() as Queue<TreeNode>
            queue.offer(root)
            while (queue.isNotEmpty()) {
                val node = queue.poll()
                ans.add(node.`val`)
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
            return ans.toIntArray()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}