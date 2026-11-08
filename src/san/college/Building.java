package san.college;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * UML ClassDiagram1: Building
 * 关联：Building 1 -- 1 College；Building 1 -- 1..* Course
 */
public class Building {

    private final String name;
    private College college;
    private final List<Course> courses = new ArrayList<>();

    public Building(String name) {
        this.name = Objects.requireNonNull(name, "name");
    }

    public String getName() {
        return name;
    }

    public College getCollege() {
        return college;
    }

    void attachTo(College college) {
        this.college = college;
    }

    /** 楼栋内可安排课程；Course 侧多重 1..*，一门课只属于一栋楼 */
    public void host(Course course) {
        Objects.requireNonNull(course, "course");
        if (course.getBuilding() == this) {
            return;
        }
        if (course.getBuilding() != null) {
            throw new IllegalStateException("Course is already held in another building");
        }
        courses.add(course);
        course.setBuilding(this);
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }
}
