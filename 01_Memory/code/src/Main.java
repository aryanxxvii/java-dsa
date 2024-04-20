public class Main {
    public static void main(String[] args) {
        String s = "Hi";
        int[] arr = {1, 2, 3};


        ObjClass obj = change(s, arr);
        System.out.println(obj.s);
        for (int i = 0; i < obj.arr.length; i++) {
            System.out.print(obj.arr[i] + " ");
        }
        System.out.println();
        System.out.println(s);
        for (int j : arr) {
            System.out.print(j + " ");
        }

    }

    static ObjClass change(String str, int[] arr) {
        str = "Bye";
        arr[0] = 5;
        ObjClass newObj = new ObjClass();
        newObj.s = str;
        newObj.arr = arr;
        return newObj;
    }
}

class ObjClass {
    String s;
    int[] arr;
}
