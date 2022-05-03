//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1209 👎 0


package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList

/**
 * 98
 * 验证二叉搜索树
 *
 * @author Gargantua丶
 * 2021-09-14 16:30:43
 */
class ValidateBinarySearchTree { 
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


    fun isValidBST(root: TreeNode?): Boolean {
        val list = ArrayList<Int>()
        root!!.mid(list)
        for (i in 1..list.lastIndex) {
            if (list[i] <= list[i - 1]) return false
        }
        return true
    }

    fun TreeNode.mid(list: ArrayList<Int>) {
        left?.mid(list)
        list += this.`val`
        right?.mid(list)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}