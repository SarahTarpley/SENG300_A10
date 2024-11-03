
public class MinHeap extends MaxHeap2{

	// Constructor to initialize an
	// empty max heap with given maximum
	// capacity

	public MinHeap(int maxsize) {
		super(maxsize);
		this.size = 0;
		Heap = new int[this.maxsize];
	}

	private void minHeapify(int pos)
	{
		if (isLeaf(pos))
			return;
		
		if(rightChild(pos)>= size) {
			
			if (Heap[pos] > Heap[leftChild(pos)]) {
				swap(pos, leftChild(pos));
				minHeapify(leftChild(pos));
			}
			return;
		}

		if (Heap[pos] > Heap[leftChild(pos)]
			|| Heap[pos] > Heap[rightChild(pos)]) {

			if (Heap[leftChild(pos)]
				< Heap[rightChild(pos)]) {
				swap(pos, leftChild(pos));
				minHeapify(leftChild(pos));
			}
			else {
				swap(pos, rightChild(pos));
				minHeapify(rightChild(pos));
			}
		}
	}
	
	@Override
	public void insert(int element)
	{
		Heap[size] = element;

		// Traverse up and fix violated property
		int current = size;
		while (Heap[current] < Heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
		size++;
	}
	
	public int extractMin() throws Exception
	{
		if (size>=1) {
			int popped = Heap[0];
			Heap[0] = Heap[--size];
			Heap[size]=0;
			minHeapify(0);
			return popped;
		}
		throw new Exception(" you cannot extract from the heap: it is empty!");
	}
	@Override public void print() {
		super.print();
	}
}
