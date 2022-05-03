//两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。 
//
// 计算一个数组中，任意两个数之间汉明距离的总和。 
//
// 示例: 
//
// 
//输入: 4, 14, 2
//
//输出: 6
//
//解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
//所以答案为：
//HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 
//2 + 2 = 6.
// 
//
// 注意: 
//
// 
// 数组中元素的范围为从 0到 10^9。 
// 数组的长度不超过 10^4。 
// 
// Related Topics 位运算 
// 👍 188 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution477 {
    fun totalHammingDistance(nums: IntArray): Int {
        val n = nums.size
        var ans = 0
        if (n < 30)
            nums.indices.forEach { i ->
                (i until n).forEach { j ->
                    ans += Integer.bitCount(nums[i] xor nums[j])
                }
            }
        else
            (0 until 30).forEach { i ->
                var c = 0
                nums.forEach { it -> c += (it shr i) and 1 }
                ans += c * (n - c)
            }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)
