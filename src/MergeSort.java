import java.util.Arrays;

/**
 * Created by afuller on 10/6/15.
 */
public final class MergeSort {

    public static int[] sort(int[] toSort) {
        int size = toSort.length;
        int [] sorted = new int[size];
        int split = size/2;
        if (size <= 1) {
            return toSort;
        }

        int[] left = Arrays.copyOfRange(toSort, 0, split);
        int[] right = Arrays.copyOfRange(toSort, split, size);

        left = sort(left);
        right = sort(right);

        return merge_sort(left, right);
    }


    private static int[] merge_sort(int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        int resultSize = leftSize + rightSize;
        int [] result = new int[resultSize];
        int commonSize = Math.min(leftSize, rightSize);
        int i = 0;
        int j = 0;
        int k = 0;
        while ( i < leftSize && j < rightSize) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                k++;
                i++;
            } else if (left[i] == right[j]) {
                result[k] = right[j];
                result[k+1] = left[i];
                j++;
                i++;
                k = k +2;
            } else {
                result[k] = right[j];
                k++;
                j++;
            }
        }

        while (i < leftSize) {
            result[k] = left[i];
            k++;
            i++;
        }

        while (j < rightSize) {
            result[k] = right[j];
            k++;
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] toSort = {0,0,-1, Integer.MAX_VALUE, -3, 0, 42, 7};
        int[] sorted = sort(toSort);
        System.out.println("toSort = " + Arrays.toString(toSort));
        System.out.println("sorted = " + Arrays.toString(sorted));
    }

}
