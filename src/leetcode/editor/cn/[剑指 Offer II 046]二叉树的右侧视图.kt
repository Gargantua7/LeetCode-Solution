//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 注意：本题与主站 199 题相同：https://leetcode-cn.com/problems/binary-tree-right-side-
//view/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 8 👎 0


package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList

/**
 * 剑指 Offer II 046
 * 二叉树的右侧视图
 *
 * @author Gargantua丶
 * 2021-10-12 13:23:28
 */
class WNC0Lk {
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

        fun rightSideView(root: TreeNode?): List<Int> {
            root ?: return emptyList()
            var queue: Queue<TreeNode> = LinkedList()
            queue.offer(root)
            var next: Queue<TreeNode> = LinkedList()
            val ans = ArrayList<Int>()
            while (queue.isNotEmpty()) {
                val node = queue.poll()
                node.left?.let { next.offer(it) }
                node.right?.let { next.offer(it) }
                if (queue.isEmpty()) {
                    ans.add(node.`val`)
                    queue = next
                    next = LinkedList()
                }
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}