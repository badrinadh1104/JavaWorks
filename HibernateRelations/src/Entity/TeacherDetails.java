package Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="teacherDetails")
public class TeacherDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="Id")
	private int id;
	@Column(name ="Hobby")
	private String hobby;
	@Column(name="City")
	private String city;
	@OneToOne(mappedBy = "teacherD",cascade = CascadeType.ALL)
	private Teacher teach;
	
	
	public TeacherDetails() {
	}

	public TeacherDetails(String hobby, String city) {
		super();
		this.hobby = hobby;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "TeacherDetails [id=" + id + ", hobby=" + hobby + ", city=" + city + "]";
	}
	
	

}
