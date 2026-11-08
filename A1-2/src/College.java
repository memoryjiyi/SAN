import java.util.ArrayList;
import java.util.List;

// 教学楼
class Building {
    private String bldgId;
    private Integer floorCount;
    private College college;

    public Building(String bldgId, Integer floorCount) {
        this.bldgId = bldgId;
        this.floorCount = floorCount;
    }

    public String getBldgId() {
        return bldgId;
    }

    public void setBldgId(String bldgId) {
        this.bldgId = bldgId;
    }

    public Integer getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(Integer floorCount) {
        this.floorCount = floorCount;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}

// 课程
class Course {
    private String courseCode;
    private String courseName;
    private Integer credits;
    private College college;
    private Building building;

    public Course(String courseCode, String courseName, Integer credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}

// 学院（public类，文件名必须College.java）
public class College {
    private String name;
    private String address;
    // 聚合：Building可以独立存在
    private List<Building> buildingList = new ArrayList<>();
    // 组合：Course生命周期依附学院
    private List<Course> courseList = new ArrayList<>();

    public College(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addBuilding(Building b) {
        buildingList.add(b);
        b.setCollege(this);
    }

    public void addCourse(Course c) {
        courseList.add(c);
        c.setCollege(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Building> getBuildingList() {
        return buildingList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }
}
