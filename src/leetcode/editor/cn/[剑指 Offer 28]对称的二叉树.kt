//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
// 1 
// / \ 
// 2 2 
// / \ / \ 
//3 4 4 3 
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
// 1 
// / \ 
// 2 2 
// \ \ 
// 3 3 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 216 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 剑指 Offer 28
 * 对称的二叉树
 *
 * @author Gargantua丶
 * 2021-08-09 01:03:54
 */
class DuiChengDeErChaShuLcof {
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

        fun isSymmetric(root: TreeNode?): Boolean {
            root ?: return true
            return dfs(root.left) { stack, left, right ->
                if (right != null) stack.push(right)
                if (left != null) stack.push(left)
            } == dfs(root.right) { stack, left, right ->
                if (left != null) stack.push(left)
                if (right != null) stack.push(right)
            }
        }

        fun dfs(root: TreeNode?, push: (Deque<TreeNode>, TreeNode?, TreeNode?) -> Unit): String {
            root ?: return ""
            val stack: Deque<TreeNode> = LinkedList()
            stack.add(root)
            val sb = StringBuilder()
            while (stack.isNotEmpty()) {
                val node = stack.pop()
                sb.append("${node.`val`} ")
                push(stack, node.left, node.right)
            }
            return sb.toString()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}