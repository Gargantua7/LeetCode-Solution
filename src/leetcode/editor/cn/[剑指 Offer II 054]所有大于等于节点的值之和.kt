//给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。 
//
// 
//
// 提醒一下，二叉搜索树满足下列约束条件： 
//
// 
// 节点的左子树仅包含键 小于 节点键的节点。 
// 节点的右子树仅包含键 大于 节点键的节点。 
// 左右子树也必须是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
// 
//
// 示例 2： 
//
// 
//输入：root = [0,null,1]
//输出：[1,null,1]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,0,2]
//输出：[3,3,2]
// 
//
// 示例 4： 
//
// 
//输入：root = [3,2,4,1]
//输出：[7,9,4,10]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数介于 0 和 10⁴ 之间。 
// 每个节点的值介于 -10⁴ 和 10⁴ 之间。 
// 树中的所有值 互不相同 。 
// 给定的树为二叉搜索树。 
// 
//
// 
//
// 注意： 
//
// 
// 本题与主站 538 题相同： https://leetcode-cn.com/problems/convert-bst-to-greater-tree/ 
//
// 本题与主站 1038 题相同：https://leetcode-cn.com/problems/binary-search-tree-to-
//greater-sum-tree/ 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 5 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer II 054
 * 所有大于等于节点的值之和
 *
 * @author Gargantua丶
 * 2021-10-15 13:46:31
 */
class W6cpku { 
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
    fun convertBST(root: TreeNode?): TreeNode? {
        last(root, 0)
        return root
    }

    fun last(root: TreeNode?, curr: Int): Int {
        root?: return curr
        root.`val` += last(root.right, curr)
        return last(root.left, root.`val`)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}