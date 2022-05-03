//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
// Related Topics 栈 数组 单调栈 👍 1633 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 84
 * 柱状图中最大的矩形
 *
 * @author Gargantua丶
 * 2021-11-20 12:33:41
 */
class LargestRectangleInHistogram {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun largestRectangleArea(heights: IntArray): Int {
            val stack: Deque<Int> = LinkedList()
            var max = 0
            IntArray(heights.size + 1) { if (it in heights.indices) heights[it] else 0 }.forEach { height ->
                if ((stack.peek() ?: -1) > height) {
                    var count = 0
                    while (stack.isNotEmpty()) {
                        val top = stack.peek()
                        if (top > height) {
                            max = max.coerceAtLeast(stack.pop() * ++count)
                        } else break
                    }
                    for (i in 1..count) {
                        stack.push(height)
                    }
                }
                stack.push(height)
            }
            return max
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}