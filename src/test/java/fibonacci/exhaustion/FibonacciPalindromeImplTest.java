package fibonacci.exhaustion;

import fibonacci.Pair;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Bencheng on 2020/1/10.
 */
public class FibonacciPalindromeImplTest {

    @org.junit.Test
    public void testFindFibonacciPalindrome() throws Exception {

        List<Integer> sequence = Arrays.asList(1, 2, 3, 0, 3, 2, 1);
        List<Integer> sequence2 = Arrays.asList(1, 2, 3, 0, 3, 2, 2, 2, 2, 2, 2, 2, 2, 1);
        List<Integer> sequence3 = Arrays.asList(1, 2, 3);
        FibonacciPalindromeImpl fibonacciPalindrome = new FibonacciPalindromeImpl();

        Pair result = fibonacciPalindrome.findFibonacciPalindrome(sequence);
        Assert.assertEquals(3, result.getFirst());
        Assert.assertEquals(0, result.getSecond());

        Pair result2 = fibonacciPalindrome.findFibonacciPalindrome(sequence2);


        Assert.assertEquals(2, result2.getFirst());
        Assert.assertEquals(2, result2.getSecond());

        Pair result3 = fibonacciPalindrome.findFibonacciPalindrome(sequence3);
        Assert.assertEquals(1, result3.getFirst());
        Assert.assertNull(result3.getSecond());
    }
}