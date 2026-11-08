package san.school;

/**
 * ClassDiagram3 演示：School / Department / Instructor / Student / Subject
 * 多重度：School 1-1..* Department；Department 1-1..* Instructor；
 *         School 1-0..* Student；Student 1-1..5 Subject；Instructor 1-1..3 Subject
 */
public class SchoolDemo {

    public static void main(String[] args) {
        School school = new School("S01", "计算机学院");
        Department d1 = new Department("D01", "软件工程系");
        Department d2 = new Department("D02", "网络工程系");
        school.addDepartment(d1);
        school.addDepartment(d2);

        Instructor t1 = new Instructor("I01", "张老师");
        Instructor t2 = new Instructor("I02", "李老师");
        d1.addInstructor(t1);
        d2.addInstructor(t2);

        Subject java = new Subject("CS101", "Java 程序设计", 4);
        Subject net = new Subject("CS201", "计算机网络", 3);
        Subject ai = new Subject("CS301", "人工智能导论", 2);
        Subject db = new Subject("CS102", "数据库原理", 3);

        t1.teach(java);
        t1.teach(db);
        t2.teach(net);
        t2.teach(ai);

        Student s1 = new Student("ST01", "王同学");
        Student s2 = new Student("ST02", "赵同学");
        school.enrol(s1);
        school.enrol(s2);

        s1.take(java);
        s1.take(net);
        s1.take(db);
        s2.take(net);
        s2.take(ai);

        // 多重度验证：学生最多选 5 门
        try {
            Subject x1 = new Subject("CS401", "选修1", 1);
            Subject x2 = new Subject("CS402", "选修2", 1);
            Subject x3 = new Subject("CS403", "选修3", 1);
            s1.take(x1);
            s1.take(x2);
            s1.take(x3);
        } catch (IllegalStateException e) {
            System.out.println("多重度生效: " + e.getMessage());
        }

        System.out.println("School " + school.getSchoolName() + "："
                + school.getDepartments().size() + " 个系，"
                + school.getStudents().size() + " 名学生");
        for (Student s : school.getStudents()) {
            System.out.println("  " + s.getStuName() + " 选修 " + s.getSubjects().size() + " 门课");
        }
        for (Department d : school.getDepartments()) {
            for (Instructor i : d.getInstructors()) {
                System.out.println("  " + d.getDeptName() + " " + i.getInsName()
                        + " 讲授 " + i.getSubjects().size() + " 门课");
            }
        }
    }
}
