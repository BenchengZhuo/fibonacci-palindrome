package fibonacci.exhaustion;

import fibonacci.FibonacciPalindrome;
import fibonacci.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Bencheng on 2020/1/10.
 */
public class FibonacciPalindromeImpl implements FibonacciPalindrome {
    public Pair findFibonacciPalindrome(List<Integer> sequence) {
        validateSequence(sequence);

        ArrayList<Integer> sequenceArrayList = new ArrayList<>(sequence);

        int max = 0, head = 0, tail = 0;

        for (int i = 0; i < sequenceArrayList.size() - max; i++) {
            for (int j = i + max; j < sequenceArrayList.size(); j++) {
                if (condition2(sequenceArrayList, i, j)) {
                    if (condition1(sequenceArrayList, i, j)) {
                        head = i;
                        tail = j;
                        max = j - i + 1;
                    }
                } else {
                        /*if this sub-sequence is meet condition2, there not exists a fibonacci palindrome start
                        with sequence.get(i) bigger than current biggest one.*/
                    break;
                }
            }
        }


        List<Integer> pairedList = sequenceArrayList.subList(head, tail + 1);
        return new FibonacciPalindromePairImpl(pairedList);

    }


    private boolean condition1(ArrayList<Integer> sequenceArrayList, int head, int tail) {
        //validate condition1: the sequence is the same whether read backward or forward.
        for (int i = head, j = tail; i < j; i++, j--) {
            if (!sequenceArrayList.get(i).equals(sequenceArrayList.get(j))) {
                return false;
            }
        }
        return true;
    }

    private boolean condition2(ArrayList<Integer> sequenceArrayList, int head, int tail) {
        /*validate condition2: either the sequence has fewer than three elements, or every contiguous three-element
         sequence {a, b, c} in it satisfies at least one of these conditions: a==c, a+b==c, or a==b+c.*/
        int subsequenceSize = tail - head + 1;
        if (subsequenceSize > 2) {
            for (int i = head; i < tail - 2; i++) {
                if (!sequenceArrayList.get(i).equals(sequenceArrayList.get(i + 2))
                        && !(sequenceArrayList.get(i) + sequenceArrayList.get(i + 1) == sequenceArrayList.get(i + 2))
                        && !(sequenceArrayList.get(i) == sequenceArrayList.get(i + 1) + sequenceArrayList.get(i + 2))) {
                    return false;
                }
            }
        }


        return true;
    }

    private void validateSequence(List<Integer> sequence) {
        if (Objects.isNull(sequence) || sequence.size() == 0) {
            throw new NumberFormatException("sequence is null or empty");
        }

        for (Integer integer : sequence) {
            if (Objects.isNull(integer) || integer < 0) {
                throw new NumberFormatException("sequence has illegal number");
            }
        }
    }
}
