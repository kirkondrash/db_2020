package homework;

import java.util.Arrays;

public class DynamicIntegerArrayImpl implements DynamicIntegerArray {

    private int[] arr;
    private int currentIndex;

    public DynamicIntegerArrayImpl(int initSize) {
        arr = new int[initSize];
        currentIndex = -1;
    }

    public DynamicIntegerArrayImpl(int innerArraySize, int[] anotherArray) {
        currentIndex = innerArraySize - 1;
        arr = new int[anotherArray.length];
        // no point in copying parts of array not initialized manually
        System.arraycopy(anotherArray, 0, arr, 0, innerArraySize);
    }

    @Override
    public int get(int index) {
        if (index>currentIndex)
            throw new IndexOutOfBoundsException();
        return arr[index];
    }

    @Override
    public void add(int value) {
        currentIndex+=1;
        
        if (currentIndex==arr.length) {
            int newLength = arr.length + (arr.length>>1) + 1;
            int[] newArr = new int[newLength];
//            got IntelliJ's suggestion, which is pretty nice - no Arrays.copyOf()
//            for (int i=0;i<arr.length;i++){
//                newArr[i] = arr[i];
//            }
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        
        arr[currentIndex] = value;
    }

    @Override
    public int size() {
        return currentIndex + 1;
    }

    int getInnerArraySize() {
        return arr.length;
    }

    int[] getInnerArray() {
        return arr;
    }

    @Override
    public String toString() {
        return "DynamicIntegerArrayImpl{" +
                "arr=" + Arrays.toString(arr) +
                ", currentIndex=" + currentIndex +
                '}';
    }
}
