package phonebook;

//BJS - HashTable class for the phonebook
public class HashTable {

	// BJS - number of buckets contained in the array
	private int numberOfBuckets;

	//BJS - HashTable class contains an array with 
	//a binary search tree in each bucket
	private BinarySearchTree[] hashArray;


	//BJS - constructor for HashTable
	public HashTable() 
	{
		//BJS - set the number of buckets to 13
		//and set the array to contain 13 elements
		this.numberOfBuckets = 13;
		this.hashArray = new BinarySearchTree[numberOfBuckets];

		//BJS - plants a (blank) tree in each bucket of the array
		for (int i = 0; i < numberOfBuckets; i++)
		{
			BinarySearchTree nuTree = new BinarySearchTree();
			hashArray[i] = nuTree;
		}
	}

	//BJS - insert method called by user to add a contact to the phonebook
	public void insert(String firstName, String lastName, String phoneNumber, String emailAddress)
	{
		//BJS - calls nameConverter method on the firstName and lastName parameters
		String name = nameConverter(firstName, lastName);

		//BJS - call findTheHash method on the above name string,
		//set new integer key to hash code that's returned
		//key is the bucket in the array for the new entry
		int key = findTheHash(name);

		//BJS - call (BinarySearchTree) insert method on the appropriate bucket
		hashArray[key].insert(firstName, lastName, phoneNumber, emailAddress);

	}

	//BJS - lookup method called by the user to find an entry in the phonebook
	public void lookup(String firstName, String lastName)
	{
		String name = nameConverter(firstName, lastName);
		int key = findTheHash(name);

		//BJS - call (BinarySearchTree) lookup method on the appropriate bucket
		hashArray[key].lookup(firstName, lastName);

	}

	//BJS - delete method called by the user to remove an entry from the phonebook
	public void delete(String firstName, String lastName)
	{
		String name = nameConverter(firstName, lastName);
		int key = findTheHash(name);

		//BJS - call (BinarySearchTree) delete method on the appropriate bucket
		hashArray[key].delete(firstName, lastName);
	}

	//BJS - sets the first and last name entered by the user
	//to a single string that is a concatenation of both
	//and in upper case
	private String nameConverter(String firstName, String lastName)
	{
		String fullName = (firstName + " " + lastName).toUpperCase();
		return fullName;
	}


	//BJS - returns the appropriate bucket for the entry
	//we're trying to insert, lookup, or delete
	private int findTheHash(String name)
	{
		//BJS - call hashCode method on the name parameter
		//set integer key to that hash
		int key = name.hashCode();

		//BJS - if the hash is a negative number,
		//change it to positive
		if (key < 0)
		{
			key = (key * -1);

		}

		//BJS - set the key to the hash modulo by number of buckets (13)
		key = (key % numberOfBuckets);

		return key;

	}



}
