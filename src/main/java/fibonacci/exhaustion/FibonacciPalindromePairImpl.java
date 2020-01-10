package fibonacci.exhaustion;

import fibonacci.Pair;

import java.util.List;
import java.util.Objects;

/**
 * Created by Bencheng on 2020/1/10.
 */
public class FibonacciPalindromePairImpl implements Pair<Integer, Integer> {

    private List<Integer> pairedList;

    public FibonacciPalindromePairImpl(List<Integer> pairedList) {
        this.pairedList = pairedList;
    }

    @Override
    public Integer getFirst() {
        if (Objects.nonNull(pairedList) && pairedList.size() > 0) {
            return pairedList.get(0);
        }
        return null;
    }

    @Override
    public Integer getSecond() {
        if (Objects.nonNull(pairedList) && pairedList.size() > 1) {
            return pairedList.get(1);
        }
        return null;
    }
}
