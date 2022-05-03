//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 188 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer 54
 * 二叉搜索树的第k大节点
 *
 * @author Gargantua丶
 * 2021-08-11 00:19:51
 */
class ErChaSouSuoShuDeDiKdaJieDianLcof {
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

        var k: Int = 0

        fun kthLargest(root: TreeNode, k: Int): Int {
            this.k = k
            return mid(root)
        }

        fun mid(root: TreeNode): Int {
            val left = root.right?.let { mid(it) } ?: 0
            if (--k == 0) return root.`val`
            val right = root.left?.let { mid(it) } ?: 0
            return kotlin.math.max(left, right)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}