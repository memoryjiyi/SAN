import java.util.ArrayList;
import java.util.List;

/**
 * A1‑3 School、Department、Instructor、Subject、Student
 */

//学校
public class School {
    private String schoolId;
    private String schoolName;
    //组合：School销毁，Department随之销毁
    private List<Department> departmentList = new ArrayList<>();
    //聚合：学生可以独立存在
    private List<Student> studentList = new ArrayList<>();

    public School(String schoolId, String schoolName) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
    }

    public void addDepartment(Department d){
        departmentList.add(d);
        d.setSchool(this);
    }
    public void addStudent(Student s){
        studentList.add(s);
        s.setSchool(this);
    }

    public String getSchoolId() { return schoolId; }
    public void setSchoolId(String schoolId) { this.schoolId = schoolId; }
    public String getSchoolName() { return schoolName; }
    public void setSchoolName(String schoolName) { this.schoolName = schoolName; }
    public List<Department> getDepartmentList() { return departmentList; }
    public List<Student> getStudentList() { return studentList; }
}

//系
class Department{
    private String deptId;
    private String deptName;
    private School school;
    private List<Instructor> instructorList = new ArrayList<>();
    private List<Subject> subjectList = new ArrayList<>();

    public Department(String deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public void addInstructor(Instructor i){
        instructorList.add(i);
    }
    public void addSubject(Subject sub){
        subjectList.add(sub);
        sub.setDepartment(this);
    }

    public String getDeptId() { return deptId; }
    public void setDeptId(String deptId) { this.deptId = deptId; }
    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }
    public School getSchool() { return school; }
    public void setSchool(School school) { this.school = school; }
    public List<Instructor> getInstructorList() { return instructorList; }
    public List<Subject> getSubjectList() { return subjectList; }
}

//指导教师
class Instructor{
    private String insId;
    private String insName;
    private List<Department> departmentList = new ArrayList<>();
    //授课：1‑3门课程
    private List<Subject> teachSubjectList = new ArrayList<>();

    public Instructor(String insId, String insName) {
        this.insId = insId;
        this.insName = insName;
    }

    public void addTeachSubject(Subject sub){
        teachSubjectList.add(sub);
    }

    public String getInsId() { return insId; }
    public void setInsId(String insId) { this.insId = insId; }
    public String getInsName() { return insName; }
    public void setInsName(String insName) { this.insName = insName; }
    public List<Department> getDepartmentList() { return departmentList; }
    public List<Subject> getTeachSubjectList() { return teachSubjectList; }
}

//课程
class Subject{
    private String subjCode;
    private String subjName;
    private Integer credit;
    private Department department;

    public Subject(String subjCode, String subjName, Integer credit) {
        this.subjCode = subjCode;
        this.subjName = subjName;
        this.credit = credit;
    }

    public String getSubjCode() { return subjCode; }
    public void setSubjCode(String subjCode) { this.subjCode = subjCode; }
    public String getSubjName() { return subjName; }
    public void setSubjName(String subjName) { this.subjName = subjName; }
    public Integer getCredit() { return credit; }
    public void setCredit(Integer credit) { this.credit = credit; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}

//学生
class Student{
    private String stuId;
    private String stuName;
    private String major;
    private School school;
    //选课：1‑5门
    private List<Subject> takeSubjectList = new ArrayList<>();

    public Student(String stuId, String stuName, String major) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.major = major;
    }

    public void selectSubject(Subject sub){
        takeSubjectList.add(sub);
    }

    public String getStuId() { return stuId; }
    public void setStuId(String stuId) { this.stuId = stuId; }
    public String getStuName() { return stuName; }
    public void setStuName(String stuName) { this.stuName = stuName; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    public School getSchool() { return school; }
    public void setSchool(School school) { this.school = school; }
    public List<Subject> getTakeSubjectList() { return takeSubjectList; }
}
