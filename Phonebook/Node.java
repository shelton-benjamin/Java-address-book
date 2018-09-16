package phonebook;

//BJS - Node class is a node or leaf on the BinarySearchTree
public class Node {

	//	BJS - key for each node, identical to the name for the respective contact
	private String key;

	//	BJS - the instance of Person stored in each node
	private Person contact;

	//	BJS - the parent node of this node
	private Node parent;

	//	BJS - the left child of this node
	private Node leftChild;

	//	BJS - the right child of this node
	private Node rightChild;

	//	BJS - constructor for the node
	public Node(String key, Person contact) 
	{
		this.key = key;
		this.contact = contact;
	}

	//	BJS - method to insert a new entry into the phone book
	//	parameters are passed from the BinarySearchTree insert method
	public void insert(String key, Person contact)
	{
		//		BJS - messages to indicate if contact was added or updated
		String inserted = (key + " has been added to your contacts.");
		String updated = (key + " was already in your contacts and their information has been updated.");

		//		BJS - if the key of the new entry is less than the key of the current node
		if (key.compareTo(this.key) < 0)
		{
			//	BJS - if this node doesn't have a left child
			//	create a new node using the passed key and contact
			//	set this node's left child to the new node
			//	set the left child's parent to this node
			//	print the contact inserted message
			if (leftChild == null)
			{
				Node newEntry = new Node(key, contact);
				leftChild = newEntry;
				leftChild.setParent(this);
				System.out.println(inserted);
			}

			//	BJS - if this node has a left child
			//	call the insert method on the left child
			else
			{
				leftChild.insert(key, contact);
			}
		}

		//	BJS - if the key of the new entry is greater than the key of the current node
		else if (key.compareTo(this.key) > 0)
		{
			//	BJS - if this node doesn't have a right child
			//	create a new node using the passed key and contact
			//	set this node's right child to the new node
			//	set the right child's parent to this node
			//	print the contact inserted message
			if (rightChild == null)
			{
				Node newEntry = new Node(key, contact);
				rightChild = newEntry;
				rightChild.setParent(this);
				System.out.println(inserted);
			}

			//	BJS - if this node has a right child
			//	call the insert method on the right child
			else
			{
				rightChild.insert(key, contact);
			}
		}

		//	BJS - if this entry matches this node, it is already in the phonebook
		//	set the key and contact information to the passed parameters
		//	print the contact updated message
		else
		{
			this.key = key;
			this.contact = contact;
			System.out.println(updated);

		}
	}

	//BJS - lookup method to find an entry in the phonebook
	//parameter passed from the BinarySearchTree lookup method
	public void lookup(String key)
	{
		//		BJS - messages to indicate if entry is or is not in phonebook
		String found = (key + " has been found in your contacts.");
		String notFound = (key + " is not listed in your contacts.");

		//	BJS - if the key we're searching for equals the current node's key,
		//	we've found the correct entry,
		//	print the found message
		//	return its information by calling Node getter methods
		if (this.key.compareTo(key) == 0)
		{
			System.out.println(found);
			System.out.println("Name: " + this.getName());
			System.out.println("Phone: " + this.getPhone());
			System.out.println("Email: " + this.getEmail());
		}

		//	BJS - if the key we're searching for is less than
		//	the current node's key
		else if (key.compareTo(this.key) < 0)
		{
			//	BJS - if this node has no left child,
			//	the entry is not in the phonebook,
			//	print the not found message
			if (leftChild == null)
			{
				System.out.println(notFound);
			}

			//	BJS - if this node has a left chid,
			//	call the lookup method on it
			else
			{
				leftChild.lookup(key);
			}
		}

		//	BJS - if the key we're searching for is greater than
		//	the current node's key
		else
		{

			//	BJS - if this node has no right child,
			//	the entry is not in the phonebook,
			//	print the not found message
			if (rightChild == null)
			{
				System.out.println(notFound);
			}

			//	BJS - if this node has a right chid,
			//	call the lookup method on it
			else
			{
				rightChild.lookup(key);
			}
		}
	}


