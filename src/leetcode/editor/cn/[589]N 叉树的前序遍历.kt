//给定一个 n 叉树的根节点 root ，返回 其节点值的 前序遍历 。 
//
// n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。 
//
// 
//示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[1,3,5,6,2,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数在范围 [0, 10⁴]内 
// 0 <= Node.val <= 10⁴ 
// n 叉树的高度小于或等于 1000 
// 
//
// 
//
// 进阶：递归法很简单，你可以使用迭代法完成此题吗? 
// Related Topics 栈 树 深度优先搜索 👍 215 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 589
 * N 叉树的前序遍历
 *
 * @author Gargantua丶
 * 2022-03-10 01:27:49
 */
class NAryTreePreorderTraversal {
//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a Node.
     * class Node(var `val`: Int) {
     *     var children: List<Node?> = listOf()
     * }
     */

    class Solution {
        fun preorder(root: Node?): List<Int> {
            val stack = LinkedList(listOf(root?: return emptyList()))
            val res = ArrayList<Int>()
            while (stack.isNotEmpty()) {
                val node = stack.pop()
                res.add(node.`val`)
                node.children.asReversed().forEach(stack::push)
            }
            return res
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }
}
