class ArrayBub
{
	private long[] a;		// reference to a array
	private int nElems;		//  number of array

	public ArrayBub(int max)
	{
		a = new long[max];
		nElems = 0;
	}

	public int size()
	{
		return nElems;
	}

	public void insert(long value)
	{
		a[nElems] = value;
		nElems++;
	}

	public void display()
	{
		for(int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println("");
	}

	public void bubbleSort()
	{
		//	应该是从 nElems - 1 开始排好序, 
		//	到第二个下标为 1 才对，答案写错了
		for(int outer = nElems - 1; outer > 0; outer--)
		{
			for(int in = 0; in < outer; in++)
			if(a[in] > a[in + 1])
				swap(in, in + 1);
			display();
		}
	}

	public void swap(int one, int two)
	{
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}

class BubbleSortWrpApp
{
	public static void main(String[] args) 
	{
		int maxSize = 100;

		ArrayBub arr;
		arr = new ArrayBub(maxSize);

		// insert 10 items
		arr.insert(33);
		arr.insert(22);
		arr.insert(88);
		arr.insert(55);
		arr.insert(77);
		arr.insert(00);
		arr.insert(99);
		arr.insert(11);
		arr.insert(44);
		arr.insert(66);

		arr.display();
		arr.bubbleSort();
		arr.display();
	}
}