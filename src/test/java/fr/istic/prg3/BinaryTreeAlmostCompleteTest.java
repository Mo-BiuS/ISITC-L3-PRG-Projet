package fr.istic.prg3;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class BinaryTreeAlmostCompleteTest {

    @Test
    public void q4_InitByAdd1(){
        BinaryTreeAlmostComplete root = new BinaryTreeAlmostComplete(109);
        System.out.println(root);
        root.addValue(107);
        System.out.println(root);
        root.addValue(111);
        System.out.println(root);
        root.addValue(112);
        System.out.println(root);
        root.addValue(103);
        System.out.println(root);
        root.addValue(104);
        System.out.println(root);
        root.addValue(110);
        System.out.println(root);
        root.addValue(101);
        System.out.println(root);
        root.addValue(106);
        System.out.println(root);
        root.addValue(102);
        System.out.println(root);
        root.addValue(108);
        System.out.println(root);
        root.addValue(105);
        System.out.println(root);
        assertTrue(root.nbDescendants == 11);
    }
    @Test
    public void q5_InitByArray1(){
        int[] values = new int[]{109,107,111,112,103,104,110,101,106,102,108,105};
        BinaryTreeAlmostComplete root = new BinaryTreeAlmostComplete(values);
        System.out.println(root);

        assertTrue(root.nbDescendants == 11);
    }
    @Test
    public void q6_GetRightmostLowestNodeTest1(){
        int[] values = new int[]{109};
        BinaryTreeAlmostComplete root = new BinaryTreeAlmostComplete(values);
        System.out.println(root);

        assertTrue(root.getRightmostLowestNode().value == 109);
    }
    @Test
    public void q6_GetRightmostLowestNodeTest2(){
        int[] values = new int[]{109,107};
        BinaryTreeAlmostComplete root = new BinaryTreeAlmostComplete(values);
        System.out.println(root);

        assertTrue(root.getRightmostLowestNode().value == 107);
    }
    @Test
    public void q6_GetRightmostLowestNodeTest3(){
        int[] values = new int[]{109,107,111,112};
        BinaryTreeAlmostComplete root = new BinaryTreeAlmostComplete(values);
        System.out.println(root);

        assertTrue(root.getRightmostLowestNode().value == 112);
    }
    @Test
    public void q6_GetRightmostLowestNodeTest4(){
        int[] values = new int[]{109,107,111,112,103,104,110,101,106,102,108,105};
        BinaryTreeAlmostComplete root = new BinaryTreeAlmostComplete(values);
        System.out.println(root);

        assertTrue(root.getRightmostLowestNode().value == 105);
    }
    @Test
    public void q7_SiftUpTest1(){
        int[] values = new int[]{107,109};
        BinaryTreeAlmostComplete root = new BinaryTreeAlmostComplete(values);
        root.left.siftUp();
        System.out.println(root);

        assertTrue(root.getRightmostLowestNode().value == 107);
    }
    @Test
    public void q7_SiftUpTest2(){
        int[] values = new int[]{109,107,111,112};
        BinaryTreeAlmostComplete root = new BinaryTreeAlmostComplete(values);
        root.left.left.siftUp();
        System.out.println(root);

        assertTrue(root.getRightmostLowestNode().value == 107);
    }
    @Test
    public void q8_SiftDownTest1(){
        int[] values = new int[]{107,109};
        BinaryTreeAlmostComplete root = new BinaryTreeAlmostComplete(values);
        root.siftDown();
        System.out.println(root);

        assertTrue(root.value == 109);
    }
    @Test
    public void q8_SiftDownTest2(){
        int[] values = new int[]{109,107,111};
        BinaryTreeAlmostComplete root = new BinaryTreeAlmostComplete(values);
        root.siftDown();
        System.out.println(root);

        assertTrue(root.value == 111);
    }

    @Test
    public void q8_SiftDownTest3(){
        BinaryTreeAlmostComplete root = new BinaryTreeAlmostComplete(100);
        for (int i = 1; i < 20; i++) {
            root.addValue(100+i);
        }
        root.value = 0;
        root.siftDown();
        System.out.println(root);
    }
}
