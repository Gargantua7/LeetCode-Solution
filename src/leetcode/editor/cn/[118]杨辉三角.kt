//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 
// 👍 533 👎 0


package leetcode.editor.cn
/**
 * 118
 * 杨辉三角
 *
 * @author Gargantua丶
 * 2021-07-26 00:49:09
 */
class PascalsTriangle { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        return ArrayList<ArrayList<Int>>().apply {
            add(arrayListOf(1))
            for (i in 1 until numRows) {
                val lastList = this[i - 1]
                add(ArrayList<Int>().apply {
                    add(0, 1)
                    for (j in 1 until i) {
                        add(j, lastList[j] + lastList[j - 1])
                    }
                    add(i, 1)
                })
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}