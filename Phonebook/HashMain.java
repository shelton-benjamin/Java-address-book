package phonebook;
public class HashMain {
	public static void main(String[] args) {
		HashTable myTable = new HashTable();
		myTable.insert("Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");
		myTable.insert("Jane", "Williams", "555-235-1112", "jw@something.com");
		myTable.insert("Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com");
		myTable.insert("Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");
		myTable.insert("Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");
		myTable.insert("H.", "Houdini", "555-235-1116", "houdini@noplace.com");
		myTable.insert("Jack", "Jones", "555-235-1117", "jjones@hill.com");
		myTable.insert("Jill", "Jones", "555-235-1118", "jillj@hill.com");
		myTable.insert("John", "Doe", "555-235-1119", "jdoe@somedomain.com");
		myTable.insert("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");
		myTable.lookup("Pat", "Jones");
		myTable.lookup("Billy", "Kidd");
		myTable.delete("John", "Doe");
		myTable.insert("Test", "Case", "555-235-1121", "Test_Case@testcase.com");
		myTable.insert("Nadezhda", "Kanachekhovskaya", "555-235-1122", 
				"dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
		myTable.insert("Jo", "Wu", "555-235-1123", "wu@h.com");
		myTable.insert("Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.us");
		myTable.insert("Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
		myTable.insert("Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");
		myTable.lookup("Jack", "Jones");
		myTable.lookup("Nadezhda", "Kanachekhovskaya");
		myTable.delete("Jill", "Jones");
		myTable.delete("John", "Doe");
		myTable.lookup("Jill", "Jones");
		myTable.lookup("John", "Doe");
		
	}

}
