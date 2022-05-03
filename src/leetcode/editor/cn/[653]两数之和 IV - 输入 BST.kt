//给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。 
//
// 
//
// 示例 1： 
//
// 
//输入: root = [5,3,6,2,4,null,7], k = 9
//输出: true
// 
//
// 示例 2： 
//
// 
//输入: root = [5,3,6,2,4,null,7], k = 28
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// root 为二叉搜索树 
// -10⁵ <= k <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 👍 324 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 653
 * 两数之和 IV - 输入 BST
 * 
 * @author Gargantua丶
 * 2022-03-21 00:38:30
 */
class TwoSumIvInputIsABst {
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
        var temp: TreeNode? = root?: return false
        val large = LinkedList<TreeNode>()
        val small = LinkedList<TreeNode>()
        while (temp != null) {
            small.push(temp)
            temp = temp.left
        }
        temp = root
        while (temp != null) {
            large.push(temp)
            temp = temp.right
        }
        while (large.isNotEmpty() && small.isNotEmpty()) {
            val high = large.peek()
            val low = small.peek()
            if (low == high) return false
            val sum = high.`val` + low.`val`
            if (sum == k) return true
            if (sum < k) {
                small.pop()
                temp = low.right
                while (temp != null) {
                    small.push(temp)
                    temp = temp.left
                }
            } else {
                large.pop()
                temp = high.left
                while (temp != null) {
                    large.push(temp)
                    temp = temp.right
                }
            }
        }
        return false
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
