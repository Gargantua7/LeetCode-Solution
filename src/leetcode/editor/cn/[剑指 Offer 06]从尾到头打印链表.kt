//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 
// 👍 167 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 剑指 Offer 06
 * 从尾到头打印链表
 *
 * @author Gargantua丶
 * 2021-08-05 01:11:02
 */
class CongWeiDaoTouDaYinLianBiaoLcof { 
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
    fun reversePrint(head: ListNode?): IntArray {
        val stack = LinkedList<Int>()
        var p = head
        while (p != null) {
            stack.push(p.`val`)
            p = p.next
        }
        val ans = IntArray(stack.size)
        var index = 0
        while (stack.isNotEmpty()) ans[index++] = stack.pop()
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}