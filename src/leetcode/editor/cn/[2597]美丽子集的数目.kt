//给你一个由正整数组成的数组 nums 和一个 正 整数 k 。 
//
// 如果 nums 的子集中，任意两个整数的绝对差均不等于 k ，则认为该子数组是一个 美丽 子集。 
//
// 返回数组 nums 中 非空 且 美丽 的子集数目。 
//
// nums 的子集定义为：可以经由 nums 删除某些元素（也可能不删除）得到的一个数组。只有在删除元素时选择的索引不同的情况下，两个子集才会被视作是不同的
//子集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,4,6], k = 2
//输出：4
//解释：数组 nums 中的美丽子集有：[2], [4], [6], [2, 6] 。
//可以证明数组 [2,4,6] 中只存在 4 个美丽子集。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：1
//解释：数组 nums 中的美丽数组有：[1] 。
//可以证明数组 [1] 中只存在 1 个美丽子集。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 18 
// 1 <= nums[i], k <= 1000 
// 
//
// Related Topics 数组 哈希表 数学 动态规划 回溯 组合数学 排序 👍 70 👎 0


package leetcode.editor.cn


/**
 * 2597
 * 美丽子集的数目
 * 
 * @author Gargantua丶
 * 2025-03-07 14:33:36
 */
private class TheNumberOfBeautifulSubsets {	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun beautifulSubsets(nums: IntArray, mod: Int): Int {

        return nums
            .groupBy { it % mod }
            .values.map {
                it.groupingBy { it }
                    .eachCount()
                    .mapValues { ( _, v) ->
                        2.pow(v) - 1
                    }
                    .entries.sortedBy { it.key }
            }.fold(1) { count, map ->
                var (prev, y) = map.first()
                var n = 1

                for (i in 1..map.lastIndex) {
                    val (k, v) = map[i]
                    val (p, np) = if (k - prev == mod) {
                        v * n to n + y
                    } else {
                        v * (n + y) to n + y
                    }
                    y = p
                    n = np
                    prev = k
                }

                count * (y + n)
            } - 1

    }

    fun Int.pow(n: Int): Int = Math.pow(this.toDouble(), n.toDouble()).toInt()

}
//leetcode submit region end(Prohibit modification and deletion)
}

fun main() {
    TheNumberOfBeautifulSubsets.Solution().beautifulSubsets(intArrayOf(10,4,5,7,2,1), 3)
}