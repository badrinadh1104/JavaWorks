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
	private String Hobby;
	@OneToOne(mappedBy = "teacherDetails",cascade = CascadeType.ALL)
	private Teacher teacher;
	
	
	public TeacherDetails() {
		
	}
	

	public TeacherDetails(String city, String hobby, Teacher teacher) {
		super();
		this.city = city;
		Hobby = hobby;
		this.teacher = teacher;
	}


	public TeacherDetails(String city, String hobby) {
		super();
		this.city = city;
		Hobby = hobby;
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

	public String getHobby() {
		return Hobby;
	}

	public void setHobby(String hobby) {
		Hobby = hobby;
	}

	@Override
	public String toString() {
		return "TeacherServices [id=" + id + ", city=" + city + ", Hobby=" + Hobby + "]";
	}
	

}
