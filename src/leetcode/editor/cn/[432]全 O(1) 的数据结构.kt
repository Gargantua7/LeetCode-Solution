//请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。 
//
// 实现 AllOne 类： 
//
// 
// AllOne() 初始化数据结构的对象。 
// inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key 。 
// dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例
//保证：在减少计数前，key 存在于数据结构中。 
// getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 "" 。 
// getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 "" 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", 
//"getMinKey"]
//[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
//输出
//[null, null, null, "hello", "hello", null, "hello", "leet"]
//
//解释
//AllOne allOne = new AllOne();
//allOne.inc("hello");
//allOne.inc("hello");
//allOne.getMaxKey(); // 返回 "hello"
//allOne.getMinKey(); // 返回 "hello"
//allOne.inc("leet");
//allOne.getMaxKey(); // 返回 "hello"
//allOne.getMinKey(); // 返回 "leet"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length <= 10 
// key 由小写英文字母组成 
// 测试用例保证：在每次调用 dec 时，数据结构中总存在 key 
// 最多调用 inc、dec、getMaxKey 和 getMinKey 方法 5 * 10⁴ 次 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 231 👎 0

package leetcode.editor.cn

import java.util.*
import kotlin.collections.HashMap

/**
 * 432
 * 全 O(1) 的数据结构
 * 
 * @author Gargantua丶
 * 2022-03-16 20:45:48
 */
class AllOoneDataStructure {
//leetcode submit region begin(Prohibit modification and deletion)
class AllOne {

    val hMap = HashMap<String, Int>()
    val tMap = TreeMap<Int, HashSet<String>>()

    fun inc(key: String) {
        val n = hMap[key]?: 0
        hMap[key] = n + 1
        tMap[n]?.remove(key)
        if (tMap[n]?.isEmpty() == true) tMap.remove(n)
        tMap.getOrPut(n + 1, ::HashSet).add(key)
    }

    fun dec(key: String) {
        val n = hMap[key]?: 0
        if (n == 1) {
            hMap.remove(key)
            tMap[1]?.remove(key)
            if (tMap[1]?.isEmpty() == true) tMap.remove(1)
            return
        }
        hMap[key] = n - 1
        tMap[n]?.remove(key)
        if (tMap[n]?.isEmpty() == true) tMap.remove(n)
        tMap.getOrPut(n - 1, ::HashSet).add(key)
    }

    fun getMaxKey(): String {
        return tMap.floorEntry(Int.MAX_VALUE)?.value?.randomOrNull()?: ""
    }

    fun getMinKey(): String {
        return tMap.ceilingEntry(0)?.value?.randomOrNull()?: ""
    }

}

/**
 * Your AllOne object will be instantiated and called as such:
 * var obj = AllOne()
 * obj.inc(key)
 * obj.dec(key)
 * var param_3 = obj.getMaxKey()
 * var param_4 = obj.getMinKey()
 */
//leetcode submit region end(Prohibit modification and deletion)

}
