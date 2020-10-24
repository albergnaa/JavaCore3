package test;

import homework6.Tasks;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTask2List {
    private int[] in;
    private boolean out;

    @Parameterized.Parameters
    public static Collection<Object> arr() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 4, 1, 4, 5, 1, 4, 2}, false},
                {new int[]{1, 1, 4, 1, 4, 1, 4, 4}, true},
                {new int[]{1, 1, 1, 1, 1}, false},
                {new int[]{4, 4, 4, 4, 4}, false}
        });
    }

    public TestTask2List(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }

    @Test
    public void testListTask2() {
        Assert.assertEquals(out, Tasks.task2(in));
    }
}
