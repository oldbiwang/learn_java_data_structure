class Person
{
	private String lastName;
	private String firstName;
	private int age;

	// --------------------------------------------
	// constructor
	public Person(String last, String first, int a)
	{
		lastName = last;
		firstName = first;
		age = a;
	}
	// --------------------------------------------
	public void displayPerson()
	{
		System.out.print(" Last name: " + lastName);
		System.out.print(", First name: " + firstName);
		System.out.println(", Age: " + age);
	}
	// ----------------------------------------------
	// get last name
	public String getLast()			
	{
		return lastName;
	}		
} //end class Person
//////////////////////////////////////////////////////
class ClassDataArray
{
	private Person[] a;			// reference to array
	private int nElems;			// number od data items

	// constructor
	public ClassDataArray(int max)
	{
		a = new Person[max];		// create the array
		nElems = 0;
	}
	//-------------------------------------------------
	public Person find(String searchName)
	{
		// find specified value
		int j;
		// for each element
		for(j = 0; j < nElems; j++)
			// found item?
			if(a[j].getLast().equals(searchName))
				break;
		if(j == nElems)
			return null;
		else
			return a[j];		// no, found it
	}	// end find()
	//------------------------------------------------
	// put person into array
	public void insert(String last, String first, int age)
	{
		a[nElems] = new Person(last, first, age);
		nElems++;								// increment size
	}
	//-------------------------------------------------
	public boolean delete(String searchName)
	{
		// delete person from array
		int j;
		// look for it
		for(j = 0; j < nElems; j++)
			if(a[j].getLast().equals(searchName))
				break;
		// can't find it
		if(j == nElems)
			return false;
		else
		{
			for(int k = j; k < nElems; k++)		// shift down
				a[k] = a[k+1];
			nElems--;						// decrement size
			return true;
		}
	}	// end delete()
	//---------------------------------------------------
	// displays array contents
	public void displayA()	
	{
		// for each element
		for(int j = 0; j < nElems; j++)
			a[j].displayPerson();			//display it
	}
}	// end class ClassDataArray
//////////////////////////////////////////////////////////
class ClassDataApp
{
	public static void main(String[] args) 
	{
		int maxSize = 100;		// array size
		ClassDataArray arr;		// reference to array
		arr = new ClassDataArray(maxSize);	// create the array

		arr.insert("Evans", "Patty", 24);
		arr.insert("Smith", "Lorraine", 37);
		arr.insert("Yee", "Tom", 43);
		arr.insert("Adams", "Henry", 63);
		arr.insert("Hashimoto", "Sato", 21);
		arr.insert("Stimson", "Henry", 29);
		arr.insert("Velasquez", "Jose", 72);
		arr.insert("Lamarque", "Henry", 54);
		arr.insert("Vang", "Minh", 22);
		arr.insert("Creswell", "Lucinda", 18);

		arr.displayA();		// display items

		String searchKey = "Stimson";	// search for item
		Person found;
		found = arr.find(searchKey);
		if(found != null)
		{
			System.out.print("Found ");
			found.displayPerson();
		}
		else
		{
			System.out.println("Can't find " + searchKey);
		}

		System.out.println("Deleteing Smith, Yee, and CresWell");
		arr.delete("Smith");
		arr.delete("Yee");
		arr.delete("Creswell");

		arr.displayA();
	}	// end main()
}		// end class ClassDataApp
