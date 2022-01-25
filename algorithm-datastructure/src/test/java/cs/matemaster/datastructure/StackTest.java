package cs.matemaster.datastructure;

import org.junit.Test;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2022/1/25 20:58
 */
public class StackTest {
    @Test
    public void test() {
        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < 100; i++) {
            numbers.push(i);
        }
        System.out.println(numbers);
    }
}
