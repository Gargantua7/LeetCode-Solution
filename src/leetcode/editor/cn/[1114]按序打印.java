//我们提供了一个类： 
//
// 
//public class Foo {
//  public void first() { print("first"); }
//  public void second() { print("second"); }
//  public void third() { print("third"); }
//} 
//
// 三个不同的线程 A、B、C 将会共用一个 Foo 实例。 
//
// 
// 一个将会调用 first() 方法 
// 一个将会调用 second() 方法 
// 还有一个将会调用 third() 方法 
// 
//
// 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3]
//输出: "firstsecondthird"
//解释: 
//有三个线程会被异步启动。
//输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
//正确的输出是 "firstsecondthird"。
// 
//
// 示例 2: 
//
// 
//输入: [1,3,2]
//输出: "firstsecondthird"
//解释: 
//输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
//正确的输出是 "firstsecondthird"。 
//
// 
//
// 提示： 
//
// 
// 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。 
// 你看到的输入格式主要是为了确保测试的全面性。 
// 
// Related Topics 多线程 👍 338 👎 0

package leetcode.editor.cn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1114
 * 按序打印
 *
 * @author Gargantua丶
 * 2021-11-22 13:37:42
 */
class PrintInOrder {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Foo {
        
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        
        int curr = 1;
        
        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            // printFirst.run() outputs "first". Do not change or remove this line.
            if (curr != 1) condition1.await();
            curr = 2;
            printFirst.run();
            condition2.signal();
            lock.unlock();
        }
        
        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            // printSecond.run() outputs "second". Do not change or remove this line.
            if (curr != 2) condition2.await();
            curr = 3;
            printSecond.run();
            condition3.signal();
            lock.unlock();
        }
        
        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            
            // printThird.run() outputs "third". Do not change or remove this line.
            if (curr != 3) condition3.await();
            curr = 1;
            printThird.run();
            condition1.signal();
            lock.unlock();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}