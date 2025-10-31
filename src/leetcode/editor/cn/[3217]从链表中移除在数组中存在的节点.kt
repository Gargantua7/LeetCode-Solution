//给你一个整数数组 nums 和一个链表的头节点 head。从链表中移除所有存在于 nums 中的节点后，返回修改后的链表的头节点。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,2,3], head = [1,2,3,4,5] 
// 
//
// 输出： [4,5] 
//
// 解释： 
//
// 
//
// 移除数值为 1, 2 和 3 的节点。 
//
// 示例 2： 
//
// 
// 输入： nums = [1], head = [1,2,1,2,1,2] 
// 
//
// 输出： [2,2,2] 
//
// 解释： 
//
// 
//
// 移除数值为 1 的节点。 
//
// 示例 3： 
//
// 
// 输入： nums = [5], head = [1,2,3,4] 
// 
//
// 输出： [1,2,3,4] 
//
// 解释： 
//
// 
//
// 链表中不存在值为 5 的节点。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// nums 中的所有元素都是唯一的。 
// 链表中的节点数在 [1, 10⁵] 的范围内。 
// 1 <= Node.val <= 10⁵ 
// 输入保证链表中至少有一个值没有在 nums 中出现过。 
// 
//
// Related Topics 数组 哈希表 链表 👍 24 👎 0


package leetcode.editor.cn

/*** 3217
* 从链表中移除在数组中存在的节点
*
* @author Gargantua7
* 2025-11-01 01:57:37
*/
class DeleteNodesFromLinkedListPresentInArray {
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
    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
        val set = nums.toSet()
        var newHead = head
        var curr = head
        var prev: ListNode? = null

        while (curr != null) {
            val value = curr.`val`
            if (value !in set) {
                if (prev == null) {
                    newHead = curr
                } else {
                    prev.next = curr
                }
                prev = curr
            }
            curr = curr.next
        }

        prev?.next = null

        return newHead
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}