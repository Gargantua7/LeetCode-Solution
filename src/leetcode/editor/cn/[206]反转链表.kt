//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 1908 👎 0


package leetcode.editor.cn

/**
 * 206
 * 反转链表
 *
 * @author Gargantua丶
 * 2021-08-21 00:36:33
 */
class ReverseLinkedList {
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

        fun reverseList(head: ListNode?): ListNode? {
            var p = head
            var q: ListNode? = null
            var r: ListNode? = null
            while (p != null) {
                q?.next = r
                r = q
                q = p
                p = p.next
            }
            q?.next = r
            return q
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}