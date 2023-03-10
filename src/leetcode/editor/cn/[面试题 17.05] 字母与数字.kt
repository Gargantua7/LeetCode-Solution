//给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。 
//
// 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。 
//
// 示例 1: 
//
// 
//输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K",
//"L","M"]
//
//输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
// 
//
// 示例 2: 
//
// 
//输入: ["A","A"]
//
//输出: []
// 
//
// 提示： 
//
// 
// array.length <= 100000 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 60 👎 0


package leetcode.editor.cn

/**
 * 面试题 17.05
 *  字母与数字
 *
 * @author Gargantua丶
 * 2023-03-11 00:21:03
 */
class FindLongestSubarrayLcci {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findLongestSubarray(array: Array<String>): Array<String> {
        val map = HashMap<Int, Int>()
        var prev = 0
        var start = 0
        var length = 0
        map[0] = -1
        array.forEachIndexed { i, s ->
            if (s.first().isDigit()) prev++ else prev--
            if (prev !in map) map[prev] = i
            else if (length < i - map[prev]!!) {
                length = i - map[prev]!!
                start = map[prev]!! + 1
            }
        }
        return Array(length) { array[start + it] }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}