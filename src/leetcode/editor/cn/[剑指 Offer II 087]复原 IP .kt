//给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "10203040"
//输出：["10.20.30.40","102.0.30.40","10.203.0.40"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
//
// 
//
// 注意：本题与主站 93 题相同：https://leetcode-cn.com/problems/restore-ip-addresses/ 
// Related Topics 字符串 回溯 👍 11 👎 0

package leetcode.editor.cn

/**
 * 剑指 Offer II 087
 * 复原 IP 	
 *
 * @author Gargantua丶
 * 2021-10-26 21:31:36
 */
class ZeroOn3uN { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun restoreIpAddresses(s: String): List<String> {
        val ans = ArrayList<String>()
        dfs(s, 0, 0, 0, StringBuilder(), ans)
        return ans
    }

    fun dfs(s: String, i: Int, curr: Int, point: Int, sb: StringBuilder, ans: ArrayList<String>) {
        if (i == s.length) {
            if (point == 3) ans.add(sb.toString())
            return
        }
        val c = s[i]
        if (curr == 0 && sb.isNotEmpty() && sb.last() == '0') {
            if (point == 3) return
            sb.append('.')
            dfs(s, i, 0, point + 1, sb, ans)
            sb.deleteCharAt(sb.lastIndex)
            return
        }
        if (curr * 10 + (c - '0') < 256) {
            sb.append(c)
            dfs(s, i + 1, curr * 10 + (c - '0'), point, sb, ans)
            sb.deleteCharAt(sb.lastIndex)
        }
        if (point < 3 && sb.isNotEmpty() && sb.last() != '.') {
            sb.append('.')
            dfs(s, i, 0, point + 1, sb, ans)
            sb.deleteCharAt(sb.lastIndex)
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}