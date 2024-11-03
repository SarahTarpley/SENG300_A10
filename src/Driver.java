import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Driver {
	
	//Solving https://www.hackerrank.com/challenges/jesse-and-cookies/problem
	public static int HR_Cookies(int k, List<Integer> A) {
		// to keep track of number of iterations to achieve goal of k
		int numPasses = 0;
		// input - array size of 6, sweetness of >= 7
		int listLength = A.size();
		MinHeap cookieHeap = new MinHeap(listLength);
		
		for(int i = 0; i < listLength; i++) {
			cookieHeap.insert(A.get(i));
		}
		
        try {
            int root = cookieHeap.extractMin();
            while(root < k) {
                int rootChild = cookieHeap.extractMin();
                int newCookie = root + 2*rootChild;
                cookieHeap.insert(newCookie);
                root = cookieHeap.extractMin();
                numPasses++;
            }
		} catch (Exception e) {
			// will throw error when no more cookies remain
			System.out.println(cookieHeap.size);
			e.printStackTrace();
			return -1;
		}
		return numPasses;
	}
	
	public static void Task01(){
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
			try {
				System.out.println("The max val is "+ maxHeap.extractMax());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			try {
				System.out.println("The min val is "+ minHeap.extractMin());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	public static void Task02() {
		int listLength = 100000;
		int sweetness = 105823341;
		int[] cookies = new int[listLength];
		for(int i = 0; i < listLength; i++) {
			cookies[i] = 1;
		}
		
		List<Integer> cookiesArray = new ArrayList<>() {{
			IntStream.of(cookies).forEach(
				i -> add(Integer.valueOf(i))
			);
		}};
		//System.out.println(cookiesArray);

		System.out.println(HR_Cookies(sweetness, cookiesArray));
	}
	
	public static void main(String[] args) throws Exception
	{
		System.out.println("Example case for Task 01 completed: ");
		Task01();
		System.out.println("\r\n");
		System.out.println("Example case for Task 02 completed: ");
		Task02();
	}
}
