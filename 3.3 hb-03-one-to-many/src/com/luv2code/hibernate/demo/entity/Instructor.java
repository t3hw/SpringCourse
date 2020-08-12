package com.luv2code.hibernate.demo.entity;

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
@Table(name="instructor")
public class Instructor {
	
	// Fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String firstemail;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;
	
	@OneToMany(mappedBy = "instructor", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Course> courses;
	
	
	// Constructors 
	
	public Instructor() {
		
	}
	
	public Instructor(String firstName, String lastName, String firstemail) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.firstemail = firstemail;
	}

	public Instructor(String firstName, String lastName, String firstemail, InstructorDetail instructorDetail) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.firstemail = firstemail;
		this.instructorDetail = instructorDetail;
	}
	
	
	// Getters/Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstemail() {
		return firstemail;
	}

	public void setFirstemail(String firstemail) {
		this.firstemail = firstemail;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	// methods
	
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", firstemail="
				+ firstemail + ", instructorDetail=" + instructorDetail + "]";
	}
	
	// convenience methods for bi-directional relationship
	public void addCourse(Course course) {
		if (this.courses == null) {
			this.courses = new ArrayList<Course>();
		}
		
		courses.add(course);
		
		course.setInstructor(this);
	}
}
