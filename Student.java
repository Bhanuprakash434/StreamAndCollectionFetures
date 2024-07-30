package Java8CommonProgramming;

import java.util.List;

public class Student {

	private int id;
	private String Name;
	private int age;
	private String gender;
	private String Dept;
	private String city;
	private int rant;
	private List<String> contacts;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDept() {
		return Dept;
	}
	public void setDept(String dept) {
		Dept = dept;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getRant() {
		return rant;
	}
	public void setRant(int rant) {
		this.rant = rant;
	}
	public List<String> getContacts() {
		return contacts;
	}
	public void setContacts(List<String> contacts) {
		this.contacts = contacts;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + Name + ", age=" + age + ", gender=" + gender + ", Dept=" + Dept
				+ ", city=" + city + ", rant=" + rant + ", contacts=" + contacts + "]";
	}
	public Student(int id, String name, int age, String gender, String dept, String city, int rant,
			List<String> contacts) {
		super();
		this.id = id;
		Name = name;
		this.age = age;
		this.gender = gender;
		Dept = dept;
		this.city = city;
		this.rant = rant;
		this.contacts = contacts;
	}
	 {

}
}
