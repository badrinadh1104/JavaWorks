package Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TeacherDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String city;
	private String Hobbie;
	@OneToOne(mappedBy = "teacherDetails",cascade = CascadeType.ALL)
	private Teacher teacher;
	
	public TeacherDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TeacherDetails( String city, String hobbie) {
		super();
		this.city = city;
		Hobbie = hobbie;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHobbie() {
		return Hobbie;
	}
	public void setHobbie(String hobbie) {
		Hobbie = hobbie;
	}
	@Override
	public String toString() {
		return "TeacherDetails [id=" + id + ", city=" + city + ", Hobbie=" + Hobbie + "]";
	}
	

}
