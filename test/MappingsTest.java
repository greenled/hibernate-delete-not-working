import models.Classroom;
import models.Group;
import models.Student;
import org.junit.Before;
import org.junit.Test;
import play.test.Fixtures;
import play.test.UnitTest;

import static org.hamcrest.CoreMatchers.is;

public class MappingsTest extends UnitTest {
    @Before
    public void setup() {
        Fixtures.deleteDatabase();
        Fixtures.loadModels("data.yml");
    }

    @Test
    public void deleteClassroom() {
        assertThat(Classroom.count(), is(1L));
        assertThat(Student.count(), is(1L));
        assertThat(Group.count(), is(1L));

        Classroom classroom = Classroom.find("byName", "classroom1").first();
        assertThat(classroom.groups.size(), is(1));
        Group group = classroom.groups.get(0);
        assertThat(group.students.size(), is(1));

        classroom.delete();

        assertThat(Classroom.count(), is(0L));
        assertThat(Group.count(), is(0L));
        assertThat(Student.count(), is(1L));
    }

    @Test
    public void deleteStudent() {
        assertThat(Classroom.count(), is(1L));
        assertThat(Student.count(), is(1L));
        assertThat(Group.count(), is(1L));

        Student student = Student.find("byName", "student1").first();
        assertThat(student.groups.size(), is(1));
        Group group = student.groups.get(0);
        assertThat(student.classrooms.contains(group.classroom), is(true));

        student.delete();

        assertThat(Classroom.count(), is(1L));
        assertThat(Student.count(), is(0L));
        assertThat(Group.count(), is(1L));
    }

    @Test
    public void deleteGroup() {
        assertThat(Classroom.count(), is(1L));
        assertThat(Student.count(), is(1L));
        assertThat(Group.count(), is(1L));

        Group group = Group.find("byName", "group1").first();
        assertThat(group.students.size(), is(1));
        Student student = group.students.get(0);
        assertThat(student.classrooms.contains(group.classroom), is(true));

        group.delete();

        assertThat(Classroom.count(), is(1L));
        assertThat(Student.count(), is(1L));
        assertThat(Group.count(), is(0L));
    }

}
