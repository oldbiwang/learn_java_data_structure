// objectSort.java
// demonstrates sorting onjects (uses insertion sort)
// to run this program: C>java ObjectSortApp
////////////////////////////////////////////////////
class Person
{
	private String lastName;
	private String firstName;
	private int age;
	//---------------------------------
	public Person(String last, String first, int a)
	{
		lastName = last;
		firstName = first;
		age = a;
	}
	//------------------------------------
	public void displayPerson()
	{
		System.out.print("    Last name: " + lastName);
		System.out.print(", First name: " + firstName);
		System.out.println(", Age: " + age);
	}
	//-------------------------------------
	public String getLast()
	{
		return lastName;
	}
	//--------------------------------------
}	// end class Person
////////////////////////////////////////////////////////
class ArrayInOb
{
	private Person[] a;			// ref to array a
	private int nElems;			// number of data items
	//--------------------------------------------------
	public ArrayInOb(int max)
	{
		a = new Person[max];
		nElems = 0;
	}
	//---------------------------------------------------
	// put person into array
	public void insert(String last, String first, int age)
	{
		a[nElems] = new Person(last, first, age);
		nElems++;
	}
	//----------------------------------------------------
	public void display()
	{
		for(int j = 0; j < nElems; j++)
			a[j].displayPerson();
		System.out.println("");
	}
	//----------------------------------------------------
	public void insertionSort()
	{
		int in, out;

		for(out = 1; out < nElems; out++)
		{
			Person temp = a[out];
			in = out;

			while(in > 0 && 
				a[in - 1].getLast().compareTo(temp.getLast()) > 0)
			{
				a[in] = a[in - 1];
				--in;
			}
			a[in] = temp;
		}
	}
}
/////////////////////////////////////////////////////////////////////
class ObjectSortApp
{
	public static void main(String[] args)
	{
		int maxSize = 100;
		ArrayInOb arr;
		arr = new ArrayInOb(maxSize);

		arr.insert("Evans", "Patty", 24);
		arr.insert("Smith", "Doc", 59);
		arr.insert("Smith", "Lorraine", 37);
		arr.insert("Smith", "Paul", 37);
		arr.insert("Yee", "Tom", 43);
		arr.insert("Hashimoto", "Sato", 21);
		arr.insert("Stimson", "Henry", 29);
		arr.insert("Velasquez", "Jose", 72);
		arr.insert("Vang", "Minh", 22);
		arr.insert("Creswell", "Lucinda", 18);

		System.out.println("Before sorting:");
		arr.display();

		arr.insertionSort();

		System.out.println("After sorting:");
		arr.display();
	}
}