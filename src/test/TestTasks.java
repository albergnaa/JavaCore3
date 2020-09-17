package test;

import homework6.Tasks;
import org.junit.Assert;
import org.junit.Test;

public class TestTasks {

    @Test
    public void test1Task1() {
        int[] in = new int[]{1, 5, 7, 8, 6, 2, 2, 4, 5, 6, 9};
        int[] out = new int[]{5, 6, 9};
        Assert.assertArrayEquals(out, Tasks.task1(in));
    }

    @Test(expected = RuntimeException.class)
    public void test2Task1() {
        int[] in = new int[]{5, 6, 3, 7, 8, 9};
        Tasks.task1(in);
    }

    @Test
    public void test1Task2() {
        int[] in = new int[]{1, 2, 5, 6, 7, 4};
        Assert.assertFalse(Tasks.task2(in));
    }

    @Test
    public void test2Task2() {
        int[] in = new int[]{1, 1, 1, 1};
        Assert.assertFalse(Tasks.task2(in));
    }

    @Test
    public void test3Task2() {
        int[] in = new int[]{1, 4, 1, 1, 4, 4};
        Assert.assertTrue(Tasks.task2(in));
    }
}
