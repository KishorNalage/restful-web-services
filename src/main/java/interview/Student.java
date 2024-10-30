package interview;

public class Student {
	private int id;
	private String name;
	private String city;
	private double marks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public Student(int id, String name, String city, double marks) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", marks=" + marks + "]";
	}
	
	//select * from student where marks in (100,2000);
    // select name  from student s1   where N =( select count(marks) from student s2 where s1.marks>s2.marks))
	//highest marks,name for each city
	
	//  select distinct(city) from student
	
}
