// HighArray.java

class HighArray 
{
	private long[] a;			// ref to array a
	private int nElems;			// number of data items 

	// ------------------------------------------------
	// constructor 
	public HighArray(int max)	
	{	
		a = new long[max];		// create the array
		nElems = 0;				// no items yet
	}
	//-------------------------------------------------
	// find specified value
	public boolean find(long searchKey) 	
	{
		int j;

		for(j = 0; j < nElems; j++)		// for each element
			if(a[j] == searchKey)		// find item?
				break;					// exit loop before end
		if(j == nElems)					// gone to end
			return false;				// yes, can't find it
		else
			return true;				// no, found it
	}	// end find()
	// --------------------------------------------------
	// put element into array
	public void insert(long value)	
	{
		a[nElems] = value;				// insert it
		nElems++;						// increment size
	}
	// --------------------------------------------------
	public boolean delete(long value)
	{
		int j;
		for(j = 0; j < nElems; j++)			// look for it
			if(a[j] == value) 
				break;
		if(j == nElems)						// can't find it
			return false;
		else                                // found it
		{
			for(int k = j; k < nElems; k++)		// move higher ones down
				a[k] = a[k + 1];
			nElems--;
			return true;
		}	
	}	// end delete
	// --------------------------------------------------
	// displays array contents
	public void display()	
	{
		for(int j = 0; j < nElems; j++)			// for each element
			System.out.print(a[j] + " ");		// display it
		System.out.println("");
	}				
	// -----------------------------------------------------
	// get max
	public long getMax()
	{
		long max = -1;
		if(nElems == 0)
			return max;
		for(int j = 0; j < nElems; j++)
			if(a[j] > max)
				max = a[j];
		return max;
	}
}	// end class HighArray

/////////////////////////////////////////////////////
class HighArrayApp 
{
	public static void main(String[] args)
	{
		int maxSize = 100;		// array size
		HighArray arr;			// reference to array
		arr = new HighArray(maxSize);	// create the array

		System.out.println("getMax() = " + arr.getMax());

		arr.insert(77);			// insert 10 items
		arr.insert(99); 		
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

		System.out.println("getMax() = " + arr.getMax());

		arr.display();			// display items

		int searchKey = 35;		// search for item
		if(arr.find(searchKey))
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can't find " + searchKey);

		arr.delete(00);			// delete 3 items
		arr.delete(55);			
		arr.delete(99);

		arr.display();			// display items again
	}	// end main()
}		// end class HighArrayAppr