//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 6616 👎 0


package leetcode.editor.cn

/**
 * 2
 * 两数相加
 *
 * @author Gargantua丶
 * 2021-08-21 00:46:20
 */
class AddTwoNumbers {
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

        fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
            var node1 = l1
            var node2 = l2
            val ln = ListNode(0)
            var p: ListNode? = ln
            var n = 0
            while (node1 != null || node2 != null) {
                if (node1 != null) {
                    n += node1.`val`
                    node1 = node1.next
                }
                if (node2 != null) {
                    n += node2.`val`
                    node2 = node2.next
                }
                p!!.next = ListNode(n % 10)
                n = if (n >= 10) 1 else 0
                p = p.next
            }
            if (n == 1) p!!.next = ListNode(n)
            return ln.next
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}