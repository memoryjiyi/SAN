package san.college;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * UML ClassDiagram1: College
 * 关联：College 1 -- 1..* Building；College 1 -- 1..* Course
 */
public class College {

    private final String name;
    private final List<Building> buildings = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();

    public College(String name) {
        this.name = Objects.requireNonNull(name, "name");
    }

    public String getName() {
        return name;
    }

    /** 增加楼栋；维护双向关联，College 侧多重 1，Building 侧多重 1..* */
    public void addBuilding(Building building) {
        Objects.requireNonNull(building, "building");
        if (building.getCollege() == this) {
            return;
        }
        if (building.getCollege() != null) {
            throw new IllegalStateException("Building already belongs to another college");
        }
        buildings.add(building);
        building.attachTo(this);
    }

    /** 开设课程；Course 必须挂在本 College 且必须指定 Building */
    public void addCourse(Course course) {
        Objects.requireNonNull(course, "course");
        if (course.getCollege() == this) {
            return;
        }
        if (course.getCollege() != null) {
            throw new IllegalStateException("Course already belongs to another college");
        }
        courses.add(course);
        course.attachTo(this);
    }

    public List<Building> getBuildings() {
        return Collections.unmodifiableList(buildings);
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }
}
