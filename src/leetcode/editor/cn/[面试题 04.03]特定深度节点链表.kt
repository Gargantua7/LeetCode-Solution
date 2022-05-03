//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。 
//
// 
//
// 示例： 
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \ 
//      2    3
//     / \    \ 
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
// 
// Related Topics 树 广度优先搜索 链表 二叉树 👍 54 👎 0


package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList

/**
 * 面试题 04.03
 * 特定深度节点链表
 *
 * @author Gargantua丶
 * 2021-09-04 15:11:16
 */
class ListOfDepthLcci {
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
    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    class Solution {

        fun listOfDepth(tree: TreeNode?): Array<ListNode?> {
            tree ?: return emptyArray()
            val list = ArrayList<ListNode>()
            var queue: Queue<TreeNode> = LinkedList()
            var next: Queue<TreeNode> = LinkedList()
            list += arrayListOf(ListNode(tree.`val`))
            queue.offer(tree)
            val temp = ListNode(0)
            while (queue.isNotEmpty()) {
                val node = queue.poll()
                node.left?.let { next.offer(it) }
                node.right?.let { next.offer(it) }
                if (queue.isEmpty() && next.isNotEmpty()) {
                    queue = next
                    next = LinkedList()
                    var p = temp
                    queue.forEach {
                        p.next = ListNode(it.`val`)
                        p = p.next!!
                    }
                    list.add(temp.next!!)
                }
            }
            val ans = Array<ListNode?>(list.size) { null }
            return list.toArray(ans)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}