//给定一个二叉树，我们在树的节点上安装摄像头。 
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 
//
// 计算监控树的所有节点所需的最小摄像头数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
// 
//
// 
//提示： 
//
// 
// 给定树的节点数的范围是 [1, 1000]。 
// 每个节点的值都是 0。 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 335 👎 0

package leetcode.editor.cn

/**
 * 968
 * 监控二叉树
 * 
 * @author Gargantua丶
 * 2021-11-24 15:11:17
 */
class BinaryTreeCameras {
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
    fun minCameraCover(root: TreeNode?): Int {
        val array = dfs(root)
        return array[1]
    }

    fun dfs(root: TreeNode?): IntArray {
        if (root == null) {
            return intArrayOf(Int.MAX_VALUE / 2, 0, 0)
        }
        val leftArray = dfs(root.left)
        val rightArray = dfs(root.right)
        val array = IntArray(3)
        array[0] = leftArray[2] + rightArray[2] + 1
        array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], rightArray[0] + leftArray[1]))
        array[2] = Math.min(array[0], leftArray[1] + rightArray[1])
        return array
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}