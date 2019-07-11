import java.util.*;

public class IteratorCombinations implements Iterable<List<Integer>> {

    private List<Integer> lista;
    private Integer k;

    public IteratorCombinations(Integer k,List<Integer> s) {
        lista = s;
        this.k = k;
    }

    @Override
    public Iterator<List<Integer>> iterator() {
        return new IteratorCombination(lista,k);
    }

    private class IteratorCombination implements Iterator<List<Integer>> {

        private int actualSize, maxresult;
        private Integer curIndex;
        private int[] result;
        private int[] indices;
        private int[] arrayList;
        private List<Integer> elem = null;

        public IteratorCombination(List<Integer> s, Integer k) {
            actualSize = k;
            curIndex = 0;
            maxresult = k;
            arrayList = new int[s.size()];
            for (int i = 0; i < arrayList.length; i++) {
                arrayList[i] = s.get(i);
            }
            this.result = new int[actualSize < s.size() ? actualSize : s.size()];
            indices = new int[result.length];
            for (int i = 0; i < result.length; i++) {
                indices[i] = result.length - 2 - i;
            }
        }

        public boolean hasNext() {
            elem = null;
            while ((elem == null && curIndex != -1)) {
                indices[curIndex]++;
                if (indices[curIndex] == (curIndex == 0 ? arrayList.length : indices[curIndex - 1])) {
                    indices[curIndex] = indices.length - curIndex - 2;
                    curIndex--;
                } else {
                    result[curIndex] = arrayList[indices[curIndex]];
                    if (curIndex < indices.length - 1) {
                        curIndex++;
                    } else {
                        elem = new LinkedList<Integer>();
                        for (int s : result) {
                            elem.add(s);
                        }
                    }
                }
            }
            if (elem == null) {
                if (actualSize < maxresult) {
                    actualSize++;
                    this.result = new int[actualSize < arrayList.length ? actualSize : arrayList.length];
                    indices = new int[result.length];
                    for (int i = 0; i < result.length; i++) {
                        indices[i] = result.length - 2 - i;
                    }
                    curIndex = 0;
                    return this.hasNext();
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }

        @Override
        public List<Integer> next() {
            return elem;
        }

        @Override
        public void remove() {}
    }
  }
