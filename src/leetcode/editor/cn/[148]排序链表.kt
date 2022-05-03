//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
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
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1366 👎 0

package leetcode.editor.cn

/**
 * 148
 * 排序链表	
 *
 * @author Gargantua丶
 * 2021-11-16 15:53:17
 */
class SortList { 
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
    fun sortList(head: ListNode?): ListNode? {
        if (head == null) {
            return head
        }
        var length = 0
        var node = head
        while (node != null) {
            length++
            node = node.next
        }
        val dummyHead = ListNode(0)
        dummyHead.next = head
        var subLength = 1
        while (subLength < length) {
            var prev: ListNode? = dummyHead
            var curr = dummyHead.next
            while (curr != null) {
                val head1: ListNode = curr
                run {
                    var i = 1
                    while (i < subLength && curr!!.next != null) {
                        curr = curr!!.next
                        i++
                    }
                }
                val head2 = curr!!.next
                curr!!.next = null
                curr = head2
                var i = 1
                while (i < subLength && curr != null && curr!!.next != null) {
                    curr = curr!!.next
                    i++
                }
                var next: ListNode? = null
                if (curr != null) {
                    next = curr!!.next
                    curr!!.next = null
                }
                val merged = merge(head1, head2)
                prev!!.next = merged
                while (prev!!.next != null) {
                    prev = prev.next
                }
                curr = next
            }
            subLength = subLength shl 1
        }
        return dummyHead.next
    }

    fun merge(head1: ListNode?, head2: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        var temp: ListNode? = dummyHead
        var temp1 = head1
        var temp2 = head2
        while (temp1 != null && temp2 != null) {
            if (temp1.`val` <= temp2.`val`) {
                temp!!.next = temp1
                temp1 = temp1.next
            } else {
                temp!!.next = temp2
                temp2 = temp2.next
            }
            temp = temp.next
        }
        if (temp1 != null) {
            temp!!.next = temp1
        } else if (temp2 != null) {
            temp!!.next = temp2
        }
        return dummyHead.next
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}