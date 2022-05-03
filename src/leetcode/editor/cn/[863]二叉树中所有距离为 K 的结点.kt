//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 304 👎 0


package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 863
 * 二叉树中所有距离为 K 的结点
 *
 * @author Gargantua丶
 * 2021-07-28 01:52:47
 */
class AllNodesDistanceKInBinaryTree {
//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int = 0) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    class Solution {
        val parent = HashMap<Int, TreeNode>()
        val ans = ArrayList<Int>()
        fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
            val stack = LinkedList<TreeNode>()
            stack.push(root!!)
            while (stack.isNotEmpty()) {
                val node = stack.pop()
                node.left?.let {
                    parent[it.`val`] = node
                    stack.push(it)
                }
                node.right?.let {
                    parent[it.`val`] = node
                    stack.push(it)
                }
            }
            find(target!!, target, 0, k)
            return ans
        }

        private fun find(node: TreeNode, form: TreeNode, depth: Int, k: Int) {
            if (depth == k) {
                ans.add(node.`val`)
                return
            }
            if (node.left != null && node.left != form) find(node.left!!, node, depth + 1, k)
            if (node.right != null && node.right != form) find(node.right!!, node, depth + 1, k)
            if (node.`val` in parent && parent[node.`val`] != form) find(parent[node.`val`]!!, node, depth + 1, k)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}