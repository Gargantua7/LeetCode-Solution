//给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。 
//
// 
//
// 注意：本题与主站 445 题相同：https://leetcode-cn.com/problems/add-two-numbers-ii/ 
// Related Topics 栈 链表 数学 👍 6 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 剑指 Offer II 025
 * 链表中的两数相加
 *
 * @author Gargantua丶
 * 2021-10-05 02:30:15
 */
class LMSNwu {
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
            val stack1: Deque<ListNode> = LinkedList()
            val stack2: Deque<ListNode> = LinkedList()
            var q = l1
            while (q != null) {
                stack1.push(q)
                q = q.next
            }
            q = l2
            while (q != null) {
                stack2.push(q)
                q = q.next
            }
            var p = ListNode(1)
            var plus = false
            while (stack1.isNotEmpty() || stack2.isNotEmpty()) {
                val sum = (if (stack1.isNotEmpty()) stack1.pop().`val` else 0) +
                        (if (stack2.isNotEmpty()) stack2.pop().`val` else 0) +
                                (if (plus) 1 else 0)
                p.`val` = sum % 10
                val temp = ListNode(1)
                temp.next = p
                p = temp
                plus = sum / 10 > 0
            }
            return if (plus) p else p.next
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}