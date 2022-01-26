package cs.matemaster.datastructure;

import org.junit.Test;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2022/1/26 21:42
 */
public class QueueTest {
    @Test
    public void test() {
        Queue<Integer> numbers = new Queue<Integer>();
        for (int i = 0; i < 10; i++) {
            numbers.enqueue(i);
        }
        System.out.println(numbers);
        System.out.println(numbers.peek());
        System.out.println(numbers.dequeue());
    }
}
