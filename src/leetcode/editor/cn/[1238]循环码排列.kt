//给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足： 
//
// 
// p[0] = start 
// p[i] 和 p[i+1] 的二进制表示形式只有一位不同 
// p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同 
// 
//
// 
//
// 示例 1： 
//
// 输入：n = 2, start = 3
//输出：[3,2,0,1]
//解释：这个排列的二进制表示是 (11,10,00,01)
//     所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]
// 
//
// 示例 2： 
//
// 输出：n = 3, start = 2
//输出：[2,6,7,5,4,0,1,3]
//解释：这个排列的二进制表示是 (010,110,111,101,100,000,001,011)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 16 
// 0 <= start < 2^n 
// 
//
// Related Topics 位运算 数学 回溯 👍 51 👎 0


package leetcode.editor.cn

/**
 * 1238
 * 循环码排列
 *
 * @author Gargantua丶
 * 2023-02-23 00:44:34
 */
class CircularPermutationInBinaryRepresentation {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun circularPermutation(n: Int, start: Int): List<Int> {
        return (0 until (1 shl n)).map { it xor (it shr 1) xor start }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}