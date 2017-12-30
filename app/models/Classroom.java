package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "r_classroom")
public class Classroom extends Model {
	@OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Group> groups = new ArrayList<>();

	@ManyToMany(mappedBy = "classrooms", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	public List<Student> students = new ArrayList<>();

	public String name;
}
