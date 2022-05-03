//给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "google"
//输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出：[["a"]  
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 131 题相同： https://leetcode-cn.com/problems/palindrome-partitioning/ 
// Related Topics 字符串 动态规划 回溯 👍 8 👎 0

package leetcode.editor.cn


/**
 * 剑指 Offer II 086
 * 分割回文子字符串
 *
 * @author Gargantua丶
 * 2021-10-26 21:22:59
 */
class M99OJA {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun partition(s: String): List<List<String>>? {
            val n = s.length
            val f = Array(n) { IntArray(n) }
            val ret = ArrayList<List<String>>()
            val ans = ArrayList<String>()
            dfs(s, 0, f, ans, ret)
            return ret
        }

        fun dfs(s: String, i: Int, f: Array<IntArray>, ans: ArrayList<String>, ret: ArrayList<List<String>>) {
            if (i == f.size) {
                ret.add(ArrayList(ans))
                return
            }
            for (j in i until f.size) {
                if (isPalindrome(s, i, j, f) == 1) {
                    ans.add(s.substring(i..j))
                    dfs(s, j + 1, f, ans, ret)
                    ans.removeAt(ans.size - 1)
                }
            }
        }

        fun isPalindrome(s: String, i: Int, j: Int, f: Array<IntArray>): Int {
            if (f[i][j] != 0) {
                return f[i][j]
            }
            if (i >= j) {
                f[i][j] = 1
            } else if (s[i] == s[j]) {
                f[i][j] = isPalindrome(s, i + 1, j - 1, f)
            } else {
                f[i][j] = -1
            }
            return f[i][j]
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}