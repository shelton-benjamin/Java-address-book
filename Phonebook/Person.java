package phonebook;

//BJS - Person class represents an entry in the phonebook.
public class Person {

	//BJS - Person's name 
	//stored as concatenated first and last names in upper case
	private String name;

	//BJS - Person's phone number
	private String phone;

	//BJS - Person's email address
	private String email;


	//BJS - constructor for Person class
	public Person(String name, String phone, String email) {

		this.name = name;
		this.phone = phone;
		this.email = email;
	}


	//BJS - getter for the name 
	public String getName() {
		return name;
	}


	//BJS - getter for the phone number
	public String getPhone() {
		return phone;
	}


	//BJS - getter for the email address
	public String getEmail() {
		return email;
	}




}
