package Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	@Column(name = "TFname")
	private String fname;
	@Column(name = "TLname")
	private String lname;
	@Column(name = "TEmail")
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Teacher_Id")
	private TeacherDetails teacherD;
	@OneToMany(mappedBy = "teacher", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private List<Course> course;
	

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	public TeacherDetails getTeacherD() {
		return teacherD;
	}

	public void setTeacherD(TeacherDetails teacherD) {
		this.teacherD = teacherD;
	}

	public Teacher() {

	}

	public Teacher(String fname, String lname, String email) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + "]";
	}
	
	public void add(Course c) {
		if(course.isEmpty()){ 
			course = new ArrayList<>();
		}
		course.add(c);
		c.setTeacher(this);
	}

}
