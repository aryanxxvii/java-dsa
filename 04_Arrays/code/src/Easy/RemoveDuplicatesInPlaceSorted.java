package Easy;

public class RemoveDuplicatesInPlaceSorted {
    public static void main(String[] args) {
        // Note: Can put anything in remaining places
        int[] arr = {1, 1, 1, 2, 2, 2, 3, 3};
        int toPlaceHere = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[toPlaceHere] != arr[i]) {
                toPlaceHere++;
                arr[toPlaceHere] = arr[i];
            }
        }
    for (int i : arr) {
        System.out.println(i);
    }



    }
}
