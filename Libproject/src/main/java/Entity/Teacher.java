package Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fname;
	private String lname;
	private String Email;
	@OneToOne(cascade = CascadeType.ALL)
	private TeacherDetails teacherDetails;
	@OneToMany(mappedBy = "teacher",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,})
	private List<Course> courses;
	
	
	public Teacher() {
		super();
	}
	public Teacher(String fname, String lname, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		Email = email;
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
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public TeacherDetails getTeacherDetails() {
		return teacherDetails;
	}
	public void setTeacherDetails(TeacherDetails teacherDetails) {
		this.teacherDetails = teacherDetails;
	}
	
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course c) {
		if(courses==null) {
			courses = new ArrayList<Course>();
		}
		courses.add(c);
		c.setTeacher(this);
		
	}
	
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", fname=" + fname + ", lname=" + lname + ", Email=" + Email + "]";
	}
	
	
	

}
