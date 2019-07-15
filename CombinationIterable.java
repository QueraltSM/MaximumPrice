import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CombinationIterable implements Iterable<List<Integer>> {

    private final List<Integer> list;

    public CombinationIterable(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Iterator<List<Integer>> iterator() {
        return new IteradorCombn(list);
    }

    private class IteradorCombn implements Iterator<List<Integer>> {
        private int actualSize;
        private int maxresult;
        private int curIndex;
        private int[] result;
        private int[] indices;
        private int[] arrayList;
        private List<Integer> elem = null;

        public IteradorCombn(List<Integer> s) {
          actualSize = 1;
          maxresult = s.size();
          arrayList = new int[s.size()];
          for (int i = 0; i < arrayList.length; i++) arrayList[i] = s.get(i);
          this.result = new int[actualSize < s.size() ? actualSize : s.size()];
          indices = new int[result.length];
          for (int i = 0; i < result.length; i++) indices[i] = result.length - 2 - i;
        }

        @Override
        public boolean hasNext() {
            elem = null;
            while ((elem == null && curIndex != -1)) {
                indices[curIndex]++;
                if (indices[curIndex] == (curIndex == 0 ? arrayList.length:indices [curIndex-1] )) {
                    indices[curIndex] = indices.length-curIndex - 2;
                    curIndex--;
                } else {
                    result[curIndex] = arrayList[arrayList.length - indices[curIndex] - 1];
                    if (curIndex < indices.length - 1) curIndex++;
                    else {
                        elem = new LinkedList <> ();
                        for (int s:result) elem.add(s);
                    }
                }
            }
            if (elem == null) {
                if (actualSize < maxresult) {
                    actualSize++;
                    this.result = new int[actualSize < arrayList.length ? actualSize : arrayList.length];
                    indices = new int[result.length];
                    for (int i = 0; i < result.length; i++) indices[i] = result.length - 2 - i;
                    curIndex = 0;
                    return this.hasNext();
                } else return false;
            } else return true;

        }

        @Override
        public List<Integer> next() {
            return elem;
        }

        /*@Override
        public void remove() {
        }*/
    }
}
