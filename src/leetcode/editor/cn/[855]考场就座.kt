//在考场里，有 n 个座位排成一行，编号为 0 到 n - 1。 
//
// 当学生进入考场后，他必须坐在离最近的人最远的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上
//。) 
//
// 设计一个模拟所述考场的类。 
//
// 实现 ExamRoom 类： 
//
// 
// ExamRoom(int n) 用座位的数量 n 初始化考场对象。 
// int seat() 返回下一个学生将会入座的座位编号。 
// void leave(int p) 指定坐在座位 p 的学生将离开教室。保证座位 p 上会有一位学生。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["ExamRoom", "seat", "seat", "seat", "seat", "leave", "seat"]
//[[10], [], [], [], [], [4], []]
//输出：
//[null, 0, 9, 4, 2, null, 5]
//解释：
//ExamRoom examRoom = new ExamRoom(10);
//examRoom.seat(); // 返回 0，房间里没有人，学生坐在 0 号座位。
//examRoom.seat(); // 返回 9，学生最后坐在 9 号座位。
//examRoom.seat(); // 返回 4，学生最后坐在 4 号座位。
//examRoom.seat(); // 返回 2，学生最后坐在 2 号座位。
//examRoom.leave(4);
//examRoom.seat(); // 返回 5，学生最后坐在 5 号座位。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 保证有学生正坐在座位 p 上。 
// seat 和 leave 最多被调用 10⁴ 次。 
// 
//
// Related Topics 设计 有序集合 堆（优先队列） 👍 288 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 855
 * 考场就座
 *
 * @author Gargantua丶
 * 2024-12-23 15:53:33
 */
private class ExamRoom {
//leetcode submit region begin(Prohibit modification and deletion)
class ExamRoom(private val n: Int) {

    val set = TreeSet(compareBy<Pair<Int, Int>> { range -> -range.length / 2 }.thenBy { it.first })
    val cache = TreeSet<Int>()

    fun seat(): Int {

        if (cache.isEmpty()) {
            return 0.also(cache::add)
        }

        val firstRange = 0 to cache.first()
        val lastRange = cache.last() to n - 1

        var (seat, maxRange) = if (firstRange.length >= lastRange.length) {
            0 to firstRange
        } else {
            n - 1 to lastRange
        }

        set.firstOrNull()?.let { range ->
            val (left, right) = range
            val midLength = range.length / 2
            val midPoint = left + midLength
            if (midLength > maxRange.length || (midLength == maxRange.length && midPoint < seat)) {
                seat = midPoint
                maxRange = range
            }
        }

        if (seat == 0) set += 0 to cache.first()
        else if (seat == n - 1) set += cache.last() to n - 1
        else {
            set -= maxRange
            set += maxRange.first to seat
            set += seat to maxRange.second
        }

        return seat.also(cache::add)
    }

    fun leave(p: Int) {

        cache -= p

        val prev = cache.floor(p)?.also {
            set -= it to p
        }

        val next = cache.ceiling(p)?.also {
            set -= p to it
        }

        if (prev != null && next != null) {
            set += prev to next
        }
    }

    private val Pair<Int, Int>.length inline get() = second - first

}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * var obj = ExamRoom(n)
 * var param_1 = obj.seat()
 * obj.leave(p)
 */
//leetcode submit region end(Prohibit modification and deletion)

}