//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 10⁵] 内。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1268 👎 0


package leetcode.editor.cn

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 * 236
 * 二叉树的最近公共祖先
 *
 * @author Gargantua丶
 * 2021-08-29 14:12:47
 */
class LowestCommonAncestorOfABinaryTree { 
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val map = HashMap<TreeNode, TreeNode>()
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root?: return null)
        while (queue.isNotEmpty()) {
            val node  = queue.poll()
            node.left?.let {
                queue.offer(it)
                map[it] = node
            }
            node.right?.let {
                queue.offer(it)
                map[it] = node
            }
        }
        val set = HashSet<TreeNode>()
        var currP = p
        set += p!!
        while (true) {
            val parent = map[currP]?: break
            set += parent
            currP = parent
        }
        var currQ = q
        if (q in set) return q
        while (true) {
            val parent = map[currQ]?: break
            if (parent in set) return parent
            currQ = parent
        }
        return null
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}