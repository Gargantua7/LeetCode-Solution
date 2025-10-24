//如果整数 x 满足：对于每个数位 d ，这个数位 恰好 在 x 中出现 d 次。那么整数 x 就是一个 数值平衡数 。 
//
// 给你一个整数 n ，请你返回 严格大于 n 的 最小数值平衡数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：22
//解释：
//22 是一个数值平衡数，因为：
//- 数字 2 出现 2 次 
//这也是严格大于 1 的最小数值平衡数。
// 
//
// 示例 2： 
//
// 
//输入：n = 1000
//输出：1333
//解释：
//1333 是一个数值平衡数，因为：
//- 数字 1 出现 1 次。
//- 数字 3 出现 3 次。 
//这也是严格大于 1000 的最小数值平衡数。
//注意，1022 不能作为本输入的答案，因为数字 0 的出现次数超过了 0 。 
//
// 示例 3： 
//
// 
//输入：n = 3000
//输出：3133
//解释：
//3133 是一个数值平衡数，因为：
//- 数字 1 出现 1 次。
//- 数字 3 出现 3 次。 
//这也是严格大于 3000 的最小数值平衡数。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁶ 
// 
//
// Related Topics 哈希表 数学 回溯 计数 枚举 👍 91 👎 0


package leetcode.editor.cn

/*** 2048
* 下一个更大的数值平衡数
*
* @author Gargantua7
* 2025-10-24 20:18:33
*/
class NextGreaterNumericallyBalancedNumber {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun nextBeautifulNumber(n: Int): Int {
        if (n == 0) return 1

        val queue = ArrayDeque<Pair<String, IntArray>>()

        for (i in 1..6) {
            val count = IntArray(10)
            count[i]++
            queue.addLast(i.toString() to count)
        }

        while (queue.isNotEmpty()) {
            val (route, count) = queue.removeFirst()

            for (i in 1..6) {
                if (count[i] == i) continue
                val nextRoute = route + i
                val nextCount = count.copyOf()
                nextCount[i]++

                if (nextRoute.toInt() > n && nextCount.withIndex().all { (idx, v) -> v == 0 || idx == v }) {
                    return nextRoute.toInt()
                }

                queue.addLast(nextRoute to nextCount)
            }
        }

        return -1
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}