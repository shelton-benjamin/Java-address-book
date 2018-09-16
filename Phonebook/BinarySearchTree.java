package phonebook;

//BJS - BinarySearchTree class points to the root or first leaf on tree
public class BinarySearchTree {

	//BJS - node that serves as root of tree
	private Node root;
	
	//BJS - constructor for BinarySearchTree
	public BinarySearchTree() 
	{
		//BJS - set root of the tree to null
		this.root = null;
	}

	//BJS - insert method called by user to add a contact to the phonebook
	public void insert(String firstName, String lastName, String phoneNumber, String emailAddress)
	{
		//BJS - calls nameConverter method on the firstName and lastName parameters
		String name = nameConverter(firstName, lastName);
		
		//BJS - creates a new Person instance using above name string
		//plus phoneNumber and emailAddress parameters
		Person contact = new Person(name, phoneNumber, emailAddress);
		
		//BJS - message to indicate the new entry has been added
		String inserted = (name + " has been added to your contacts.");

		//BJS - if the tree has no root,
		//the new entry becomes the root
		if (root == null)
		{
			Node newEntry = new Node(name, contact);
			root = newEntry;
			root.setParent(null); 
			System.out.println(inserted);
		}

		//BJS - if the tree already has a root,
		//call the Node insert method on the root
		else
		{
			root.insert(name, contact);
		}


	}
	
	//BJS - lookup method called by the user to find an entry in the phonebook
	public void lookup(String firstName, String lastName)
	{
		String name = nameConverter(firstName, lastName);
		
		//BJS - message displayed if phonebook is empty
		String empty = (name + " was not found because your contacts are empty.");

		//BJS - if the tree is empy, display the empty message
		if (root == null)
		{
			System.out.println(empty);
		}

		//BJS - if the tree is not empty,
		//call Node lookup method on the root
		else
		{
			root.lookup(name);
		}
	}

	//BJS - delete method called by the user to remove an entry from the phonebook
	public void delete(String firstName, String lastName)
	{
		String name = nameConverter(firstName, lastName);
		
		//BJS - messages to indicate whether entry was deleted
		String empty = (name + " was not deleted because your contacts are empty.");
		String deleted = (name + " has been deleted from your contacts.");

		//BJS - if the tree is empty, display the empty/not deleted message
		if (root == null)
		{
			System.out.println(empty);
		}

		//BJS - if the node to be deleted is the root
		else if (root.getKey().compareTo(name) == 0)

		{
			//BJS - display the deleted message
			System.out.println(deleted);

			//BJS - if the root has no children, set the root to null
			if (root.getLeftChild() == null && root.getRightChild() == null)
			{
				root = null;
			}
			
			//BJS - if the root has a left child and no right child
			//set the root to the left child
			else if (!(root.getLeftChild() == null) && root.getRightChild() == null)
			{
				root = root.getLeftChild();
				
				//BJS - set the parent of the replacement from the root to null
				root.setParent(null);
			}
			
			//BJS - if the root has a right child and no left child
			//set the root to the right child
			else if(root.getLeftChild() == null && !(root.getRightChild() == null))
			{
				root = root.getRightChild();		
				root.setParent(null);
			}
				
			//BJS - if the root has two children
			else
			{
				//BJS - create a placeholder node and 
				//set it to the replacement found
				//when getReplacement is called on the root
				Node tempNode = root.getReplacement();
				
				//BJS - set the replacement's parents and children
				//to the root's
				tempNode.setParent(null);
				tempNode.setLeftChild(root.getLeftChild());
				tempNode.setRightChild(root.getRightChild());
				
				//BJS - set the root to the replacement
				root = tempNode;
				
				//BJS - set the new root's children's parent fields
				//to reference the new root
				root.getLeftChild().setParent(root);
				root.getRightChild().setParent(root);
			}
		}

		//BJS - if the node to be deleted is not the root,
		//call the delete method on the root
		else
		{
			root.delete(name);
		}
	}

	//BJS - sets the first and last name entered by the user
	//to a single string that is a concatenation of both
	//and in upper case
	private String nameConverter(String firstName, String lastName)
	{
		String fullName = (firstName + " " + lastName).toUpperCase();
		return fullName;
	}

}

