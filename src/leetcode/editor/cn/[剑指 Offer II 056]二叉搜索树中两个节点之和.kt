//给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。 
//
// 
//
// 示例 1： 
//
// 
//输入: root = [8,6,10,5,7,9,11], k = 12
//输出: true
//解释: 节点 5 和节点 7 之和等于 12
// 
//
// 示例 2： 
//
// 
//输入: root = [8,6,10,5,7,9,11], k = 22
//输出: false
//解释: 不存在两个节点值之和为 22 的节点
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [1, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// root 为二叉搜索树 
// -10⁵ <= k <= 10⁵ 
// 
//
// 
//
// 注意：本题与主站 653 题相同： https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 👍 3 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 剑指 Offer II 056
 * 二叉搜索树中两个节点之和
 *
 * @author Gargantua丶
 * 2021-10-16 13:34:08
 */
class OpLdQZ { 
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
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        root?: return false
        val left: Deque<TreeNode> = LinkedList()
        var temp: TreeNode? = root
        while (temp != null) {
            left.push(temp)
            temp = temp.left
        }
        val right: Deque<TreeNode> = LinkedList()
        temp = root
        while (temp != null) {
            right.push(temp)
            temp = temp.right
        }
        while (left.isNotEmpty() && right.isNotEmpty()) {
            val leftNode = left.peek()
            val rightNode = right.peek()
            if (leftNode == rightNode) break
            val sum = leftNode.`val` + rightNode.`val`
            if (sum == k) return true
            if (sum < k) {
                var t = left.pop().right
                while (t != null) {
                    left.push(t)
                    t = t.left
                }
            } else {
                var t = right.pop().left
                while (t != null) {
                    right.push(t)
                    t = t.right
                }
            }
        }
        return false
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}