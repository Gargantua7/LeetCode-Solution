//给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
//输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [5,1,7]
//输出：[1,null,5,null,7]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的取值范围是 [1, 100] 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 注意：本题与主站 897 题相同： https://leetcode-cn.com/problems/increasing-order-search-
//tree/ 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 二叉树 👍 5 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 剑指 Offer II 052
 * 展平二叉搜索树
 *
 * @author Gargantua丶
 * 2021-10-14 15:22:37
 */
class NYBBNL { 
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

    lateinit var res: TreeNode

    fun increasingBST(root: TreeNode?): TreeNode? {
        val new = TreeNode(0)
        res = new
        dfs(root)
        return new.right
    }

    fun dfs(node: TreeNode?) {
        node?: return
        dfs(node.left)
        res.right = node
        node.left = null
        res = node
        dfs(node.right)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}