//给定一个链表的 头节点 head ，请判断其是否为回文链表。 
//
// 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [1,2,3,3,2,1]
//输出: true 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [1,2]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 链表 L 的长度范围为 [1, 10⁵] 
// 0 <= node.val <= 9 
// 
//
// 
//
// 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// 
//
// 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/ 
// Related Topics 栈 递归 链表 双指针 👍 6 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer II 027
 * 回文链表
 *
 * @author Gargantua丶
 * 2021-10-06 21:21:51
 */
class AMhZSa { 
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
    fun isPalindrome(head: ListNode?): Boolean {
        var fast = head
        var slow = head?: return true
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
            if(p.`val` != q.`val`) return false
            p = p.next
            q = q.next
        }
        return true
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