package fr.istic.prg3;

import org.junit.Test;

import java.util.*;

public class Benchmark {
    int nValues = 100;
    int nTest = 10000;

    @Test
    public void benchmarkRandom() {
        int[] values = new int[nValues];
        long heapArrayTime = 0;
        long heapTreeTime = 0;
        long arrayListTime = 0;
        Random r = new Random();

        for (int i = 0; i < nTest; i++) {
            for (int j = 0; j < nValues; j++) values[j] = r.nextInt();

            long timeIn = System.nanoTime();
            HeapArray.heapsort(values);
            heapArrayTime += System.nanoTime() - timeIn;

            timeIn = System.nanoTime();
            HeapTree.heapsort(values);
            heapTreeTime += System.nanoTime() - timeIn;

            timeIn = System.nanoTime();
            Collections.sort(Arrays.asList(values), Collections.reverseOrder());
            arrayListTime += System.nanoTime() - timeIn;
        }

        System.out.println("==========[Random]==========");
        System.out.println("Number of tests  : "+nTest);
        System.out.println("Number of values : "+nValues);
        System.out.println("HeapArray   | Medium time in μs : " + (heapArrayTime / nTest));
        System.out.println("HeapTree    | Medium time in μs : " + (heapTreeTime / nTest));
        System.out.println("ArrayList   | Medium time in μs : " + (arrayListTime / nTest));
    }


    @Test
    public void benchmarkInReverseOrder(){
        int[] values = new int[nValues];

        long heapArrayTime = 0;
        long heapTreeTime = 0;
        long arrayListTime = 0;
        Random r = new Random();

        for (int i = 0; i < nTest; i++) {
            for (int j = 0; j < nValues; j++) values[j] = nValues - j;

            long timeIn = System.nanoTime();
            HeapArray.heapsort(values);
            heapArrayTime += System.nanoTime() - timeIn;

            timeIn = System.nanoTime();
            HeapTree.heapsort(values);
            heapTreeTime += System.nanoTime() - timeIn;

            timeIn = System.nanoTime();
            Collections.sort(Arrays.asList(values), Collections.reverseOrder());
            arrayListTime += System.nanoTime() - timeIn;
        }

        System.out.println("==========[In reverse order]==========");
        System.out.println("Number of tests  : "+nTest);
        System.out.println("Number of values : "+nValues);
        System.out.println("HeapArray   | Medium time in μs : " + (heapArrayTime/nTest));
        System.out.println("HeapTree    | Medium time in μs : " + (heapTreeTime/nTest));
        System.out.println("ArrayList   | Medium time in μs : " + (arrayListTime/nTest));
    }
    @Test
    public void benchmarkInOrder(){
        int[] values = new int[nValues];

        long heapArrayTime = 0;
        long heapTreeTime = 0;
        long arrayListTime = 0;
        Random r = new Random();

        for (int i = 0; i < nTest; i++) {
            for (int j = 0; j < nValues; j++) values[j] = j;

            long timeIn = System.nanoTime();
            HeapArray.heapsort(values);
            heapArrayTime += System.nanoTime() - timeIn;

            timeIn = System.nanoTime();
            HeapTree.heapsort(values);
            heapTreeTime += System.nanoTime() - timeIn;

            timeIn = System.nanoTime();
            Collections.sort(Arrays.asList(values), Collections.reverseOrder());
            arrayListTime += System.nanoTime() - timeIn;
        }
        System.out.println("==========[In order]==========");
        System.out.println("Number of tests  : "+nTest);
        System.out.println("Number of values : "+nValues);
        System.out.println("HeapArray   | Medium time in μs : " + (heapArrayTime/nTest));
        System.out.println("HeapTree    | Medium time in μs : " + (heapTreeTime/nTest));
        System.out.println("ArrayList   | Medium time in μs : " + (arrayListTime/nTest));
    }
}