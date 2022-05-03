//请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
// Related Topics 栈 数组 单调栈 👍 930 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 739
 * 每日温度	
 *
 * @author Gargantua丶
 * 2021-11-18 15:03:55
 */
class DailyTemperatures { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val ans = IntArray(temperatures.size)
        val stack: Deque<Pair<Int, Int>> = LinkedList()
        temperatures.forEachIndexed { i, temp ->
            while ((stack.peek()?.second?: 1000) < temp) {
                val (index) = stack.pop()
                ans[index] = i - index
            }
            stack.push(i to temp)
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}