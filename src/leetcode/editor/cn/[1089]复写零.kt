//给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。 
//
// 注意：请不要在超过该数组长度的位置写入元素。 
//
// 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。 
//
// 
//
// 示例 1： 
//
// 输入：[1,0,2,3,0,4,5,0]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
// 
//
// 示例 2： 
//
// 输入：[1,2,3]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10000 
// 0 <= arr[i] <= 9 
// 
// Related Topics 数组 双指针 👍 161 👎 0

package leetcode.editor.cn

/**
 * 1089
 * 复写零
 * 
 * @author Gargantua丶
 * 2022-06-17 12:58:24
 */
class DuplicateZeros {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun duplicateZeros(arr: IntArray) {
        val n = arr.size
        var top = 0
        var i = -1
        while (top < n) {
            i++
            if (arr[i] != 0) {
                top++
            } else {
                top += 2
            }
        }
        var j = n - 1
        if (top == n + 1) {
            arr[j] = 0
            j--
            i--
        }
        while (j >= 0) {
            arr[j] = arr[i]
            j--
            if (arr[i] == 0) {
                arr[j] = arr[i]
                j--
            }
            i--
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
