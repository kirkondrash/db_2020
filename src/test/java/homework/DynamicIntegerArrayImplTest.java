package homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DynamicIntegerArrayImplTest {

    private int[] innerArray;
    private DynamicIntegerArrayImpl arr;

    @Before
    public void setup(){
        // this is a data structure for assertions
        innerArray = new int[]{1,3,3,7,12345};
        // we say that it is filled all but one last slot
        int innerArraySize = 4;
        // it is copied inside tested DynamicIntegerArrayImpl.class object and one slot is available
        arr = new DynamicIntegerArrayImpl(innerArraySize,innerArray);
    }

    @Test
    public void testArrayInitialisation() {
        // the array is not the same object - the values are copied, but the reference is not the same
        Assert.assertNotEquals(innerArray,arr.getInnerArray());
        // last one (12345) shouldn't have been copied, size does not allow it
        Assert.assertEquals(0,arr.getInnerArray()[4]);
    }

    @Test
    public void getNormalIndex() {
        // didn't test whether it'll work in generic/object case (and not primitives) or not
        Assert.assertEquals(innerArray[0],arr.get(0));
        Assert.assertEquals(innerArray[1],arr.get(1));
        Assert.assertEquals(innerArray[2],arr.get(2));
        Assert.assertEquals(innerArray[3],arr.get(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getNegativeIndex() {
        arr.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOutBoundIndex() {
        arr.get(4);
    }

    @Test
    public void addWithoutExtendingArray() {
        arr.add(42);
        Assert.assertEquals(arr.size(),5);
        Assert.assertEquals(arr.getInnerArraySize(),5);
        Assert.assertEquals(arr.get(4),42);
    }

    @Test
    public void addWithExtendingArray() {
        arr.add(42);
        arr.add(777);
        // we now have six values, so current empty slot is 6, counting from zero
        Assert.assertEquals(arr.size(),6);
        // the actual size of the array is 1.5 times + 1
        Assert.assertEquals(arr.getInnerArraySize(),8);
        Assert.assertEquals(arr.get(4),42);
        Assert.assertEquals(arr.get(5),777);
    }

    @Test
    public void size() {
        Assert.assertEquals(arr.size(),4);
    }
}