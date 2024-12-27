//一个密码锁由 4 个环形拨轮组成，每个拨轮都有 10 个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', 
//'9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，请给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，因为当拨动到 "0102" 时这
//个锁就会被锁定。
// 
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：
//把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//输出：-1
//解释：
//无法旋转到目标数字且不被锁定。
// 
//
// 示例 4: 
//
// 
//输入: deadends = ["0000"], target = "8888"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target 不在 deadends 之中 
// target 和 deadends[i] 仅由若干位数字组成 
// 
//
// 
//
// 注意：本题与主站 752 题相同： https://leetcode-cn.com/problems/open-the-lock/ 
// Related Topics 广度优先搜索 数组 哈希表 字符串 👍 1 👎 0

package leetcode.editor.cn

import java.util.ArrayList

import java.util.HashSet

import java.util.LinkedList

import java.util.Queue




/**
 * 剑指 Offer II 109
 * 开密码锁	
 *
 * @author Gargantua丶
 * 2021-11-03 14:32:26
 */
class ZlDJc7 { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun openLock(deadends: Array<String>, target: String): Int {
        if ("0000" == target) {
            return 0
        }
        val dead: MutableSet<String> = HashSet()
        for (deadend in deadends) {
            dead.add(deadend)
        }
        if (dead.contains("0000")) {
            return -1
        }
        var step = 0
        val queue: Queue<String> = LinkedList()
        queue.offer("0000")
        val seen: MutableSet<String> = HashSet()
        seen.add("0000")
        while (!queue.isEmpty()) {
            ++step
            val size = queue.size
            for (i in 0 until size) {
                val status = queue.poll()
                for (nextStatus in get(status)) {
                    if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if (nextStatus == target) {
                            return step
                        }
                        queue.offer(nextStatus)
                        seen.add(nextStatus)
                    }
                }
            }
        }
        return -1
    }

    fun numPrev(x: Char): Char {
        return if (x == '0') '9' else (x.toInt() - 1).toChar()
    }

    fun numSucc(x: Char): Char {
        return if (x == '9') '0' else (x.toInt() + 1).toChar()
    }

    // 枚举 status 通过一次旋转得到的数字
    operator fun get(status: String): List<String> {
        val ret: MutableList<String> = ArrayList()
        val array = status.toCharArray()
        for (i in 0..3) {
            val num = array[i]
            array[i] = numPrev(num)
            ret.add(String(array))
            array[i] = numSucc(num)
            ret.add(String(array))
            array[i] = num
        }
        return ret
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}