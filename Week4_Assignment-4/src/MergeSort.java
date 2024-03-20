import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    private static void mergeSort(int[] a, int left, int right) {
        int inputLength = a.length;
        if (inputLength<2){
            return;
        }

        int midIndex = inputLength/2;
        /*int[] leftHalf = Arrays.copyOfRange(a,0,midIndex-1);
        int[] rightHalf = Arrays.copyOfRange(a,midIndex,inputLength-1);;*/
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength-midIndex];
        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = a[i];
        }
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i-midIndex] = a[i];
        }

        mergeSort(leftHalf,left,midIndex);
        mergeSort(rightHalf,midIndex,right);

        //merge
        merge(a,leftHalf,rightHalf);
    }

    private static void merge(int[] inputArray,int[] leftHalf,int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i=0,j=0,k=0;
        while (i<leftSize && j<rightSize){
            if (leftHalf[i]<=rightHalf[j]){
                inputArray[k] = leftHalf[i];
                i++;
            }else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while (i<leftSize){
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j<rightSize){
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        mergeSort(a,0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
