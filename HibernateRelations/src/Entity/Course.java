package Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import net.bytebuddy.agent.builder.AgentBuilder.RawMatcher.Inversion;

@Entity
@Table(name = "Course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	@Column(name = "name")
	private String name;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name ="Teacher_id")
	private Teacher teacher;
	
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name ="Review_Id")
	private List<Reviews> reviews;
	
	
	
	@ManyToMany(fetch = FetchType.LAZY,cascade =  { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH } )
	@JoinTable(name ="Course_student",
		joinColumns=@JoinColumn(name ="course_id"),
		inverseJoinColumns=@JoinColumn(name="StudentId")
	)
	private List<Student> studentlist;
	
	public List<Reviews> getReviews() {
		return reviews;
	}
	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Course() {
		
	}
	public Course(String name) {
		super();
		this.name = name;
	}
	
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
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	public void add(Reviews r) {
		if(reviews == null) {
			reviews= new ArrayList<Reviews>();
		}
		reviews.add(r);
		
	}
	public void addstudent(Student s) {
		if(studentlist == null) {
			studentlist=new ArrayList<Student>();
		}
		studentlist.add(s);
		
	}
	
	
	

}
