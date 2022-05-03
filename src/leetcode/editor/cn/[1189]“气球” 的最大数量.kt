//给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。 
//
// 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：text = "nlaebolko"
//输出：1
// 
//
// 示例 2： 
//
// 
//
// 输入：text = "loonbalxballpoon"
//输出：2
// 
//
// 示例 3： 
//
// 输入：text = "leetcode"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 10^4 
// text 全部由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 👍 59 👎 0

package leetcode.editor.cn

/**
 * 1189
 * “气球” 的最大数量
 * 
 * @author Gargantua丶
 * 2022-02-13 00:11:03
 */
class MaximumNumberOfBalloons {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxNumberOfBalloons(text: String): Int {
        val count = IntArray(26)
        text.forEach { count[it - 'a']++ }
        return intArrayOf(count[1], count[0], count[11] / 2, count[14] / 2, count[13]).min()!!
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}

fun IntArray.min(): Int? {
    return minOrNull()
}
