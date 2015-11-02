import java.util.Arrays;

/**
 * Created by afuller on 10/11/15.
 */
public class BubbleSort {


    public static int[] sort(int[] toSort) {
        int size = toSort.length;
        return loop(toSort);
    }

    private static int[] loop(int[] toSort) {
        int swapCount = toSort.length;
        while (swapCount != 0) {
            int loopSwaps = 0;
            for (int i = 0; i < toSort.length - 1; i++) {
                if (i <= toSort.length - 2) {
                    if (toSort[i + 1] < toSort[i]) {
                        toSort = swap(toSort, i);
                        loopSwaps++;
                    }
                }
            }
            swapCount = loopSwaps;
        }
        return toSort;
    }

    private static int[] swap(int[] toSort, int position) {
        if (position < toSort.length - 1) {
            int tmp = toSort[position];
            toSort[position] = toSort[position + 1];
            toSort[position + 1] = tmp;
        }
        return toSort;
    }

    public static void main(String[] args) {
        int[] test = {2, 4, 1, 9, 3, 0, 2, 1, 5, 6, 3};
        int[] test1 = {2};

    }
}
