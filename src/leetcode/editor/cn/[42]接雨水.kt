//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 2510 👎 0


package leetcode.editor.cn

import java.util.*


/**
 * 42
 * 接雨水
 *
 * @author Gargantua丶
 * 2021-07-23 01:47:47
 */
class TrappingRainWater {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun trap(height: IntArray): Int {
            val stack: Deque<Int> = LinkedList()
            var ans = 0
            height.forEachIndexed { i, h ->
                while (stack.isNotEmpty() && h > height[stack.peek()]) {
                    val top = stack.pop()
                    val left = stack.peek()?: break
                    ans += (i - left - 1) * (kotlin.math.min(height[left], height[i]) - height[top])
                }
                stack.push(i)
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /** Double Point */
    fun trap(height: IntArray): Int {
        var ans = 0
        var left = 0
        var right = height.size - 1
        var leftMax = 0
        var rightMax = 0
        while (left < right) {
            leftMax = leftMax.coerceAtLeast(height[left])
            rightMax = rightMax.coerceAtLeast(height[right])
            if (height[left] < height[right]) {
                ans += leftMax - height[left]
                ++left
            } else {
                ans += rightMax - height[right]
                --right
            }
        }
        return ans
    }

}

