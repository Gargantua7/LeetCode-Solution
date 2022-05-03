//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给定一个二叉树的根节点 root ，返回其 最大路径和，即所有路径上节点值之和的最大值。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
//
// 
//
// 注意：本题与主站 124 题相同： https://leetcode-cn.com/problems/binary-tree-maximum-path-
//sum/ 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 8 👎 0


package leetcode.editor.cn

import kotlin.math.max

/**
 * 剑指 Offer II 051
 * 节点之和最大的路径
 *
 * @author Gargantua丶
 * 2021-10-14 14:46:14
 */
class JC7MId {
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

        fun maxPathSum(root: TreeNode?): Int {
            return dfs(root).first
        }

        fun dfs(node: TreeNode?): Pair<Int, Int> {
            node ?: return Int.MIN_VALUE to 0
            val (sumL, maxL) = dfs(node.left)
            val (sumR, maxR) = dfs(node.right)
            val sum = maxL + maxR + node.`val`
            val second = maxOf(node.`val`, node.`val` + maxOf(maxL, maxR))
            return maxOf(maxOf(sumL, sumR), maxOf(sum, second)) to second
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}