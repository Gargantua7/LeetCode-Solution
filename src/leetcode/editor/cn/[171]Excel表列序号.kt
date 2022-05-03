//给定一个Excel表格中的列名称，返回其相应的列序号。 
//
// 例如， 
//
//     A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// 示例 1: 
//
// 输入: "A"
//输出: 1
// 
//
// 示例 2: 
//
// 输入: "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 输入: "ZY"
//输出: 701 
//
// 致谢： 
//特别感谢 @ts 添加此问题并创建所有测试用例。 
// Related Topics 数学 字符串 
// 👍 240 👎 0


package leetcode.editor.cn

import kotlin.math.pow


/**
 * 171
 * Excel表列序号
 *
 * @author Gargantua丶
 * 2021-07-30 00:12:06
 */
class ExcelSheetColumnNumber {
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun titleToNumber(columnTitle: String): Int {
            return columnTitle.foldIndexed(0) { i, ans, c ->
                ans + (c - 'A' + 1) * Math.pow(26.0, (columnTitle.lastIndex - i).toDouble()).toInt()
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}