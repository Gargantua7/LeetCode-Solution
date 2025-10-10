//一个魔法师有许多不同的咒语。 
//
// 给你一个数组 power ，其中每个元素表示一个咒语的伤害值，可能会有多个咒语有相同的伤害值。 
//
// 已知魔法师使用伤害值为 power[i] 的咒语时，他们就 不能 使用伤害为 power[i] - 2 ，power[i] - 1 ，power[i] +
// 1 或者 power[i] + 2 的咒语。 
//
// 每个咒语最多只能被使用 一次 。 
//
// 请你返回这个魔法师可以达到的伤害值之和的 最大值 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：power = [1,1,3,4] 
// 
//
// 输出：6 
//
// 解释： 
//
// 可以使用咒语 0，1，3，伤害值分别为 1，1，4，总伤害值为 6 。 
//
// 示例 2： 
//
// 
// 输入：power = [7,1,6,6] 
// 
//
// 输出：13 
//
// 解释： 
//
// 可以使用咒语 1，2，3，伤害值分别为 1，6，6，总伤害值为 13 。 
//
// 
//
// 提示： 
//
// 
// 1 <= power.length <= 10⁵ 
// 1 <= power[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 动态规划 计数 排序 👍 65 👎 0


package leetcode.editor.cn

import java.util.LinkedList
import java.util.TreeMap

/*** 3186
* 施咒的最大总伤害
*
* @author Gargantua7
* 2025-10-11 01:12:14
*/
class MaximumTotalDamageWithSpellCasting {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maximumTotalDamage(power: IntArray): Long {
        val map = power.toList().groupingBy { it }.eachCount().let(::TreeMap)
        val queue = ArrayDeque<Triple<Int, Long, Long>>()

        map.forEach { (pow, count) ->
            val use = queue.lastOrNull { (v, _, _) -> pow - v > 2 }?.let { maxOf(it.second, it.third) } ?: 0
            val notUse = queue.lastOrNull()?.let { maxOf(it.second, it.third) } ?: 0

            val tri = Triple(pow, use + pow.toLong() * count.toLong(), notUse)
            queue.addLast(tri)
            if (queue.size > 3) queue.removeFirst()
        }

        return queue.last().let { maxOf(it.second, it.third) }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}