// Java program to implement Max Heap

// Main class
public class MaxHeap2 {
	protected int[] Heap;
	public int size;
	protected int maxsize;

	// Constructor to initialize an
	// empty max heap with given maximum
	// capacity
	public MaxHeap2(int maxsize)
	{
		// This keyword refers to current instance itself
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize];
	}

	// Method 1
	// Returning position of parent
	protected int parent(int pos) { return (pos - 1) / 2; }

	// Method 2
	// Returning left children
	protected int leftChild(int pos) { return (2 * pos+1); }

	// Method 3
	// Returning left children
	protected int rightChild(int pos)
	{
		return (2 * pos) + 2;
	}

	// Method 4
	// Returning true of given node is leaf
	protected boolean isLeaf(int pos)
	{
		if (pos > (size / 2)-1 && pos <= size-1) {
			return true;
		}
		return false;
	}

	// Method 5
	// Swapping nodes
	protected void swap(int fpos, int spos)
	{
		int tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	// Method 6
	// Recursive function to max heapify given subtree
	private void maxHeapify(int pos)
	{
		if (isLeaf(pos))
			return;
		
		if(rightChild(pos)>= size) {
			
			if (Heap[pos] < Heap[leftChild(pos)]) {
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			}
			return;
		}

		if (Heap[pos] < Heap[leftChild(pos)]
			|| Heap[pos] < Heap[rightChild(pos)]) {

			if (Heap[leftChild(pos)]
				> Heap[rightChild(pos)]) {
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			}
			else {
				swap(pos, rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}


	// Method 7
	// Inserts a new element to max heap
	public void insert(int element)
	{
		Heap[size] = element;

		// Traverse up and fix violated property
		int current = size;
		while (Heap[current] > Heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
		size++;
	}
	
	// Method 8
	public void print()
	{
		for (int i = 0; i <= (size / 2) - 1; i++) {
			System.out.print(
				" PARENT : " + Heap[i]
				+ " LEFT CHILD : " + Heap[2 * i + 1]
				+ " RIGHT CHILD :" + Heap[2 * i + 2]);
			System.out.println();
		}
	}

	// Method 9
	// Remove an element from max heap
	public int extractMax() throws Exception
	{
		if (size>=1) {
			int popped = Heap[0];
			Heap[0] = Heap[--size];
			Heap[size]=0;
			maxHeapify(0);
			//System.out.println(size);
			return popped;
		}
		throw new Exception(" you cannot extract from the heap: it is empty!");
	}
}
