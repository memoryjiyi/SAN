package san.college;

/**
 * ClassDiagram1 演示：College / Building / Course 及约束 "Course must be held in a Building"
 */
public class CollegeDemo {

    public static void main(String[] args) {
        College college = new College("信息学院");

        Building a = new Building("一号教学楼");
        Building b = new Building("实验楼");
        college.addBuilding(a);
        college.addBuilding(b);

        Course java = new Course("Java 程序设计", a);
        Course db = new Course("数据库原理", b);
        college.addCourse(java);
        college.addCourse(db);

        // 约束验证：不给 Building 就无法创建 Course
        try {
            new Course("违反约束的课程", null);
        } catch (IllegalArgumentException e) {
            System.out.println("约束生效: " + e.getMessage());
        }

        System.out.println("College " + college.getName()
                + " 有 " + college.getBuildings().size() + " 栋楼、"
                + college.getCourses().size() + " 门课");
        for (Course c : college.getCourses()) {
            System.out.println("  " + c.getTitle() + " -> " + c.getBuilding().getName());
        }
    }
}
