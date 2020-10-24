package test;


import homework6.Tasks;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTask1List {
    private int[] in;
    private int[] out;

    @Parameterized.Parameters
    public static Collection<Object[]> arr() {
        return Arrays.asList(new Object[][]{
                {new int[]{5, 6, 9, 8, 3, 4, 5}, new int[]{5}},
                {new int[]{2, 6, 5, 9, 4}, new int[]{}},
                {new int[]{1, 4, 5, 3, 4, 1, 2, 5}, new int[]{1, 2, 5}},
                {new int[]{4, 6, 8, 5, 6, 3}, new int[]{6, 8, 5, 6, 3}}
        });
    }

    public TestTask1List(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }

    @Test
    public void testListTask1() {
        Assert.assertArrayEquals(out, Tasks.task1(in));
    }
}
