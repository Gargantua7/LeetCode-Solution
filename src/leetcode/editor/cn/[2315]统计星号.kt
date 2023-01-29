//给你一个字符串 s ，每 两个 连续竖线 '|' 为 一对 。换言之，第一个和第二个 '|' 为一对，第三个和第四个 '|' 为一对，以此类推。 
//
// 请你返回 不在 竖线对之间，s 中 '*' 的数目。 
//
// 注意，每个竖线 '|' 都会 恰好 属于一个对。 
//
// 
//
// 示例 1： 
//
// 输入：s = "l|*e*et|c**o|*de|"
//输出：2
//解释：不在竖线对之间的字符加粗加斜体后，得到字符串："l|*e*et|c**o|*de|" 。
//第一和第二条竖线 '|' 之间的字符不计入答案。
//同时，第三条和第四条竖线 '|' 之间的字符也不计入答案。
//不在竖线对之间总共有 2 个星号，所以我们返回 2 。 
//
// 示例 2： 
//
// 输入：s = "iamprogrammer"
//输出：0
//解释：在这个例子中，s 中没有星号。所以返回 0 。
// 
//
// 示例 3： 
//
// 输入：s = "yo|uar|e**|b|e***au|tifu|l"
//输出：5
//解释：需要考虑的字符加粗加斜体后："yo|uar|e**|b|e***au|tifu|l" 。不在竖线对之间总共有 5 个星号。所以我们返回 5 。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 只包含小写英文字母，竖线 '|' 和星号 '*' 。 
// s 包含 偶数 个竖线 '|' 。 
// 
//
// Related Topics 字符串 👍 36 👎 0


package leetcode.editor.cn

/**
 * 2315
 * 统计星号
 *
 * @author Gargantua丶
 * 2023-01-29 20:44:14
 */
class CountAsterisks {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun countAsterisks(s: String): Int {
        var flag = true
        var ans = 0
        s.forEach {
            when (it) {
                '|' -> flag = !flag
                '*' -> if (flag) ans++
            }
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}