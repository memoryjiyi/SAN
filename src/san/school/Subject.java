package san.school;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * UML ClassDiagram3: Subject
 * 属性：subjCode: String、subjName: String、credit: Integer
 * 关联：Subject 1..* -- Instructor（一门课由 1..* 位讲师讲授）；
 *       Subject 1..* -- Student（一门课被 1..* 名学生选修）
 */
public class Subject {

    private final String subjCode;
    private final String subjName;
    private final Integer credit;
    private final List<Instructor> instructors = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();

    public Subject(String subjCode, String subjName, Integer credit) {
        this.subjCode = Objects.requireNonNull(subjCode, "subjCode");
        this.subjName = Objects.requireNonNull(subjName, "subjName");
        if (credit == null || credit <= 0) {
            throw new IllegalArgumentException("credit must be positive");
        }
        this.credit = credit;
    }

    public String getSubjCode() {
        return subjCode;
    }

    public String getSubjName() {
        return subjName;
    }

    public Integer getCredit() {
        return credit;
    }

    void addInstructor(Instructor instructor) {
        if (!instructors.contains(instructor)) {
            instructors.add(instructor);
        }
    }

    void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public List<Instructor> getInstructors() {
        return Collections.unmodifiableList(instructors);
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }
}
