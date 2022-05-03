//给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i 
//+ 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,3,6]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,1,2,6]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [4,-2,2,-4]
//输出：true
//解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= arr.length <= 3 * 10⁴ 
// arr.length 是偶数 
// -10⁵ <= arr[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 哈希表 排序 👍 73 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 954
 * 二倍数对数组
 * 
 * @author Gargantua丶
 * 2022-04-01 03:19:45
 */
class ArrayOfDoubledPairs {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun canReorderDoubled(arr: IntArray): Boolean {
        return check(arr.filter { it > 0 }) && check(arr.filter { it < 0 }.map { -it })
    }

    fun check(arr: List<Int>): Boolean {
        if (arr.size and 1 == 1) return false
        val map = TreeMap<Int, Int>()
        arr.forEach { map[it] = (map[it]?: 0) + 1 }
        while (map.isNotEmpty()) {
            val (key, value) = map.ceilingEntry(0)
            val doubleKey = key * 2
            val doubleValue = map[doubleKey]?: 0
            if (value > doubleValue) return false
            map.remove(key)
            if (doubleValue == value) map.remove(doubleKey)
            else map[doubleKey] = doubleValue - value
        }
        return true
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
