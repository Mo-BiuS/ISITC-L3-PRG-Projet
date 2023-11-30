package fr.istic.prg3;

import java.util.ArrayList;

/**
 * @version 0.4
 *
 */
public class HeapArray implements Heap {

	ArrayList<Integer> values = new ArrayList<>();
	
	public HeapArray(int[] valuesArray) {
		for(int v : valuesArray)
			addValue(v);
	}
	public HeapArray(int v) {
		addValue(v);
	}
	
	
	public void addValue(int newValue) {
		if(values.size() == 0)
			values.add(0,newValue);
		else
			addValue(0, newValue);
	}
	protected void addValue(int index, int newValue){
		int left = indexLeft(index);
		int right = indexRight(index);

		if(!isIn(left)) {
			if(left >= values.size()){
				for (int i = values.size(); i < left+1; i++) {
					values.add(i,null);
				}
			}
			values.set(left, newValue);
			siftUp(left);
		}else if (!isIn(right)) {
			if(right >= values.size()){
				for (int i = values.size(); i < right+1; i++) {
					values.add(i,null);
				}
			}
			values.set(right, newValue);
			siftUp(right);
		}else{
			if(getNumberOfDescendants(right) > getNumberOfDescendants(left))
				addValue(left,newValue);
			else
				addValue(right,newValue);
		}

	}


	public int getMax(){
		return values.get(0);
	}
	
	
	public int extractMax() {
		int rep = values.get(0);

		if(values.size() > 1) {
			Integer last = values.get(values.size()-1);
			values.set(0,  last);

			do {
				values.remove(values.size()-1);
				last = values.get(values.size()-1);
			} while (last == null);

		}else {
			values.remove(0);
		}

		siftDown(0);

		return rep;
	}



	public static int[] heapsort(int[] unsortedValues) {
		HeapArray array = new HeapArray(unsortedValues);
		int size =  array.getNumberOfDescendants(0);

		int[] rep = new int[size];
		for (int i = 0; i < size; i++)
			rep[i] = array.extractMax();
		return rep;
	}



	protected int indexLeft(int position) {
		return (2*position)+1;
	}
	protected int indexRight(int position) {
		return (2*position)+2;
	}
	protected int indexUp(int position) {
		return (position-1)/2;
	}
	protected boolean isIn(int position) {
		return values.size() > position && values.get(position) != null;
	}
	private int getNumberOfDescendants(int position) {
		if (isIn(position))
			return 1 + getNumberOfDescendants(indexLeft(position)) + getNumberOfDescendants(indexRight(position));
		else
			return 0;
	}



	public void siftDown() {
		this.siftDown(0);
	}
	protected void siftDown(int thisPos) {
		if(isIn(thisPos)) {
			int rightPos = indexRight(thisPos);
			int leftPos = indexLeft(thisPos);
			boolean rightExist = isIn(rightPos);
			boolean leftExist = isIn(leftPos);
			int thisValue = values.get(thisPos);

			if (rightExist && leftExist) {
				int rightValue = values.get(rightPos);
				int leftValue = values.get(leftPos);
				boolean supRight = rightValue > thisValue;
				boolean supLeft = leftValue > thisValue;

				if (supLeft && supRight) {
					if (rightValue > leftValue && swap(rightPos, thisPos)) siftDown(rightPos);
					else if (swap(leftPos, thisPos)) siftDown(leftPos);
				} else if (supLeft && swap(leftPos, thisPos)) siftDown(leftPos);
				else if (supRight && swap(rightPos, thisPos)) siftDown(rightPos);
			} else if (rightExist && values.get(rightPos) > thisValue && swap(thisPos, rightPos)) siftDown(rightPos);
			else if (leftExist && values.get(leftPos) > thisValue && swap(thisPos, leftPos)) siftDown(leftPos);
		}
	}


	public void siftUp() {
		this.siftUp(values.size()-1);
	}
	protected void siftUp(int pos) {
		if(pos > 0) {
			Integer value = values.get(pos);
			int posUp = indexUp(pos);
			Integer valueUp = values.get(posUp);
			if(value != null && valueUp != null && value > valueUp) {
				swap(pos, posUp);
				siftUp(posUp);
			}
		}
	}
	


	protected boolean swap(int index1, int index2) {
		if(isIn(index1) && isIn(index2)) {
			int val1 = values.get(index1);
			int val2 = values.get(index2);

			values.set(index1, val2);
			values.set(index2, val1);
			return true;
		}else return false;
	}

	
	public String toString() {
		return "Size : "+values.size()+"\n"+this.toString(0,"");
	}
	public String toString(int index, String offset) {
		String rep = offset+values.get(index) + " | ("+(getNumberOfDescendants(index)-1)+") descendants\n";

		int left = indexLeft(index);
		if(isIn(left))rep+=toString(left,offset+"  ");
		else if(left < values.size())rep+=offset+"  NULL\n";

		int right = indexRight(index);
		if(isIn(right))rep+=toString(right,offset+"  ");
		else if(right < values.size())rep+=offset+"  NULL\n";

		return rep;
	}
}
