//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 👍 1023 👎 0


package leetcode.editor.cn

/**
 * 92
 * 反转链表 II
 *
 * @author Gargantua丶
 * 2021-09-14 15:58:34
 */
class ReverseLinkedListIi {
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

        fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
            if (left == right) return head
            var curr = 0
            val new = ListNode(0)
            new.next = head ?: return null
            var p: ListNode? = new
            var q = p
            var temp: ListNode? = null
            while (p != null) {
                when (curr++) {
                    left - 1 -> {
                        temp = p
                        q = p
                        p = p.next
                    }
                    in left + 1 until right -> {
                        val next = p.next
                        p.next = q
                        q = p
                        p = next
                    }
                    right -> {
                        temp?.next?.next = p.next
                        temp?.next = p
                        p.next = q
                        return new.next
                    }
                    else -> {
                        q = p
                        p = p.next
                    }
                }
            }
            return new.next
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}