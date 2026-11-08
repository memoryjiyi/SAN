package san.school;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * UML ClassDiagram3: Instructor
 * 属性：insId: String、insName: String
 * 关联：Instructor 1..* -- 1 Department；Instructor 1 -- 1..3 Subject（每位讲师讲授 1 到 3 门课）
 */
public class Instructor {

    private static final int MAX_SUBJECTS = 3;

    private final String insId;
    private final String insName;
    private Department department;
    private final List<Subject> subjects = new ArrayList<>();

    public Instructor(String insId, String insName) {
        this.insId = Objects.requireNonNull(insId, "insId");
        this.insName = Objects.requireNonNull(insName, "insName");
    }

    public String getInsId() {
        return insId;
    }

    public String getInsName() {
        return insName;
    }

    public Department getDepartment() {
        return department;
    }

    void attachTo(Department department) {
        this.department = department;
    }

    /** 讲授一门课；多重 1..3，超过 3 门抛异常 */
    public void teach(Subject subject) {
        Objects.requireNonNull(subject, "subject");
        if (subjects.contains(subject)) {
            return;
        }
        if (subjects.size() >= MAX_SUBJECTS) {
            throw new IllegalStateException("Instructor " + insName + " can teach at most " + MAX_SUBJECTS + " subjects");
        }
        subjects.add(subject);
        subject.addInstructor(this);
    }

    public List<Subject> getSubjects() {
        return Collections.unmodifiableList(subjects);
    }
}
