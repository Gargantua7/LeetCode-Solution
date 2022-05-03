//编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。 
//
// 注意：本题相对原题稍作修改 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 排序 
// 👍 25 👎 0


package leetcode.editor.cn

/**
 * 面试题 10.02
 * 变位词组
 *
 * @author Gargantua丶
 * 2021-07-18 00:07:27
 */
class GroupAnagramsLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val map = HashMap<String, ArrayList<String>>()
            strs.forEach { str ->
                val arr = IntArray(26)
                val sb = StringBuilder()
                str.forEach { ch -> arr[ch - 'a']++ }
                arr.forEachIndexed { i, item ->
                    sb.append("${'a' + i}$item")
                }
                val s = sb.toString()
                val list = map[s] ?: ArrayList()
                list.add(str)
                map[s] = list
            }
            val ans = ArrayList<List<String>>()
            map.forEach { (_, list) -> ans.add(list) }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}