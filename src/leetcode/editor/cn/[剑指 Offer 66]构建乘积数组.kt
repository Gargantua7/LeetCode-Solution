//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// Related Topics 数组 前缀和 👍 148 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer 66
 * 构建乘积数组
 *
 * @author Gargantua丶
 * 2021-09-19 13:27:57
 */
class GouJianChengJiShuZuLcof { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun constructArr(a: IntArray): IntArray {
        if (a.isEmpty()) return a
        val b = IntArray(a.size)
        b[0] = 1
        var temp = 1
        for (i in 1..b.lastIndex) {
            b[i] = a[i - 1] * b[i - 1]
        }
        for (i in b.lastIndex - 1 downTo 0) {
            temp *= a[i + 1]
            b[i] *= temp
        }
        return b
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}