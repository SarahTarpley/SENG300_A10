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

	// Method 10
	// main dri er method
	public static void main(String[] args) throws Exception
	{
		int numelements = 21;

		MaxHeap2 maxHeap = new MaxHeap2(numelements);

		// Inserting nodes
		// Custom inputs
		//8,9,16,1, 25, 4}
			
		maxHeap.insert(8);
		maxHeap.insert(9);
		maxHeap.insert(16);
		maxHeap.insert(1);
		maxHeap.insert(25);
		maxHeap.insert(4);
		maxHeap.insert(2);
		// Calling maxHeap() as defined above
		
		// Display message for better readability
		System.out.println("The Max Heap is ");
		maxHeap.print();
		System.out.println();
		
		int heapStartSize = maxHeap.size;
		for (int i = 0; i < heapStartSize; i++) {
			// Print and display the maximum value in heap
			System.out.println("The max val is "+ maxHeap.extractMax());
	         maxHeap.print();
		}
		System.out.println("\r\n");
		
		MinHeap minHeap = new MinHeap(numelements);
	
		minHeap.insert(8);
		minHeap.insert(9);
		minHeap.insert(16);
		minHeap.insert(1);
		minHeap.insert(25);
		minHeap.insert(4);
		minHeap.insert(2);
		
		// Display message for better readability
		System.out.println("The Min Heap is ");
		minHeap.print();
		System.out.println();
		
		for (int i = 0; i < minHeap.size; i++) {
			// Print and dis10lay the maximum value in heap
			System.out.println("The min val is "+ minHeap.extractMin());
	         minHeap.print();
		}
		
		/*maxHeap.insert(5);
		maxHeap.insert(3);
		maxHeap.insert(17);
		maxHeap.insert(10);
		maxHeap.insert(84);
		maxHeap.insert(19);
		maxHeap.insert(6);
		maxHeap.insert(22);
		maxHeap.insert(9);
*/



	}
}
