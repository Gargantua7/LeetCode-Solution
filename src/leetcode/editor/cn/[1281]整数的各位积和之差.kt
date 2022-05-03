//给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。 
//
// 
//
// 示例 1： 
//
// 输入：n = 234
//输出：15 
//解释：
//各位数之积 = 2 * 3 * 4 = 24 
//各位数之和 = 2 + 3 + 4 = 9 
//结果 = 24 - 9 = 15
// 
//
// 示例 2： 
//
// 输入：n = 4421
//输出：21
//解释： 
//各位数之积 = 4 * 4 * 2 * 1 = 32 
//各位数之和 = 4 + 4 + 2 + 1 = 11 
//结果 = 32 - 11 = 21
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^5 
// 
// Related Topics 数学 👍 75 👎 0

package leetcode.editor.cn

/**
 * 1281
 * 整数的各位积和之差
 * 
 * @author Gargantua丶
 * 2022-03-17 01:58:01
 */
class SubtractTheProductAndSumOfDigitsOfAnInteger {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun subtractProductAndSum(n: Int): Int {
        var t = n
        var pro = 1
        var sum = 0
        while(t > 0) {
            val i = t % 10
            pro *= i
            sum += i
            t /= 10
        }
        return pro - sum
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
