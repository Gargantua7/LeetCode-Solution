//在一个社交圈子当中，有 N 个人。每个人都有一个从 0 到 N-1 唯一的 id 编号。 
//
// 我们有一份日志列表 logs，其中每条记录都包含一个非负整数的时间戳，以及分属两个人的不同 id，logs[i] = [timestamp, id_A, 
//id_B]。 
//
// 每条日志标识出两个人成为好友的时间，友谊是相互的：如果 A 和 B 是好友，那么 B 和 A 也是好友。 
//
// 如果 A 是 B 的好友，或者 A 是 B 的好友的好友，那么就可以认为 A 也与 B 熟识。 
//
// 返回圈子里所有人之间都熟识的最早时间。如果找不到最早时间，就返回 -1 。 
//
// 
//
// 示例： 
//
// 输入：logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190
//224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], N = 6
//输出：20190301
//解释：
//第一次结交发生在 timestamp = 20190101，0 和 1 成为好友，社交朋友圈如下 [0,1], [2], [3], [4], [5]。
//第二次结交发生在 timestamp = 20190104，3 和 4 成为好友，社交朋友圈如下 [0,1], [2], [3,4], [5].
//第三次结交发生在 timestamp = 20190107，2 和 3 成为好友，社交朋友圈如下 [0,1], [2,3,4], [5].
//第四次结交发生在 timestamp = 20190211，1 和 5 成为好友，社交朋友圈如下 [0,1,5], [2,3,4].
//第五次结交发生在 timestamp = 20190224，2 和 4 已经是好友了。
//第六次结交发生在 timestamp = 20190301，0 和 3 成为好友，大家都互相熟识了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 100 
// 1 <= logs.length <= 10^4 
// 0 <= logs[i][0] <= 10^9 
// 0 <= logs[i][1], logs[i][2] <= N - 1 
// 保证 logs[i][0] 中的所有时间戳都不同 
// Logs 不一定按某一标准排序 
// logs[i][1] != logs[i][2] 
// 
// Related Topics 并查集 数组 👍 19 👎 0

package leetcode.editor.cn

/**
 * 1101
 * 彼此熟识的最早时间
 * 
 * @author Gargantua丶
 * 2021-11-29 16:42:46
 */
class TheEarliestMomentWhenEveryoneBecomeFriends {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun earliestAcq(logs: Array<IntArray>, n: Int): Int {
        logs.sortBy { it.first() }
        val uf = UnionFind(n)
        logs.forEach { (time, a, b) ->
            uf.union(a, b)
            if (uf.count == 1) return time
        }
        return -1
    }

    class UnionFind(val n: Int) {
        val parent = IntArray(n) { it }
        val size = IntArray(n) { 1 }
        var count = n

        operator fun get(i: Int): Int = if (parent[i] == i) i else run {
            parent[i] = this[parent[i]]
            parent[i]
        }

        fun union(i: Int, j: Int): Boolean {
            var x = this[i]
            var y = this[j]
            if (x == y) return false
            if (size[x] < size[y]) {
                val temp = x
                x = y
                y = temp
            }
            parent[y] = x
            size[x] += size[y]
            count--
            return true
        }

        operator fun get(i: Int, j: Int) = this[i] == this[j]

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}