package fr.istic.prg3;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class HeapArrayTest {

    @Test
    public void t0_InitTry(){
        HeapArray array = new HeapArray(100);
        for (int i = 0; i < 20; i++) {
            array.addValue(100+i);
        }
        System.out.println(array);
    }

    @Test
    public void t1_InitByAdd1(){
        HeapArray array = new HeapArray(109);
        array.addValue(110);
        assertTrue(array.getMax() == 110);
        array.addValue(120);
        assertTrue(array.getMax() == 120);
        System.out.println(array);
    }
    @Test
    public void t1_InitByAdd2(){
        HeapArray array = new HeapArray(100);
        for (int i = 1; i < 20; i++) {
            array.addValue(100+i);
            assertTrue(array.getMax() == 100+i);
            System.out.println(array);
        }
    }
    @Test
    public void t1_InitByArray1(){
        int[] values = new int[]{109,107,111};
        HeapArray array = new HeapArray(values);
        assertTrue(array.getMax() == 111);
        System.out.println(array);
    }
    @Test
    public void t1_InitByArray2(){
        int[] values = new int[]{109,107,111,112,103,104,110,101,106,102,108,105};
        HeapArray array = new HeapArray(values);
        assertTrue(array.getMax() == 112);
        System.out.println(array);
    }
    @Test
    public void t2_ExtractMax1(){
        HeapArray array = new HeapArray(100);
        for (int i = 1; i < 20; i++) {
            array.addValue(100+i);
        }
        for (int i = 19; i > 0 ; i--) {
            int max =  array.extractMax();
            System.out.println(array);
            assertTrue(100+i == max);
        }
    }
    @Test
    public void t3_HeapsortTest1(){
        int[] values = new int[]{109,107,111,112,103,104,110,101,106,102,108,105};
        int[] sortedValues = HeapArray.heapsort(values);
        for (int i : values)System.out.print(i +" ");
        System.out.println();
        for (int i : sortedValues)System.out.print(i +" ");
    }
    @Test
    public void t3_HeapsortTest2(){
        int[] values = new int[1000];
        int nTest = 1000;
        Random r = new Random();

        for (int i = 0; i < nTest; i++) {
            for (int j = 0; j < values.length; j++)values[j] = r.nextInt();

            int[] sortedValues = HeapArray.heapsort(values);
            Arrays.sort(values);
            for (int j = 0; j < values.length / 2; j++) {
                int temp = values[j];
                values[j] = values[values.length - 1 - j];
                values[values.length - 1 - j] = temp;
            }
            assertTrue(Arrays.equals(sortedValues, values));
        }
    }
}
