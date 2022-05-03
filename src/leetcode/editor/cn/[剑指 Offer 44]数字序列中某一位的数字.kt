//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 二分查找 👍 173 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer 44
 * 数字序列中某一位的数字
 *
 * @author Gargantua丶
 * 2021-09-27 13:25:50
 */
class ShuZiXuLieZhongMouYiWeiDeShuZiLcof {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun findNthDigit(n: Int): Int {
            if (n < 10) return n
            var temp = n.toLong() - 1
            var curr = 9L
            var i = 1
            while (temp >= (curr * i)) {
                temp -= curr * i
                curr *= 10
                i++
            }
            val start = curr / 9L
            val target = (start + temp / i).toString()[(temp % i).toInt()]
            return target - '0'
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}