package san.school;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * UML ClassDiagram3: Student
 * 属性：stuId: String、stuName: String
 * 关联：Student 0..* -- 1 School；Student 1 -- 1..5 Subject（每名学生选修 1 到 5 门课）
 */
public class Student {

    private static final int MAX_SUBJECTS = 5;

    private final String stuId;
    private final String stuName;
    private School school;
    private final List<Subject> subjects = new ArrayList<>();

    public Student(String stuId, String stuName) {
        this.stuId = Objects.requireNonNull(stuId, "stuId");
        this.stuName = Objects.requireNonNull(stuName, "stuName");
    }

    public String getStuId() {
        return stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public School getSchool() {
        return school;
    }

    void attachTo(School school) {
        this.school = school;
    }

    /** 选修一门课；多重 1..5，超过 5 门抛异常 */
    public void take(Subject subject) {
        Objects.requireNonNull(subject, "subject");
        if (subjects.contains(subject)) {
            return;
        }
        if (subjects.size() >= MAX_SUBJECTS) {
            throw new IllegalStateException("Student " + stuName + " can take at most " + MAX_SUBJECTS + " subjects");
        }
        subjects.add(subject);
        subject.addStudent(this);
    }

    public List<Subject> getSubjects() {
        return Collections.unmodifiableList(subjects);
    }
}
