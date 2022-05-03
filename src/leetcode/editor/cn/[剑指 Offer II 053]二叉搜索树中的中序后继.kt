//给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。 
//
// 节点 p 的后继是值比 p.val 大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [2,1,3], p = 1
//输出：2
//解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], p = 6
//输出：null
//解释：因为给出的节点没有中序后继，所以答案就返回 null 了。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内。 
// -10⁵ <= Node.val <= 10⁵ 
// 树中各节点的值均保证唯一。 
// 
//
// 
//
// 注意：本题与主站 285 题相同： https://leetcode-cn.com/problems/inorder-successor-in-bst/ 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 9 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer II 053
 * 二叉搜索树中的中序后继
 *
 * @author Gargantua丶
 * 2021-10-15 13:36:11
 */
class P5rCT8 { 
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    var flag = false

    fun inorderSuccessor(root: TreeNode?, p: TreeNode?): TreeNode? {
        flag = false
        return mid(root, p)
    }

    fun mid(root: TreeNode?, p: TreeNode?): TreeNode? {
        root?: return null
        mid(root.left, p)?.let { return it }
        if (flag) {
            flag = false
            return root
        }
        if (root == p) flag = true
        return mid(root.right, p)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}