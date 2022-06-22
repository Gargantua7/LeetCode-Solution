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
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 303 👎 0

package leetcode.editor.cn

import java.util.LinkedList

/**
 * 513
 * 找树左下角的值
 * 
 * @author Gargantua丶
 * 2022-06-22 10:05:42
 */
class FindBottomLeftTreeValue {
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
        var parent = LinkedList<TreeNode>()
        var child = LinkedList<TreeNode>()
        parent.offer(root?: return 0)
        var first = parent.peek()
        while (parent.isNotEmpty()) {
            val node = parent.poll()
            node.left?.let { child.offer(it) }
            node.right?.let { child.offer(it) }
            if (parent.isEmpty()) {
                if (child.isEmpty()) return first.`val`
                parent = child
                child = LinkedList()
                first = parent.peek()
            }
        }
        return 0
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
