package phonebook;
public class TreeMain {
	public static void main(String[] args) {
		BinarySearchTree myTree = new BinarySearchTree();
		myTree.insert("Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");
		myTree.insert("Jane", "Williams", "555-235-1112", "jw@something.com");
		myTree.insert("Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com");
		myTree.insert("Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");
		myTree.insert("Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");
		myTree.insert("H.", "Houdini", "555-235-1116", "houdini@noplace.com");
		myTree.insert("Jack", "Jones", "555-235-1117", "jjones@hill.com");
		myTree.insert("Jill", "Jones", "555-235-1118", "jillj@hill.com");
		myTree.insert("John", "Doe", "555-235-1119", "jdoe@somedomain.com");
		myTree.insert("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");
		myTree.lookup("Pat", "Jones");
		myTree.lookup("Billy", "Kidd");
		myTree.delete("John", "Doe");
		myTree.insert("Test", "Case", "555-235-1121", "Test_Case@testcase.com");
		myTree.insert("Nadezhda", "Kanachekhovskaya", "555-235-1122", 
				"dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
		myTree.insert("Jo", "Wu", "555-235-1123", "wu@h.com");
		myTree.insert("Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.us");
		myTree.insert("Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
		myTree.insert("Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");
		myTree.lookup("Jack", "Jones");
		myTree.lookup("Nadezhda", "Kanachekhovskaya");
		myTree.delete("Jill", "Jones");
		myTree.delete("John", "Doe");
		myTree.lookup("Jill", "Jones");
		myTree.lookup("John", "Doe");
		
	}

}