	//	BJS - delete method to remove an entry from the phonebook
	//	parameter passed from the BinarySearchTree delete method
	public void delete(String key)
	{
		//	BJS - messages to indicate if the entry was deleted or not
		String notDeleted = (key + " was not deleted because they are not in your contacts.");
		String deleted = (key + " was deleted from your contacts.");

		//	BJS - if the key of entry to be deleted
		//	is less than the key of the current node
		if (key.compareTo(this.key) < 0)
		{

			//BJS - if the current node has no left child,
			//the entry is not in the phonebook
			//print the not deleted message
			if (leftChild == null)
			{
				System.out.println(notDeleted);
			}

			//			BJS - if the current node has a left child,
			//			call the delete method on it
			else
			{
				leftChild.delete(key);
			}
		}

		//		BJS - if the key of entry to be deleted
		//		is greater than the key of the current node
		else if (key.compareTo(this.key) > 0)
		{

			//BJS - if the current node has no right child,
			//the entry is not in the phonebook
			//print the not deleted message
			if (rightChild == null)
			{
				System.out.println(notDeleted);
			}

			//	BJS - if the current node has a right child,
			//	call the delete method on it
			else 
			{
				rightChild.delete(key);
			}
		}

		//	BJS - if we've found the entry we want to delete
		else
		{
			//	BJS - print the deleted message
			System.out.println(deleted);

			//	BJS - create the boolean lefty to tell us if the node
			//	we're deleting is a left or right child
			boolean lefty;

			//	BJS - if this node's key is less than its parent's key,
			//	it's a left child
			if (this.key.compareTo(parent.key) < 0 )
			{
				lefty = true;
			}

			//	BJS - if this node's key is greater than its parent's key,
			//	it's a right child
			else
			{
				lefty = false;
			}

			//	BJS - if the node to be deleted has no children
			//	set its parent's left child to null if it's a left child
			//	or its parent's right child to null if it's a right child
			if (leftChild == null && rightChild == null)
			{
				if (lefty)
				{
					parent.leftChild = null;
				}

				else
				{
					parent.rightChild = null;
				}

			}

			//BJS - if the node to be deleted has a left child but no right child,
			//replace the node with its left child
			else if (!(leftChild == null) && rightChild == null)
			{
				//BJS - create a placeholder node 
				//	for the left child's information
				Node tempNode = leftChild;

				//BJS - set the placeholder's parent to 
				//	the parent of the node that is being deleted
				tempNode.parent = this.parent;

				//BJS - set the left child to null
				leftChild = null;

				//BJS - set the left child of the parent to the placeholder 
				//node if its a left child or to the right child if its a right child
				if (lefty)
				{
					parent.leftChild = tempNode;
				}

				else
				{
					parent.rightChild = tempNode;
				}

			}

			//BJS - if the node to be deleted has a right child but no left child,
			//replace the node with its right child
			else if (leftChild == null && !(rightChild == null))
			{
				Node tempNode = rightChild;
				tempNode.parent = this.parent;
				rightChild = null;

				if (lefty)
				{
					parent.leftChild = tempNode;
				}

				else
				{
					parent.rightChild = tempNode;
				}
			}

			//BJS - if the node to be deleted has two children,
			//replace it once we find a suitable replacement
			else
			{
				//BJS - create a placeholder node
				//call the getReplacement method on the node to be deleted
				//set the placeholder node to the replacement  
				Node tempNode = this.getReplacement();

				//BJS - set the parent, left child, and right child
				//of the placeholder node to that of 
				//the node being deleted
				tempNode.parent = this.parent;
				tempNode.leftChild = this.leftChild;
				tempNode.rightChild = this.rightChild;

				//BJS - set the parent of the current node 
				//to be delete's children to the placeholder node
				leftChild.parent = tempNode;
				rightChild.parent = tempNode;


				if (lefty)
				{

					parent.leftChild = tempNode;
				}

				else
				{
					parent.rightChild = tempNode;
				}
			}

		}
	}


	//BJS - called by delete method if node to be deleted has two children
	//returns a suitable replacement
	public Node getReplacement()
	{
		//BJS - create a placeholder node,
		//set to the current node's right child
		Node tempNode = this.rightChild;

		//BJS - finds the node with the smallest key
		//from the right branch of the node to be deleted
		while (tempNode.leftChild != null)
		{
			tempNode = tempNode.leftChild;
		}

		//BJS - set a new node to the placeholder node
		Node replacement = tempNode;

		//BJS - call the privateDelete method to delete
		//the replacement we found at its original position
		tempNode.privateDelete();

		//BJS - return the replacement node
		return replacement;
	}

	//BJS - delete method called only within Node class,
	//follows same algorithm as second part of regular delete method
	//except it doesn't display any messages to the user
	//refer to above delete method for further documentation
	private void privateDelete()
	{
		boolean lefty;

		if (this.key.compareTo(parent.key) < 0 )
		{
			lefty = true;
		}

		else
		{
			lefty = false;
		}

		if (leftChild == null && rightChild == null)
		{
			if (lefty)
			{
				parent.leftChild = null;
			}

			else
			{
				parent.rightChild = null;
			}

		}

		else if (!(leftChild == null) && rightChild == null)
		{
			Node tempNode = leftChild;
			tempNode.parent = this.parent;
			leftChild = null;

			if (lefty)
			{
				parent.leftChild = tempNode;
			}

			else
			{
				parent.rightChild = tempNode;
			}

		}

		else if (leftChild == null && !(rightChild == null))
		{
			Node tempNode = rightChild;
			tempNode.parent = this.parent;
			rightChild = null;

			if (lefty)
			{
				parent.leftChild = tempNode;
			}

			else
			{
				parent.rightChild = tempNode;
			}
		}

		else
		{
			Node tempNode = this.getReplacement();
			tempNode.parent = this.parent;
			tempNode.leftChild = this.leftChild;
			tempNode.rightChild = this.rightChild;
			leftChild.parent = tempNode;
			rightChild.parent = tempNode;

			if (lefty)
			{
				parent.leftChild = tempNode;
			}

			else
			{
				parent.rightChild = tempNode;
			}
		}
	}

	//BJS - getter for the name of the node's contact,
	//calls the Person's name getter method
	private String getName()
	{
		String name = contact.getName();
		return name;
	}

	//BJS - getter for the phone number of the node's contact,
	//calls the Person's phone getter method
	private String getPhone()
	{
		String phone = contact.getPhone();
		return phone;
	}

	//BJS - getter for the email address of the node's contact,
	//calls the Person's email getter method
	private String getEmail()
	{
		String email = contact.getEmail();
		return email;
	}

	//BJS - setter for the node's parent
	public void setParent(Node parent) 
	{
		this.parent = parent;
	}

	//BJS - getter for the node's key
	public String getKey() 
	{
		return key;
	}

	//BJS - getter for the node's left child
	public Node getLeftChild() 
	{
		return leftChild;
	}

	//BJS - getter for the node's right child
	public Node getRightChild() 
	{
		return rightChild;
	}

	//BJS - setter for the node's left child
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	//BJS - setter for the node's right child
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}


}
