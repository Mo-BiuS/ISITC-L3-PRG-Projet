/**
 * 
 */
package fr.istic.prg3;

import java.util.Objects;



/**
 * @version 1.0
 *
 */
public class HeapTree extends BinaryTreeAlmostComplete implements Heap {
	
	public HeapTree(int value) {
		super(value);
	}
	
	
	protected HeapTree(int value, HeapTree parent) {
		super(value,parent);
		if(parent != null)this.siftUp();
	}
	
	
	public HeapTree(int[] values) {
		this(values[0],null);
		for(int i = 1; i < values.length; i++)
			addValue(values[i]);
	}
	
	
	
	public void addValue(int value) {
		if(this.left == null){
			this.left = new HeapTree(value,this);
			this.updateNumberOfDescendants();
		}
		else if(this.right == null) {
			this.right = new HeapTree(value, this);
			this.updateNumberOfDescendants();
		}
		else {
			if(this.right.nbDescendants > this.left.nbDescendants)
				this.left.addValue(value);
			else
				this.right.addValue(value);
		}
	}
	
	
	public int extractMax() {
		int rep = this.value;

		HeapTree rightmostLowestNode = (HeapTree) this.getRightmostLowestNode();
		this.value = rightmostLowestNode.value;

		if(rightmostLowestNode.up != null) {
			if (rightmostLowestNode.up.right == rightmostLowestNode)
				rightmostLowestNode.up.right = null;
			else
				rightmostLowestNode.up.left = null;
			rightmostLowestNode.up = null;
		}

		this.siftDown();

		return rep;
	}

	public int getMax() {
		return value;//Bruh
	}

	public static int[] heapsort(int[] unsortedValues) {
		HeapTree heapTree = new HeapTree(unsortedValues);
		int[] rep = new int[heapTree.nbDescendants+1];
		for (int i = 0; i < heapTree.nbDescendants+1; i++)
			rep[i] = heapTree.extractMax();
		return rep;
	}
}
