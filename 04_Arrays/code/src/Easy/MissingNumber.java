package Easy;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        System.out.println(summationApproach(arr));
        System.out.println(xorApproach(arr));
        System.out.println(iterativeApproach(arr));
    }

    public static int summationApproach(int[] arr) {
        int n = arr.length + 1; // +1 because one number is missing
        int desiredSum = (n*(n+1))/2;
        int arraySum = 0;
        for (int i : arr) {
            arraySum += i;
        }

        int diff = desiredSum - arraySum;
        return diff;
    }

    public static int xorApproach(int[] arr) {
        int desiredXor = 0;
        int arrayXor = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            arrayXor = arrayXor ^ arr[i];
            desiredXor = desiredXor ^ (i + 1);
        }
        desiredXor = desiredXor ^ (arr.length);
        int missing = desiredXor ^ arrayXor;
        return missing;
    }

    public static int iterativeApproach(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != (i+1)) {
                return (i+1);
            }
        }
        return -1;
    }
}
