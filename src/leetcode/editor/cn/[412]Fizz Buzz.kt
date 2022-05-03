//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
// Related Topics 数学 字符串 模拟 👍 107 👎 0


package leetcode.editor.cn

/**
 * 412
 * Fizz Buzz
 *
 * @author Gargantua丶
 * 2021-10-13 00:12:54
 */
class FizzBuzz {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun fizzBuzz(n: Int): List<String> {
            return (1..n).map {
                when (0) {
                    it % 15 -> "FizzBuzz"
                    it % 3 -> "Fizz"
                    it % 5 -> "Buzz"
                    else -> it.toString()
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}