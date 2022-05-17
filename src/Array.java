import java.util.Arrays;

public class Array {
    private int[] arr;
    private int lastItemIndex = 0;

    public Array(int initialLength) {
        arr = new int[initialLength];
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }

    public void insert(int item) {
        if (arr.length == lastItemIndex) {
            int[] temp = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
        arr[lastItemIndex++] = item;
    }

    public int indexOf(int item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item)return  i;
        }
        return  -1;
    }

    public void remove(int index) {
        if (index < 0 || index >= lastItemIndex)
            throw new IllegalArgumentException();

        int[] temp = new int[arr.length -1];
        int tempIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                temp[tempIndex++] = arr[i];
            }
        }
        arr = temp;
    }

    public int[] toArr() {
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            output[i] = arr[i];
        }

        return output;
    }

    public int max() {
        int item = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (item < arr[i])
                item = arr[i];
        }
        return item;
    }

    public int[] intersect(int[] inputArr) {

        Array test = new Array(0);

        for (int i = 0; i < arr.length; i++) {
            int arrItem = arr[i];
            for (int j = 0; j < inputArr.length; j++) {
                if (inputArr[j] == arrItem) {
                    test.insert(arrItem);
                }
            }
        }
        
        return  test.toArr();
    }

    public void reverse() {
        int[] reversedArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reversedArr[i] = arr[arr.length - (i + 1)];
        }

        arr = reversedArr;
    }

    public void insertAt(int item, int index) {
        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        newArr[index] = item;

        for (int i = index + 1; i < arr.length + 1; i++) {
            newArr[i] = arr[i - 1];
        }

        arr = newArr;

    }

}
