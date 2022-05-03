//用一个 非空 单链表来表示一个非负整数，然后将这个整数加一。 
//
// 你可以假设这个整数除了 0 本身，没有任何前导的 0。 
//
// 这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
// 
// Related Topics 链表 数学 👍 76 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 369
 * 给单链表加一	
 *
 * @author Gargantua丶
 * 2021-11-16 15:45:06
 */
class PlusOneLinkedList { 
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
    fun plusOne(head: ListNode?): ListNode? {
        head?: return null
        val stack: Deque<ListNode> = LinkedList()
        var temp: ListNode? = head
        while (temp != null) {
            stack.push(temp)
            temp = temp.next
        }
        while (stack.isNotEmpty()) {
            val node = stack.poll()
            if (node.`val` < 9) {
                node.`val`++
                return head
            }
            node.`val` = 0
        }
        val ans = ListNode(1)
        ans.next = head
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}