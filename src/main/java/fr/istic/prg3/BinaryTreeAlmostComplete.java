/**
 * 
 */
package fr.istic.prg3;

import java.util.Objects;



/**
 * @version 1.0
 *
 */
public class BinaryTreeAlmostComplete {
	
	protected int value;
	protected BinaryTreeAlmostComplete left;
	protected BinaryTreeAlmostComplete right;
	protected BinaryTreeAlmostComplete up;
	protected int nbDescendants;

	public BinaryTreeAlmostComplete(int value) {
		this(value, null);
	}
	
	
	public BinaryTreeAlmostComplete(int[] values) {
		this(values[0],null);
		for(int i = 1; i < values.length; i++)
			addValue(values[i]);
	}

	protected BinaryTreeAlmostComplete(int value, BinaryTreeAlmostComplete parent) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.up = parent;
		this.updateNumberOfDescendants();
	}


	public void addValue(int value) {
		if (Objects.isNull(this.left)) {
			this.left = new BinaryTreeAlmostComplete(value, this);
			this.updateNumberOfDescendants();
		}
		else {
			if (Objects.isNull(this.right)) {
				this.right = new BinaryTreeAlmostComplete(value, this);
				this.updateNumberOfDescendants();
			}
			else {
				// both left and right exist
				int nbDescLeft = this.left.nbDescendants;
				if (getLevels(nbDescLeft) == getLevels(nbDescLeft + 1)) {
					// the lowest level of left child is not full
					this.left.addValue(value);
				}
				else {
					// the lowest level of left child is full
					int nbDescRight = this.right.nbDescendants;
					if (nbDescLeft > nbDescRight) {
						// the lowest level of left child is full, AND the lowest level of right child is not full
						this.right.addValue(value);
					}
					else {
						// both left and right child are full and have the same level
						this.left.addValue(value);
					}
				}
			}
		}
	}
	
	
	
	protected static int getLevels(int n) {
		return (int)(Math.log(n + 1) / Math.log(2));
	}
	
	
	protected BinaryTreeAlmostComplete getRightmostLowestNode() {
		if(this.right != null && this.left != null) {
			int nbDescLeft = this.left.nbDescendants;
			if (getLevels(nbDescLeft) == getLevels(nbDescLeft + 1))
				return this.left.getRightmostLowestNode();
			else
				return this.right.getRightmostLowestNode();
		}
		else if(this.right != null) return this.right.getRightmostLowestNode();
		else if(this.left != null) return this.left.getRightmostLowestNode();
		else return this;
	}
	
	
	
	
	public void siftDown() {
		if(this.right != null && this.left != null) {
			boolean supRight = this.right.value > this.value;
			boolean supLeft = this.left.value > this.value;
			if(supLeft && supRight){
				if(this.right.value > this.left.value && switchRight())this.right.siftDown();
				else if(switchLeft())this.left.siftDown();
			}
			else if (supLeft && switchLeft())this.left.siftDown();
			else if(supRight && switchRight())this.right.siftDown();
		}
		else if(this.right != null && this.right.value > this.value && switchRight())this.right.siftDown();
		else if(this.left != null && this.left.value > this.value && switchLeft())this.left.siftDown();
	}
	
	
	public void siftUp() {
		if(this.up != null && this.value > this.up.value && switchUp())
			this.up.siftUp();
	}
	
	private boolean switchUp(){
		if (this.up != null) {
			int temp = this.value;
			this.value = this.up.value;
			this.up.value = temp;
			return true;
		}else return false;
	}
	private boolean switchRight(){
		if (this.right != null) {
			int temp = this.value;
			this.value = this.right.value;
			this.right.value = temp;
			return true;
		}else return false;
	}
	private boolean switchLeft(){
		if (this.left != null) {
			int temp = this.value;
			this.value = this.left.value;
			this.left.value = temp;
			return true;
		}else return false;
	}
	public String toString() {
		return this.toString("");
	}
	
	
	public String toString(String offset) {
		String rep = offset+this.value +" | ("+this.nbDescendants+" descendants)\n";
		if(this.left != null)rep+=this.left.toString(offset+"  ");
		if(this.right != null)rep+=this.right.toString(offset+"  ");
		return rep;
	}
	
	
	
	protected void updateNumberOfDescendants() {
		this.nbDescendants = 0;
		if (Objects.nonNull(this.left)) {
			this.nbDescendants += 1 + this.left.nbDescendants;
		}
		if (Objects.nonNull(this.right)) {
			this.nbDescendants += 1 + this.right.nbDescendants;
		}
		if (Objects.nonNull(this.up)) {
			up.updateNumberOfDescendants();
		}
	}
}
