package leetcode.editor.cn.weekly

import java.util.*

/**
 * @author Gargantua丶
 **/
class Weekly253 {

    /** 5839 */
    fun minStoneSum(piles: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int> { a, b -> b - a }
        piles.forEach { queue.add(it) }
        for (i in 1..k) {
            val value = queue.poll()
            queue.add(value - value / 2)
        }
        return queue.sum()
    }
}