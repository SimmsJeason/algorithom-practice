package typicalAlgorithom.Sort;

public abstract class SortInt {

    protected boolean less(int v, int w) {
        return v < w;
    }

    protected void swap(int [] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
