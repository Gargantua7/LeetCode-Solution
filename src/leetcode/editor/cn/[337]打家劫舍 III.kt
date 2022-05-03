//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1044 👎 0

package leetcode.editor.cn

/**
 * 337
 * 打家劫舍 III
 * 
 * @author Gargantua丶
 * 2021-11-22 13:30:06
 */
class HouseRobberIii {
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

    val f = HashMap<TreeNode, Int>()
    val g = HashMap<TreeNode, Int>()

    fun rob(root: TreeNode?): Int {
        dfs(root?: return 0)
        return maxOf(f[root]?: 0, g[root]?: 0)
    }

    fun dfs(node: TreeNode) {
        node.left?.let { dfs(it) }
        node.right?.let { dfs(it) }
        f[node] = node.`val` + (g[node.left]?: 0) + (g[node.right]?: 0)
        g[node] = maxOf(f[node.left]?: 0, g[node.left]?: 0) + maxOf(f[node.right]?: 0, g[node.right]?: 0)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}