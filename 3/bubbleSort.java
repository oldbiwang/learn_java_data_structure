// bubbleSort.java
class ArrayBub
{
	private long[] a;		// ref to array a
	private int nElems;		// number od data items
	// --------------------------------------------
	// constructor
	public ArrayBub(int max)
	{
		a = new long[max];		// create the array
		nElems = 0;				// no items yet
	}
	//----------------------------------------------
	// put element into array
	public void insert(long value)	 
	{
		a[nElems] = value;		// insert it
		nElems++;				// increment size
	}
	// ---------------------------------------------
	public void display()
	{
		for(int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println("");
	}
	// -----------------------------------------------
	public void bubbleSort()
	{
		int out, in;

		// outer loop(backward)
		for(out = nElems - 1; out > 1; out--)
		{
			// inner loop
			for(in = 0; in < out; in++)
				// out of order?
				if(a[in] > a[in + 1])
					// swap them
					swap(in, in + 1);
			display();
		}
	}	// end bubbleSort()
	// ------------------------------------------------
	private void swap(int one, int two)
	{
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}	
	// ------------------------------------------------
}	// end class ArrayBub
///////////////////////////////////////////////////////
class BubbleSortApp
{
	public static void main(String[] args)
	{
		int maxSize = 100;		// array size
		ArrayBub arr;			// reference tp array
		arr = new ArrayBub(maxSize);	// create the array

		arr.insert(112);
		arr.insert(115);
		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		arr.insert(200);

		arr.display();		// display items

		arr.bubbleSort();	// bubble sort them
		arr.display();		// display them again
	}	// end main()
}	// end class BubbleSortApp