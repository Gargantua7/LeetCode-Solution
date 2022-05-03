//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 560 👎 0


package leetcode.editor.cn

import java.util.*


/**
 * 113
 * 路径总和 II
 *
 * @author Gargantua丶
 * 2021-08-27 01:25:35
 */
class PathSumIi {
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

        var ret: MutableList<List<Int>> = LinkedList()
        var path: Deque<Int> = LinkedList()

        fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>>? {
            dfs(root, targetSum)
            return ret
        }

        fun dfs(root: TreeNode?, targetSum: Int) {
            var targetSum1 = targetSum
            if (root == null) {
                return
            }
            path.offerLast(root.`val`)
            targetSum1 -= root.`val`
            if (root.left == null && root.right == null && targetSum1 == 0) {
                ret.add(LinkedList(path))
            }
            dfs(root.left, targetSum1)
            dfs(root.right, targetSum1)
            path.pollLast()
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}