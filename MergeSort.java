public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        System.out.println("============== left ============= ");
        System.out.println("mergeSort(arr, " + left + " , " + mid + ")");
        mergeSort(arr, left, mid);
        System.out.println("============== right ============= ");
        System.out.println("mergeSort(arr, " + mid + " + 1, " + right + ")");
        mergeSort(arr, mid + 1, right);
        System.out.println("======== merge recursion ========= ");
        System.out.println("merge(arr, " + left + " , "  + mid + " , " + right + ")");
        merge(arr, left, mid, right);

    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        System.out.println("============== merge function ============= ");
        System.out.println("left = "+ left);
        System.out.println("mid = "+ mid);
        System.out.println("right = "+ right);
        System.out.println("n1 = "+ n1);
        System.out.println("n2 = "+ n2);

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        System.out.print("arr = [ ");

        for (int x : arr) {
            System.out.print( x + " ");
        }
        System.out.print(" ]");

        System.out.print("\n");
        System.out.println("============== end merge function ============= \n \n \n \n");

    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 7, 8, 5, 2, 4};

        mergeSort(arr, 0, arr.length - 1);
        System.out.print("arr = ");

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
