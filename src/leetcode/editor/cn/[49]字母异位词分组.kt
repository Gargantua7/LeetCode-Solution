//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 排序 👍 816 👎 0


package leetcode.editor.cn

/**
 * 49
 * 字母异位词分组
 *
 * @author Gargantua丶
 * 2021-08-19 01:23:52
 */
class GroupAnagrams {

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val arr = arrayOf(
                2.0, 3.0, 5.0, 7.0, 11.0, 13.0, 17.0, 19.0, 23.0, 29.0, 31.0, 37.0, 41.0, 43.0, 47.0, 53.0, 59.0, 61.0,
                67.0, 71.0, 73.0, 79.0, 83.0, 89.0, 97.0, 101.0
            )
            val map = HashMap<Double, ArrayList<String>>()
            strs.forEach { str ->
                val temp = str.fold(1.0) { ans, c -> ans * arr[c - 'a'] }
                map[temp]?: run { map[temp] = ArrayList() }
                map[temp]!! += str
            }
            return map.map { (_, v) -> v }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}