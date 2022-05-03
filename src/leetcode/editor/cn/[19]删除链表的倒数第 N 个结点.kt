//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1506 👎 0


package leetcode.editor.cn

/**
 * 19
 * 删除链表的倒数第 N 个结点
 *
 * @author Gargantua丶
 * 2021-08-16 00:51:28
 */
class RemoveNthNodeFromEndOfList {
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

        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            val new = ListNode(0)
            new.next = head
            var first = head
            var second = new
            for (i in 1..n) first = first?.next
            while (first != null) {
                first = first.next
                second = second.next!!
            }
            second.next = second.next?.next
            return new.next
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}