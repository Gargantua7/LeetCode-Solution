//给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
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
//
// 
//
// 进阶：能尝试使用一趟扫描实现吗？ 
//
// 
//
// 注意：本题与主站 19 题相同： https://leetcode-cn.com/problems/remove-nth-node-from-end-
//of-list/ 
// Related Topics 链表 双指针 👍 5 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 剑指 Offer II 021
 * 删除链表的倒数第 n 个结点
 *
 * @author Gargantua丶
 * 2021-10-04 01:34:34
 */
class SLwz0R { 
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
        val queue: Queue<ListNode> = LinkedList()
        var p: ListNode? = new
        while (p != null) {
            queue.offer(p)
            if (queue.size > n + 1) {
                queue.poll()
            }
            p = p.next
        }
        val node = queue.poll()
        node.next = node.next?.next
        return new.next
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}