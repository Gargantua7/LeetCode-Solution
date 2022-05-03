//给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。 
//
// 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。 
//
// 在执行完所有删除操作后，返回最终得到的字符串。 
//
// 本题答案保证唯一。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abcd", k = 2
//输出："abcd"
//解释：没有要删除的内容。 
//
// 示例 2： 
//
// 输入：s = "deeedbbcccbdaa", k = 3
//输出："aa"
//解释： 
//先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
//再删除 "bbb"，得到 "dddaa"
//最后删除 "ddd"，得到 "aa" 
//
// 示例 3： 
//
// 输入：s = "pbbcggttciiippooaais", k = 2
//输出："ps"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// 2 <= k <= 10^4 
// s 中只含有小写英文字母。 
// 
// Related Topics 栈 字符串 
// 👍 101 👎 0


package leetcode.editor.cn


/**
 * 1209
 * 删除字符串中的所有相邻重复项 II
 *
 * @author Gargantua丶
 * 2021-08-07 22:33:36
 */
class RemoveAllAdjacentDuplicatesInStringIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun removeDuplicates(s: String, k: Int): String {
            val str = StringBuilder()
            var last = s[0]
            var num = 0
            for (c in 1..s.lastIndex) {
                if (s[c] == last) {
                    num++
                } else {
                    for (i in 0..num) {
                        str.append(last)
                        if (i == 1) break
                    }
                    last = s[c]
                    num = 0
                }
            }
            for (i in 0..num) {
                str.append(last)
                if (i == 1) break
            }
            return str.toString()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    fun checkMove(board: Array<CharArray>, rMove: Int, cMove: Int, color: Char): Boolean {
        val map = arrayOf(
            arrayOf(-1, -1), arrayOf(0, -1), arrayOf(1, -1), arrayOf(-1, 0), arrayOf(1, 0), arrayOf(-1, 1),
            arrayOf(0, 1), arrayOf(1, 1)
        )
        for (m in map) {
            var rCurr = rMove
            var cCurr = cMove
            rCurr += m[0]
            cCurr += m[1]
            if (rCurr !in 0..7 || cCurr !in 0..7) continue
            var value = board[rCurr][cCurr]
            if (value == '.') continue
            if (value == color) continue
            while (true) {
                rCurr += m[0]
                cCurr += m[1]
                if (rCurr !in 0..7 || cCurr !in 0..7) break
                value = board[rCurr][cCurr]
                if (value == '0') break
                if (value == color) return true
            }
        }
        return false
    }


}

fun maxProduct(s: String): Long {
    val str = findMax(s)
    val index = s.indexOf(str)
    val sec = findMax(s.removeRange(index, index + str.length))
    return str.length.toLong() * sec.length.toLong()
}

fun findMax(s: String): String {
    var max = 1
    var maxIndex = 0
    for (i in 1 until s.lastIndex) {
        var left = i - 1
        var right = i + 1
        var num = 1
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            num += 2
            left--
            right++
        }
        if (max < num) {
            max = num
            maxIndex = i - (max - 1) / 2
        }
    }
    return s.substring(maxIndex, max + maxIndex)
}
