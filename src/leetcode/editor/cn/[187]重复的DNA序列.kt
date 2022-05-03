//所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复
//序列有时会对研究非常有帮助。 
//
// 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 10⁵ 
// s[i] 为 'A'、'C'、'G' 或 'T' 
// 
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 👍 209 👎 0


package leetcode.editor.cn
/**
 * 187
 * 重复的DNA序列
 *
 * @author Gargantua丶
 * 2021-10-08 00:54:08
 */
class RepeatedDnaSequences { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    val map = mapOf(
        'A' to 0,
        'T' to 1,
        'G' to 2,
        'C' to 3
    )

    fun findRepeatedDnaSequences(s: String): List<String> {
        if (s.length <= 10) return emptyList()
        val ans = ArrayList<String>()
        var temp = (0..8).fold(0) { t, i -> (t shl 2) or map[s[i]]!!}
        val count = HashMap<Int, Int>()
        for (i in 9..s.lastIndex) {
            temp = ((temp shl 2) or map[s[i]]!!) and ((1 shl 20) - 1)
            count[temp] = (count[temp]?: 0) + 1
            if (count[temp] == 2) ans += s.substring(i - 9..i)
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}