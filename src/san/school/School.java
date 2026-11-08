package san.school;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * UML ClassDiagram3: School
 * 属性：schoolId: String、schoolName: String
 * 关联：School 1 -- 1..* Department；School 1 -- 0..* Student
 */
public class School {

    private final String schoolId;
    private final String schoolName;
    private final List<Department> departments = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();

    public School(String schoolId, String schoolName) {
        this.schoolId = Objects.requireNonNull(schoolId, "schoolId");
        this.schoolName = Objects.requireNonNull(schoolName, "schoolName");
    }

    public String getSchoolId() {
        return schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    /** School 1 -- 1..* Department */
    public void addDepartment(Department department) {
        Objects.requireNonNull(department, "department");
        if (department.getSchool() == this) {
            return;
        }
        if (department.getSchool() != null) {
            throw new IllegalStateException("Department already belongs to another school");
        }
        departments.add(department);
        department.attachTo(this);
    }

    /** School 1 -- 0..* Student */
    public void enrol(Student student) {
        Objects.requireNonNull(student, "student");
        if (student.getSchool() == this) {
            return;
        }
        if (student.getSchool() != null) {
            throw new IllegalStateException("Student already belongs to another school");
        }
        students.add(student);
        student.attachTo(this);
    }

    public List<Department> getDepartments() {
        return Collections.unmodifiableList(departments);
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }
}
