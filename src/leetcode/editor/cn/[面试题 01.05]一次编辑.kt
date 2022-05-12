//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 双指针 字符串 👍 135 👎 0

package leetcode.editor.cn

/**
 * 面试题 01.05
 * 一次编辑
 * 
 * @author Gargantua丶
 * 2022-05-13 03:11:17
 */
class OneAwayLcci {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun oneEditAway(first: String, second: String): Boolean {
        if (first.length - second.length > 1 || first.length - second.length < -1) return false
        if (first == second) return true
        var i = 0
        var j = 0
        var count = 0
        while (i < first.length && j < second.length) {
            if (first[i] != second[j]) {
                if (count == 1) {
                    return false
                }
                if (first.length > second.length) {
                    i++
                } else if (first.length < second.length) {
                    j++
                } else {
                    i++
                    j++
                }
                count++
            } else {
                i++
                j++
            }
        }
        return true
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
