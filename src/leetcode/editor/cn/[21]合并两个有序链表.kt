//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 1857 👎 0


package leetcode.editor.cn

/**
 * 21
 * 合并两个有序链表
 *
 * @author Gargantua丶
 * 2021-08-21 00:28:35
 */
class MergeTwoSortedLists {
//leetcode submit region begin(Prohibit modification and deletion)
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

        fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
            var node1 = l1
            var node2 = l2
            val head = ListNode(0)
            var p = head
            while (node1 != null && node2 != null) {
                if (node1.`val` < node2.`val`) {
                    p.next = node1
                    p = node1
                    node1 = node1.next
                } else {
                    p.next = node2
                    p = node2
                    node2 = node2.next
                }
            }
            p.next = node1 ?: node2
            return head.next
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}