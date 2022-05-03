//给定一棵二叉树的根节点 root 和树中的一个节点 u ，返回与 u 所在层中距离最近的右侧节点，当 u 是所在层中最右侧的节点，返回 null 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,null,4,5,6], u = 4
//输出：5
//解释：节点 4 所在层中，最近的右侧节点是节点 5。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [3,null,4,2], u = 2
//输出：null
//解释：2 的右侧没有节点。
// 
//
// 示例 3： 
//
// 
//输入：root = [1], u = 1
//输出：null
// 
//
// 示例 4： 
//
// 
//输入：root = [3,4,2,null,null,null,1], u = 4
//输出：2
// 
//
// 
//
// 提示: 
//
// 
// 树中节点个数的范围是 [1, 10⁵] 。 
// 1 <= Node.val <= 10⁵ 
// 树中所有节点的值是唯一的。 
// u 是以 root 为根的二叉树的一个节点。 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 6 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 1602
 * 找到二叉树中最近的右侧节点
 * 
 * @author Gargantua丶
 * 2021-11-21 13:51:10
 */
class FindNearestRightNodeInBinaryTree {
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
    fun findNearestRightNode(root: TreeNode?, u: TreeNode?): TreeNode? {
        root?: return null
        u?: return null
        var queue: Queue<TreeNode> = LinkedList()
        var children: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        var flag = false
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (flag) return node
            if (node == u) flag = true
            node.left?.let { children.offer(it) }
            node.right?.let { children.offer(it) }
            if (queue.isEmpty() && children.isNotEmpty()) {
                if (flag) return null
                queue = children
                children = LinkedList()
            }
        }
        return null
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}