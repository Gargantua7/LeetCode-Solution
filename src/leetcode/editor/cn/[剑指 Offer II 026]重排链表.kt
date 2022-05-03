//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// 
//
// 注意：本题与主站 143 题相同：https://leetcode-cn.com/problems/reorder-list/ 
// Related Topics 栈 递归 链表 双指针 👍 12 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer II 026
 * 重排链表
 *
 * @author Gargantua丶
 * 2021-10-05 02:52:39
 */
class LGjMqU { 
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
    fun reorderList(head: ListNode?): Unit {
        var fast = head
        var slow = head?: return
        while (fast != null) {
            fast = fast.next?.next
            if (fast == null) {
                val temp = slow
                if (slow.next != null)
                    slow = slow.next!!
                temp.next = null
                break
            }
            slow = slow.next!!
        }
        val reverse = reverseList(slow)
        var p: ListNode? = head
        var q = reverse
        while (p != null && q != null) {
            val nextP = p.next
            val nextQ = q.next
            p.next = q
            q.next = nextP
            p = nextP
            q = nextQ
        }
    }

    fun reverseList(head: ListNode?): ListNode? {
        var p = head
        var q: ListNode? = null
        while (p != null) {
            val count = p.next
            p.next = q
            q = p
            p = count
        }
        return q
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}