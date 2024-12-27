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
// -10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// 
//
// 注意：本题与主站 437 题相同：https://leetcode-cn.com/problems/path-sum-iii/ 
// Related Topics 树 深度优先搜索 二叉树 👍 4 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer II 050
 * 向下的路径节点之和
 *
 * @author Gargantua丶
 * 2021-10-14 14:27:23
 */
class SixEUYwP { 
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
        return dfs(root, 0, HashMap<Int, Int>().apply { this[0] = 1 }, targetSum)
    }

    fun dfs(node: TreeNode?, pre: Int, map: HashMap<Int, Int>, target: Int): Int {
        node?: return 0
        node.`val` += pre
        var ans = map[node.`val` - target]?: 0
        map[node.`val`] = (map[node.`val`]?: 0) + 1
        ans += dfs(node.left, node.`val`, map, target)
        ans += dfs(node.right, node.`val`, map, target)
        map[node.`val`] = map[node.`val`]!! - 1
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}