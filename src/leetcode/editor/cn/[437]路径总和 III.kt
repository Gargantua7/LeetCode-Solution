//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 989 👎 0


package leetcode.editor.cn

/**
 * 437
 * 路径总和 III
 *
 * @author Gargantua丶
 * 2021-09-28 00:09:05
 */
class PathSumIii {
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

        fun pathSum(root: TreeNode?, targetSum: Int): Int {
            return dfs(root, HashMap<Int, Int>().apply { this[0] = 1 }, 0, targetSum)
        }

        fun dfs(root: TreeNode?, map: HashMap<Int, Int>, pre: Int, target: Int): Int {
            root ?: return 0
            val sum = root.`val` + pre
            var ans = map[sum - target] ?: 0
            map[sum] = (map[sum] ?: 0) + 1
            ans += dfs(root.left, map, sum, target)
            ans += dfs(root.right, map, sum, target)
            map[sum] = map[sum]!! - 1
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}