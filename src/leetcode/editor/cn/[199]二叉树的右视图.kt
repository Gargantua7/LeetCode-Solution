//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
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
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 525 👎 0


package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList

/**
 * 199
 * 二叉树的右视图
 *
 * @author Gargantua丶
 * 2021-08-27 00:45:17
 */
class BinaryTreeRightSideView {
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

        val Deque<*>.lastIndex get() = this.size - 1

        fun rightSideView(root: TreeNode?): List<Int> {
            val ans = ArrayList<Int>()
            val stack: Deque<TreeNode> = LinkedList()
            stack.push(root ?: return emptyList())
            while (stack.isNotEmpty()) {
                val node = stack.peek()
                if (ans.size == stack.lastIndex) ans.add(node.`val`)
                node.right?.let { stack.push(it) } ?: run {
                    var lastNode: TreeNode? = null
                    while (stack.isNotEmpty()) {
                        val node1 = stack.peek()
                        if (node1.left != null && node1.left != lastNode) {
                            stack.push(node1.left)
                            break
                        } else {
                            lastNode = stack.pop()
                        }
                    }
                }
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}