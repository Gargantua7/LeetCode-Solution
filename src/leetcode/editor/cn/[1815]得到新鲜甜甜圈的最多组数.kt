//有一个甜甜圈商店，每批次都烤 batchSize 个甜甜圈。这个店铺有个规则，就是在烤一批新的甜甜圈时，之前 所有 甜甜圈都必须已经全部销售完毕。给你一个整
//数 batchSize 和一个整数数组 groups ，数组中的每个整数都代表一批前来购买甜甜圈的顾客，其中 groups[i] 表示这一批顾客的人数。每一位顾
//客都恰好只要一个甜甜圈。 
//
// 当有一批顾客来到商店时，他们所有人都必须在下一批顾客来之前购买完甜甜圈。如果一批顾客中第一位顾客得到的甜甜圈不是上一组剩下的，那么这一组人都会很开心。 
//
// 你可以随意安排每批顾客到来的顺序。请你返回在此前提下，最多 有多少组人会感到开心。 
//
// 
//
// 示例 1： 
//
// 
//输入：batchSize = 3, groups = [1,2,3,4,5,6]
//输出：4
//解释：你可以将这些批次的顾客顺序安排为 [6,2,4,5,1,3] 。那么第 1，2，4，6 组都会感到开心。
// 
//
// 示例 2： 
//
// 
//输入：batchSize = 4, groups = [1,3,2,5,2,2,1,6]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= batchSize <= 9 
// 1 <= groups.length <= 30 
// 1 <= groups[i] <= 10⁹ 
// 
//
// Related Topics 位运算 记忆化搜索 数组 动态规划 状态压缩 👍 41 👎 0


package leetcode.editor.cn

/**
 * 1815
 * 得到新鲜甜甜圈的最多组数
 *
 * @author Gargantua丶
 * 2023-01-22 01:07:56
 */
class MaximumNumberOfGroupsGettingFreshDonuts {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxHappyGroups(batchSize: Int, groups: IntArray): Int {
        var ans = 0
        val pool = IntArray(batchSize)
        groups.forEach {
            if (it % batchSize == 0) ans++
            else pool[it % batchSize]++
        }
        println("Init -> $ans")
        println(pool.contentToString())
        var target = batchSize
        var count = 2
        while (count <= batchSize && target <= pool.foldIndexed(0) { i, c, n -> c + i * n }) {
            println(target)
            while (match(pool, target, count)) {
                println(pool.contentToString())
                ans++
            }
            if (pool.foldIndexed(0) { i, c, n -> c + i * n } >= target + batchSize) {
                target += batchSize
            }
            count++
        }
        pool.forEach { if (it != 0) return ans + 1 }
        return ans
    }

    fun match(pool: IntArray, target: Int, count: Int): Boolean {
        if (count == 0) return false
        for (i in minOf(pool.lastIndex, target) downTo 0) {
            if (pool[i] != 0) {
                pool[i]--
                if (target == i || match(pool, target - i, count - 1)) {
                    return true
                }
                else pool[i]++
            }
        }
        return false
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}