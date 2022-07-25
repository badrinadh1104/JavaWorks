package Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//@Table(name ="Teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name ="Id")
	private int id;
//	@Column(name="Lname")
	private String lname ;
//	@Column(name ="Fname")
	private String Fname;
//	@Column(name ="Email")
	private String Email;
	@OneToOne(cascade = CascadeType.ALL)
	private TeacherDetails teacherDetails;
//	@OneToMany(mappedBy = "teacher",cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
//	private List<Course> course;
	public TeacherDetails getTeacherService() {
		return teacherDetails;
	}
	public void setTeacherService(TeacherDetails teacherService) {
		this.teacherDetails = teacherService;
	}
	public Teacher() {
		
	}
	public Teacher(String lname, String fname, String email) {
		this.lname = lname;
		Fname = fname;
		Email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", lname=" + lname + ", Fname=" + Fname + ", Email=" + Email + "]";
	}
//	public void add(Course c) {
//		if(course == null) {
//			course = new ArrayList<Course>();
//			
//		}
//		course.add(c);
//		c.setTeacher(this);
//	
//	}
	
	


}
