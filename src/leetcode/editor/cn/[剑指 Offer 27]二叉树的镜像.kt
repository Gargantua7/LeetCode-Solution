//请完成一个函数，输入一个二叉树，该函数输出它的镜像。 
//
// 例如输入： 
//
// 4 
// / \ 
// 2 7 
// / \ / \ 
//1 3 6 9 
//镜像输出： 
//
// 4 
// / \ 
// 7 2 
// / \ / \ 
//9 6 3 1 
//
// 
//
// 示例 1： 
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 164 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 剑指 Offer 27
 * 二叉树的镜像
 *
 * @author Gargantua丶
 * 2021-08-09 00:59:15
 */
class ErChaShuDeJingXiangLcof { 
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
    fun mirrorTree(root: TreeNode?): TreeNode? {
        val stack = LinkedList<TreeNode>() as Deque<TreeNode>
        stack.push(root?: return null)
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            val left = node.right
            val right = node.left
            node.left = left?.apply { stack.push(this) }
            node.right = right?.apply { stack.push(this) }
        }
        return root
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}