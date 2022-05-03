//给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
// Related Topics 双指针 字符串 👍 140 👎 0


package leetcode.editor.cn

/**
 * 541
 * 反转字符串 II
 *
 * @author Gargantua丶
 * 2021-08-20 00:23:17
 */
class ReverseStringIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun reverseStr(s: String, k: Int): String {
            val arr = s.toCharArray()
            for (i in arr.indices step 2 * k) {
                println(i)
                if (i + k < arr.size) arr.reverse(i, i + k)
                else arr.reverse(i, arr.size)
            }
            return String(arr)
        }

        fun CharArray.reverse(fromIndex: Int, toIndex: Int) {
            val midPoint = (fromIndex + toIndex) / 2
            if (fromIndex == midPoint) return
            var reverseIndex = toIndex - 1
            for (index in fromIndex until midPoint) {
                val tmp = this[index]
                this[index] = this[reverseIndex]
                this[reverseIndex] = tmp
                reverseIndex--
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}