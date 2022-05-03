//给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。 
//
// 例如， 
//
// 
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和值: 2
// 
//
// 你应该返回如下子树: 
//
// 
//      2     
//     / \   
//    1   3
// 
//
// 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。 
// Related Topics 树 二叉搜索树 二叉树 👍 201 👎 0

package leetcode.editor.cn

/**
 * 700
 * 二叉搜索树中的搜索
 * 
 * @author Gargantua丶
 * 2021-11-26 13:04:44
 */
class SearchInABinarySearchTree {
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
    fun searchBST(root: TreeNode?, target: Int): TreeNode? {
        var curr = root
        while (curr != null && curr.`val` != target) {
            curr = if (curr.`val` < target) curr.right else curr.left
        }
        return curr
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}