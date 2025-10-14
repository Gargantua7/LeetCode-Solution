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


        fun rightSideView(root: TreeNode?): List<Int> {
            if (root == null) return emptyList()

            val res = ArrayList<Int>()
            var queue = ArrayDeque<TreeNode>()
            var next = ArrayDeque<TreeNode>()

            queue.addLast(root)
            res.add(root.`val`)

            var value = root.`val`

            while (queue.isNotEmpty()) {
                val node = queue.removeFirst()
                node.left?.let {
                    next.addLast(it)
                    value = it.`val`
                }
                node.right?.let {
                    next.addLast(it)
                    value = it.`val`
                }

                if (queue.isEmpty() && next.isNotEmpty()) {
                    res.add(value)

                    queue = next
                    next = ArrayDeque<TreeNode>()
                }
            }

            return res

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}