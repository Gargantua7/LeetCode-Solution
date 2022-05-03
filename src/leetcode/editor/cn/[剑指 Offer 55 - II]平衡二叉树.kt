//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
// 
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 0 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 180 👎 0


package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList

/**
 * 剑指 Offer 55 - II
 * 平衡二叉树
 *
 * @author Gargantua丶
 * 2021-08-11 00:43:50
 */
class PingHengErChaShuLcof {
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

        var res = true

        fun isBalanced(root: TreeNode?): Boolean {
            res = true
            root?.let { mid(it) }
            return res
        }

        fun mid(root: TreeNode, depth: Int = 0): Int {
            val left = root.left?.let { mid(it, depth + 1) } ?: (depth + 1)
            val right = root.right?.let { mid(it, depth + 1) } ?: (depth + 1)
            if (left - right !in -1..1) res = false
            return kotlin.math.max(left, right)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}