//给你一个正整数 n ，请你返回 n 的 惩罚数 。 
//
// n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和： 
//
// 
// 1 <= i <= n 
// i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：182
//解释：总共有 3 个整数 i 满足要求：
//- 1 ，因为 1 * 1 = 1
//- 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
//- 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
//因此，10 的惩罚数为 1 + 81 + 100 = 182
// 
//
// 示例 2： 
//
// 
//输入：n = 37
//输出：1478
//解释：总共有 4 个整数 i 满足要求：
//- 1 ，因为 1 * 1 = 1
//- 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
//- 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
//- 36 ，因为 36 * 36 = 1296 ，且 1296 可以分割成 1 + 29 + 6 。
//因此，37 的惩罚数为 1 + 81 + 100 + 1296 = 1478
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
//
// Related Topics 数学 回溯 👍 80 👎 0


package leetcode.editor.cn

/**
 * 2698
 * 求一个整数的惩罚数
 *
 * @author Gargantua丶
 * 2023-10-25 14:42:03
 */
class FindThePunishmentNumberOfAnInteger {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun punishmentNumber(n: Int): Int {
        var res = 0
        for (i in 1..n) {
            val s = (i * i).toString()
            if (dfs(s, 0, 0, i)) {
                res += i * i
            }
        }
        return res
    }

    fun dfs(s: String, pos: Int, tot: Int, target: Int): Boolean {
        if (pos == s.length) {
            return tot == target
        }
        var sum = 0
        for (i in pos until s.length) {
            sum = sum * 10 + s[i].code - '0'.code
            if (sum + tot > target) {
                break
            }
            if (dfs(s, i + 1, sum + tot, target)) {
                return true
            }
        }
        return false
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}