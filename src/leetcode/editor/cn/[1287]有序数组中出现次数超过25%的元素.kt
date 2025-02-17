//给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。 
//
// 请你找到并返回这个整数 
//
// 
//
// 示例： 
//
// 
//输入：arr = [1,2,2,6,6,6,6,7,10]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^4 
// 0 <= arr[i] <= 10^5 
// 
//
// Related Topics 数组 👍 106 👎 0


package leetcode.editor.cn

/**
 * 1287
 * 有序数组中出现次数超过25%的元素
 * 
 * @author Gargantua丶
 * 2025-02-17 16:11:56
 */
private class ElementAppearingMoreThan25InSortedArray {	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findSpecialInteger(arr: IntArray): Int {
        return arr[arr.indices.find { arr[it] == arr[it + arr.size / 4] }!!]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}