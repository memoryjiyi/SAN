package san.college;

import java.util.Objects;

/**
 * UML ClassDiagram1: Course
 * 约束（附页注释）：Course must be held in a Building —— 一门课程必须安排在某一栋楼内。
 * 该约束在构造时强制：没有指定 Building 就无法创建 Course。
 * 关联：Course 1 -- 1 College；Course 1 -- 1 Building
 */
public class Course {

    private final String title;
    private College college;
    private Building building;

    /**
     * @param title    课程名
     * @param building 上课楼栋，OCL 约束要求必填
     */
    public Course(String title, Building building) {
        this.title = Objects.requireNonNull(title, "title");
        if (building == null) {
            throw new IllegalArgumentException("Course must be held in a Building");
        }
        this.building = building;
        building.host(this);
    }

    public String getTitle() {
        return title;
    }

    public College getCollege() {
        return college;
    }

    public Building getBuilding() {
        return building;
    }

    void attachTo(College college) {
        this.college = college;
    }

    void setBuilding(Building building) {
        this.building = building;
    }
}
