package fr.istic.prg3;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class HeapTreeTest {

    @Test
    public void q9_InitByAdd1(){
        HeapTree root = new HeapTree(109);
        root.addValue(110);
        assertTrue(root.value == 110);
        root.addValue(120);
        assertTrue(root.value == 120);
    }
    @Test
    public void q9_InitByAdd2(){
        HeapTree root = new HeapTree(100);
        for (int i = 0; i < 20; i++) {
            root.addValue(100+i);
            assertTrue(root.value == 100+i);
        }
    }
    @Test
    public void q9_InitByArray1(){
        int[] values = new int[]{109,107,111};
        HeapTree root = new HeapTree(values);
        assertTrue(root.value == 111);
    }
    @Test
    public void q9_InitByArray2(){
        int[] values = new int[]{109,107,111,112,103,104,110,101,106,102,108,105};
        HeapTree root = new HeapTree(values);
        assertTrue(root.value == 112);
    }
    @Test
    public void q10_StepByStepVisualisation(){
        int[] values = new int[]{109,107,111,112,103,104,110,101,106,102,108,105};
        HeapTree root = new HeapTree(values[0]);
        for (int i = 1; i < values.length; i++) {
            root.addValue(values[i]);
            System.out.println(root);
        }
    }
    @Test
    public void q11_GetMaxTest1(){
        HeapTree root = new HeapTree(100);
        for (int i = 0; i < 20; i++) {
            root.addValue(100+i);
            assertTrue(root.getMax() == 100+i);
        }
    }
    @Test
    public void q12_ExtractMaxTest1(){
        HeapTree root = new HeapTree(100);
        for (int i = 1; i <= 20; i++) {
            root.addValue(100+i);
        }
        for (int i = 20; i >= 1; i--) {
            assertTrue(root.extractMax() == 100+i);
            System.out.println(root);
        }
    }
    @Test
    public void q13_HeapsortTest1(){
        int[] values = new int[]{109,107,111,112,103,104,110,101,106,102,108,105};
        int[] sortedValues = HeapTree.heapsort(values);
        for (int i : values)System.out.print(i +" ");
        System.out.println();
        for (int i : sortedValues)System.out.print(i +" ");
    }
    @Test
    public void q13_HeapsortTest2(){
        int[] values = new int[1000];
        int nTest = 1000;
        Random r = new Random();

        for (int i = 0; i < nTest; i++) {
            for (int j = 0; j < values.length; j++)values[j] = r.nextInt();
            int[] sortedValues = HeapTree.heapsort(values);
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
