//给你两个整数 m 和 k ，以及数据流形式的若干整数。你需要实现一个数据结构，计算这个数据流的 MK 平均值 。 
//
// MK 平均值 按照如下步骤计算： 
//
// 
// 如果数据流中的整数少于 m 个，MK 平均值 为 -1 ，否则将数据流中最后 m 个元素拷贝到一个独立的容器中。 
// 从这个容器中删除最小的 k 个数和最大的 k 个数。 
// 计算剩余元素的平均值，并 向下取整到最近的整数 。 
// 
//
// 请你实现 MKAverage 类： 
//
// 
// MKAverage(int m, int k) 用一个空的数据流和两个整数 m 和 k 初始化 MKAverage 对象。 
// void addElement(int num) 往数据流中插入一个新的元素 num 。 
// int calculateMKAverage() 对当前的数据流计算并返回 MK 平均数 ，结果需 向下取整到最近的整数 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["MKAverage", "addElement", "addElement", "calculateMKAverage", "addElement", 
//"calculateMKAverage", "addElement", "addElement", "addElement", 
//"calculateMKAverage"]
//[[3, 1], [3], [1], [], [10], [], [5], [5], [5], []]
//输出：
//[null, null, null, -1, null, 3, null, null, null, 5]
//
//解释：
//MKAverage obj = new MKAverage(3, 1); 
//obj.addElement(3);        // 当前元素为 [3]
//obj.addElement(1);        // 当前元素为 [3,1]
//obj.calculateMKAverage(); // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
//obj.addElement(10);       // 当前元素为 [3,1,10]
//obj.calculateMKAverage(); // 最后 3 个元素为 [3,1,10]
//                          // 删除最小以及最大的 1 个元素后，容器为 [3]
//                          // [3] 的平均值等于 3/1 = 3 ，故返回 3
//obj.addElement(5);        // 当前元素为 [3,1,10,5]
//obj.addElement(5);        // 当前元素为 [3,1,10,5,5]
//obj.addElement(5);        // 当前元素为 [3,1,10,5,5,5]
//obj.calculateMKAverage(); // 最后 3 个元素为 [5,5,5]
//                          // 删除最小以及最大的 1 个元素后，容器为 [5]
//                          // [5] 的平均值等于 5/1 = 5 ，故返回 5
// 
//
// 
//
// 提示： 
//
// 
// 3 <= m <= 10⁵ 
// 1 <= k*2 < m 
// 1 <= num <= 10⁵ 
// addElement 与 calculateMKAverage 总操作次数不超过 10⁵ 次。 
// 
//
// Related Topics 设计 队列 数据流 有序集合 堆（优先队列） 👍 86 👎 0


package leetcode.editor.cn

import java.lang.NullPointerException
import java.util.*
import kotlin.collections.HashMap

/**
 * 1825
 * 求出 MK 平均值
 *
 * @author Gargantua丶
 * 2023-01-18 22:31:32
 */
class FindingMkAverage {
//leetcode submit region begin(Prohibit modification and deletion)
class MKAverage(val m: Int, val k: Int) {

    val queue = LinkedList<Int>()

    var moreSize = k
    var lessSize = k

    val more = PriorityQueue<Int>()
    val less = PriorityQueue<Int> { a, b -> b - a }
    val main = TreeMap<Int, Int>()
    val delMap = HashMap<Int, Int>()

    fun addElement(num: Int) {
        val size = queue.size
        if (size < m - 1) {
            main[num] = (main[num]?: 0) + 1
            queue.offer(num)
        } else if (size == m - 1) {
            main[num] = (main[num]?: 0) + 1
            queue.offer(num)
            transform()
        } else {
            val del = queue.poll()
            if (del >= more.peek()) {
                moreSize++
                delMap[del] = (delMap[del]?: 0) + 1
                val (max, count) = main.floorEntry(Int.MAX_VALUE)
                more.offer(max)
                if (count == 1) main.remove(count)
                else main[count] = count - 1
            } else if (del <= less.peek()) {
                lessSize++
                delMap[del] = (delMap[del]?: 0) + 1
                val (min, count) = main.ceilingEntry(0)
                less.offer(min)
                if (count == 1) main.remove(count)
                else main[count] = count - 1
            } else {
                val count = main[del]!!
                if (count == 1) main.remove(del)
                else main[del] = count - 1
            }

            queue.offer(num)
            if (num >= more.peek()) {
                val top = more.poll()
                if (top in delMap) {
                    if (delMap[top] == 1) delMap.remove(top)
                    else delMap[top] = delMap[top]!! - 1
                    moreSize--
                } else {
                    main[top] = (main[top]?: 0) + 1
                }
            }
        }
    }

    fun calculateMKAverage(): Int {
        val count = m - 2 * k
        var avg = 0.0
        main.forEach { (n, c) ->
            avg += c * (n.toDouble() / count.toDouble())
        }
        return kotlin.math.ceil(avg).toInt()
    }

    fun transform() {
        while (less.size < k) {
            val (min, count) = main.ceilingEntry(0)
            less.offer(min)
            if (count == 1) main.remove(count)
            else main[count] = count - 1
        }
        while (more.size < k) {
            val (max, count) = main.floorEntry(Int.MAX_VALUE)
            more.offer(max)
            if (count == 1) main.remove(count)
            else main[count] = count - 1
        }
    }

}

/**
 * Your MKAverage object will be instantiated and called as such:
 * var obj = MKAverage(m, k)
 * obj.addElement(num)
 * var param_2 = obj.calculateMKAverage()
 */
//leetcode submit region end(Prohibit modification and deletion)

}