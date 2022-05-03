//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 434 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 230
 * 二叉搜索树中第K小的元素
 *
 * @author Gargantua丶
 * 2021-08-28 00:42:46
 */
class KthSmallestElementInABst {
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

        fun kthSmallest(root: TreeNode?, k: Int): Int {
            val stack: Deque<TreeNode> = LinkedList()
            var curr = root
            while (curr != null) {
                stack.push(curr)
                curr = curr.left
            }
            for (i in 1 until k) {
                var temp = stack.pop().right
                while (temp != null) {
                    stack.push(temp)
                    temp = temp.left
                }
            }
            return stack.pop().`val`
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    var k = 0

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        this.k = k
        return mid(root)
    }

    fun mid(root: TreeNode?): Int {
        root ?: return -1
        var value = mid(root.left)
        if (value > -1) return value
        if (--k == 0) return root.`val`
        value = mid(root.right)
        return value
    }
}