//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1168 👎 0

package leetcode.editor.cn

/**
 * 104
 * 二叉树的最大深度
 * 
 * @author Gargantua丶
 * 2022-03-27 03:01:58
 */
class MaximumDepthOfBinaryTree {
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
    fun maxDepth(root: TreeNode?): Int {
        return root?.let { maxOf(maxDepth(it.left), maxDepth(it.right)) + 1 }?: 0
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
