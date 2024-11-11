import java.util.ArrayList;
import java.util.List;

public class HashSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 1, 5};
        int[] sortedArr = hashSort(arr);
        System.out.print("Array ordenado: ");
        for (int num : sortedArr) {
            System.out.print(num + " ");
        }
    }

    public static int[] hashSort(int[] arr) {
        int maxVal = getMaxValue(arr);
        List<Integer>[] hashTable = new List[maxVal + 1];

        for (int i = 0; i <= maxVal; i++) {
            hashTable[i] = new ArrayList<>();
        }

        for (int num : arr) {
            hashTable[num].add(num);
        }

        int[] sortedArr = new int[arr.length];
        int index = 0;
        for (List<Integer> bucket : hashTable) {
            for (int num : bucket) {
                sortedArr[index++] = num;
            }
        }

        return sortedArr;
    }

    private static int getMaxValue(int[] arr) {
        int maxVal = arr[0];
        for (int num : arr) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        return maxVal;
    }
}
