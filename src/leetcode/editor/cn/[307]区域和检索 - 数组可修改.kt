//给你一个数组 nums ，请你完成两类查询。 
//
// 
// 其中一类查询要求 更新 数组 nums 下标对应的值 
// 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right 
// 
//
// 实现 NumArray 类： 
//
// 
// NumArray(int[] nums) 用整数数组 nums 初始化对象 
// void update(int index, int val) 将 nums[index] 的值 更新 为 val 
// int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元
//素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]） 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["NumArray", "sumRange", "update", "sumRange"]
//[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
//输出：
//[null, 9, null, 8]
//
//解释：
//NumArray numArray = new NumArray([1, 3, 5]);
//numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
//numArray.update(1, 2);   // nums = [1,2,5]
//numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -100 <= nums[i] <= 100 
// 0 <= index < nums.length 
// -100 <= val <= 100 
// 0 <= left <= right < nums.length 
// 调用 pdate 和 sumRange 方法次数不大于 3 * 10⁴ 
// 
// Related Topics 设计 树状数组 线段树 数组 👍 359 👎 0

package leetcode.editor.cn

/**
 * 307
 * 区域和检索 - 数组可修改
 * 
 * @author Gargantua丶
 * 2022-04-04 02:06:45
 */
class RangeSumQueryMutable {
//leetcode submit region begin(Prohibit modification and deletion)
class NumArray(val nums: IntArray) {

    private val segmentTree = IntArray(nums.size * 4)
    private val n = nums.size

    init {
        build(0, 0, n - 1, nums)
    }

    fun update(index: Int, `val`: Int) {
        change(index, `val`, 0, 0, n - 1)
    }

    fun sumRange(left: Int, right: Int): Int {
        return range(left, right, 0, 0, n - 1)
    }

    private fun build(node: Int, s: Int, e: Int, nums: IntArray) {
        if (s == e) {
            segmentTree[node] = nums[s]
            return
        }
        val m = s + (e - s) / 2
        build(node * 2 + 1, s, m, nums)
        build(node * 2 + 2, m + 1, e, nums)
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2]
    }

    private fun change(index: Int, `val`: Int, node: Int, s: Int, e: Int) {
        if (s == e) {
            segmentTree[node] = `val`
            return
        }
        val m = s + (e - s) / 2
        if (index <= m) {
            change(index, `val`, node * 2 + 1, s, m)
        } else {
            change(index, `val`, node * 2 + 2, m + 1, e)
        }
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2]
    }

    private fun range(left: Int, right: Int, node: Int, s: Int, e: Int): Int {
        if (left == s && right == e) {
            return segmentTree[node]
        }
        val m = s + (e - s) / 2
        return if (right <= m) {
            range(left, right, node * 2 + 1, s, m)
        } else if (left > m) {
            range(left, right, node * 2 + 2, m + 1, e)
        } else {
            range(left, m, node * 2 + 1, s, m) + range(m + 1, right, node * 2 + 2, m + 1, e)
        }
    }


}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * obj.update(index,`val`)
 * var param_2 = obj.sumRange(left,right)
 */
//leetcode submit region end(Prohibit modification and deletion)

}
