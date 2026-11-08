package san.school;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * UML ClassDiagram3: Department
 * 属性：deptId: String、deptName: String
 * 关联：Department 1..* -- 1 School；Department 1 -- 1..* Instructor
 */
public class Department {

    private final String deptId;
    private final String deptName;
    private School school;
    private final List<Instructor> instructors = new ArrayList<>();

    public Department(String deptId, String deptName) {
        this.deptId = Objects.requireNonNull(deptId, "deptId");
        this.deptName = Objects.requireNonNull(deptName, "deptName");
    }

    public String getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public School getSchool() {
        return school;
    }

    void attachTo(School school) {
        this.school = school;
    }

    /** Department 1 -- 1..* Instructor：每位讲师隶属于且仅隶属于一个系 */
    public void addInstructor(Instructor instructor) {
        Objects.requireNonNull(instructor, "instructor");
        if (instructor.getDepartment() == this) {
            return;
        }
        if (instructor.getDepartment() != null) {
            throw new IllegalStateException("Instructor already belongs to another department");
        }
        instructors.add(instructor);
        instructor.attachTo(this);
    }

    public List<Instructor> getInstructors() {
        return Collections.unmodifiableList(instructors);
    }
}
