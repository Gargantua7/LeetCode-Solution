//给你一个有根节点
// root 的二叉树，返回它 最深的叶节点的最近公共祖先 。 
//
// 回想一下： 
//
// 
// 叶节点 是二叉树中没有子节点的节点 
// 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1 
// 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4]
//输出：[2,7,4]
//解释：我们返回值为 2 的节点，在图中用黄色标记。
//在图中用蓝色标记的是树的最深的节点。
//注意，节点 6、0 和 8 也是叶节点，但是它们的深度是 2 ，而节点 7 和 4 的深度是 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[1]
//解释：根节点是树中最深的节点，它是它本身的最近公共祖先。
// 
//
// 示例 3： 
//
// 
//输入：root = [0,1,3,null,2]
//输出：[2]
//解释：树中最深的叶节点是 2 ，最近公共祖先是它自己。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数将在
// [1, 1000] 的范围内。 
// 0 <= Node.val <= 1000 
// 每个节点的值都是 独一无二 的。 
// 
//
// 
//
// 注意：本题与力扣 865 重复：https://leetcode-cn.com/problems/smallest-subtree-with-all-
//the-deepest-nodes/ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 👍 213 👎 0


package leetcode.editor.cn

import com.sun.source.tree.Tree
import java.util.LinkedList

/**
 * 1123
 * 最深叶节点的最近公共祖先
 *
 * @author Gargantua丶
 * 2023-09-06 14:55:02
 */
class LowestCommonAncestorOfDeepestLeaves {
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
    fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
        var queue = LinkedList<TreeNode>()
        var next = LinkedList<TreeNode>()
        val map = HashMap<TreeNode, TreeNode>()
        var first = root
        var last = root
        queue.offer(root!!)
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            node.left?.let {
                next.offer(it)
                map[it] = node
            }
            node.right?.let {
                next.offer(it)
                map[it] = node
            }
            if (queue.isEmpty() && next.isNotEmpty()) {
                first = next.first
                last = next.last
                queue = next
                next = LinkedList()
            }
        }

        while (first != last) {
            first = map[first]!!
            last = map[last]!!
        }

        return first
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}