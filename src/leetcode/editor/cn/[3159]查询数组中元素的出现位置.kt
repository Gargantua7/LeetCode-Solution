//给你一个整数数组 nums ，一个整数数组 queries 和一个整数 x 。 
//
// 对于每个查询 queries[i] ，你需要找到 nums 中第 queries[i] 个 x 的位置，并返回它的下标。如果数组中 x 的出现次数少于 
//queries[i] ，该查询的答案为 -1 。 
//
// 请你返回一个整数数组 answer ，包含所有查询的答案。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,3,1,7], queries = [1,3,2,4], x = 1 
// 
//
// 输出：[0,-1,2,-1] 
//
// 解释： 
//
// 
// 第 1 个查询，第一个 1 出现在下标 0 处。 
// 第 2 个查询，nums 中只有两个 1 ，所以答案为 -1 。 
// 第 3 个查询，第二个 1 出现在下标 2 处。 
// 第 4 个查询，nums 中只有两个 1 ，所以答案为 -1 。 
// 
//
// 示例 2： 
//
// 
// 输入：nums = [1,2,3], queries = [10], x = 5 
// 
//
// 输出：[-1] 
//
// 解释： 
//
// 
// 第 1 个查询，nums 中没有 5 ，所以答案为 -1 。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, queries.length <= 10⁵ 
// 1 <= queries[i] <= 10⁵ 
// 1 <= nums[i], x <= 10⁴ 
// 
//
// Related Topics 数组 哈希表 👍 23 👎 0


package leetcode.editor.cn

import kotlin.collections.toIntArray

/**
 * 3159
 * 查询数组中元素的出现位置
 * 
 * @author Gargantua丶
 * 2024-12-27 14:38:33
 */
private class FindOccurrencesOfAnElementInAnArray {	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun occurrencesOfElement(nums: IntArray, queries: IntArray, x: Int): IntArray {
        val list = nums.toList().mapIndexedNotNull { index, it ->
            if (it == x) index else null
        }
        return queries.map { list.getOrNull(it - 1)?: -1 }.toIntArray()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}