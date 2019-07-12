import java.util.*;

public class PermutationIterable<T> implements Iterable<List<T>> {

    final List<T> allElements = new ArrayList<>();

    public PermutationIterable(List<T> allElements) {
        this.allElements.addAll(allElements);
    }

    @Override
    public Iterator<List<T>> iterator() {
        return new PermutationIterator<>(allElements);
    }

    private final class PermutationIterator<T>
    implements Iterator<List<T>> {

        private List<T> nextPermutation;
        private final List<T> allElements = new ArrayList<>();
        private int[] indices;

        PermutationIterator(List<T> allElements) {
            if (allElements.isEmpty()) {
                nextPermutation = null;
                return;
            }
            this.allElements.addAll(allElements);
            this.indices = new int[allElements.size()];
            for (int i = 0; i < indices.length; ++i) indices[i] = i;
            nextPermutation = new ArrayList<>(this.allElements);
        }

        @Override
        public boolean hasNext() {
            return nextPermutation != null;
        }

        @Override
        public List<T> next() {
            if (nextPermutation == null) throw new NoSuchElementException("No permutations left.");
            List<T> ret = nextPermutation;
            generateNextPermutation();
            return ret;
        }

        private void generateNextPermutation() {
            int i = indices.length - 2;

            while (i >= 0 && indices[i] > indices[i + 1]) {
                --i;
            }
            if (i == -1) {
                nextPermutation = null;
                return;
            }

            int j = i + 1;
            int min = indices[j];
            int minIndex = j;

            while (j < indices.length) {
                if (indices[i] < indices[j] && indices[j] < min) {
                    min = indices[j];
                    minIndex = j;
                }
                ++j;
            }
            swap(indices, i, minIndex);
            ++i;
            j = indices.length - 1;
            while (i < j) {
                swap(indices, i++, j--);
            }
            loadPermutation();
        }

        private void loadPermutation() {
            List<T> newPermutation = new ArrayList<>(indices.length);
            for (int i : indices) newPermutation.add(allElements.get(i));
            this.nextPermutation = newPermutation;
        }
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
