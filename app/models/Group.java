package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "r_group")
public class Group extends Model {
	@ManyToOne
	public Classroom classroom;

	@ManyToMany(mappedBy = "groups", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	public List<Student> students = new ArrayList<>();

	public String name;
}
