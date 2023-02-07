//力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大
//于等于三次，这个系统会自动发布一个 警告 。 
//
// 给你字符串数组 keyName 和 keyTime ，其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡
//的时间。 
//
// 使用时间的格式是 24小时制 ，形如 "HH:MM" ，比方说 "23:51" 和 "09:49" 。 
//
// 请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序 排序后返回。 
//
// 请注意 "10:00" - "11:00" 视为一个小时时间范围内，而 "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使
//用情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], 
//keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
//输出：["daniel"]
//解释："daniel" 在一小时内使用了 3 次员工卡（"10:00"，"10:40"，"11:00"）。
// 
//
// 示例 2： 
//
// 
//输入：keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12
//:01","12:00","18:00","21:00","21:20","21:30","23:00"]
//输出：["bob"]
//解释："bob" 在一小时内使用了 3 次员工卡（"21:00"，"21:20"，"21:30"）。
// 
//
// 示例 3： 
//
// 
//输入：keyName = ["john","john","john"], keyTime = ["23:58","23:59","00:01"]
//输出：[]
// 
//
// 示例 4： 
//
// 
//输入：keyName = ["leslie","leslie","leslie","clare","clare","clare","clare"], 
//keyTime = ["13:00","13:20","14:00","18:00","18:51","19:30","19:49"]
//输出：["clare","leslie"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= keyName.length, keyTime.length <= 10⁵ 
// keyName.length == keyTime.length 
// keyTime 格式为 "HH:MM" 。 
// 保证 [keyName[i], keyTime[i]] 形成的二元对 互不相同 。 
// 1 <= keyName[i].length <= 10 
// keyName[i] 只包含小写英文字母。 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 22 👎 0


package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList

/**
 * 1604
 * 警告一小时内使用相同员工卡大于等于三次的人
 *
 * @author Gargantua丶
 * 2023-02-07 00:14:16
 */
class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun alertNames(keyName: Array<String>, keyTime: Array<String>): List<String> {
        val times = TreeMap<String, PriorityQueue<Int>>()
        for (i in keyName.indices) {
            times.getOrPut(keyName[i], ::PriorityQueue).offer(keyTime[i].substring(0, 2).toInt() * 60 + keyTime[i].substring(3).toInt())
        }
        val ans = ArrayList<String>()
        times.forEach { (name, queue) ->
            if (queue.size < 3) return@forEach
            val que = LinkedList<Int>()
            while (queue.isNotEmpty()) {
                val t = queue.poll()
                que.offer(t)
                if (que.size > 2) {
                    val top = que.poll()
                    if (t - top <= 60) {
                        ans += name
                        break
                    }
                }
            }
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}