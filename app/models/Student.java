package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "r_student")
public class Student extends Model {
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	public List<Classroom> classrooms = new ArrayList<>();

	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	public List<Group> groups = new ArrayList<>();

	public String name;
}
