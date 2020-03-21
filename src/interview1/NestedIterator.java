package interview1;

import java.util.*;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 *
 * Solution:
 *  - traverse all value and put it into a list
 *  - implement list iterator
 *
 *  time: O(n)
 */
public class NestedIterator implements Iterator<Integer> {
    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }


    private List<Integer> list;
    private int ptr = -1;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        traverse(nestedList, list);
    }

    private void traverse(List<NestedInteger> nestedList, List<Integer> list) {
        for (NestedInteger each: nestedList) {
            if (each.isInteger())
                list.add(each.getInteger());
            else
                traverse(each.getList(), list);
        }
    }

    @Override
    public Integer next() {
        return list.get(++ptr);
    }

    @Override
    public boolean hasNext() {
        return ptr + 1 < list.size();
    }
}
