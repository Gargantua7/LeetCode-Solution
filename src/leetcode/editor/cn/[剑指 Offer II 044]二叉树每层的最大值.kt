//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
//解释:
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
//解释:
//          1
//         / \
//        2   3
// 
//
// 示例3： 
//
// 
//输入: root = [1]
//输出: [1]
// 
//
// 示例4： 
//
// 
//输入: root = [1,null,2]
//输出: [1,2]
//解释:      
//           1 
//            \
//             2     
// 
//
// 示例5： 
//
// 
//输入: root = []
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//
// 注意：本题与主站 515 题相同： https://leetcode-cn.com/problems/find-largest-value-in-
//each-tree-row/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 3 👎 0


package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList

/**
 * 剑指 Offer II 044
 * 二叉树每层的最大值
 *
 * @author Gargantua丶
 * 2021-10-12 13:15:12
 */
class HPov7L { 
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
    fun largestValues(root: TreeNode?): List<Int> {
        root?: return emptyList()
        var queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        var next: Queue<TreeNode> = LinkedList()
        val ans = ArrayList<Int>()
        var max = Int.MIN_VALUE
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            max = max.coerceAtLeast(node.`val`)
            node.left?.let { next.offer(it) }
            node.right?.let { next.offer(it) }
            if (queue.isEmpty()) {
                queue = next
                next = LinkedList()
                ans.add(max)
                max = Int.MIN_VALUE
            }
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}